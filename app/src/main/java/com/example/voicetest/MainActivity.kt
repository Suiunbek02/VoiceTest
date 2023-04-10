package com.example.voicetest

import android.app.Activity
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.voicetest.databinding.ActivityMainBinding
//import com.example.voicetest.databinding.ActivityMainBinding
//import com.example.voicetest.ui.Notification
import java.util.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {


}


//
//    private val binding by viewBinding(ActivityMainBinding::bind)
////    private val REQUEST_CODE_SPEECH_INPUT = 100
//    private val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
//    private val alarmPendingIntent by lazy {
//        val intent = Intent(applicationContext, Notification::class.java)
//        PendingIntent.getBroadcast(applicationContext, 0, intent, 0 )
//    }
//
//    private fun schedulePushNotifications() {
//
//    }


//    private fun getMic() = with(binding) {
//        voiceBtn.setOnClickListener {
//            speak()
//        }
//    }
//
//    private fun speak() {
//        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
//        intent.putExtra(
//            RecognizerIntent.EXTRA_LANGUAGE_MODEL,
//            RecognizerIntent.LANGUAGE_MODEL_FREE_FORM
//        )
//        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault())
//        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi Speak something")
//
//        try {
//            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT)
//        }
//        catch (
//            exception : Exception
//        ) {
//            Toast.makeText(this, exception.message, Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    @Deprecated("Deprecated in Java")
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        when(requestCode) {
//            REQUEST_CODE_SPEECH_INPUT -> {
//                if (resultCode == Activity.RESULT_OK && null != data) {
//                    val result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
//                    binding.textTV.text = result!![0]
//
//                }
//            }
//        }
//    }

//private const val HOUR_TO_SHOW_PUSH = 22