package com.example.coinflip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            onTap()
    }

    private fun onTap(){
        val ivCoin = findViewById<ImageView>(R.id.IVcoin)
        ivCoin.setOnClickListener {
            val result = (1..2).random()
            if (result == 1){
                flipAnimation(R.drawable.heads,"Heads")
            }else{
                flipAnimation(R.drawable.tails,"Tails")
            }
        }
    }

    private fun flipAnimation(resultImage: Int, resultText: String) {

        val imageView = findViewById<ImageView>(R.id.IVcoin)
        imageView.animate().apply {
            duration = 1000
            rotationYBy(1800f)
            imageView.isClickable = false
        }.withEndAction(){
            imageView.setImageResource(resultImage)
            Toast.makeText(this, resultText, Toast.LENGTH_SHORT).show()
            imageView.isClickable = true
        }
    }
}