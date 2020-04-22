import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Historial es una clase para leer los ficheros de exportación de los
 * jugadores. Muestra la Fecha de la partida, las puntuaciones, el número de
 * jugadores que había y la posición del jugador en cuestión.
 * 
 *
 */
public class Historial {
  // Atributos ////////
  private String nombreJugador;
  private int numeroPartidas; // Número de partidas jugadas (número de líneas)
  private int mediaPuntos; // Suma todos los puntos de todas las partidas
  private int partidasPrimero; // Veces que estaba primero
  private float puestoMedio; // Media de la posición de todas las partidas
  private BufferedReader archivo; // Archivo con el historial

  /**
   * Constructor de la clase Historial. Se le pasa como parámetro un jugador.
   * 
   * @param player
   * @throws IOException
   */
  public Historial(Jugador player) throws IOException {
    this.nombreJugador = player.getNombre();
    this.archivo = abrirFichero();
    this.numeroPartidas = cuentaLineas(); // Inicializamos con 0
    this.mediaPuntos = 0; // Inicializamos con 0
    this.partidasPrimero = 0; // Inicializamos con 0
    this.puestoMedio = 0; // Inicializamos con 0
  }

  // Getters & Setters
  private String getNombreJugador() {
    return nombreJugador;
  }

  private BufferedReader getArchivo() {
    return archivo;
  }

  private void setArchivo(BufferedReader archivo) {
    this.archivo = archivo;
  }

  private int getNumeroPartidas() {
    return numeroPartidas;
  }

  private void setNumeroPartidas(int numeroPartidas) {
    this.numeroPartidas = numeroPartidas;
  }

  private int getMediaPuntos() {
    return mediaPuntos;
  }

  private void setMediaPuntos(int mediaPuntos) {
    this.mediaPuntos = mediaPuntos;
  }

  private int getPartidasPrimero() {
    String texto = "";
    String linea;
    try {

      while ((linea = archivo.readLine()) != null) {
        texto += linea + "\n";
      }

      // Puesto: 1
      Pattern patron = Pattern.compile("Puesto: 1");
      Matcher match = patron.matcher(texto);
      while (match.find()) {
        partidasPrimero++;
      }

    } catch (IOException e) {
      System.err.println("error al abrir el archivo");
    }

    return partidasPrimero;
  }

  private void setPartidasPrimero(int partidasPrimero) {
    this.partidasPrimero = partidasPrimero;
  }

  private float getPuestoMedio() {
    String texto = "";
    String linea;
    float veces=0;
    try {

      while ((linea = archivo.readLine()) != null) {
        texto += linea + "\n";
      }

      // Puesto: 1
      Pattern patron = Pattern.compile("Puesto: (.*?)");
      Matcher match = patron.matcher(texto);
      while (match.find()) {
        puestoMedio+= Float.parseFloat(match.group(1));
        veces++;
      }

    } catch (IOException e) {
      System.err.println("error al abrir el archivo");
    }
    puestoMedio= puestoMedio/veces;
    return puestoMedio;
  }

  private void setPuestoMedio(int puestoMedio) {
    this.puestoMedio = puestoMedio;
  }

  /**
   * Método para abrir el fichero del jugador
   * 
   * @return
   */
  private BufferedReader abrirFichero() {
    // Abro el archivo
    BufferedReader archivo = null;
    try {
      archivo = new BufferedReader(new FileReader("risco_" + getNombreJugador() + ".txt"));
    } catch (IOException e) {
      System.err.println("Error al abrir el fichero.");
      System.exit(2);
    }
    return archivo;
  }

  /**
   * Método que cuenta las líneas del archivo, o lo que es lo mismo, el número de
   * partidas.
   * 
   * @return
   * @throws IOException
   */
  private int cuentaLineas() throws IOException {
    int nPartidas = 0;
    while (archivo.readLine() != null) {
      nPartidas++;
    }
    setArchivo(abrirFichero()); // Vuelvo a abrir el fichero y meterlo en el objeto, porque ahora estará leyendo
                                // el final
    return nPartidas;
  }

  /**
   * Método para pruebas, BORRAR cuando ya no sea necesario
   * 
   * @throws IOException
   */
  void leerFichero() throws IOException {
    String linea = archivo.readLine();
    while (linea != null) {
      System.out.println(linea);
      linea = archivo.readLine();
    }
  }

  @Override
  public String toString() {
    return "\nHistorial de " + getNombreJugador() + "\nPartidas hechas → " + getNumeroPartidas()
        + "\nPuntuación media → " + getMediaPuntos() + "\nPartidas primero → " + getPartidasPrimero()
        + "\nPuesto medio → " + getPuestoMedio();
  }

}
