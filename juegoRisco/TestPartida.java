
//package ProyectoDados.juegoRisco;
import utiles.*;

public class TestPartida {

	static Menu menu = new Menu("Indique la opción que quiere realizar:",
			new String[] { "Risco", "Trece", "Escalera Mayor", "Escalera Menor ", "Escalera par", "Escalera impar",
					"Trio", "Seis", "Cinco", "Cuatro", "Tres", "Dos", "Ases" });

	public static void main(String[] args) {

		int nJugadores;

		String nombreTmp;

		// Recojo el número de jugadores, y se los paso a Partida

		nJugadores = Teclado.leerEntero("Indica cuantos jugadores sois: ");
		// Crear una partida
		Partida partida = new Partida(nJugadores);
		for (int i = 1; i <= nJugadores; i++) {
			nombreTmp = Teclado.leerCadena("Introduce el nombre del jugador " + i + ": ");
			partida.crearJugadores(i, nombreTmp);
		}

		// Para recorrer las 13 rondas
		for (int i = 1; i <= 13; i++) {

			/**
			 * Recorremos todos los jugadores durante cada ronda
			 */
			for (int j = 1; j <= nJugadores; j++) {
				Jugador player = partida.jugadores.get(partida.jugadores.indexOf(new Jugador(j)));

				System.out.print("\n\nTurno " + i + " del jugador "
						+ partida.jugadores.get(partida.jugadores.indexOf(new Jugador(j))).getNombre());
				System.out.println("\nEn esta tirada obtienes:\n"
						+ Partida.tirarDados(partida.jugadores.get(partida.jugadores.indexOf(new Jugador(j)))));

				String cambioDado = Teclado.leerCadena("\n¿Quieres cambiar algún dado? [S/N]: ").toUpperCase();
				if (cambioDado.equals("S")) {
					int nDadosCambiar = Teclado.leerEntero("¿Cuántos dados quieres cambiar?: ");
					System.out.println(player.dadosJugador.cambiarDados(nDadosCambiar));
				}

				switch (menu.gestionar()) {
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
						Partida.numero(player, 6);
						break;

					case 9:
						Partida.numero(player, 5);
						break;

					case 10:
						Partida.numero(player, 4);
						break;

					case 11:
						Partida.numero(player, 3);
						break;

					case 12:
						Partida.numero(player, 2);
						break;

					case 13:
						Partida.numero(player, 1);
						break;

					default:
						System.out.println("Opción no valida.");
						j--;
						break;
				}

				partida.muestraTablero();
				System.out.println();

				String exporto = Teclado
						.leerCadena("\nPulsa Intro para seguir o e para exportar tus datos actuales[Intro/e]: ")
						.toUpperCase();
				if (exporto.equals("E")) {

					player.guardaDatos();

				}
			}
		}
	}

}
