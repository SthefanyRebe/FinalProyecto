package ProyectoF121;

import java.util.ArrayList;
import java.util.List;

public class principal {
    public static void main(String[] args) {
        // Crear un banco
          Banco banco = new Banco("Banco Central");

        // Crear listas para almacenar los datos
        List<Cliente> clientes = new ArrayList<>();
        List<CuentaBancaria> cuentas = new ArrayList<>();
        List<TarjetaCredito> tarjetasDeCredito = new ArrayList<>();
        List<Cajeros> cajeros = new ArrayList<>();

        // Crear instancias de las clases Arch
        ArchCliente archCliente = new ArchCliente(clientes);
        ArchCuentas archCuentas = new ArchCuentas(cuentas, clientes);
        ArchTarjetas archTarjetas = new ArchTarjetas(clientes, tarjetasDeCredito);
        ArchCajeros archCajeros = new ArchCajeros(cajeros);
        
        
        
        //Persistencia de objetos
        // Cargar datos desde archivos (si existen)
        archCliente.cargarDesdeArchivo("clientes.dat");
        archCuentas.cargarDesdeArchivo("cuentas.dat");
        archTarjetas.cargarDesdeArchivo("tarjetas.dat");
        archCajeros.cargarDesdeArchivo("cajeros.dat");

        // Agregar nuevos datos (si es necesario)
        Cliente nuevoCliente = new Cliente("C001", "Calle Falsa 123");
        clientes.add(nuevoCliente);

        // Guardar datos en archivos
        archCliente.guardarEnArchivo("clientes.dat");
        archCuentas.guardarEnArchivo("cuentas.dat");
        archTarjetas.guardarEnArchivo("tarjetas.dat");
        archCajeros.guardarEnArchivo("cajeros.dat");

        // Mostrar los datos cargados
        banco.mostrar();
        //hasta aca la persistenci 
        
        
        
        // Cargar datos desde la base de datos
        archCliente.cargarClientesDesdeBD();
        archCuentas.cargarCuentasDesdeBD();
        archTarjetas.cargarTarjetasDesdeBD();
        archCajeros.cargarCajerosDesdeBD();

        // Asignar las listas cargadas al banco
        banco.setClientes(clientes);
        banco.setCuentas(cuentas);
        banco.setTarjetasDeCredito(tarjetasDeCredito);
        banco.setCajeros(cajeros);

        // Mostrar los datos cargados
        System.out.println("=== Datos cargados desde la base de datos ===");
        banco.mostrar();

        // Crear una instancia del menú y mostrarlo
        Menu menu = new Menu(archCliente, archCuentas, archTarjetas, archCajeros);
        menu.mostrarMenu();
        // ==============================================================
        // Crear nuevos datos (independientes de los ya existentes)
        // ==============================================================
        // Crear clientes
        Cliente cliente1 = new Cliente("C001", "Calle Falsa N 123");
        Cliente cliente2 = new Cliente("C002", "Avenida Siempre Viva N 742");
        Cliente cliente3 = new Cliente("C003", "Calle Alegria N 345");
        Cliente cliente4 = new Cliente("C004", "Avenida Arce N 324");
        Cliente cliente5 = new Cliente("C005", "San Francisco N 457");
        Cliente cliente6 = new Cliente("C006", "Otero De La Vega N 549");

        // Agregar cuentas y tarjetas al cliente 1
        cliente1.CrearCuentaCorriente(123, 400, 1000);
        cliente1.CrearCuentaAhorros(5345, 100, 10, 50, "laboral");
        cliente1.ObtenerTarjeta("A1234", 1000, 3050);
        cliente1.ObtenerTarjeta("BR143", 3000, 200);

        // Agregar cuentas y tarjetas al cliente 2
        cliente2.CrearCuentaAhorros(7438, 300, 5, 100, "privado");
        cliente2.CrearCuentaAhorros(3548, 450, 4, 1500, "privado");

        // Agregar cuentas y tarjetas al cliente 3
        cliente3.CrearCuentaCorriente(1234, 780, 139);
        cliente3.CrearCuentaCorriente(6462, 1000, 1);
        cliente3.CrearCuentaCorriente(34589, 14522, 120);
        cliente3.CrearCuentaAhorros(5345, 100, 10, 50, "laboral");
        cliente3.ObtenerTarjeta("H12658", 2300, 55);
        cliente3.ObtenerTarjeta("F785", 3000, 10);
        cliente3.ObtenerTarjeta("W48573", 2300, 55);
        cliente3.ObtenerTarjeta("Q4753", 49483, 378);

        // Agregar cuentas y tarjetas al cliente 4
        cliente4.CrearCuentaCorriente(4567, 1200, 500);
        cliente4.ObtenerTarjeta("D1121", 1500, 1000);

        // Agregar cuentas y tarjetas al cliente 5
        cliente5.CrearCuentaAhorros(7890, 500, 8, 200, "privado");
        cliente5.ObtenerTarjeta("E3141", 2500, 1200);

        // Agregar cuentas y tarjetas al cliente 6
        cliente6.CrearCuentaCorriente(1122, 600, 300);
        cliente6.ObtenerTarjeta("F5161", 3500, 1800);

        // Crear cajeros automáticos
        Cajeros cajero1 = new Cajeros("Sucursal Centro", "Cajero001", 5000.0);
        Cajeros cajero2 = new Cajeros("Sucursal Norte", "Cajero002", 8000.0);
        Cajeros cajero3 = new Cajeros("Sucursal Sur", "Cajero003", 8000.0);
        Cajeros cajero4 = new Cajeros("Sucursal Centro", "Cajero004", 8000.0);
        Cajeros cajero5 = new Cajeros("Sucursal Norte", "Cajero005", 8000.0);
        Cajeros cajero6 = new Cajeros("Sucursal Sur", "Cajero006", 8000.0);

        // Agregar clientes al banco
        banco.agregarCliente(cliente1);
        banco.agregarCliente(cliente2);
        banco.agregarCliente(cliente3);
        banco.agregarCliente(cliente4);
        banco.agregarCliente(cliente5);
        banco.agregarCliente(cliente6);

        // Agregar cajeros al banco
        banco.getCajeros().add(cajero1);
        banco.getCajeros().add(cajero2);
        banco.getCajeros().add(cajero3);
        banco.getCajeros().add(cajero4);
        banco.getCajeros().add(cajero5);
        banco.getCajeros().add(cajero6);

        // Agregar tarjetas de crédito adicionales al banco
        TarjetaCredito tarjeta1 = new TarjetaCredito("123456789", 5000.0, 2000.0);
        TarjetaCredito tarjeta2 = new TarjetaCredito("987654321", 3000.0, 1500.0);
        TarjetaCredito tarjeta3 = new TarjetaCredito("555555555", 4000.0, 2500.0);
        TarjetaCredito tarjeta4 = new TarjetaCredito("666666666", 6000.0, 3500.0);
        TarjetaCredito tarjeta5 = new TarjetaCredito("777777777", 8000.0, 1000.0);
        TarjetaCredito tarjeta6 = new TarjetaCredito("888888888", 9000.0, 4500.0);

        banco.getTarjetasDeCredito().add(tarjeta1);
        banco.getTarjetasDeCredito().add(tarjeta2);
        banco.getTarjetasDeCredito().add(tarjeta3);
        banco.getTarjetasDeCredito().add(tarjeta4);
        banco.getTarjetasDeCredito().add(tarjeta5);
        banco.getTarjetasDeCredito().add(tarjeta6);

        // Mostrar la información del banco
        banco.mostrar();

        // Solicitar una cuenta de ahorros para el cliente 3
        banco.SolicitudCuentaA("C003");
        System.out.println("*---*********---------------------------");
        // Realizar un pago con la tarjeta de crédito del cliente 1
        cliente1.AccionesTarjeta("A1234", "realizarPago");
        System.out.println("-*************************************------------------");

        // Realizar un retiro con la tarjeta de crédito del cliente 3
        cliente3.AccionesTarjeta("H12658", "retiro");

        // Realizar una transacción con la tarjeta de crédito del cliente 1
        cliente1.AccionesTarjeta("A1234", "transaccion");

        // Nuevas solicitudes del otro main
        System.out.println("\nNuevas solicitudes:");
        
        // SOL1: Crear un cliente y asignarle cuentas bancarias
        System.out.println("SOL1: Creando cliente y asignando cuentas bancarias");
        Cliente cliente7 = new Cliente("C007", "Av. Principal 123");
        cliente7.CrearCuentaCorriente(5678, 1000, 500);
        cliente7.CrearCuentaAhorros(9012, 500, 5, 100, "personal");
        banco.agregarCliente(cliente7);
        
        // SOL2: Realizar un depósito en una cuenta de ahorros
        System.out.println("\nSOL2: Realizando deposito en cuenta de ahorros");
        CuentaBancaria cuentaAhorros = cliente7.getCuentas().get(1);
        cuentaAhorros.depositar(300.0);
        
        // SOL3: Verificar el saldo mínimo en una cuenta de ahorros
        System.out.println("\nSOL3: Verificando saldo minimo en cuenta de ahorros");
        CuentaAhorros cuentaAhorrosTipo = (CuentaAhorros) cuentaAhorros;
        System.out.println("Saldo actual: " + cuentaAhorrosTipo.getSaldo());
        System.out.println("Saldo minimo requerido: " + cuentaAhorrosTipo.getSaldoMinimo());
        if (cuentaAhorrosTipo.getSaldo() >= cuentaAhorrosTipo.getSaldoMinimo()) {
            System.out.println("El saldo es MAYOR o IGUAL al saldo minimo requerido");
        } else {
            System.out.println("El saldo es MENOR al saldo minimo requerido");
        }
        cuentaAhorrosTipo.agregarInteres();
        
        // SOL4: Realizar un retiro en una cuenta corriente
        System.out.println("\nSOL4: Realizando retiro en cuenta corriente");
        CuentaCorriente cuentaCorriente = (CuentaCorriente) cliente7.getCuentas().get(0);
        System.out.println("Saldo antes del retiro: " + cuentaCorriente.getSaldo());
        cuentaCorriente.retirar(200.0);
        System.out.println("Saldo despues del retiro: " + cuentaCorriente.getSaldo());
        
        // SOL5: Crear y mostrar los datos de una tarjeta de crédito
        System.out.println("\nSOL5: Creando y mostrando tarjeta de credito");
        cliente7.ObtenerTarjeta("N9876", 5000, 1000);
        TarjetaCredito tarjeta = cliente7.getTarjetasDeCredito().get(0);
        tarjeta.mostrar();
        
        // SOL6: Registrar una transacción en una cuenta bancaria
        System.out.println("----------------------------------***************************---------------------------------------");
        System.out.println("\nSOL6: Registrando transaccion en cuenta bancaria");
        cuentaAhorros.RealizarTransaccion("TR001", 150.0, "deposito");
        
        // SOL7: Consultar el saldo disponible desde un cajero
        System.out.println("\nSOL7: Consultando saldo desde cajero");
        Cajeros cajeroN = new Cajeros("Sucursal Principal", "CAJ001", 10000.0);
        cajeroN.consultarSaldo(cuentaAhorros);
        System.out.println("----------------------------------***************************---------------------------------------");
        // SOL8: Dispensar efectivo desde un cajero
        System.out.println("\nSOL8: Dispensando efectivo desde cajero");
        cajeroN.dispensarEfectivo(500.0);
        
        // SOL9: Pagar una tarjeta de crédito
        System.out.println("\nSOL9: Pagando tarjeta de credito");
        tarjeta.realizarPago(200.0);
        
        // SOL10: Mostrar todos los clientes de un banco
        System.out.println("\nSOL10: Mostrando clientes del banco");
        banco.mostrar();
    }
}