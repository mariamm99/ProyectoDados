package utiles;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Teclado {
    static Scanner sc = new Scanner(System.in);

    /**
     * Lectura de entero
     * @param mensaje
     * @return
     * @throws InputMismatchException
     */
    public static int leerEntero(final String mensaje) throws InputMismatchException {
        while (true) {
            int entero;
            System.out.println(mensaje);
            try {
                entero = sc.nextInt();
                return entero;
            } catch (final InputMismatchException e) {
                System.err.println("dato erroneo, debe ser un número entero");
                sc.next();
            }
        }
    }

    /**
     * Lectura de Cadena
     * @param mensaje
     * @return
     */
    public static String leerCadena(final String mensaje) {

        String cadena;
        System.out.println(mensaje);
        cadena = sc.next();
        return cadena;
    }

    /**
     * Lectura de Float
     * @param mensaje
     * @return
     * @throws InputMismatchException
     */
    public float leerFloat(final String mensaje) throws InputMismatchException {
        float decimal;
        while (true) {
            System.out.println(mensaje);
            try {
                decimal = sc.nextFloat();
                return decimal;

            } catch (final InputMismatchException i) {
                sc.next();
                System.err.println("dato erroneo, debe ser un número ");
            }
        }
    }
}