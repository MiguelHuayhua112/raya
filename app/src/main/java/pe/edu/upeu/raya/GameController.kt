package pe.edu.upeu.raya

class GameController {
    //aqui estaran los tipos de juego como empate, ganar o perder

    enum class EstadoPartida{
        JUGADOR1_GANO, JUGADOR2_GANO, EMPATE, NO_TERMINO
    }


    private lateinit var tablero: Array<Array<Char>>

    fun nuevoTablero(): Array<Array<Char>>{
        tablero =  Array(3) { Array(3) {'-'} }
        return tablero
    }

    fun estadoPartida(): EstadoPartida{
        
    }
}