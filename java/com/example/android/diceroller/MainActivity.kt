/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    //contenedor de imagenes
    lateinit var diceImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //se carga el layout de la app
        setContentView(R.layout.activity_main2) //R es el directorio res, layout es la subcarpeta layout, y el activity_main es el xml que contiene la interfaz de la app
        //Se carga el boton
        val rollButton: Button = findViewById(R.id.boton_lanzar) //findviewbyid es la funcion que busca el xml con el id roll_button
        //Cuando el usuario interactua con el boton ejecuta la funcion rolldice
        rollButton.setOnClickListener {
            rollDice()
        }
        //se carga la imagen inicial
        diceImage = findViewById(R.id.dado_imagen)
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(7) + 1 //numero aleatorio entre 1 y 7
        val drawableResource = when (randomInt) { //devuelve la imagen que se mostrará en pantalla
            1 -> R.drawable.dice_1 //cara 1
            2 -> R.drawable.dice_2 //cara 2
            3 -> R.drawable.dice_3 //cara 3
            4 -> R.drawable.dice_4 //cara 4
            5 -> R.drawable.dice_5 //cara 5
            6 -> R.drawable.dice_6 //cara 6
            else -> R.drawable.kirbo //cara derp
        }
        //Carga la imagen obtenida de la funcion anterior
        diceImage.setImageResource(drawableResource)
    }
}
