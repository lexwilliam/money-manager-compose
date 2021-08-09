package com.lexwilliam.moneymanager.data.repository

import com.lexwilliam.moneymanager.data.model.ReportType
import com.lexwilliam.moneymanager.domain.model.Report
import com.lexwilliam.moneymanager.domain.model.Wallet
import com.lexwilliam.moneymanager.domain.repository.IWalletRepository
import com.lexwilliam.moneymanager.presentation.model.WalletPresentation
import com.lexwilliam.moneymanager.presentation.util.fakeWallet
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.LocalDate

class FakeWalletRepository(val walletList: MutableList<Wallet>? = mutableListOf()): IWalletRepository {
    override suspend fun getWalletsFromFirestore(): Flow<Any?> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllWalletWithReport(): Flow<List<Wallet>> {
        TODO("Not yet implemented")
    }

    override suspend fun getWalletWithReportById(walletName: String): Flow<Wallet> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllReport(): Flow<List<Report>> {
        TODO("Not yet implemented")
    }

    override suspend fun getReportById(reportId: Int): Flow<Report> {
        TODO("Not yet implemented")
    }

    override suspend fun insertWallet(wallet: Wallet): Flow<Long> = flow {
        walletList?.add(wallet)
        emit(0)
    }

    override suspend fun insertReport(report: Report): Flow<Long> {
        TODO("Not yet implemented")
    }

    override suspend fun updateWallet(wallet: Wallet): Flow<Int> {
        TODO("Not yet implemented")
    }

    override suspend fun updateReport(report: Report): Flow<Int> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteWallet(wallet: Wallet): Flow<Int> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteReport(report: Report): Flow<Int> {
        TODO("Not yet implemented")
    }
}