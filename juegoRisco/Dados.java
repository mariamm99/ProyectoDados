package ProyectoDados.juegoRisco;

import java.util.Scanner;

public class Dados {
  Scanner sc = new Scanner(System.in);

  static int d1;
  static int d2;
  static int d3;

  public Dados() {

    setD1(d1);
    setD2(d2);
    setD3(d3);
  }

  public static int getD1() {
    return d1;
  }

  public void setD1(int d1) {
    this.d1 = (int) (Math.random() * 6 + 1);
  }

  public static int getD2() {
    return d2;
  }

  public void setD2(int d2) {
    this.d2 = (int) (Math.random() * 6 + 1);
  }

  public static int getD3() {

    return d3;
  }

  public void setD3(int d3) {
    this.d3 = (int) (Math.random() * 6 + 1);
  }

  void cambiarDados(int nDadosCambiar) {

    if (nDadosCambiar > 1) {
      if (nDadosCambiar > 3) {

        System.out.println("solo puedes cambiar 3 dados");
        nDadosCambiar = 3;
      }

      int dado;
      boolean cambiod1 = true;
      boolean cambiod2 = true;
      boolean cambiod3 = true;
      for (int i = 0; i < nDadosCambiar; i++) {

        System.out.println("que dado quiere cambiar, 1, 2 o 3");
        dado = sc.nextInt();

        if (dado == 1 && cambiod1) {
          setD1(d1);

          cambiod1 = false;
        } else if (dado == 2 && cambiod2) {
          setD2(d2);

          cambiod2 = false;
        } else if (dado == 3 && cambiod3) {
          setD3(d3);

          cambiod3 = false;
        } else if (!cambiod1 || !cambiod2 || !cambiod3) {
          System.out.println("dado " + dado + " ya ha sido cambiado introduzca otro");
          --i;
        } else {
          System.out.println("dado " + dado + " no existe introduzca otro");
          --i;
        }
      }

    } else if (nDadosCambiar == 0) {
      System.out.println("continuemos con la partida.");

    }
System.out.println("dados definitivos");
  }

  @Override
  public String toString() {
    return "dado 1: " + getD1() + " dado 2: " + getD2() + " dado 3: " + getD3();
  }

}
