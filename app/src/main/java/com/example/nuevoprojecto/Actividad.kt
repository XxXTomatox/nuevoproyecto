package com.example.nuevoprojecto

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class Actividad : AppCompatActivity() {
    private lateinit var redir: Button
    private lateinit var saludar: Button
    private lateinit var genero: Spinner
    private lateinit var estado:Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_actividad)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            redir = findViewById(R.id.redireccion)
            saludar = findViewById(R.id.alerta)
            genero = findViewById(R.id.genero)
            estado = findViewById(R.id.estado)

            val options = listOf("Masculino", "Femenino")
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            genero.adapter = adapter

            val estados = listOf("Aguascalientes","Ciudad de México","Estado de México","Hidalgo","Chiapas")
            val estadosad=ArrayAdapter(this, android.R.layout.simple_spinner_item, estados)
            estadosad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            estado.adapter = estadosad

            redir.setOnClickListener {
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
    private fun entraHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    private fun saludar(){
        val nombre = findViewById<EditText>(R.id.nombre)
        val palabra = nombre.text.toString()
        val edad = findViewById<EditText>(R.id.edad)
        val Edad= edad.text.toString()

        val genero = genero.selectedItem.toString()
        val estado = estado.selectedItem.toString()

        val dialogView=layoutInflater.inflate(R.layout.custom_dialog,null)

        val dialogTitle = dialogView.findViewById<TextView>(R.id.dialog_title)
        val dialogMessage =dialogView.findViewById<TextView>(R.id.dialog_message)

        dialogTitle.text="Confirmar"
        dialogMessage.text="¿quieres saludar?"
        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
        val dialog=builder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        val btnCanceler = dialogView.findViewById<Button>(R.id.cancelar)
        val btnAceptar = dialogView.findViewById<Button>(R.id.aceptar)
        btnCanceler.setOnClickListener{
            dialog.dismiss()
        }
        btnAceptar.setOnClickListener{
            dialog.dismiss()
            mostrarDatos(palabra,Edad,genero,estado)
        }
    }
    private fun mostrarDatos(nombre:String,edad:String,genero:String,estado:String){
        val dialogView=layoutInflater.inflate(R.layout.custom_dialog,null)

        val dialogTitle = dialogView.findViewById<TextView>(R.id.dialog_title)
        val dialogMessage =dialogView.findViewById<TextView>(R.id.dialog_message)

        dialogTitle.text="Saludo"
        dialogMessage.text="nombre:$nombre\nEdad:$edad\nGenero:$genero\nEstado:$estado"
        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
        val dialog=builder.create()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        val btnCanceler = dialogView.findViewById<Button>(R.id.cancelar)
        val btnAceptar = dialogView.findViewById<Button>(R.id.aceptar)
        btnCanceler.setOnClickListener{
            dialog.dismiss()
        }
        btnAceptar.setOnClickListener{
            dialog.dismiss()
            Toast.makeText(this,"Accion Completa",Toast.LENGTH_LONG).show()
        }
    }

}