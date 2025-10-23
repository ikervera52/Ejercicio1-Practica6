import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    final static  Scanner sc = new Scanner(System.in);
    public static String nombre;
    public static int cantidad;
    public static LocalDate fecha;

    public static void main(String[] args) {

        //Desarrolla un proyecto que solicite los datos de diez productos
        //(descripción, número de unidades y fecha de caducidad). El programa
        //debe mostrar el nombre del producto más largo, el nombre del producto
        //que antes caduca y el nombre del producto del que más unidades se
        //dispone.
        String nombreLargo = "", mayorCantidad = "", ultimaFecha ="";
        for (int i = 1; i <= 2; i++){
            System.out.println("-- Recogida de datos de producto numero " + i + " --");
            nombreProducto();
             nombreLargo = medidorNombreProducto();

            cantidadProducto();
             mayorCantidad = mayorCantidadProducto();
            sc.nextLine();

            fechaProducto();
             ultimaFecha = ultimaFechaProducto();
        }



        imprimirResultado(nombreLargo, mayorCantidad, ultimaFecha);
    }

    public static void nombreProducto (){
        System.out.print("Dame el nombre del producto: ");
        nombre = sc.nextLine();
    }

    public static String medidorNombreProducto (){
        String nombreFinal = " ";

        if (nombre.length() > nombreFinal.length()){
            nombreFinal = nombre;
        }
        return nombreFinal;
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

    public static String ultimaFechaProducto (){
        String nombreFechaFinal = "";
        LocalDate fechaFinal = LocalDate.of(2500,12,31);
        if (fecha.isBefore(fechaFinal)){
            fechaFinal = fecha;
            nombreFechaFinal = nombre;
        }

        return nombreFechaFinal;
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

    public static String mayorCantidadProducto (){
        String mayorCantidadFinal = "";
        int cantidadFinal = 0;

        if (cantidad > cantidadFinal){

            cantidadFinal = cantidad;
            mayorCantidadFinal = nombre;
        }

        return mayorCantidadFinal;
    }

    public static void imprimirResultado (String nombreLargo, String mayorCantidad, String ultimaFecha){
        System.out.println("-- Resultados de producto --");
        System.out.printf("""
                El producto con nombre más largo es: %s \s
                El producto con la fecha de caducidad más antigua es: %s\s
                El producto con más stock es: %s""" , nombreLargo, mayorCantidad, ultimaFecha);
    }
}