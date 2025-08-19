package co.edu.uniquindio.pr2.factory;

import co.edu.uniquindio.pr2.model.EmpresaTransporte;
import co.edu.uniquindio.pr2.model.Propietario;
import co.edu.uniquindio.pr2.model.VehiculoCarga;
import co.edu.uniquindio.pr2.model.VehiculoPasajero;

public class ModelFactory {
    private static ModelFactory instance;
    EmpresaTransporte empresaTransporte;

    private ModelFactory() {}

    public static ModelFactory getInstance() {
        if(instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    public EmpresaTransporte inicializarDatos() {
        EmpresaTransporte empresa = new EmpresaTransporte();
        empresa.setNombre("La Carreta");

        Propietario propietario1 = new Propietario();
        propietario1.setNombre("Pedro");
        propietario1.setEdad(45);
        propietario1.setIdentificacion("123456789");

        Propietario propietario2 = new Propietario();
        propietario2.setNombre("María");
        propietario2.setEdad(38);
        propietario2.setIdentificacion("987654321");

        Propietario propietario3 = new Propietario();
        propietario3.setNombre("Carlos");
        propietario3.setEdad(52);
        propietario3.setIdentificacion("456123789");

        Propietario propietario4 = new Propietario();
        propietario4.setNombre("Ana");
        propietario4.setEdad(29);
        propietario4.setIdentificacion("789456123");

        VehiculoCarga vehiculoCarga1 = new VehiculoCarga();
        vehiculoCarga1.setPlaca("ABC123");
        vehiculoCarga1.setCapacidadCarga(200);
        vehiculoCarga1.setModelo("Volvo FH");

        VehiculoCarga vehiculoCarga2 = new VehiculoCarga();
        vehiculoCarga2.setPlaca("XYZ789");
        vehiculoCarga2.setCapacidadCarga(500);
        vehiculoCarga2.setModelo("Mercedes Actros");

        VehiculoCarga vehiculoCarga3 = new VehiculoCarga();
        vehiculoCarga3.setPlaca("DEF456");
        vehiculoCarga3.setCapacidadCarga(800);
        vehiculoCarga3.setModelo("Scania R500");

        VehiculoPasajero vehiculoPasajero1 = new VehiculoPasajero();
        vehiculoPasajero1.setPlaca("PAS001");
        vehiculoPasajero1.setNumeroMaximoPasajeros(10);
        vehiculoPasajero1.setModelo("Toyota Hiace");

        VehiculoPasajero vehiculoPasajero2 = new VehiculoPasajero();
        vehiculoPasajero2.setPlaca("PAS002");
        vehiculoPasajero2.setNumeroMaximoPasajeros(20);
        vehiculoPasajero2.setModelo("Mercedes Sprinter");

        VehiculoPasajero vehiculoPasajero3 = new VehiculoPasajero();
        vehiculoPasajero3.setPlaca("PAS003");
        vehiculoPasajero3.setNumeroMaximoPasajeros(15);
        vehiculoPasajero3.setModelo("Ford Transit");

        // Pedro tiene 2 vehículos de carga
        propietario1.getListaVehiculosAsociados().add(vehiculoCarga1);
        propietario1.getListaVehiculosAsociados().add(vehiculoCarga2);

        // María tiene 1 vehículo de pasajeros
        propietario2.getListaVehiculosAsociados().add(vehiculoPasajero1);

        // Carlos tiene 1 vehículo de carga y 1 de pasajeros
        propietario3.getListaVehiculosAsociados().add(vehiculoCarga3);
        propietario3.getListaVehiculosAsociados().add(vehiculoPasajero2);

        // Ana tiene 1 vehículo de pasajeros
        propietario4.getListaVehiculosAsociados().add(vehiculoPasajero3);

        // ===== AGREGAR TODO A LA EMPRESA =====
        // Agregar propietarios
        empresa.getListaPropietarios().add(propietario1);
        empresa.getListaPropietarios().add(propietario2);
        empresa.getListaPropietarios().add(propietario3);
        empresa.getListaPropietarios().add(propietario4);

        // Agregar vehículos de carga
        empresa.getListaVehiculosCarga().add(vehiculoCarga1);
        empresa.getListaVehiculosCarga().add(vehiculoCarga2);
        empresa.getListaVehiculosCarga().add(vehiculoCarga3);

        // Agregar vehículos de pasajeros
        empresa.getListaVehiculosPasajeros().add(vehiculoPasajero1);
        empresa.getListaVehiculosPasajeros().add(vehiculoPasajero2);
        empresa.getListaVehiculosPasajeros().add(vehiculoPasajero3);

        this.empresaTransporte = empresa;
        return empresa;
    }

    public EmpresaTransporte getEmpresaTransporte() {
        return empresaTransporte;
    }


    public void crearPropietarioVehiculoCarga(String propietario, String vehiculo) {
        getEmpresaTransporte().crearPropietarioVehiculoCarga(propietario, vehiculo);
    }
}
