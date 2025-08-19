package co.edu.uniquindio.pr2;

import co.edu.uniquindio.pr2.factory.ModelFactory;
import co.edu.uniquindio.pr2.model.*;

import static co.edu.uniquindio.pr2.model.EmpresaTransporte.ingresarPeso;
import static co.edu.uniquindio.pr2.model.Vehiculo.buscarPlaca;


public class Main {
    public static void main(String[] args) {
        ModelFactory modelFactory = ModelFactory.getInstance();
        EmpresaTransporte empresaTransporte = modelFactory.inicializarDatos();
        crearPropietarioVehiculoCarga(modelFactory);
        empresaTransporte.listaPropietarioVehiculoCarga(ingresarPeso());
        empresaTransporte.usuariosMovilizadosEnVehiculo(empresaTransporte,buscarPlaca());
        empresaTransporte.propietariosMayores();
        empresaTransporte.calcularTotalPasajerosTransportados(empresaTransporte,buscarPlaca());
    }

    private static void calcularTotalPasajerosTransportados(EmpresaTransporte empresaTransporte) {

    }

    private static void crearPropietarioVehiculoCarga(ModelFactory modelFactory) {
        String propietario = "Pepe";
        String vehiculo = "ARM 2232";
        modelFactory.crearPropietarioVehiculoCarga(propietario, vehiculo);
    }
}