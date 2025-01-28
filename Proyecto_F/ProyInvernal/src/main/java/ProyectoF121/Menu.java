package ProyectoF121;

import java.util.Scanner;

public class Menu {

    private ArchCliente archCliente;
    private ArchCuentas archCuentas;
    private ArchTarjetas archTarjetas;
    private ArchCajeros archCajeros;

    public Menu(ArchCliente archCliente, ArchCuentas archCuentas, ArchTarjetas archTarjetas, ArchCajeros archCajeros) {
        this.archCliente = archCliente;
        this.archCuentas = archCuentas;
        this.archTarjetas = archTarjetas;
        this.archCajeros = archCajeros;
    }

    // Método para mostrar el menú y manejar las opciones
    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== Menu de opciones ===");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Agregar cuenta");
            System.out.println("3. Agregar tarjeta de credito");
            System.out.println("4. Agregar cajero");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    agregarClientePorTeclado(scanner);
                    break;
                case 2:
                    agregarCuentaPorTeclado(scanner);
                    break;
                case 3:
                    agregarTarjetaPorTeclado(scanner);
                    break;
                case 4:
                    agregarCajeroPorTeclado(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo del menu...");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    // Método para agregar un cliente por teclado
    private void agregarClientePorTeclado(Scanner scanner) {
        System.out.println("\n=== Agregar cliente ===");
        System.out.print("Ingrese el ID del cliente: ");
        String id = scanner.nextLine();
        System.out.print("Ingrese la direccion del cliente: ");
        String direccion = scanner.nextLine();

        Cliente cliente = new Cliente(id, direccion);
        archCliente.getClientes().add(cliente);
        archCliente.guardarClientesEnBD();
        System.out.println("Cliente agregado y guardado en la base de datos.");
    }

    // Método para agregar una cuenta por teclado
    private void agregarCuentaPorTeclado(Scanner scanner) {
        System.out.println("\n=== Agregar cuenta ===");
        System.out.print("Ingrese el ID del cliente: ");
        String clienteId = scanner.nextLine();
        System.out.print("Ingrese el número de cuenta: ");
        int nroCuenta = scanner.nextInt();
        System.out.print("Ingrese el saldo inicial: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer del scanner
        System.out.print("Ingrese el tipo de cuenta (ahorro/corriente): ");
        String tipo = scanner.nextLine();

        Cliente cliente = archCuentas.obtenerCliente(clienteId);
        if (cliente != null) {
            if (tipo.equalsIgnoreCase("ahorro")) {
                System.out.print("Ingrese la tasa de interes: ");
                double tasaInteres = scanner.nextDouble();
                System.out.print("Ingrese el saldo minimo: ");
                double saldoMinimo = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer del scanner
                CuentaAhorros cuenta = new CuentaAhorros(nroCuenta, saldo, tasaInteres, saldoMinimo, "personal");
                cliente.agregarCuenta(cuenta);
            } else if (tipo.equalsIgnoreCase("corriente")) {
                System.out.print("Ingrese el límite de sobregiro: ");
                double limiteSobregiro = scanner.nextDouble();
                scanner.nextLine(); // Limpiar el buffer del scanner
                CuentaCorriente cuenta = new CuentaCorriente(nroCuenta, saldo, limiteSobregiro);
                cliente.agregarCuenta(cuenta);
            }
            archCuentas.guardarCuentasEnBD();
            System.out.println("Cuenta agregada y guardada en la base de datos.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    // Método para agregar una tarjeta de crédito por teclado
    private void agregarTarjetaPorTeclado(Scanner scanner) {
        System.out.println("\n=== Agregar tarjeta de crédito ===");
        System.out.print("Ingrese el ID del cliente: ");
        String clienteId = scanner.nextLine();
        System.out.print("Ingrese el numero de tarjeta: ");
        String numTarjeta = scanner.nextLine();
        System.out.print("Ingrese el limite de crédito: ");
        double limite = scanner.nextDouble();
        System.out.print("Ingrese el saldo inicial: ");
        double saldo = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer del scanner

        Cliente cliente = archTarjetas.obtenerCliente(clienteId);
        if (cliente != null) {
            TarjetaCredito tarjeta = new TarjetaCredito(numTarjeta, limite, saldo);
            cliente.agregarTarjeta(tarjeta);
            archTarjetas.guardarTarjetasEnBD();
            System.out.println("Tarjeta de credito agregada y guardada en la base de datos.");
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    // Método para agregar un cajero por teclado
    private void agregarCajeroPorTeclado(Scanner scanner) {
        System.out.println("\n=== Agregar cajero ===");
        System.out.print("Ingrese el ID del cajero: ");
        String idCajero = scanner.nextLine();
        System.out.print("Ingrese la ubicaciun del cajero: ");
        String ubicacion = scanner.nextLine();
        System.out.print("Ingrese el efectivo disponible: ");
        double efectivoDisponible = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer del scanner

        Cajeros cajero = new Cajeros(ubicacion, idCajero, efectivoDisponible);
        archCajeros.getCajeros().add(cajero);
        archCajeros.guardarCajerosEnBD();
        System.out.println("Cajero agregado y guardado en la base de datos.");
    }
}