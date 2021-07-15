package com.lexwilliam.moneymanager.domain.usecase

import com.lexwilliam.moneymanager.data.repository.WalletRepository
import com.lexwilliam.moneymanager.domain.model.Wallet
import javax.inject.Inject

class InsertWalletUseCase
@Inject constructor(
    private val walletRepository: WalletRepository
) {
    suspend operator fun invoke(wallet: Wallet) = walletRepository.insertWallet(wallet)
}