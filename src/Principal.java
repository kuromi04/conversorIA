import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    // Creamos una instancia de Scanner para leer la entrada del usuario
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Variable para controlar el ciclo del menú
        boolean continuar = true;

        // Ciclo principal del programa
        while (continuar) {
            mostrarMenu(); // Mostramos el menú de opciones
            try {
                // Solicitamos la moneda de origen
                System.out.print("Ingrese la moneda de cambio: ");
                String monedaOrigen = sc.nextLine().toUpperCase().trim();
                validarMoneda(monedaOrigen); // Validamos la moneda de origen

                // Solicitamos la moneda de destino
                System.out.print("Ingrese la moneda que quieres obtener: ");
                String monedaSalida = sc.nextLine().toUpperCase().trim();
                validarMoneda(monedaSalida); // Validamos la moneda de destino

                // Solicitamos la cantidad a convertir
                System.out.print("Ingrese la cantidad que desea cambiar: ");
                double cantidad = sc.nextDouble();
                sc.nextLine(); // Consumimos la nueva línea pendiente
                validarCantidad(cantidad); // Validamos que la cantidad sea positiva

                System.out.println("Espera un momento...");
                // Llamamos a la API para realizar la conversión
                consultaAPI.convertirMoneda(monedaOrigen, monedaSalida, cantidad);

                // Preguntamos si el usuario quiere realizar otra conversión
                System.out.print("\n¿Deseas hacer otra conversión? (si/no): ");
                String respuesta = sc.nextLine().toLowerCase().trim();
                if (!respuesta.equals("si")) {
                    continuar = false; // Terminamos el ciclo si la respuesta no es "si"
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Ingresa un valor válido.");
                sc.nextLine(); // Consumimos la entrada incorrecta
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }

        // Mensaje de despedida
        System.out.println("Gracias por usar el conversor de monedas CoinIA.");
    }

    // Método para mostrar el menú de opciones
    private static void mostrarMenu() {
        System.out.println("""
                
                *** Conversor de monedas CoinIA ***
                ARS - Peso argentino
                BOB - Peso boliviano
                BRL - Real brasileño
                CLP - Peso chileno
                COP - Peso colombiano
                USD - Dólar estadounidense
                MXN - Peso mexicano
                EUR - Euro
                SALIR - Finalizar programa
                **************************
                """);
    }

    // Método para validar el código de moneda ingresado
    private static void validarMoneda(String moneda) {
        if (moneda.equals("SALIR")) {
            System.out.println("Gracias por usar el conversor de monedas. ¡Vuelva pronto!");
            System.exit(0); // Finalizamos el programa si el usuario ingresa "SALIR"
        }
        if (moneda.length() != 3) {
            throw new IllegalArgumentException("Código de moneda no válido. Debe ser de 3 caracteres.");
        }
    }

    // Método para validar que la cantidad sea positiva
    private static void validarCantidad(double cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser un número positivo.");
        }
    }
}
