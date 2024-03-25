package com.example.signinapp

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {
    private lateinit var edit_id: EditText
    private lateinit var edit_password: EditText
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        edit_id = findViewById(R.id.edit_id)
        edit_password = findViewById(R.id.edit_password)
        val btn_in1 = findViewById<Button>(R.id.btn_in1)
        val btn_in2 = findViewById<Button>(R.id.btn_in2)

        setResultNext()

        //btn_in1(로그인 버튼)을 눌렀을 때
        btn_in1.setOnClickListener {
            //아이디 입력 EditText가 비어있을 때
            if (edit_id.text.toString().trim().isEmpty()) {
                Toast.makeText(this@SignInActivity, "아이디를 확인해주세요", Toast.LENGTH_SHORT).show()
                //비밀번호 입력 EditText가 비어있을 때
            } else if (edit_password.text.toString().trim().isEmpty()) {
                Toast.makeText(this@SignInActivity, "비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
                //성공적으로 로그인이 되면 HomeActivity로 go!
            } else {
                Toast.makeText(this@SignInActivity, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                //val inputId는 EditText id에서 받아온 text를 toString으로 바꿔서
                val inputId = edit_id.text.toString()
                //intent 보내준다
                intent.putExtra("", inputId)
                startActivity(intent)
            }
        }
        //btn_in2(회원가입 버튼)을 눌렀을 때 ShignUpActivity로 go!
        btn_in2.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            resultLauncher.launch(intent)
        }
    }

    private fun setResultNext() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val id = result.data?.getStringExtra("id") ?: ""
                    val password = result.data?.getStringExtra("password") ?: ""
                    edit_id.setText(id)
                    edit_password.setText(password)
                }
            }
    }
}


