package com.example.lab1project

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.*

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById<Spinner>(R.id.avDocSpinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.available_documents_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        Handler().postDelayed({
            val ratePanel = findViewById<ConstraintLayout>(R.id.RatePanel)
            ratePanel.visibility = View.VISIBLE
        }, 5000)

        val yesRadio = findViewById<RadioButton>(R.id.radioButtonYes)
        val maybeRadio = findViewById<RadioButton>(R.id.radioButtonMaybe)
        yesRadio.setOnClickListener {

            val rateBar = findViewById<RatingBar>(R.id.ratingBar)
            rateBar.visibility = View.VISIBLE
            val rateButton = findViewById<Button>(R.id.acceptRateButton)
            rateButton.visibility = View.VISIBLE
            yesRadio.visibility = View.GONE
            maybeRadio.visibility = View.GONE
        }

        maybeRadio.setOnClickListener {
            val ratePanel = findViewById<ConstraintLayout>(R.id.RatePanel)
            ratePanel.visibility = View.GONE
            Handler().postDelayed({
                ratePanel.visibility = View.VISIBLE
            }, 10000)
        }


        val createNewDocButton = findViewById<Button>(R.id.createNewDocButton)
        createNewDocButton.setOnLongClickListener {

            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(applicationContext, "THIS IS LONG CLICK", duration)
            toast.show()
            return@setOnLongClickListener true
        }


    }

    fun onFindDocumentClick(view: View)
    {
        val editText = findViewById<EditText>(R.id.docNameInputField)
        val message = editText.text.toString()
        val arrayTitles: Array<String> = resources.getStringArray(R.array.available_documents_array)
        var msg:String = "Not Found"
        if(arrayTitles.contains(message))
        {
            msg = message
        }

        val duration = Toast.LENGTH_SHORT
        val toast = Toast.makeText(applicationContext, msg, duration)
        toast.show()
    }

    fun onEditDocumentClick(view: View)
    {
        val spinner: Spinner = findViewById<Spinner>(R.id.avDocSpinner)
        val message = spinner.getSelectedItem().toString()
        val intent = Intent(this, DocumentEditorActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    fun onReadClick(view: View)
    {
        val spinner: Spinner = findViewById<Spinner>(R.id.avDocSpinner)
        val message = spinner.getSelectedItem().toString()
        val intent = Intent(this, DocumentReaderActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    fun onCreateNewDocument(view: View)
    {
        val message = "empty document"
        val intent = Intent(this, DocumentEditorActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, message)
        }
        startActivity(intent)
    }

    fun acceptRate(view: View)
    {
        val ratePanel = findViewById<ConstraintLayout>(R.id.RatePanel)
        ratePanel.visibility = View.GONE
    }









}
