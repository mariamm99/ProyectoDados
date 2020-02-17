package juegoRisco;

import java.util.Scanner;

public class Partida {

  // Scanner
  Scanner s = new Scanner(System.in);
  
  // Atributos
  int ronda;
  int nJugadores;
  
  public Partida(int nJugadores) {
    this.nJugadores = nJugadores;
    this.ronda = 1;
  }
  
  // Método para crear Jugadores (Jugador). Habrá que llamarlo en main.
  public void creaJugador() {
    String nombretmp;
    for (int i=0;i<=this.nJugadores;i++) {
      System.out.println("Introduce el nombre del jugador " + i + ": ");
      nombretmp = s.next();
      // TODO: Ahora como hacemos que cree tantas instancias de jugador según nJugadores?
    }
  }
    
  // Comento esto temporalmente, en sustitución de muestraTablero
  // public int[][] tablero(int casilla, int puntos) {
    /**
     * Escribir en el array y mostrarlo tras cada modificación y fin de tirada de un
     * jugador.
     */
    /**
     * no se donde crear el array
     */
    /* int[][] tablero = new int[this.nJugadores][14];
    for (int i = 0; i < this.jugador; i++) {
      for (int j = 0; j < 14; j++) {
        System.out.println(tablero[i][j] + "/t");
      }

    }
    return tablero;
  } */
  
  public void muestraTablero() {
    String[] juegos = {" ", "Risco", "Trece", "Escalera mayor", "Escalera menor", "Escalera par", "Escalera impar", "Tres iguales", "Seis", "Cinco", "Cuatro", "Tres", "Dos", "As", "Total"}
    System.out.print();
    for (int i=0;i<=juegos.length;i++) {
      System.out.print(juegos[i] + "\t");
      for (int j=0;j<=this.nJugadores;j++) {
        System.out.println();
      }
    }
  }
  
  public boolean casillaVacia(int casilla) {
    /* Habría que crear el jugador, temporalmente ¿j1?*/
    /* Cada juego, pasa como argumento de casillaVacia el número de posición 
     * en el ArrayList, por ejemplo, en un Risco, se llamaría a 
     * casillaVacia(0)
     */
    if (j1.p.get(casilla)==0) { // En el ArrayList, 0 es vacío, es decir, sin puntos
      return true;
    } else {
      return false;
    }
  }


// METODOS DE COMPROBACION DE LAS DISTINTAS PUNTUACIONES DE LA PARTIDA 

  /*
  *   Metodo para comprobacion del Risco
  */

  public String Risco() {
    if ((d1 == d2 || d1 == d3 || d2 == d3) && (d1 + d2 + d3 == 13)) {
      if (this.casillaVacia(Risco)) {
        this.tablero(Risco, 50);
        return "Casilla Risco completada, 50 ptos";
      } else {
        return "casilla ocupada";
      }

    } else {
      return "Esta conbinación de números no es un risco";
    }

  }

  /*
  *   Metodo para comprobacion del Trece
  */

  public String Trece() {
    if (d1 + d2 + d3 != 13) {
      return "Esta conbinación de números no es un trece";
    } else {
      if (this.casillaVacia(trece)) {
        this.tablero(trece, 50);
        return "Casilla trece completada, 26 ptos";
      } else {
        return "casilla ocupada";
      }

    }
  }

  /*
  *   Metodo para comprobacion de la Escalera Mayor
  */

  public boolean EscaleraMayor() {
    if (this.casillaVacia(casilla)){
      for (int i = 4 ; i <= 6 ; i++){

        if (d1 != i || d2 != i || d3 != i){

          return false;

        } 
      }

      return true;

    }
    }
  }

  /*
  *   Metodo para comprobacion de la Escalera Menor
  */

  public boolean EscaleraMenor() {
    if (this.casillaVacia(casilla)) {

      for (int i = 1 ; i <= 3 ; i++){

        if (d1 != i || d2 != i || d3 != i){

          return false;

        } 
      }

      return true;

    }
  }

  /*
  *   Metodo para comprobacion de la Escalera Par
  */

  public boolean EscaleraPar() {
    if (this.casillaVacia(casilla)) {

      for (int i = 1 ; i <= 5 ; i += 2){

        if (d1 != i || d2 != i || d3 != i){

          return false;

        } 
      }

      return true;

    }
  }

  /*
  *   Metodo para comprobacion de la Escalera Impar
  */

  public boolean EscaleraImpar() {
    if (this.casillaVacia(casilla)) {

      for (int i = 2 ; i <= 6 ; i += 2){

        if (d1 != i || d2 != i || d3 != i){

          return false;

        } 
      }

      return true;

    }
  }



  /*
  *   Metodo para comprobacion del Trece
  */

  String Trio() {
    if (d1 == d2 && d1 == d3) {
      if (this.casillaVacia(Risco)) {
        this.tablero(Risco, 50);
        return "Casilla Risco completada, 50 ptos";
      } else {
        return "casilla ocupada";
      }

    } else {
      return "Esta conbinación de números no es un risco";
    }

  }


    /**
     * La puntuación por números puede ser la misma función e indicarle el número que es.
     * */
    
    String numero(int n){
      int puntos=0;
      if (d1==n) {
        puntos+=n;
      }
      if (d2==n) {
        puntos+=n;
      }
      if (d3==n) {
        puntos+=n;
      }
      
      if (this.casillaVacia(n)) {
        this.tablero( n, n);
        return "Casilla Risco completada "+n + " ptos";
      } else {
        return "casilla ocupada";
      }
    }

  int Ntablero(n){
       switch (n) {
      case Risco:
        
        break;
        
      case Trece:
        
        break;
      case a:
        
        break;

      default:
        break;
      }
       
       
     }
  
  s.close();
}
