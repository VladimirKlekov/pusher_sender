package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream

fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)
val token = "cmkFts59Tva8cvWBlyeJtv:APA91bHPOXJRCWKv480cJcHzvdA3_Xhh_bAI1Nho99i-9EffrS2B0m6N9oMnhI9Q2OM2mhvJI6B9OHQtjo_OeRZQJBW7F1eHlr1lxze-wkVjFxCINE8Mn2xw7_wDcf92qBcHYykBnak7"
    val message = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "Посетитель",
          "postId": 2,
          "postAuthor": "Netology",
          "text": "Пользователь написал пост"
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)
}