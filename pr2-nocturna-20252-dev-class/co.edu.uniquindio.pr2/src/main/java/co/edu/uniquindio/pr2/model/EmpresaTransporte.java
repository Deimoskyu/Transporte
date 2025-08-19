package co.edu.uniquindio.pr2.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class EmpresaTransporte {
    private String nombre;

    private List<VehiculoCarga> listaVehiculosCarga = new ArrayList<>();
    private List<VehiculoPasajero> listaVehiculosPasajeros = new ArrayList<>();
    private List<Propietario> listaPropietarios = new ArrayList<>();

    public EmpresaTransporte() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<VehiculoCarga> getListaVehiculosCarga() {
        return listaVehiculosCarga;
    }

    public void setListaVehiculosCarga(List<VehiculoCarga> listaVehiculosCarga) {
        this.listaVehiculosCarga = listaVehiculosCarga;
    }

    public List<VehiculoPasajero> getListaVehiculosPasajeros() {
        return listaVehiculosPasajeros;
    }

    public void setListaVehiculosPasajeros(List<VehiculoPasajero> listaVehiculosPasajeros) {
        this.listaVehiculosPasajeros = listaVehiculosPasajeros;
    }

    public List<Propietario> getListaPropietarios() {
        return listaPropietarios;
    }

    public void setListaPropietarios(List<Propietario> listaPropietarios) {
        this.listaPropietarios = listaPropietarios;
    }

    public void crearPropietarioVehiculoCarga(String propietario, String vehiculo) {
        Propietario propietarioObj = new Propietario();
        propietarioObj.setNombre(propietario);
        VehiculoCarga vehiculoObj = new VehiculoCarga();
        vehiculoObj.setPlaca(vehiculo);
        propietarioObj.setVehiculo(vehiculoObj);
        listaPropietarios.add(propietarioObj);
    }

    public ArrayList listaPropietarioVehiculoCarga(double peso){
        ArrayList<Propietario> propietarioVehiculoCarga = new ArrayList<>();
        for (VehiculoCarga vehiculoCarga : listaVehiculosCarga) {
            if (peso > vehiculoCarga.getCapacidadCarga()) {
                System.out.println("Lista de propietarios que supera el peso de carga:");
                for (Propietario propietario : listaPropietarios) {
                    System.out.println(propietario.getNombre() +"Se esta excediendo el peso de carga: ");
                    propietarioVehiculoCarga.add(propietario);
                }
            }else {
                System.out.println("No hay propietarios que supera el peso de carga:");

            }
        }
        return propietarioVehiculoCarga;
    }
    public static double ingresarPeso(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("ingrese el peso de carga");

        return scanner.nextDouble();
    }
    public void usuariosMovilizadosEnVehiculo(EmpresaTransporte empresa, String placa){
        for (VehiculoPasajero vehiculoActual : empresa.getListaVehiculosPasajeros()){
            if (Objects.equals(vehiculoActual.getPlaca(), placa)){
                System.out.println("El vehiculo con placa: " + placa + " Transporto " + vehiculoActual.getPasajerosTransportados() + " Pasajeros");
                return;
            }
        }
        System.out.println("No se encontró un vehículo con la placa " + placa);
    }
    public ArrayList propietariosMayores(){
        ArrayList<Propietario> propietariosMayores = new ArrayList<>();
        for (Propietario propietario : listaPropietarios){
            if (propietario.getEdad() > 60){
                propietariosMayores.add(propietario);
            }
        }
        System.out.println("Los propietarios mayores de 60 años son:");
        for (Propietario propietarioMayor : propietariosMayores){
            System.out.println(propietarioMayor.getNombre());
        }
        return propietariosMayores;
    }

    public int calcularTotalPasajerosTransportados(EmpresaTransporte empresaTransporte, String placa) {
        Scanner scanner = new Scanner(System.in);
        int suma = 0;

        for (VehiculoPasajero vehiculo : empresaTransporte.getListaVehiculosPasajeros()) {
            if (Objects.equals(vehiculo.getPlaca(), placa)) {
                System.out.println("Ingrese el numero de viajes que hizo en el dia");
                int numViajes = scanner.nextInt();

                for (int i = 1; i <= numViajes; i++) {
                    System.out.println("Ingrese la cantidad de pasajeros del viaje " + i);
                    int cantidadPasajeros = scanner.nextInt();
                    suma += cantidadPasajeros;
                }

                vehiculo.setPasajerosTransportados(suma);
                System.out.println("La cantidad de pasajeros del dia fue: " + suma);
            }
        }
        return suma;
    }


}
