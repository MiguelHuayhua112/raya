

package pe.edu.upeu.raya

import android.widget.LinearLayout
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upeu.raya.ui.theme.RayaTheme


class MainActivity : ComponentActivity() {

     private val gameController = GameController()
     private lateinit var tablero: Array<Array<Char>>
     private var gameOver = false
     private var turnoJugador1 = true
    private lateinit var tableroLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tableroLayout = findViewById(R.id.tableroLayout)

        inicializarPartida()
        inicializarListeners()

    }

    private fun inicializarPartida(){
        tablero = gameController.nuevoTablero()
        gameOver = false
        turnoJugador1 = true
    }
        private fun inicializarListeners(){
            for(i in 0 until tableroLayout.childCount){
               // val fila = tableroLayout[i] as LinearLayout
                val fila = tableroLayout.getChildAt(i) as LinearLayout
                for(j in 0 until fila.childCount){
                    //val ficha = fila[j] as ImageView
                    val ficha = fila.getChildAt(j) as ImageView
                    ficha.setOnClickListener{
                        if(tablero[i][j]== '-'){ // el guion significa click
                            setFicha(ficha, i, j)
                            turnoJugador1 = !turnoJugador1 //se le dara el valor opuesto
                        }

                        //ficha.setImageDrawable(getDrawable(R.drawable.circulo))
                    }


            }
        }

    }

    private fun setFicha(view: ImageView, posicionFila: Int, posicionColumna: Int){
        if(turnoJugador1){
            tablero[posicionFila][posicionColumna] = 'o'
            view.setImageDrawable(getDrawable(R.drawable.circulo))
        } else{
            tablero[posicionFila][posicionColumna] = 'o'
            view.setImageDrawable(getDrawable(R.drawable.cruz))
        }
    }
}