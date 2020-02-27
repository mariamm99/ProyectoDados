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
    // Crear una partida ////////
    Partida partida = new Partida(nJugadores);
    // Creo jugadores, llamando a crearJugadores en Partida
    for (int i=1;i<=nJugadores;i++) {
      System.out.print("Introduce el nombre del jugador " + i + ": ");
      nombreTmp = sc.next();
      partida.crearJugadores(i, nombreTmp);
    }
    
    /* BORRAR ¿? ¿Llamadas de prueba?
 
    Dados d1 = new Dados();

    System.out.println(d1);

    System.out.println("Indique cuantos dados vas a cambiar:");
    int dadosCambiar = sc.nextInt();

    d1.cambiarDados(dadosCambiar);
    System.out.println(d1);
    */
    
    //int jugadorActual;
    // Asignación temporal, hay que implementar una forma de saber cual es el jugador que
    // está jugando.
    //jugadorActual = 1;
    
    // para recorrer los 13 juegos
    for (int i = 0; i < 13; i++) {
    	for (int j = 0; j < nJugadores; j++) {
    		
    		partida.muestraTablero();
    		System.out.println();
    		
    		//Partida.jugadores.get(Partida.jugadores.indexOf(partida));
    		//System.out.println(player);
    		//partida.muestraDados(player);
    		

    		
    		System.out.println("\n\nTurno " + (i + 1) + " del Jugador " + Partida.jugadores.get(Partida.jugadores.indexOf(new Jugador(j+1))).nombre);
			System.out.println("Menu inicial indique la letra de lo que quiere realizar: \n "
		          + "[1]Risco \n [2]Trece \n [3]Escalera Mayor \n [4]Escalera Menor \n "
		          + "[5]Escalera par \n [6]Escalera impar \n [7]Trio \n [8]Seis \n " + "[9]Cinco \n "
		          + "[10]Cuatro  \n [11]Tres  \n [12]Dos  \n [13]Ases \n   ");
		
	      	int opcion;
	      	opcion = sc.nextInt();
	
		      switch (opcion) {
		      case 1:
<<<<<<< HEAD
		        
            //Partida.Risco(player); // Cambio temporal
=======
		    	
		    	Jugador player = Partida.jugadores.get(Partida.jugadores.indexOf(j));
		        Partida.Risco(player); // Cambio temporal
>>>>>>> 966c4919b5f15916c9e93f0f0f9984f2520c98f5
		        break;
		      case 2:
		        //Partida.Trece(d1);
		        break;
		      case 3:
		        //Partida.EscaleraMayor(d1);
		        break;
		
		      case 4:
		        //Partida.EscaleraMenor(d1);
		        break;
		
		      case 5:
		        //Partida.EscaleraPar(d1);
		        break;
		
		      case 6:
		        //Partida.EscaleraImpar(d1);
		        break;
		
		      case 7:
		        //Partida.Trio(d1);
		        break;
		
		      case 8:
		        //Partida.numero(d1, 6);
		        break;
		
		      case 9:
		        //Partida.numero(d1, 5);
		        break;
		
		      case 10:
		        //Partida.numero(d1, 4);
		        break;
		
		      case 11:
		        //Partida.numero(d1, 3);
		        break;
		
		      case 12:
		        //Partida.numero(d1, 2);
		        break;
		
		      case 13:
		        //Partida.numero(d1, 1);
		        break;
		
		      default:
		    	  System.out.println("Esto es una prueba");
		        break;
		      }
    	}
    }
    
    sc.close();
  }


}
