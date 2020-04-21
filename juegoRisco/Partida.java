//package ProyectoDados.juegoRisco;

import java.util.ArrayList;

public class Partida {

  // Atributos
  private int ronda;
  private int nJugadores;

   ArrayList<Jugador> jugadores = new ArrayList<Jugador>();

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

  /**
   * Método para crear jugadores para la partida.
   * 
   * @param nj (Número de jugadores)
   * @param nombre (Nombre del jugador)
   */
  public void crearJugadores(int nj, String nombre) {
    Jugador jugador = new Jugador(nj, nombre);
    jugadores.add(jugador);
  }

  /**
   * Método estático para que el jugador tire sus dados.
   * 
   * @param Jugador
   * @return
   */
  public static Dados tirarDados(Jugador player) {
    player.setDadosJugador(new Dados());
    return player.dadosJugador;
  }

  /**
   * Método para mostrar por pantalla el tablero de la partida actual.
   * 
   */
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
          System.out.print("\n" + jugadores.get(jugadores.indexOf(new Jugador(i + 1))).getNombre() + "\t");
        } else {
          if (jugadores.get(jugadores.indexOf(new Jugador(i + 1))).p.get(j - 1) != null) {
            System.out.print(jugadores.get(jugadores.indexOf(new Jugador(i + 1))).p.get(j - 1) + "\t");
          } else {
            System.out.print("\t");
          }
        }
      }
    }

  }

  /**
   * Método para comprobar si una casilla está vacía o no.
   * 
   * @param Jugador
   * @param casilla
   * @return boolean
   */
  public static boolean casillaVacia(Jugador player, int casilla) {
    if (player.p.get(casilla) == null) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Método de comprobación: Risco.
   * 
   * @param player
   * @return
   */
  public static String Risco(Jugador player) {
    if (!casillaVacia(player, 0)) {
      return "Casilla ocupada";
    }
    if ((player.dadosJugador.getD1() == player.dadosJugador.getD2()
        || player.dadosJugador.getD1() == player.dadosJugador.getD3()
        || player.dadosJugador.getD2() == player.dadosJugador.getD3())
        && (player.dadosJugador.getD1() + player.dadosJugador.getD2() + player.dadosJugador.getD3() == 13)) {

      player.p.set(0, 50);
      player.p.set(13, player.totalPtos(0));
      return "Casilla Risco completada, 50 ptos";
    } else {
      player.p.set(0,0);
      player.p.set(13, player.totalPtos(0));
      return "Esta combinación de números no es un risco";
    }
  }

  /**
   * Método de comprobación: Trece.
   * 
   * @param player
   * @return
   */
  public static String Trece(Jugador player) {
    if (!casillaVacia(player, 1)) {
      return "Casilla ocupada";
    }
    if (player.dadosJugador.getD1() + player.dadosJugador.getD2() + player.dadosJugador.getD3() == 13) {
      player.p.set(1, 26);
      player.p.set(13, player.totalPtos(1));
      return "Casilla Trece completada, 26 ptos";
    } else {
      player.p.set(1,0);
      player.p.set(13, player.totalPtos(1));
      return "Esta combinación de números no es un trece";

    }
  }

  /**
   * Método de comprobación: Escalera Mayor.
   * 
   * @param player
   * @return
   */
  public static String EscaleraMayor(Jugador player) {
    boolean valord1 = false;
    boolean valord2 = false;
    boolean valord3 = false;

    if (!casillaVacia(player, 2)) {
      return "Casilla ocupada";
    }
    for (int i = 4; i <= 6; i++) {
    
      if (player.dadosJugador.getD1() == i) {
        valord1 = true;
      } else if (player.dadosJugador.getD2() == i) {
        valord2 = true;
      } else if (player.dadosJugador.getD3() == i) {
        valord3 = true;
      } else {
        player.p.set(2,0);
        player.p.set(13, player.totalPtos(2));
        return "Esta combinación de dados no es una Escalera Mayor";
      }
    }
    
    if (valord1 && valord2 && valord3) {
      player.p.set(2, 20);
      player.p.set(13, player.totalPtos(2));
    }
    return "Esta combinación es una Escalera Mayor, 20 ptos";
  }

  /**
   * Método de comprobación: Escalera Menor.
   * 
   * @param player
   * @return
   */
  public static String EscaleraMenor(Jugador player) {
    boolean valord1 = false;
    boolean valord2 = false;
    boolean valord3 = false;
    if (!casillaVacia(player, 3)) {
      return "Casilla ocupada";
    }

    for (int i = 1; i <= 3; i++) {

      if (player.dadosJugador.getD1() == i) {
        valord1 = true;
      } else if (player.dadosJugador.getD2() == i) {
        valord2 = true;
      } else if (player.dadosJugador.getD3() == i) {
        valord3 = true;
      } else {
        player.p.set(3,0);
        player.p.set(13, player.totalPtos(3));
        return "Esta combinación de dados no es una Escalera Menor";

      }
    }

    if (valord1 && valord2 && valord3) {
      player.p.set(3, 20);
      player.p.set(13, player.totalPtos(3));
    }
    return "Esta combinación es una Escalera Menor, 20 ptos";
  }

  /**
   * Método de comprobación: Escalera Par.
   * 
   * @param player
   * @return
   */
  public static String EscaleraPar(Jugador player) {
    boolean valord1 = false;
    boolean valord2 = false;
    boolean valord3 = false;
    if (!casillaVacia(player, 4)) {
      return "Casilla ocupada";
    }

    for (int i = 2; i <= 6; i += 2) {

      if (player.dadosJugador.getD1() == i) {
        valord1 = true;
      } else if (player.dadosJugador.getD2() == i) {
        valord2 = true;
      } else if (player.dadosJugador.getD3() == i) {
        valord3 = true;
      } else {
        player.p.set(4,0);
        player.p.set(13, player.totalPtos(4));
        return "Esta combinación de dados no es una Escalera Par";
      }

    }
    if (valord1 && valord2 && valord3) {
      player.p.set(4, 20);
      player.p.set(13, player.totalPtos(4));
    }
    return "Esta combinaci�n es una Escalera Par, 20 ptos";
  }

  /**
   * Método de comprobación: Escalera Impar.
   * 
   * @param player
   * @return
   */
  public static String EscaleraImpar(Jugador player) {
    boolean valord1 = false;
    boolean valord2 = false;
    boolean valord3 = false;

    if (!casillaVacia(player, 5)) {
      return "Casilla ocupada";
    }
    for (int i = 2; i <= 6; i += 2) {

      if (player.dadosJugador.getD1() == i) {
        valord1 = true;
      } else if (player.dadosJugador.getD2() == i) {
        valord2 = true;
      } else if (player.dadosJugador.getD3() == i) {
        valord3 = true;
      } else {
        player.p.set(5,0);
        player.p.set(13, player.totalPtos(5));
        return "Esta combinación de dados no es una escalera impar";
      }

    }
    if (valord1 && valord2 && valord3) {
      player.p.set(5, 20);
      player.p.set(13, player.totalPtos(5));
    }
    return "Esta combinación es una escalera impar, 20 ptos";
  }

  /**
   * Método de comprobación: Trío.
   * 
   * @param player
   * @return
   */
  public static String Trio(Jugador player) {
    if (!casillaVacia(player, 6)) {
      return "Casilla ocupada";
    }
    if (player.dadosJugador.getD1() == player.dadosJugador.getD2()
        && player.dadosJugador.getD1() == player.dadosJugador.getD3()) {

      player.p.set(6, 25);
      player.p.set(13, player.totalPtos(6));
      return "Casilla Trío completada, 25 ptos";
    } else {
      player.p.set(6,0);
      player.p.set(13, player.totalPtos(6));
     
      return "Esta combinación de números no es un trío.";
    }
  }

  /**
   * Método de comprobación: Seis, cinco, cuatro, tres, dos, ases.
   * 
   * @param player
   * @param n (Número de juego, p. ej 5 en refencia al cinco)
   * @return
   */
  public static String numero(Jugador player, int n) {
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
    if (!casillaVacia(player, casilla)) {
      return "Casilla ocupada";
    }

    player.p.set(casilla, puntos);
    player.p.set(13, player.totalPtos(casilla));
    return "Casilla" + n + "completada con " + n + " ptos";
  }

  @Override
  public String toString() {
    return "\n Partida ronda=" + ronda + ", nJugadores=" + nJugadores;
  }
}
