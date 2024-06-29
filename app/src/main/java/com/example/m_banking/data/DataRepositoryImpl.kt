package com.example.m_banking.data

import com.example.m_banking.domain.model.CardModel
import com.example.m_banking.domain.model.TransactionModel
import com.example.m_banking.domain.repository.DataRepository
import java.time.LocalDate
import java.time.Month

class DataRepositoryImpl : DataRepository {
    override fun getCards(): List<CardModel> {
        return listOf(
            CardModel(
                cardName = "My first account",
                number = "91212192291221",
                cardNumber = "•••• 1234"
            ),
            CardModel(
                cardName = "For travelling",
                number = "91212192291221",
                cardNumber = "•••• 1234"
            ),
            CardModel(
                cardName = "Saving Account ",
                number = "91212192291221",
                cardNumber = "•••• 1234"
            )
        )
    }


    override fun getTransactions(): List<TransactionModel> {
        return listOf(
            TransactionModel(
                companyName = "OOO “Company”",
                transactionNumber = "f4345jfshjek3454",
                date = LocalDate.of(2024, Month.JUNE, 1),
                transactionStatus = "Executed",
                amount = 10.09
            ),
            TransactionModel(
                companyName = "OOO “Company2”",
                transactionNumber = "f4345jfshjek3454",
                date = LocalDate.of(2024, Month.JUNE, 2),
                transactionStatus = "Declined",
                amount = 10.09
            ),
            TransactionModel(
                companyName = "OOO “Company”",
                transactionNumber = "f4345jfshjek3454",
                date = LocalDate.of(2024, Month.JUNE, 6),
                transactionStatus = "In progress",
                amount = 10.09
            ),
            TransactionModel(
                companyName = "OOO “Company”",
                transactionNumber = "f4345jfshjek3454",
                date = LocalDate.of(2024, Month.JUNE, 10),
                transactionStatus = "Executed",
                amount = 10.09
            )
        )
    }
}