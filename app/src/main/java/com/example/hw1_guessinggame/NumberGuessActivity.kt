package com.example.hw1_guessinggame
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_guess)
        Game()
        reset()
    }

    fun Game() {
        // creamos el numero a partir de un ramdon entre 0 y 1000
        var iThought = Random.nextInt(0, 1000)
        println(iThought)
        // capturamos el valor del edit text
        val btnplay = findViewById<Button>(R.id.btnplay)
        val btnreset = findViewById<Button>(R.id.btn_reset)
        btnreset.isEnabled = false

        btnplay.setOnClickListener() {
            val userNumber = findViewById<EditText>(R.id.userNumber)
            var tumadre = userNumber.text.toString().toInt()

            val txtView = findViewById<TextView>(R.id.txtView)

            when {
                tumadre<iThought -> {
                    txtView.setText(resources.getText(R.string.txtView_higther))
                }
                tumadre>iThought -> {
                    txtView.setText(resources.getText(R.string.txtView_lower))
                }
                tumadre==iThought -> {
                    txtView.setText(resources.getText(R.string.txtView_won))
                    btnreset.isEnabled = true
                }
                else -> txtView.setText(resources.getText(R.string.txtView_error))
            }
            }

    }
    fun reset (){
        val btnreset = findViewById<Button>(R.id.btn_reset)
        btnreset.setOnClickListener(){
            val txtView = findViewById<TextView>(R.id.txtView)
            val userNumber = findViewById<TextView>(R.id.userNumber)
            txtView.setText(resources.getText(R.string.txtView_Thinking))
            userNumber.setText("")
            Game()
        }
    }


}




