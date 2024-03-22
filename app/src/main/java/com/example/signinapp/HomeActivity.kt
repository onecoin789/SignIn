package com.example.signinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val text_id = findViewById<TextView>(R.id.text_id_get)
        val btn_finish = findViewById<Button>(R.id.btn_finish)

        //HomeActivity 이미지 랜덤 출력
        val imageView = findViewById<ImageView>(R.id.img3)
        when(Random.nextInt(5)) {
            0 -> imageView.setImageResource(R.drawable.randompic1)
            1 -> imageView.setImageResource(R.drawable.randompic2)
            2 -> imageView.setImageResource(R.drawable.randompic3)
            3 -> imageView.setImageResource(R.drawable.randompic4)
            4 -> imageView.setImageResource(R.drawable.randompic5)
        }

        //SignInActivity에서 put해준 text를 여기서 getStringExtra로 받아준다.
        if(intent.hasExtra("")) {
            text_id.text = intent.getStringExtra("")
        }
        //btn_finish(종료 버튼)을 누르면 finish()로 현재 Activity가 종료되면서 첫화면으로 돌아간다.
        btn_finish.setOnClickListener {
            finish()
        }
    }
}