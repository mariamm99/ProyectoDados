package ProyectoDados.juegoRisco;
import java.util.ArrayList;

public class Jugador {
  // Atributos ///////
  String nombre;
  int nj; // Número de Jugador, como si fuera un código
  ArrayList<Integer> p = new ArrayList<Integer>(); // ArrayList de puntuaciones
  Dados dadosJugador; // ArrayList de dados
  
  // Constructor ///////
  public Jugador (int nj, String nombre) {
    this.nj = nj;
    this.nombre = nombre;
    this.dadosJugador = new Dados(); // Genero un objeto Dado, el dado a su vez contiene tres dados (d1, d2, d3)
    p.add(null); // 0 Risco Para añadir puntuación → p.add(0, puntuación);
    p.add(null); // 1 Trece
    p.add(null); // 2 Escalera mayor
    p.add(null); // 3 Escalera menor
    p.add(null); // 4 Escalera par
    p.add(null); // 5 Escalera impar
    p.add(null); // 6 Tres iguales
    p.add(null); // 7 Seis
    p.add(null); // 8 Cinco
    p.add(null); // 9 Cuatro
    p.add(null); // 10 Tres
    p.add(null); // 11 Dos
    p.add(null); // 12 As
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public ArrayList<Integer> getP() {
    return p;
  }

  public void setP(ArrayList<Integer> p) {
    this.p = p;
  }
  
  public Dados getDadosJugador() {
    return dadosJugador;
  }

  public void setDadosJugador(Dados dadosJugador) {
    this.dadosJugador = dadosJugador;
  }

  public int getNj() {
    return nj;
  }

  public void setNj(int nj) {
    this.nj = nj;
  }

  public int totalPtos() {
    int tmp = 0; // Variable que almacena todos los puntos
    for (int i: p) {
      tmp += i;
    }
    return tmp;
  }
  
  
  
}