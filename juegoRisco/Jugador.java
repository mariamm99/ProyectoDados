//package ProyectoDados.juegoRisco;
import java.util.ArrayList;

public class Jugador {
  // Atributos ///////
  private String nombre;
  private int nj; // Número de Jugador, como si fuera un código
  ArrayList<Integer> p = new ArrayList<Integer>(); // ArrayList de puntuaciones
  Dados dadosJugador; // ArrayList de dados ESTO NO ES ARRAYLIST!! es array solo by María
  
  // Constructor ///////
  public Jugador (int nj, String nombre) {
    this.nj = nj; // Número de jugador
    this.nombre = nombre; // Nombre de jugador
    this.dadosJugador = new Dados(); // Genero un objeto Dado, el dado a su vez contiene tres dados (d1, d2, d3)
    p.add(null); // 0 Risco 
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
    p.add(null); // 13 Para guardar el total
  }
  
  public Jugador(int nj) {
    this.nj = nj;
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
  int tmp=0; // Variable que almacena todos los puntos
  public int totalPtos(int i) {
    
    boolean hayPtos = false;
    
      if (p.get(i) != null) {
          tmp += p.get(i);
          hayPtos = true;
      
    }
    if (hayPtos) {
      return tmp;
    } else {
      return 0;
    }
  }
  

  /* Métodos equals y hashCode generados por Eclipse */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + nj;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Jugador other = (Jugador) obj;
    if (nj != other.nj)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Jugador [nombre=" + nombre +  ", dadosJugador=" + dadosJugador + "]";
  }
  
  
  
}