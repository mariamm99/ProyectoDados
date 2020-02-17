import java.util.ArrayList;

public class Jugador {
  // Atributos ///////
  String nombre;
  // TODO: Uso un ArrayList, igual hay que importarlo en las demás clases (SÓLO SI FALLA)
  ArrayList<Integer> p = new ArrayList<Integer>();
  
  // Constructor ///////
  public Jugador (String nombre) {
    this.nombre = nombre;
    p.put(0); // 0 Risco Para añadir puntuación → p.add(0, puntuación);
    p.put(0); // 1 Trece
    p.put(0); // 2 Escalera mayor
    p.put(0); // 3 Escalera menor
    p.put(0); // 4 Escalera par
    p.put(0); // 5 Escalera impar
    p.put(0); // 6 Tres iguales
    p.put(0); // 7 Seis
    p.put(0); // 8 Cinco
    p.put(0); // 9 Cuatro
    p.put(0); // 10 Tres
    p.put(0); // 11 Dos
    p.put(0); // 12 As
    // TODO: Calcular TOTAL en el tablero... O hacer método totalPtos()
    this.p = p;
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
    int tmp; // Variable que almacena todos los puntos
    for (int i: p) {
      tmp += i;
    }
    return tmp;
  }
  
}