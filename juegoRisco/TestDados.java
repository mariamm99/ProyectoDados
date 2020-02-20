package ProyectoDados.juegoRisco;

import java.util.Scanner;



public class TestDados {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int nJugadores;
 
    System.out.println("indica cuantos jugadores son");
    nJugadores = sc.nextInt();

 

    Dados d1 = new Dados();

    System.out.println(d1);
    
    System.out.println("indique cuantos dados vas a cambiar");
    int dadosCambiar= sc.nextInt();
    
    d1.cambiarDados(dadosCambiar);
    System.out.println(d1);
    
    Partida.Risco(d1);


//    for (int i = 1; i <= nJugadores; i++) {
//      String nombreTirada ="tirada" + i;
//      System.out.println(nombreTirada);
//      
//      for (int j = 0; j < args.length; j++) {
//        EjercicioDados nombreTirada = new EjercicioDados(i, nJugadores);
//      }
    }
    
  }

