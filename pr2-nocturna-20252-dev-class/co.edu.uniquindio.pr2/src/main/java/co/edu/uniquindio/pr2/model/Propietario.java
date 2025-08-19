package co.edu.uniquindio.pr2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Propietario {
    private String nombre;
    private int edad;
    private String identificacion;
    private String email;
    private String numeroCelular;
    private Vehiculo vehiculo;

    private List<Vehiculo> listaVehiculosAsociados = new ArrayList<>();

    EmpresaTransporte ownedByEmpresaTransporte;

    public Propietario() {
    }

    public Propietario(String nombre, int edad, String identificacion, String email, String numeroCelular, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.edad = edad;
        this.identificacion = identificacion;
        this.email = email;
        this.numeroCelular = numeroCelular;
        this.vehiculo = vehiculo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }
    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.identificacion = numeroIdentificacion;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "Propietario{" +
                "nombre='" + nombre + '\'' +
                ", numeroIdentificacion='" + identificacion + '\'' +
                ", email='" + email + '\'' +
                ", numeroCelular='" + numeroCelular + '\'' +
                '}';
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNumeroCelular() {
        return numeroCelular;
    }
    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    public List<Vehiculo> getListaVehiculosAsociados() {
        return listaVehiculosAsociados;
    }
    public void setListaVehiculosAsociados(List<Vehiculo> listaVehiculosAsociados) {
        this.listaVehiculosAsociados = listaVehiculosAsociados;
    }
    public static Propietario ingresarDatosPropietario(EmpresaTransporte empresa){
        Scanner scanner = new Scanner(System.in);
        Propietario datosPropietario = new Propietario();
        System.out.println("Ingrese el nombre del propietario");
        datosPropietario.setNombre(scanner.nextLine());
        System.out.println("Ingrese la edad del propietario");
        datosPropietario.setEdad(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Ingrese la cedula del propietario");
        datosPropietario.setNumeroIdentificacion(scanner.nextLine());
        System.out.println("Ingrese el email del propietario");
        datosPropietario.setEmail(scanner.nextLine());
        System.out.println("Ingrese el numero de celular del propietario");
        datosPropietario.setNumeroCelular(scanner.nextLine());

        empresa.getListaPropietarios().add(datosPropietario);
        return datosPropietario;
    }


}
