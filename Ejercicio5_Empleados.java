
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;


public class Ejercicio5_Empleados {
    public static void main(String[] args) {
        System.out.println(   "             Pequeño sistema de empleados");
        System.out.println("**************************************************************");

        
        appendEmpl();
    
        String letra =" ";
        Scanner  teclado=new Scanner(System.in);
        System.out.print("Ingrese la primera letra del apellido a buscar:");
        letra=(teclado.nextLine()).toUpperCase();
        teclado.close();
        System.out.println("__________________________ ");
        Empleados.buscarApellidoP1Letra(letra);
        System.out.println("__________________________ ");
        System.out.println(" ");
        System.out.println("//////////////////////////////////////////////////////////////");
        System.out.println("Empleados/as más viejo es: ");
        System.out.println("____________________________ ");
        Empleados.mayorEmpleado();
        System.out.println(" ");
        System.out.println("Empleados/as más joven es: ");
        System.out.println("____________________________");
        Empleados.menorEmpleado();
        System.out.println(" ");
        System.out.println("Empleados/as  que más gana es: ");
        System.out.println("____________________________");
        Empleados.minimoSueldo();
        System.out.println(" ");
        System.out.println("Empleados/as que menos gana es: ");
        System.out.println("______________________________");
        Empleados.maximoSueldo();
        System.out.println(" ");
        System.out.println("////////////////////////////////////////////////////");
        System.out.println("Empleados ordenados alfabeticamente por nombres:");
        System.out.println("___________________________________________________ ");
        Empleados.ordenarAlfab();
    }
    
    // Permite Leer el archivo empleados.txt y  crea una instancia de la clase empleados por cada linea
    static void appendEmpl() {
        String archivo = "D:/Java 2021/clase 5/empleados.txt";
        try (Stream<String> stream = Files.lines(Paths.get(archivo))){
            stream.forEach((e) -> {
                String[] lista = e.split(",");
                String nombre = lista[0];
                String apellido = lista[1];
                String fechaNacimiento = lista[2];
                String sueldo = lista[3];
                Empleados empleados = new Empleados(nombre, apellido, fechaNacimiento, sueldo);
                
            });
        } catch (Exception e) {
            System.out.println("ocurrido un error.!!" + e.getMessage());
        }
    }
}