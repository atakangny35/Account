package com.AccountManagemnt.Account.entity

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.util.HashSet

@Entity
data class Customer(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        val id :String,
        val name:String,
        val surname:String,
        @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
        val accounts: Set<Account>
)

{
        constructor():this(
                id="",
                name="Atakan",
                surname="gunay",
                accounts= HashSet<Account>()
        )
        override fun equals(other: Any?): Boolean {
                if (this === other) return true
                if (javaClass != other?.javaClass) return false

                other as Customer

                if (id != other.id) return false
                if (name != other.name) return false
                if (surname != other.surname) return false
                if (accounts != other.accounts) return false

                return true
        }

        override fun hashCode(): Int {
                var result = id?.hashCode() ?: 0
                result = 31 * result + (name?.hashCode() ?: 0)
                result = 31 * result + (surname?.hashCode() ?: 0)
                return result
        }
}

