package com.AccountManagemnt.Account.entity

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class Account(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id :String?="",
        val balance : BigDecimal?= BigDecimal.ZERO,
        val createdAt: LocalDateTime?,



        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name = "customerId", nullable = false)
        val customer : Customer?,
        @OneToMany(mappedBy = "account", fetch = FetchType.LAZY,cascade = [CascadeType.ALL])
        val transactions: Set<Transaction> = HashSet()




)

{
                constructor(balance: BigDecimal,createdAt: LocalDateTime,customer: Customer) :this(
                id="",
                balance=balance,
                createdAt=createdAt,
                customer=customer
                )
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Account

                if (id != other.id) return false
                if (balance != other.balance) return false
                if (createdAt != other.createdAt) return false
                if (customer != other.customer) return false
                if (transactions != other.transactions) return false

                return true
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + (balance?.hashCode() ?: 0)
                result = 31 * result + createdAt.hashCode()
                result = 31 * result + (customer?.hashCode() ?: 0)
                return result
        }
}

