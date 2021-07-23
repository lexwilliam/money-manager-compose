package com.lexwilliam.moneymanager.presentation.util

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.ui.unit.dp
import com.lexwilliam.moneymanager.R
import com.lexwilliam.moneymanager.data.model.ReportType
import com.lexwilliam.moneymanager.presentation.model.WalletPresentation
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*

val cardWidth = 200.dp
val cardHeight = 270.dp

val thisMonth = convertLongToTime(System.currentTimeMillis(), "MMM yyyy", false)

val walletIconResources: List<Int> = listOf(
    R.drawable.account_balance_black_24dp,
    R.drawable.account_filled_balance_wallet_black_24dp,
    R.drawable.savings_black_24dp,
    R.drawable.store_black_24dp,
    R.drawable.shopping_bag_black_24dp,
    R.drawable.shopping_basket_black_24dp
)

data class IncomeExpenseSummary(
    val income: Double,
    val expense: Double,
    val total: Double = income + expense
)

fun getThisMonthSummary(wallets: List<WalletPresentation>): IncomeExpenseSummary {
    var income = +0.0
    var expense = -0.0
    wallets.forEach { wallet ->
        val groupedReport = wallet.reports.groupBy { convertLongToTime(it.timeAdded, "MMM yyyy", false) }
        groupedReport.forEach { month , reports ->
            if(month == thisMonth) {
                reports.forEach { report ->
                    when(report.reportType) {
                        ReportType.Income -> income += report.money
                        ReportType.Expense -> expense -= report.money
                        ReportType.Default -> Log.d("TAG", "${report.reportId} has no report type")
                    }
                }
            }
        }
    }
    return IncomeExpenseSummary(income, expense)
}

@SuppressLint("SimpleDateFormat")
fun convertLongToTime(time: Long, dateFormat: String, todayYesterday: Boolean = true): String {
    val date = Date(time)
    val simpleFormat = SimpleDateFormat(dateFormat)
    val result = simpleFormat.format(date)
    if(todayYesterday) {
        val formatter = DateTimeFormatter.ofPattern(dateFormat)
        val today = LocalDate.now().format(formatter)
        val yesterday = LocalDate.now().minus(1, ChronoUnit.DAYS).format(formatter)
        when(result) {
            today -> return "Today"
            yesterday -> return "Yesterday"
        }
    }
    return result
}

fun walletTotalBalance(wallet: WalletPresentation): Double {
    var totalMoney = 0.0
    wallet.reports.forEach {
        totalMoney += it.money
    }
    return totalMoney
}

fun allWalletTotalBalance(wallets: List<WalletPresentation>): Double {
    var totalBalance = 0.0
    wallets.forEach { wallet ->
        wallet.reports.forEach { report ->
            totalBalance += report.money
        }
    }
    return totalBalance
}

fun getWalletIncome(wallet: WalletPresentation): Double {
    var totalMoney = 0.0
    wallet.reports.forEach { report ->
        if(report.reportType == ReportType.Income) {
            totalMoney += report.money
        }
    }
    return totalMoney
}

fun getWalletExpense(wallet: WalletPresentation): Double {
    var totalMoney = 0.0
    wallet.reports.forEach { report ->
        if(report.reportType == ReportType.Expense) {
            totalMoney += report.money
        }
    }
    return totalMoney
}

fun convertDoubleToMoneyFormat(num: Double): String {
    val numberFormat = NumberFormat.getCurrencyInstance()
    return numberFormat.format(num)
}