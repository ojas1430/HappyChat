package com.ojasx.happychat.ui.Login

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.LaunchedEffect

@Preview(showBackground = true)
@Composable
fun OtpVerificationScreen() {

    var phoneNumber by remember { mutableStateOf("9876543210") } // demo number
    var otp by remember { mutableStateOf("") }

    val screenHeight = LocalConfiguration.current.screenHeightDp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {

        Spacer(Modifier.height((screenHeight * 0.12f).dp))

        Text(
            text = "Verification Code",
            fontSize = 34.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(Modifier.height(18.dp))

        Text(
            text = "Enter the code we sent to +91 $phoneNumber",
            fontSize = 18.sp,
            color = Color.Gray
        )

        Spacer(Modifier.height(18.dp))

        TextButton(
            onClick = {}
        ) {
            Text(
                text = "Wrong number?",
                fontSize = 18.sp,
                color = Color.Blue
            )
        }

        Spacer(Modifier.height(48.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            OtpTextField(
                otp = otp,
                onOtpChange = { otp = it }
            )
        }
        Spacer(Modifier.height(16.dp))

        TextButton(
            onClick = {}
        ) {
            Text(
                text = "Resend Code",
                fontSize = 18.sp,
                color = Color.Gray
            )
        }

        Spacer(Modifier.weight(1f))

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            enabled = otp.length == 6,
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

@Composable
fun OtpTextField(
    otp: String,
    onOtpChange: (String) -> Unit
) {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Box(
        contentAlignment = Alignment.Center
    ) {
        BasicTextField(
            value = otp,
            onValueChange = {
                if (it.length <= 6 && it.all { char -> char.isDigit() }) {
                    onOtpChange(it)
                }
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(0.dp)
                .focusRequester(focusRequester)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(6) { index ->

                val char = if (index < otp.length) {
                    otp[index].toString()
                } else {
                    ""
                }

                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .border(
                            width = 1.dp,
                            color = if (index == otp.length) Color.Black else Color.Gray,
                            shape = RoundedCornerShape(8.dp)
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = char,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }
    }
}