package com.example.lab1project

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class DocumentEditorActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_document_editor)

        val message = intent.getStringExtra(EXTRA_MESSAGE)

        val textViewTitle = findViewById<TextView>(R.id.saveScreenTitle).apply {
            text = message
        }

        val editDocText: EditText = findViewById<EditText>(R.id.editDoc).apply {
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
    }

    fun onSaveClick(view: View)
    {
        val text = "Saving(not really tbh)"
        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()
    }

}
