
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Empleados {

    static List<Empleados> empleadoLista = new ArrayList<>();
    String nombre;
    String apellido;
    LocalDate fechaNacimiento;
    BigDecimal sueldo;

    public Empleados(String nombre, String apellido, String fechaNacimiento, String sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = toFecha(fechaNacimiento);
        this.sueldo = toSueldo(sueldo);
        Listado();
    }

    static LocalDate toFecha(String fechaNacimiento) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fecha = LocalDate.parse(fechaNacimiento, formato);
        return fecha;
    }

    static BigDecimal toSueldo(String sueldo) {
        BigDecimal monto = new BigDecimal(sueldo);
        return monto;
    }

    // Agrega instancia a la lista de empleados
    private void Listado() {
        empleadoLista.add(this);
    }

    // Muestra los empleados cuyo apellido empieza con "letra" ingresada por teclado
    public static void buscarApellidoP1Letra(String letra) {
        empleadoLista.forEach((e) -> {
            if (e.apellido.startsWith(letra)) {
                System.out.println(e);
            }
        });
    }
    //Saca la edad 
    private int edad() {
        int edad = LocalDate.now().getYear() - this.fechaNacimiento.getYear();
        return edad;
    }

    // Muestra al empleado/as con mayor edad
    public static void mayorEmpleado() {
        if (empleadoLista.size() != 0) {
            int comp = 0;
            for (int i = 0; i < empleadoLista.size(); i++) {
                if (comp < empleadoLista.get(i).edad()) {
                    comp = empleadoLista.get(i).edad();
                }
            }
            for (int i = 0; i < empleadoLista.size(); i++) {
                if (empleadoLista.get(i).edad() == comp) {
                    System.out.println(empleadoLista.get(i));
                }
            }
        }
        else {
            System.out.println("Archivo vacío.!!");
        }
    }

    // Muestra al empleado/as con menor edad
    public static void menorEmpleado() {
        if (empleadoLista.size() != 0) {
            int comp = empleadoLista.get(0).edad();
            for (int i = 0; i < empleadoLista.size(); i++) {
                if (comp > empleadoLista.get(i).edad()) {
                    comp = empleadoLista.get(i).edad();
                }
            }
            for (int i = 0; i < empleadoLista.size(); i++) {
                if (empleadoLista.get(i).edad() == comp) {
                    System.out.println(empleadoLista.get(i));
                }
            }
        }
        else {
            System.out.println("Archivo vacío.!!");
        }
    }

    // Muestra al empleado/as con el sueldo maximo
    public static void maximoSueldo() {
        if (empleadoLista.size() != 0) {
            BigDecimal comp = empleadoLista.get(0).sueldo;
            for (int i = 0; i < empleadoLista.size(); i++) {
                if (comp.compareTo(empleadoLista.get(i).sueldo) == -1 ) {
                    comp = empleadoLista.get(i).sueldo;
                }
            }
            for (int i = 0; i < empleadoLista.size(); i++) {
                if (empleadoLista.get(i).sueldo == comp) {
                    System.out.println(empleadoLista.get(i));
                }
            }
        }
        else {
            System.out.println("Archivo vacío.!!");
        }
    }
    
    // Muestra al empleado/as con el sueldo minimo
    public static void minimoSueldo() {
        if (empleadoLista.size() != 0) {
            BigDecimal comp = empleadoLista.get(0).sueldo;
            for (int i = 0; i < empleadoLista.size(); i++) {
                if (comp.compareTo(empleadoLista.get(i).sueldo) == 1 ) {
                    comp = empleadoLista.get(i).sueldo;
                }
            }
            for (int i = 0; i < empleadoLista.size(); i++) {
                if (empleadoLista.get(i).sueldo == comp) {
                    System.out.println(empleadoLista.get(i));
                }
            }
        }
        else {
            System.out.println("Archivo vacío.!!");
        }
    }

    // Permite Ordenar alfabeticamente  la lista de empleado/as.
    public static void ordenarAlfab() {
        
        empleadoLista.sort((o1, o2) -> o1.nombre.compareTo(o2.nombre));
        System.out.println(empleadoLista);
    }

    @Override
    public String toString() {
        return this.nombre + " " + this.apellido + ": $" + this.sueldo;
    }
}