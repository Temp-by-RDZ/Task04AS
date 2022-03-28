package com.TRDZ.task04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val B_save: Button = findViewById(R.id.B_save)
        val B_gen: Button = findViewById(R.id.B_gen)
        val T_save: TextView = findViewById(R.id.T_save)
        val T_count: TextView = findViewById(R.id.T_count)
        val T_name: TextView = findViewById(R.id.T_name)
        val T_col: EditText = findViewById(R.id.T_col)

        val alpha = Data("Alpha",1)
        T_name.text = alpha.name
        T_count.text = alpha.number.toString()

        B_save.setOnClickListener(View.OnClickListener { T_save.text = Database.save(alpha) })
        B_gen.setOnClickListener(View.OnClickListener {
            try{alpha.counting(T_col.text.toString().toInt()); T_count.text = alpha.number.toString()}
            catch (Ignored: Exception ){}})
        }
    }