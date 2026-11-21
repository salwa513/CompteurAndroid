package com.example.compteurandroid

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var compteur: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Récupérer les composants graphiques
        val textViewCompteur: TextView = findViewById(R.id.textViewCompteur)
        val buttonIncrementer: Button = findViewById(R.id.buttonIncrementer)
        val buttonDecrementer: Button = findViewById(R.id.buttonDecrementer)
        val buttonReinitialiser: Button = findViewById(R.id.buttonReinitialiser)

        // Restaurer la valeur après rotation
        if (savedInstanceState != null) {
            compteur = savedInstanceState.getInt("compteur", 0)
            actualiserAffichage(textViewCompteur)
        }

        // Bouton +
        buttonIncrementer.setOnClickListener {
            compteur++
            actualiserAffichage(textViewCompteur)
        }

        // Bouton -
        buttonDecrementer.setOnClickListener {
            compteur--
            actualiserAffichage(textViewCompteur)
        }

        // Bouton Réinitialiser
        buttonReinitialiser.setOnClickListener {
            compteur = 0
            actualiserAffichage(textViewCompteur)
            Toast.makeText(this, R.string.message_reinitialisation, Toast.LENGTH_SHORT).show()
        }
    }

    private fun actualiserAffichage(textViewCompteur: TextView) {
        textViewCompteur.text = compteur.toString()

        // Couleur selon la valeur
        textViewCompteur.setTextColor(
            when {
                compteur > 0 -> Color.parseColor("#2E7D32") // vert
                compteur < 0 -> Color.parseColor("#C62828") // rouge
                else -> Color.BLACK
            }
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("compteur", compteur)
    }
}
