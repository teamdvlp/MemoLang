package com.teamttdvlp.memolang.view.helper

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders

fun Activity.quickStartActivity (target : Class<*>) {
  startActivity(Intent(this, target))
}

fun Activity.quickToast (message : String) {
  Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

//fun Activity.quickStartActivity(target : Class<*>) {
//    val intent = Intent(this, target)
//    val bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle()
//    startActivity(intent, bundle)
//}


inline fun <reified T : ViewModel> Fragment.getFragmentViewModel(noinline creator: (() -> T)? = null): T {
  return if (creator == null)
    ViewModelProviders.of(this).get(T::class.java)
  else
    ViewModelProviders.of(this, ViewModelFactory(creator)).get(T::class.java)
}

inline fun <reified T : ViewModel> FragmentActivity.getActivityViewModel(noinline creator: (() -> T)? = null): T {
  return if (creator == null)
    ViewModelProviders.of(this).get(T::class.java)
  else
    ViewModelProviders.of(this, ViewModelFactory(creator)).get(T::class.java)
}

