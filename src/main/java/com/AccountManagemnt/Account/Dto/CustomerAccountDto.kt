package com.AccountManagemnt.Account.Dto

import java.math.BigDecimal
import java.time.LocalDateTime

data class CustomerAccountDto(
    val id :String?,
    val balance : BigDecimal?= BigDecimal.ZERO,
    val createdAt: LocalDateTime?,
    val transactions: Set<TransactionDto>?


    ) {
}