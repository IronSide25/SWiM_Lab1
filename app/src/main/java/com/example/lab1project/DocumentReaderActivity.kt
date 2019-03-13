package com.example.lab1project

import android.graphics.Color
import android.graphics.Paint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class DocumentReaderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_document_reader)

        val message = intent.getStringExtra(EXTRA_MESSAGE)

        val textViewTitle = findViewById<TextView>(R.id.readerTitle).apply {
            text = message
        }

        val editDocText: TextView = findViewById<TextView>(R.id.readerText).apply {
            val arrayTitles: Array<String> = resources.getStringArray(R.array.available_documents_array)
            val arrayTexts: Array<String> = resources.getStringArray(R.array.available_documents_texts)

            if(message == arrayTitles.get(0))
                setText(arrayTexts.get(0))
            else if(message == arrayTitles.get(1))
                setText(arrayTexts.get(1))
            else if(message == arrayTitles.get(2))
                setText(arrayTexts.get(2))
            else if(message == arrayTitles.get(3))
                setText(arrayTexts.get(3))
        }

        val blueToggle = findViewById<ToggleButton>(R.id.toggleButtonBlue)
        val boldToggle = findViewById<ToggleButton>(R.id.toggleButtonBold)
        blueToggle.setText("OFF")
        boldToggle.setText("OFF")
        blueToggle.setTextOff("OFF")
        blueToggle.setTextOn("ON")
        boldToggle.setTextOff("OFF")
        boldToggle.setTextOn("ON")

        blueToggle.setOnClickListener {
            val editDocText: TextView = findViewById<TextView>(R.id.readerText)
            if(findViewById<ToggleButton>(R.id.toggleButtonBlue).isChecked)
                editDocText.setTextColor(Color.BLUE)
            else
                editDocText.setTextColor(Color.BLACK)
        }

        boldToggle.setOnClickListener {
            val editDocText: TextView = findViewById<TextView>(R.id.readerText)
            if(findViewById<ToggleButton>(R.id.toggleButtonBold).isChecked)
                editDocText.setTextAppearance(R.style.boldText)
            else
                editDocText.setTextAppearance(R.style.normalText)
        }



    }
}
