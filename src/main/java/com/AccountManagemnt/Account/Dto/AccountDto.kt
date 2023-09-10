package com.AccountManagemnt.Account.Dto

import com.AccountManagemnt.Account.entity.Customer
import com.AccountManagemnt.Account.entity.Transaction
import java.math.BigDecimal
import java.time.LocalDateTime

data class AccountDto(

    val id :String?,
    val balance : BigDecimal?= BigDecimal.ZERO,
    val createdAt: LocalDateTime?,
    val customer : AccountCustomerDto?,
    val transactions: Set<TransactionDto>?
)
