package com.example.labs

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var buttonPT: Button
    private lateinit var buttonENG: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        button = findViewById(R.id.button);
        buttonPT = findViewById(R.id.ptButton);
        buttonENG = findViewById(R.id.engButton);

        button.setOnClickListener {
            val intent = Intent(this, AT2::class.java)
            startActivity(intent)
        }

        buttonPT.setOnClickListener {
            setLanguage("pt")
        }

        buttonENG.setOnClickListener {
            setLanguage("eng")
        }
    }

    private fun setLanguage(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val configuration = resources.configuration
        configuration.setLocale(locale)

        val context = createConfigurationContext(configuration)
        resources.updateConfiguration(configuration, resources.displayMetrics)

        recreate() // Recreate the activity to reflect the change
    }
}