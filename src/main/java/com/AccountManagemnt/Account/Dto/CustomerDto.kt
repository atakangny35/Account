package com.AccountManagemnt.Account.Dto

data class CustomerDto(
    val id :String?,
    val name:String?,
    val surname:String?,
    val accounts: Set<CustomerAccountDto>?
)
