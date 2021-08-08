package com.lexwilliam.moneymanager.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "wallet_report")
data class ReportEntity(
    @PrimaryKey(autoGenerate = true) val reportId: Int = 0,
    val walletName: String,
    val timeAdded: LocalDate? = LocalDate.now(),
    val iconId: Int,
    val name: String,
    val money: Double,
    val reportType: ReportType
)

enum class ReportType {
    Expense, Income, Default, RecurringExpense, RecurringIncome
}