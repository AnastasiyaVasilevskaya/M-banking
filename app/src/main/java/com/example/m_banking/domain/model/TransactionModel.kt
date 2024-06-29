package com.example.m_banking.domain.model

import java.time.LocalDate

data class TransactionModel (
    val companyName: String,
    val transactionNumber: String,
    val date: LocalDate,
    val transactionStatus: String,
    val amount: Double
)
