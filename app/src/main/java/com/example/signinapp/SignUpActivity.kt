package com.example.signinapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {

    private lateinit var edit1:EditText
    private lateinit var edit2:EditText
    private lateinit var edit3:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)



        val btn_up = findViewById<Button>(R.id.btn_up)
        edit1 = findViewById(R.id.edit1)
        edit2 = findViewById(R.id.edit2)
        edit3 = findViewById(R.id.edit3)

        //btn_up(회원가입 버튼)을 눌렀을 때 각 EditText가 비어있다면 Toast 메세지 출력과 함께 넘어가지 않는다.
        btn_up.setOnClickListener {
            if (edit1.text.toString().trim().isEmpty()) {
                Toast.makeText(this@SignUpActivity, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else if (edit2.text.toString().trim().isEmpty()) {
                Toast.makeText(this@SignUpActivity, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            } else if (edit3.text.toString().trim().isEmpty()) {
                Toast.makeText(this@SignUpActivity, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }
            //3가지 EditText가 전부 제대로 입력되었다면 Toast 메세지와 함께 현재화면이 종료된다.
            else {
                Toast.makeText(this@SignUpActivity, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show()
                signUp()
            }
        }
    }
    private fun signUp() {
        val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
        intent.putExtra("id", edit2.text.toString())
        intent.putExtra("password", edit3.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }
}