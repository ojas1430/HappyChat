package com.ojasx.happychat.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    private val _phonenumber = MutableLiveData<String>()
    val phonenumber : LiveData<String> = _phonenumber

    fun setPhoneNumber(number:String){
        _phonenumber.value = number
    }
}