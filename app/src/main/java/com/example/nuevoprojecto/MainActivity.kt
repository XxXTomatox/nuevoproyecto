package com.example.nuevoprojecto

import android.content.Intent
import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var saludar: Button
    private lateinit var actividad:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            button = findViewById(R.id.button)
            saludar = findViewById(R.id.saludar)
            actividad = findViewById(R.id.actividad)

            actividad.setOnClickListener{
                actividad()
            }
            button.setOnClickListener {
                entraHome()
            }
            saludar.setOnClickListener{
                saludar()
            }
            val buttonNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
            buttonNavigationView.setOnNavigationItemSelectedListener { item ->
                when(item.itemId){
                    R.id.nav_home->{
                        Toast.makeText(this,"Estas en home",Toast.LENGTH_LONG).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        true
                    }
                    R.id.nav_settings->{
                        Toast.makeText(this,"Estas en configuracion",Toast.LENGTH_LONG).show()
                        val intent = Intent(this, MainActivity3::class.java)
                        startActivity(intent)
                        true
                    }
                    R.id.nav_profile->{
                        Toast.makeText(this,"Estas en perfil",Toast.LENGTH_LONG).show()
                        val intent = Intent(this,Actividad::class.java)
                        startActivity(intent)
                        true
                    }
                    else->false
                }
            }
            insets
        }
    }
    private  fun actividad(){
        val intent = Intent(this,Actividad::class.java)
        startActivity(intent)
    }
    private fun entraHome() {
        val intent = Intent(this, MainActivity3::class.java)
        startActivity(intent)
    }
    private fun saludar(){
        val nombre = findViewById<EditText>(R.id.nombre)
        val palabra = nombre.text.toString()
        val spinnerOpciones =findViewById<Spinner>(R.id.opciones)
        val options = listOf("Masculino","Femenino")

        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerOpciones.adapter
        var selectOpcion=""

        spinnerOpciones.onItemSelectedListener=object:AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?,view: View,position: Int, id: Long) {
                selectOpcion= options[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        Toast.makeText(this,"Hola,$palabra,Tu genero es:$selectOpcion",Toast.LENGTH_SHORT).show()
    }
}
