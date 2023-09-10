package com.AccountManagemnt.Account.Dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import java.math.BigDecimal

data class CreateAccountRequest(
    @field:NotBlank(message = "Bu alan boş geçilemez")
    val customerId :String,
    @field:Min(value = 0, message = "sıfırdan küçük olamaz")
    val initialCredit:BigDecimal
)
