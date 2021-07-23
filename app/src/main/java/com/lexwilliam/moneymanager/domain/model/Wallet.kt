package com.lexwilliam.moneymanager.domain.model

data class Wallet(
    val name: String,
    val iconId: Int,
    val reports: List<Report>
)