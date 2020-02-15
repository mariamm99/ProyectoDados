package ejercicioDados;

public class Partida {

  // Atributos
  int ronda;
  
  public Partida(int jugador, int nJugadores) {
    
  
  /**
   * Para crear la tabla de valores un array?? sería bidimensional jugador1 |
   * Jugador2 | .... Risco Trece ... ptos Totales
   */

  // TODO: Comento esto temporalmente, en sustitución de muestraTablero
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
   * ESCALERAS NO SE HACERLAS
   */

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
  

}
