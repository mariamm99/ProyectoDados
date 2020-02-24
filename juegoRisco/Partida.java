package ProyectoDados.juegoRisco;

import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
  // Scanner
  Scanner s = new Scanner(System.in);

  // Atributos
  int ronda;
  int nJugadores;

  static ArrayList<Jugador> partida = new ArrayList<Jugador>();

  static void crearJugadores(String nombre) {

    Jugador jugador = new Jugador(nombre);
    partida.add(jugador);
  }

  public Partida(int nJugadores) {
    setnJugadores(nJugadores);
    this.ronda = 1;
  }

// Método para crear Jugadores (Jugador). Habrá que llamarlo en main.
//  public void creaJugador() {
//    String nombretmp;
//    for (int i = 0; i <= this.nJugadores; i++) {
//      System.out.println("Introduce el nombre del jugador " + i + ": ");
//      nombretmp = s.next();
//      // TODO: Ahora como hacemos que cree tantas instancias de jugador según
//      // nJugadores?
//    }
//  }

  // Comento esto temporalmente, en sustitución de muestraTablero
  // public int[][] tablero(int casilla, int puntos) {

  public int getRonda() {
    return ronda;
  }

  public void setRonda(int ronda) {
    this.ronda = ronda;
  }

  public int getnJugadores() {
    return nJugadores;
  }

  public void setnJugadores(int nJugadores) {
    this.nJugadores = nJugadores;
  }

  public void muestraTablero() {
    String[] juegos = { " ", "Risco", "Trece", "Escalera mayor", "Escalera menor", "Escalera par", "Escalera impar",
        "Tres iguales", "Seis", "Cinco", "Cuatro", "Tres", "Dos", "As", "Total" };
    System.out.println();
    for (int i = 0; i <= juegos.length; i++) {
      System.out.print(juegos[i] + "\t");
      for (int j = 0; j <= this.nJugadores; j++) {
        System.out.println();
      }
    }
  }

  public static boolean casillaVacia(int casilla) {
    /* Habría que crear el jugador, temporalmente ¿j1? */
    /*
     * Cada juego, pasa como argumento de casillaVacia el número de posición en el
     * ArrayList, por ejemplo, en un Risco, se llamaría a casillaVacia(0)
     */
    // partida[casilla]
    if (0 == 0) { // En el ArrayList, 0 es vacío, es decir, sin puntos
      return true;
    } else {
      return false;
    }
  }

  /*
   * Metodo para comprobacion del Risco
   */

  public static String Risco(Dados dados) {
    if (casillaVacia(0)) {
      if ((dados.getD1() == dados.getD2() || dados.getD1() == dados.getD3() || dados.getD2() == dados.getD3())
          && (dados.getD1() + dados.getD2() + dados.getD3() == 13)) {

        // tablero(0, 50);
        return "Casilla Risco completada, 50 ptos";
      } else {
        return "Esta conbinación de números no es un risco";
      }

    } else {
      return "casilla ocupada";
    }

  }

  /*
   * Metodo para comprobacion del Trece
   */

  public static String Trece(Dados dados) {
    if (casillaVacia(1)) {
      if (dados.getD1() + dados.getD2() + dados.getD3() == 13) {
        return "Esta conbinación de números no es un trece";
      } else {

        // tablero(1, 50);
        return "Casilla trece completada, 26 ptos";
      }
    } else {
      return "casilla ocupada";
    }

  }

  /*
   * Metodo para comprobacion de la Escalera Mayor
   */

  public static boolean EscaleraMayor(Dados dados) {
    if (casillaVacia(2)) {
      for (int i = 4; i <= 6; i++) {

        if (Dados.getD1() != i || Dados.getD2() != i || Dados.getD3() != i) {

          return false;

        }
      }

      return true;

    }
    return false;
  }

  /*
   * Metodo para comprobacion de la Escalera Menor
   */

  public static boolean EscaleraMenor(Dados dados) {
    if (casillaVacia(3)) {

      for (int i = 1; i <= 3; i++) {

        if (Dados.getD1() != i || Dados.getD2() != i || Dados.getD3() != i) {

          return false;

        }
      }

      return true;

    }
    return false;
  }

  /*
   * Metodo para comprobacion de la Escalera Par
   */

  public static boolean EscaleraPar(Dados dados) {
    if (casillaVacia(4)) {

      for (int i = 1; i <= 5; i += 2) {

        if (Dados.getD1() != i || Dados.getD2() != i || Dados.getD3() != i) {

          return false;

        }
      }

      return true;

    }
    return false;
  }

  /*
   * Metodo para comprobacion de la Escalera Impar
   */

  public static boolean EscaleraImpar(Dados dados) {
    if (casillaVacia(5)) {

      for (int i = 2; i <= 6; i += 2) {

        if (Dados.getD1() != i || Dados.getD2() != i || Dados.getD3() != i) {

          return false;

        }
      }
    }
    return true;
  }


  static String Trio(Dados dados) {
    if (casillaVacia(6)) {
      if (Dados.getD1() == Dados.getD2() && Dados.getD1() == Dados.getD3()) {

        // this.tablero(6, 50);
        return "Casilla Risco completada, 50 ptos";
      } else {
        return "casilla ocupada";
      }

    } else {
      return "Esta conbinación de números no es un risco";
    }

  }

  /**
   * La puntuación por números puede ser la misma función e indicarle el número
   * que es.
   */

  static String numero(Dados dados, int n ) {
    int puntos = 0;
    if (Dados.getD1() == n) {
      puntos += n;
    }
    if (Dados.getD2() == n) {
      puntos += n;
    }
    if (Dados.getD3() == n) {
      puntos += n;
    }

    int casilla = 0;
    if (n == 6) {
      casilla = 7;
    } else if (n == 5) {
      casilla = 8;
    } else if (n == 4) {
      casilla = 9;
    } else if (n == 3) {
      casilla = 10;
    } else if (n == 2) {
      casilla = 11;
    } else if (n == 1) {
      casilla = 12;
    }

    if (casillaVacia(casilla)) {
      // this.tablero(casilla, n);
      return "Casilla Risco completada " + n + " ptos";
    } else {
      return "casilla ocupada";
    }
  }

}
