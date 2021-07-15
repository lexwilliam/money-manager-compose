package com.lexwilliam.moneymanager.domain.usecase

import com.lexwilliam.moneymanager.data.repository.WalletRepository
import com.lexwilliam.moneymanager.domain.model.Report
import javax.inject.Inject

class InsertReportUseCase
@Inject constructor(
    private val walletRepository: WalletRepository
) {
    suspend operator fun invoke(report: Report) = walletRepository.insertReport(report)
}