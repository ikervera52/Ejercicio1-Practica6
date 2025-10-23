import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    final static  Scanner sc = new Scanner(System.in);
    public static String nombre, nombreFinal = " ", mayorCantidadFinal = "", nombreFechaFinal = "";
    public static int cantidad, cantidadFinal = 0;
    public static LocalDate fecha, fechaFinal = LocalDate.of(2500,12,31);

    public static void main(String[] args) {

        //Desarrolla un proyecto que solicite los datos de diez productos
        //(descripción, número de unidades y fecha de caducidad). El programa
        //debe mostrar el nombre del producto más largo, el nombre del producto
        //que antes caduca y el nombre del producto del que más unidades se
        //dispone.

        for (int i = 1; i <= 2; i++){
            System.out.println("-- Recogida de datos de producto numero " + i + " --");
            nombreProducto();
            medidorNombreProducto();

            cantidadProducto();
            mayorCantidadProducto();
            sc.nextLine();

            fechaProducto();
             ultimaFechaProducto();
        }



        imprimirResultado();
    }

    public static void nombreProducto (){
        System.out.print("Dame el nombre del producto: ");
        nombre = sc.nextLine();
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
        }
        catch (InputMismatchException e){
            System.out.println("El valor introducido no es valido");
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
        System.out.println("-- Resultados de producto --");
        System.out.println("El producto con nombre más largo es: " + nombreFinal);
        System.out.println("El producto con la fecha de caducidad más antigua es: " + nombreFechaFinal);
        System.out.println("El producto con más stock es: " + mayorCantidadFinal);
    }
}