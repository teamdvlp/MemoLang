package com.teamttdvlp.memolang.view.Activity.viewmodel.signup

import com.google.firebase.auth.FirebaseUser
import java.lang.Exception

interface OnSignUpListener {

    fun onSuccess(user : FirebaseUser)

    fun onFailed (ex : Exception?)

}