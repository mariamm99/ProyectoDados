package ProyectoDados.juegoRisco;

import java.util.Scanner;

public class TestDados {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int nJugadores;
    String nombreTmp;
    
    // Recojo el número de jugadores, y se los paso a Partida
    System.out.print("Indica cuantos jugadores sois: ");
    nJugadores = sc.nextInt();
    // Creo una partida
    Partida partida = new Partida(nJugadores);
    // Creo jugadores, llamando a crearJugadores en Partida
    for (int i=1;i<=nJugadores;i++) {
      System.out.print("Introduce el nombre del jugador " + i + ": ");
      nombreTmp = sc.next();
      partida.crearJugadores(i, nombreTmp);
    }
    
    /* BORRAR */
    partida.muestraTablero();

    Dados d1 = new Dados();

    System.out.println(d1);

    System.out.println("indique cuantos dados vas a cambiar");
    int dadosCambiar = sc.nextInt();

    d1.cambiarDados(dadosCambiar);
    System.out.println(d1);

    // para recorrer los 13 juegos
    for (int i = 0; i < 13; i++) {

      System.out.println("Menu inicial indique la letra de lo que quiere realizar: \n "
          + "[1]Risco \n [2]Trece \n [3]Escalera Mayor \n [4] Escalera Menor \n "
          + "[5]Escalera par \n [6]Escalera impar \n [7] tres iguales \n [8] seis \n " + "[8] cinco \n "
          + "[9] cinco \n " + "[10]cuatro  \n [11]tres  \n [12]dos  \n [13]ases \n   ");

      int opcion;
      opcion = sc.nextInt();

      switch (opcion) {
      case 1:
        Partida.Risco(d1);
        break;
      case 2:
        Partida.Trece(d1);
        break;
      case 3:
        Partida.EscaleraMayor(d1);
        break;

      case 4:
        Partida.EscaleraMenor(d1);
        break;

      case 5:
        Partida.EscaleraPar(d1);
        break;

      case 6:
        Partida.EscaleraImpar(d1);
        break;

      case 7:
        Partida.Trio(d1);
        break;

      case 8:
        Partida.numero(d1, 6);
        break;

      case 9:
        Partida.numero(d1, 5);
        break;

      case 10:
        Partida.numero(d1, 4);
        break;

      case 11:
        Partida.numero(d1, 3);
        break;

      case 12:
        Partida.numero(d1, 2);
        break;

      case 13:
        Partida.numero(d1, 1);
        break;

      default:
        break;
      }

    }

    // Partida.Risco(d1);

//    for (int i = 1; i <= nJugadores; i++) {
//      String nombreTirada ="tirada" + i;
//      System.out.println(nombreTirada);
//      
//      for (int j = 0; j < args.length; j++) {
//        EjercicioDados nombreTirada = new EjercicioDados(i, nJugadores);
//      }
    
    sc.close();
  }

}
