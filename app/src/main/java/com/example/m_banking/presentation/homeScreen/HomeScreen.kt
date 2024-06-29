package com.example.m_banking.presentation.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.m_banking.R
import com.example.m_banking.data.DataRepositoryImpl
import com.example.m_banking.presentation.theme.GreyBackground
import com.example.m_banking.presentation.theme.TextBlue

@Composable
fun HomeScreen(navController: NavHostController) {
    val dataRepository = DataRepositoryImpl()
    val cards = dataRepository.getCards()
    val transactions = dataRepository.getTransactions()
    var openAccountsSheet by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black) //
            .padding(top = 24.dp, bottom = 12.dp, start = 16.dp, end = 16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = stringResource(id = R.string.accountTitle),
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                fontSize = 28.sp,
                fontWeight = FontWeight.W700
            )
            AccountCard(
                cardName = cards.first().cardName,
                number = cards.first().number,
                cardNumber = cards.first().cardNumber,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.18f),
                onClick = {
                    openAccountsSheet = true
                }
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.recentTransactions),
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.W700
                )
                Text(
                    text = stringResource(id = R.string.viewAll),
                    color = TextBlue,
                    modifier = Modifier.clickable {
                        navController.navigate("allTransactions")
                    }
                )
            }
            Card(
                shape = RoundedCornerShape(13.dp),
                colors = CardDefaults.cardColors(
                    containerColor = GreyBackground
                ),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                LazyColumn(
                    modifier = Modifier.padding(16.dp)
                ) {
                    itemsIndexed(items = transactions) { index, item ->
                        TransactionCard(
                            companyName = item.companyName,
                            date = item.date,
                            transactionStatus = item.transactionStatus,
                            amount = item.amount
                        )
                        if (index < transactions.lastIndex)
                            Divider(
                                color = Color.LightGray,
                                thickness = 0.3.dp,
                                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                            )
                    }
                }
            }
        }
        FloatingActionButton(
            onClick = {
                navController.navigate("addTransaction")
            },
            shape = CircleShape,
            containerColor = TextBlue,
            contentColor = Color.White,
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 16.dp, bottom = 12.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.plus),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}