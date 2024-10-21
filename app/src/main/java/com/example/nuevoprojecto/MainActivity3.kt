package com.example.nuevoprojecto

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
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
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity3 : AppCompatActivity() {
    private lateinit var resultado: Button
    private lateinit var operacion: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            resultado = findViewById(R.id.resultado)
            operacion = findViewById(R.id.operacion)

            val options = listOf("suma", "resta","multiplicacion","division")
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            operacion.adapter = adapter

            resultado.setOnClickListener{
                test()
            }


            val buttonNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
            buttonNavigationView.setOnNavigationItemSelectedListener { item ->
                when(item.itemId){
                    R.id.nav_home->{
                        Toast.makeText(this,"Estas en home", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        true
                    }
                    R.id.nav_settings->{
                        Toast.makeText(this,"Estas en configuracion", Toast.LENGTH_LONG).show()
                        val intent = Intent(this, MainActivity3::class.java)
                        startActivity(intent)
                        true
                    }
                    R.id.nav_profile->{
                        Toast.makeText(this,"Estas en perfil", Toast.LENGTH_LONG).show()
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

    private fun test() {
        val numero1 = findViewById<EditText>(R.id.N1)
        val Numero1= numero1.text.toString()
        val numero2 = findViewById<EditText>(R.id.N2)
        val Numero2 = numero2.text.toString()

        val operaciones = operacion.selectedItem.toString()

        when(operaciones){
            "suma"->{
                val aux1 = Integer.parseInt(Numero1)
                val aux2 = Integer.parseInt(Numero2)
                suma(aux1,aux2)
            }
            "resta"->{
                val aux1 = Integer.parseInt(Numero1)
                val aux2 = Integer.parseInt(Numero2)
                resta(aux1,aux2)
            }
            "multiplicacion"->{
                val aux1 = Integer.parseInt(Numero1)
                val aux2 = Integer.parseInt(Numero2)
                multiplicar(aux1,aux2)
            }
            "division"->{
                val aux1 = Integer.parseInt(Numero1)
                val aux2 = Integer.parseInt(Numero2)
                dividir(aux1,aux2)
            }
        }

    }
    private fun suma(aux1: Int,aux2:Int){
        val resultado = aux1 + aux2;

        val dialogView=layoutInflater.inflate(R.layout.custom_dialog,null)

        val dialogTitle = dialogView.findViewById<TextView>(R.id.dialog_title)
        val dialogMessage =dialogView.findViewById<TextView>(R.id.dialog_message)

        dialogTitle.text="Confirmar"
        dialogMessage.text="¿quieres sumar?"
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
            mostrarDatos(resultado)
        }
    }
    private  fun resta(aux1:Int,aux2: Int){
        val resultado = aux1 - aux2;
        val dialogView=layoutInflater.inflate(R.layout.custom_dialog,null)

        val dialogTitle = dialogView.findViewById<TextView>(R.id.dialog_title)
        val dialogMessage =dialogView.findViewById<TextView>(R.id.dialog_message)

        dialogTitle.text="Confirmar"
        dialogMessage.text="¿quieres restar?"
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
            mostrarDatos(resultado)
        }
    }
    private fun multiplicar(aux1:Int,aux2: Int){
        val resultado = aux1 * aux2;
        val dialogView=layoutInflater.inflate(R.layout.custom_dialog,null)

        val dialogTitle = dialogView.findViewById<TextView>(R.id.dialog_title)
        val dialogMessage =dialogView.findViewById<TextView>(R.id.dialog_message)

        dialogTitle.text="Confirmar"
        dialogMessage.text="¿quieres multiplicar?"
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
            mostrarDatos(resultado)
        }
    }
    private fun dividir(aux1:Int,aux2: Int){
        val resultado = aux1 / aux2;
        val dialogView=layoutInflater.inflate(R.layout.custom_dialog,null)

        val dialogTitle = dialogView.findViewById<TextView>(R.id.dialog_title)
        val dialogMessage =dialogView.findViewById<TextView>(R.id.dialog_message)

        dialogTitle.text="Confirmar"
        dialogMessage.text="¿quieres dividir?"
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
            mostrarDatos(resultado)
        }
    }

    private fun mostrarDatos(resultado: Int) {
        val dialogView=layoutInflater.inflate(R.layout.custom_dialog,null)

        val dialogTitle = dialogView.findViewById<TextView>(R.id.dialog_title)
        val dialogMessage =dialogView.findViewById<TextView>(R.id.dialog_message)

        dialogTitle.text="Resultado"
        dialogMessage.text="Tu resultado es:$resultado"
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