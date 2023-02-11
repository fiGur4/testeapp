package co.tiagoaguiar.fitnesstracker

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Adapter
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {


    private lateinit var adapter: Adapter

//   private lateinit var btn_Imc : LinearLayout

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




//    btn_Imc = findViewById(R.id.btn_IMC)
//
//
//        btn_Imc.setOnClickListener{
//            val segundaTela = Intent(this, Activity_Imc::class.java)
//            startActivity(segundaTela)
//
//        }

    }



}