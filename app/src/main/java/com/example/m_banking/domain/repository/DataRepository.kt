package com.example.m_banking.domain.repository

import com.example.m_banking.domain.model.CardModel
import com.example.m_banking.domain.model.TransactionModel

interface DataRepository {
    fun getCards(): List<CardModel>
    fun getTransactions(): List<TransactionModel>
}