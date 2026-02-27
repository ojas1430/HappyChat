package com.ojasx.happychat.ui.Login

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun PhoneLoginScreen() {

    var phoneNumber by remember { mutableStateOf("") }

    val screenHeight = LocalConfiguration.current.screenHeightDp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {

        Spacer(Modifier.height((screenHeight * 0.12f).dp))

        Text(
            text = "Phone number",
            fontSize = 34.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(Modifier.height(18.dp))

        Text(
            text = "You will receive a verification code.",
            fontSize = 18.sp,
            color = Color.Gray
        )

        Text(
            text = "Carrier rates may apply.",
            fontSize = 18.sp,
            color = Color.Gray
        )

        Spacer(Modifier.height(48.dp))

        // Country Box
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
                .padding(18.dp)
        ) {
            Text(
                text = "🇮🇳  India",
                fontSize = 18.sp
            )
        }

        Spacer(Modifier.height(18.dp))

        // Phone Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp))
                .padding(horizontal = 18.dp, vertical = 6.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "+91",
                fontSize = 18.sp
            )

            Spacer(Modifier.width(14.dp))

            OutlinedTextField(
                value = phoneNumber,
                onValueChange = {
                    if (it.length <= 10) {
                        phoneNumber = it.filter { ch -> ch.isDigit() }
                    }
                },
                placeholder = {
                    Text("Phone number", fontSize = 18.sp)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                modifier = Modifier.weight(1f),
                singleLine = true
            )
        }

        Spacer(Modifier.weight(1f))

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            enabled = phoneNumber.length == 10,
            shape = RoundedCornerShape(32.dp)
        ) {
            Text(
                "Next",
                fontSize = 18.sp
            )
        }

        Spacer(Modifier.height(28.dp))
    }
}