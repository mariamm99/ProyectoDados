package ProyectoDados.juegoRisco;

import java.util.ArrayList;
import java.util.Scanner;

public class Partida {
  // Scanner
  Scanner sc = new Scanner(System.in);

  // Atributos
  int ronda;
  int nJugadores;

  static ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

  public Partida(int nJugadores) {
    this.nJugadores = nJugadores;
    this.ronda = 1;
  }

  // Getters & Setters
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

  public void crearJugadores(int nj, String nombre) {
    Jugador jugador = new Jugador(nj, nombre);
    jugadores.add(jugador);
  }

//  public int numeroJugador(Jugador player) {
//    return player.getNj();
//  }
  // PRUEBA PARA SACAR EL JUGADOR DE OTRA FORMA A LO DE INDEXOF...

  
  public void cambiarDados() {
 
    
  }
  
  public void muestraTablero() {
    String[] juegos = { "\t" + "Risco", "Trece", "E.Mayor", "E.Menor", "E.Par", "E.Impar", "Trio", "Seis", "Cinco",
        "Cuatro", "Tres", "Dos", "As", "Total" };
    System.out.println();
    for (int i = 0; i <= juegos.length - 1; i++) {
      System.out.print(juegos[i] + "\t");
    }
    for (int i = 0; i < nJugadores; i++) {
      for (int j = 0; j <= 14; j++) {
        if (j == 0) {
          System.out.print("\n" + jugadores.get(jugadores.indexOf(new Jugador(i + 1))).nombre + "\t"); // Del ArrayList
                                                                                                       // de jugadores
                                                                                                       // obtén j y de
                                                                                                       // ese jugador
                                                                                                       // saca i del
                                                                                                       // ArrayList de
                                                                                                       // puntuaciones
                                                                                                       // (p). ¿Sería i
                                                                                                       // u tendríamos
                                                                                                       // que hacer otro
                                                                                                       // bucle? EL 2 ES
                                                                                                       // TEMPORAL
        } else {
          System.out.print(jugadores.get(jugadores.indexOf(new Jugador(i + 1))).p.get(j - 1) + "\t");
        }
      }
    }

  }

  public static boolean casillaVacia(int casilla) {
    /*
     * Cada juego, pasa como argumento de casillaVacia el número de posición en el
     * ArrayList, por ejemplo, en un Risco, se llamaría a casillaVacia(0)
     */
    /*
     * Cambiar nJugador por el que sea... ¿Como?
     */
    if (jugadores.get(jugadores.indexOf(new Jugador(1))).p.get(casilla).equals(null)) { // En el ArrayList, null es
                                                                                        // vacío, es decir, sin puntos
      return true;
    } else {
      return false;
    }
  }

  /*
   * Metodo para comprobacion del Risco
   */

  public static String Risco(Jugador player) {
    if (casillaVacia(0)) {
      if ((player.dadosJugador.getD1() == player.dadosJugador.getD2()
          || player.dadosJugador.getD1() == player.dadosJugador.getD3()
          || player.dadosJugador.getD2() == player.dadosJugador.getD3())
          && (player.dadosJugador.getD1() + player.dadosJugador.getD2() + player.dadosJugador.getD3() == 13)) {

        // tablero(0, 50);
        return "Casilla Risco completada, 50 ptos";
      } else {
        return "Esta conbinación de números no es un risco";
      }

    } else {
      return "Casilla ocupada";
    }

  }

  /*
   * Metodo para comprobacion del Trece
   */

  public static String Trece(Jugador player) {
    if (casillaVacia(1)) {
      if (player.dadosJugador.getD1() + player.dadosJugador.getD2() + player.dadosJugador.getD3() == 13) {
        return "Esta conbinación de números no es un trece";
      } else {

        // tablero(1, 50);
        return "Casilla trece completada, 26 ptos";
      }
    } else {
      return "Casilla ocupada";
    }

  }

  /*
   * Metodo para comprobacion de la Escalera Mayor
   */

  public static String EscaleraMayor(Jugador player) {
    if (casillaVacia(2)) {
      for (int i = 4; i <= 6; i++) {

        if (player.dadosJugador.getD1() != i || player.dadosJugador.getD2() != i || player.dadosJugador.getD3() != i) {

          return "Esta combinacion de dados no es una Escalera Mayor";

        } else {

          return "Esta combinacion es una Escalera Mayor";

        }

      }
    }
    return "Casilla ocupada";

  }

  /*
   * Metodo para comprobacion de la Escalera Menor
   */
  public static String EscaleraMenor(Jugador player) {
    if (casillaVacia(3)) {

      for (int i = 1; i <= 3; i++) {

        if (player.dadosJugador.getD1() != i || player.dadosJugador.getD2() != i || player.dadosJugador.getD3() != i) {

          return "Esta combinacion de dados no es una Escalera Menor";

        } else {
          return "Esta combinacion es una Escalera Menor";
        }
      }
    }
    return "Casilla ocupada";

  }

  /*
   * Metodo para comprobacion de la Escalera Par
   */
  public static String EscaleraPar(Jugador player) {
    if (casillaVacia(4)) {

      for (int i = 1; i <= 5; i += 2) {

        if (player.dadosJugador.getD1() != i || player.dadosJugador.getD2() != i || player.dadosJugador.getD3() != i) {

          return "Esta combinacion de dados no es una Escalera Par";
        } else {
          return "Esta combinacion es una Escalera Par";
        }
      }
    }

    return "Casilla ocupada";
  }

  /*
   * Metodo para comprobacion de la Escalera Impar
   */
  public static String EscaleraImpar(Jugador player) {
    if (casillaVacia(5)) {

      for (int i = 2; i <= 6; i += 2) {

        if (player.dadosJugador.getD1() != i || player.dadosJugador.getD2() != i || player.dadosJugador.getD3() != i) {

          return "Esta combinacion de dados no es una Escalera Impar";

        } else {

          return "Esta combinacion es una Escalera Impar";

        }
      }
    }

    return "Casilla ocupada";

  }

  static String Trio(Jugador player) {
    if (casillaVacia(6)) {
      if (player.dadosJugador.getD1() == player.dadosJugador.getD2()
          && player.dadosJugador.getD1() == player.dadosJugador.getD3()) {

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

  static String numero(Jugador player, int n) {
    int puntos = 0;
    if (player.dadosJugador.getD1() == n) {
      puntos += n;
    }
    if (player.dadosJugador.getD2() == n) {
      puntos += n;
    }
    if (player.dadosJugador.getD3() == n) {
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
      return "Casilla ocupada";
    }
  }

  @Override
  public String toString() {
    return "\n Partida ronda=" + ronda + ", nJugadores=" + nJugadores ;
  }
}
