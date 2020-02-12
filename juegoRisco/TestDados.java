package ejercicioDados;

import java.util.Scanner;

import Inicio.Fraccion;

public class TestDados {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int nJugadores;
    /**
     * Mostrar tabla
     */
    System.out.println("indica cuantos jugadores son");
    nJugadores = sc.nextInt();

    /**
     * bucle para las tiradas??? pa saber cuantas tiradas hay ssegún el nJugadores
     **/

    for (int i = 1; i <= nJugadores; i++) {
      String nombreTirada ="tirada" + i;
      System.out.println(nombreTirada);
      
      for (int j = 0; j < args.length; j++) {
        EjercicioDados nombreTirada = new EjercicioDados(i, nJugadores);
      }
    }
    
  }
}
