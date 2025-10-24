import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    final static  Scanner sc = new Scanner(System.in);
    public static String nombre, nombreFinal = " ", mayorCantidadFinal = "", nombreFechaFinal = "";
    public static int cantidad, cantidadFinal = 0;
    public static LocalDate fecha, fechaFinal = LocalDate.of(3000,12,31);

    public static void main(String[] args) {

        for (int i = 1; i <= 3; i++){
            System.out.println("-- Recogida de datos de producto numero " + i + " --");
            nombreProducto();
            medidorNombreProducto();

            cantidadProducto();
            mayorCantidadProducto();
            sc.nextLine();

            fechaProducto();
             ultimaFechaProducto();

             System.out.println("------------------------------------------------------");
        }



        imprimirResultado();
    }

    public static void nombreProducto (){
        Pattern patron = Pattern.compile("^[A-Za-z]+$");

        System.out.print("Dame el nombre del producto: ");
        nombre = sc.nextLine();
        Matcher matcher = patron.matcher(nombre);

        if (!matcher.matches()){
            System.out.println("El nombre del producto no es valido");
            nombreProducto();
        }
    }

    public static void medidorNombreProducto (){

        if (nombre.length() > nombreFinal.length()){
            nombreFinal = nombre;
        }
    }

    public static void fechaProducto (){
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            System.out.print("Fecha de caducidad del producto (dd/MM/yyyy): ");
            fecha = LocalDate.parse(sc.nextLine(), formatter);
        }
        catch (DateTimeParseException ex){
            System.out.println("El dato introducido no es valido");
            fechaProducto();
        }

        catch (Exception e){
            System.out.println(e.getClass());
            fechaProducto();
        }
    }

    public static void ultimaFechaProducto (){

        if (fecha.isBefore(fechaFinal)){
            fechaFinal = fecha;
            nombreFechaFinal = nombre;
        }
    }

    public static void cantidadProducto (){
        try {
            System.out.print("Dime la cantidad del producto: ");
            cantidad = sc.nextInt();
            if (cantidad < 0){
                System.out.println("La cantidad del producto no es valida");
                cantidadProducto();
            }
        }
        catch (InputMismatchException e){
            sc.nextLine();
            System.out.println("El valor introducido tiene que ser numérico");
            cantidadProducto();
        }
    }

    public static void mayorCantidadProducto (){

        if (cantidad > cantidadFinal){
            cantidadFinal = cantidad;
            mayorCantidadFinal = nombre;
        }
    }

    public static void imprimirResultado (){
        System.out.printf(""" 
        -- Resultados de producto --
        El producto con nombre más largo es: %s
        El producto con la fecha de caducidad más antigua es: %s | con fecha: %s
        El producto con más stock es: %s | con Stock: %s
        """, nombreFinal.toUpperCase(), nombreFechaFinal.toUpperCase(), fechaFinal, mayorCantidadFinal.toUpperCase(), cantidadFinal );
    }
}