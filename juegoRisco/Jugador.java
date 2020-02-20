package ProyectoDados.juegoRisco;
import java.util.ArrayList;

public class Jugador {
  // Atributos ///////
  String nombre;
  // TODO: Uso un ArrayList, igual hay que importarlo en las demás clases (SÓLO SI FALLA)
  ArrayList<Integer> p = new ArrayList<Integer>();
  
  // Constructor ///////
  public Jugador (String nombre) {
    this.nombre = nombre;
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
    // TODO: Calcular TOTAL en el tablero... O hacer método totalPtos()
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
  
  public int totalPtos() {
    int tmp = 0; // Variable que almacena todos los puntos
    for (int i: p) {
      tmp += i;
    }
    return tmp;
  }
  
}