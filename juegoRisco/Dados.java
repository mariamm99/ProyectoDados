//package ProyectoDados.juegoRisco;

import utiles.Teclado;

public class Dados {

  private int d1;
  private int d2;
  private int d3;

  /**
   * Constructor de dados.
   */
  public Dados() {

    setD1();
    setD2();
    setD3();
  }

  public int getD1() {
    return d1;
  }

  public void setD1() {
    this.d1 = (int) (Math.random() * 6 + 1);
  }

  public int getD2() {
    return d2;
  }

  public void setD2() {
    this.d2 = (int) (Math.random() * 6 + 1);
  }

  public int getD3() {

    return d3;
  }

  public void setD3() {
    this.d3 = (int) (Math.random() * 6 + 1);
  }

  /**
   * Cambiar dados. al tirar los dados puedes solicitar cambiar 1,2 o los 3 dados.
   * 
   * @param nDadosCambiar
   */
  String cambiarDados(int nDadosCambiar) {

    if (nDadosCambiar > 2) {
      if (nDadosCambiar > 3) {
        System.out.println("Solo puedes cambiar 3 dados");
        nDadosCambiar = 3;
      }
      System.out.println("Continuemos con la partida.");
      setD1();
      setD2();
      setD3();

      return toString();

    }

    int dado;
    boolean cambiod1 = true;
    boolean cambiod2 = true;
    boolean cambiod3 = true;
    for (int i = 0; i < nDadosCambiar; i++) {

      dado = Teclado.leerEntero("¿Que dado quiere cambiar? 1, 2 o 3: ");

      if (dado == 1 && cambiod1) {
        setD1();

        cambiod1 = false;
      } else if (dado == 2 && cambiod2) {
        setD2();

        cambiod2 = false;
      } else if (dado == 3 && cambiod3) {
        setD3();

        cambiod3 = false;
      } else if (!cambiod1 || !cambiod2 || !cambiod3) {
        System.out.println("Dado " + dado + " ya ha sido cambiado introduzca otro");
        --i;
      } else {
        System.out.println("Dado " + dado + " no existe introduzca otro");
        --i;
      }
    }
    return toString();
  }

  @Override
  public String toString() {
    return "Dado 1: " + getD1() + "\nDado 2: " + getD2() + "\nDado 3: " + getD3();
  }
}