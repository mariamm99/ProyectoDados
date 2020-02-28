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
    
    
    // Para recorrer los 13 juegos
    for (int i = 0; i < 13; i++) {
    	for (int j = 0; j < nJugadores; j++) {
    		partida.muestraTablero();
    		System.out.println();
    		
    		System.out.print("\n\nTurno " + (i + 1) + " del Jugador " + partida.jugadores.get(partida.jugadores.indexOf(new Jugador(j+1))).nombre);
    		System.out.print("\nEn esta tirada obtienes:\n" + Partida.tirarDados(partida.jugadores.get(partida.jugadores.indexOf(new Jugador(j+1)))));
    		

        Jugador player = partida.jugadores.get(partida.jugadores.indexOf(new Jugador(j+1)));
        
    		System.out.print("\n¿Quieres cambiar algún dado? [s/n]: ");
    		String cambioDado = sc.next();
    		if (cambioDado.equals("s")) {
    		  System.out.print("¿Cuántos dados quieres cambiar?: ");
          int nDadosCambiar = sc.nextInt();
          player.dadosJugador.cambiarDados(nDadosCambiar);
          System.out.print(player.dadosJugador + "\n");
    		}
    		
    		System.out.println("Menu inicial indique la opción que quiere realizar: \n "
		          + "[1]Risco \n [2]Trece \n [3]Escalera Mayor \n [4]Escalera Menor \n "
		          + "[5]Escalera par \n [6]Escalera impar \n [7]Trio \n [8]Seis \n " + "[9]Cinco \n "
		          + "[10]Cuatro  \n [11]Tres  \n [12]Dos  \n [13]Ases ");
		
	      	int opcion;
	      	opcion = sc.nextInt();
	
		      switch (opcion) {
		      case 1:
		        System.out.println(Partida.Risco(player));
		        break;
		      case 2:
		        System.out.println(Partida.Trece(player));
		        break;
		      case 3:
		        System.out.println(Partida.EscaleraMayor(player));
		        break;
		
		      case 4:
		        System.out.println(Partida.EscaleraMenor(player));
		        break;
		
		      case 5:
		        System.out.println(Partida.EscaleraPar(player));
		        break;
		
		      case 6:
		        System.out.println(Partida.EscaleraImpar(player));
		        break;
		
		      case 7:
		        System.out.println(Partida.Trio(player));
		        break;
		
		      case 8:
		        Partida.numero(player,6);
		        break;
		
		      case 9:
            Partida.numero(player, 5);
		        break;
		
		      case 10:
            Partida.numero(player, 4);
 
		        break;
		
		      case 11:
            Partida.numero(player,3);
		        break;
		
		      case 12:
            Partida.numero(player, 2);
		        break;
		
		      case 13:
            Partida.numero(player, 1);
		        break;
		
		      default:
		    	  System.out.println("Opción no valida");
		    	  j--;
		        break;
		      }
    	}
    }
    
    sc.close();
  }


}
