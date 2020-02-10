package ejercicioDados;

public class EjercicioDados {

  /**
   * Creamos las clases según los distintos tipos de puntuaciones de los dados
   **/

  int d1;
  int d2;
  int d3;
  /**
   * si es el 1º el 2º jugador*/
  int jugador;

  public EjercicioDados(int d1, int d2, int d3,int jugador) {
    this.d1 = d1;
    this.d2 = d2;
    this.d3 = d3;
    this.jugador=jugador;
    
    
    /**
     * pa darle valor a los dados
     * 
     *  
     * **/
    
  }



  /**
   * Generamos los get y los setters pa dados. En los set tendremes que realizar una
   * creación de números aleatorios entre 1-6 que será el resultado podemos crear
   * un solo set??????
   * 
   * Hago set separados por si quiere cambiar tiradas indicar que seters llamar
   */
  public int getD1() {
    return d1;
  }

  public void setD1(int d1) {
    this.d1 = (int) (Math.random()*6);
  }

  public int getD2() {
    return d2;
  }

  public void setD2() {
    this.d2 = (int) (Math.random() * 6 );
  }

  public int getD3() {

    return d3;
  }

  public void setD3(int d3) {
    this.d3 = (int) (Math.random() * 6 );
  }

  public boolean casillaVacia() {

    return false;
  }
  
  public int getJugador() {
    return jugador;
  }

  public void setJugador(int jugador) {
    this.jugador = jugador;
  }

  /**
   * Para crear la tabla de valores un array??
   * sería bidimensional 
   *            jugador1 | Jugador2 | ....
   * Risco
   * Trece 
   * ...
   * ptos Totales
   * */
  
  public int[][] tablero(int casilla, int puntos){
    /**
     * Escribir en el array y mostrarlo tras cada modificación y fin de tirada de un jugador.
     * */
    
    /**
     * no se donde crear el array
     */
    int[][] tablero = new int[this.jugador][14];
    for (int i = 0; i < this.jugador; i++) {
      for (int j = 0; j < 14; j++) {
        System.out.println(tablero[i][j] + "/t");
      }
      
    }
    
   return tablero;
 
  }

  public boolean casillaVacia(int casilla, int puntos) {

    return false;
  }

  public String Risco() {
    if ((d1 == d2 || d1 == d3 || d2 == d3) && (d1 + d2 + d3 == 13)) {
      if (this.casillaVacia(Risco)) {
        this.tablero( Risco, 50);
        return "Casilla Risco completada, 50 ptos";
      } else {
        return "casilla ocupada";
      }

    } else {
      return "Esta conbinación de números no es un risco";
    }

  }

  public String Trece() {
    if  (d1+d2+d3!=13) {
      return "Esta conbinación de números no es un risco";
   } else {
     if (this.casillaVacia(trece)) {
      this.tablero(trece, 50);
      return "Casilla Risco completada, 50 ptos";
    }else {
      return "casilla ocupada";
    }
    
  }
  }
    String Trio() {
      if  (d1 == d2 && d1 == d3  ) {
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
     * */
    
    
    /**
     * La puntuación por números puede ser la misma función e indicarle el número que es.
     * */
    
     int numero(int n){
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
      
      if (this.casillaVacia()) {
        this.tablero( n, n);
        return "Casilla Risco completada "+n + " ptos";
      } else {
        return "casilla ocupada";
      }
    }
    }
  

}
