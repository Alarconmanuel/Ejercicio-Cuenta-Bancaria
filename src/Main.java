import java.util.*;

public class Main {
    /*
    Se creo un limite de 5 transacciones por cuenta al ingresar cada vez a una
    y se creo un nuevo metodo para hacer transacciones entre cuentas en la
    clase Cuentabancaria, ademas en transacciones se agrego otra opción para
    hacer uso de este metodo.
     */
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int op ,transacciones;
        double monto;
        boolean estado = true, transacionEstado= true;


        List<CuentaBancaria> lstBanco = new ArrayList<>();
        CuentaBancaria cl1 = new CuentaBancaria();

        do {
            System.out.println("""
                    1. CREAR UN CLIENTE
                    2. MOSTRAR CLIENTES/CUENTAS
                    3. MOSTAR INFORMACION DE UNA CUENTA ESPECIFICA
                    4. TRANSACCIONES
                    5. SALIR
                    """);
            op = teclado.nextInt();
            switch (op) {
                case 1 -> {
                    System.out.println("INGRESE NOMBRE DEL TITULAR: ");
                    cl1.setTitular(teclado.next());

                    System.out.println("INGRESE SALDO DE LA CUENTA: ");
                    cl1.setSaldo(teclado.nextDouble());

                    System.out.println("INGRESE NUMERO DE LA CUENTA");
                    cl1.setNumeroCuenta(teclado.next());

                    //cl1 = new CuentaBancaria(cl1.getTitular(), cl1.getSaldo(), cl1.getNumeroCuenta());
                    //lstBanco.add(cl1);

                    lstBanco.add(new CuentaBancaria(cl1.getTitular(), cl1.getSaldo(), cl1.getNumeroCuenta()));
                }
                case 2 -> {
                    for (CuentaBancaria cu : lstBanco) {
                        System.out.println(cu);
                    }
                }
                case 3 -> {
                    String nCuenta;
                    System.out.println("INGRESE SU NUMERO DE CUENTA");
                    nCuenta = teclado.next();
                    for (int i =0; i < lstBanco.size(); i++){
                        if (lstBanco.get(i).getNumeroCuenta().equalsIgnoreCase(nCuenta)){
                            System.out.println(lstBanco.get(i));
                        }
                    }
                }
                case 4 -> {
                    String nCuenta;
                    System.out.println("INGRESE SU NUMERO DE CUENTA");
                    nCuenta = teclado.next();
                    CuentaBancaria cuentaSeleccionada = null;
                    for (CuentaBancaria cuenta : lstBanco) {
                        if (cuenta.getNumeroCuenta().equalsIgnoreCase(nCuenta)) {
                            cuentaSeleccionada = cuenta;
                        }
                    }
                    transacciones=5;

                        do {
                            System.out.println("""
                                    1. DEPOSITAR DINERO
                                    2. RETIRAR DINERO
                                    3. TRANSFERIR A OTRA CUENTA 
                                    4. MOSTRAR DATOS DE LA CUENTA 
                                    5. MOSTRAR CLIENTES DESDE LA LISTA
                                    6. SALIR
                                    """);

                            op = teclado.nextInt();

                            switch (op) {
                                case 1 -> {
                                    System.out.println("DEPOSITAR");
                                    do {
                                        System.out.println("CUANTO DINERO DESEA DEPOSITAR");
                                        monto = teclado.nextDouble();
                                    } while (monto <= 0);
                                    cuentaSeleccionada.depositarDinero(monto);
                                    System.out.println("DINERO DEPOSITADO");
                                    transacciones-=1;
                                    System.out.println("TRANSACCIONES RESTANTES: "+transacciones);
                                }
                                case 2 -> {
                                    System.out.println("RETIRAR");
                                    do {
                                        System.out.println("CUANTO DINERO DESEA RETIRAR");
                                        monto = teclado.nextDouble();
                                    } while (monto <= 0);
                                    cuentaSeleccionada.retirarDinero(monto);
                                    System.out.println("DINERO RETIRADO");
                                    transacciones-=1;
                                    System.out.println("TRANSACCIONES RESTANTES: "+transacciones);
                                }
                                case 3 -> {
                                    System.out.println("INGRESE EL NUMERO DE CUENTA DESTINO:");
                                    String cuentaDestinoNum = teclado.next();

                                    CuentaBancaria cuentaDestino = null;
                                    for (CuentaBancaria cuenta : lstBanco) {
                                        if (cuenta.getNumeroCuenta().equalsIgnoreCase(cuentaDestinoNum)) {
                                            cuentaDestino = cuenta;
                                        }
                                    }

                                    if (cuentaDestino == null) {
                                        System.out.println("Cuenta destino no encontrada.");
                                    } else {
                                        System.out.println("CUANTO DINERO DESEA TRANSFERIR:");
                                        monto = teclado.nextDouble();
                                        if (monto > 0) {
                                            cuentaSeleccionada.transferirDinero(cuentaDestino, monto);
                                        } else {
                                            System.out.println("El monto debe ser mayor a 0");
                                        }
                                    }
                                    transacciones-=1;
                                    System.out.println("TRANSACCIONES RESTANTES: "+transacciones);
                                }
                                case 4 -> {
                                    System.out.println("MOSTRAR DATOS DE LA CUENTA");
                                    cuentaSeleccionada.mostrarInformacion();
                                }
                                case 5 -> {
                                    System.out.println("MOSTRAR DATOS DE LA CUENTA DESDE LA LISTA");
                                    for (CuentaBancaria cu : lstBanco) {
                                        System.out.println(cu);
                                    }
                                }
                                case 6 -> {
                                    System.out.println("SALIR...");
                                    transacionEstado = false;
                                }
                                default -> {
                                    System.out.println("NO EXISTE OPCION");
                                }
                            }
                            if (transacciones==0) {
                                System.out.println("YA NO TE QUEDAN MÁS TRANSACCIONES");
                            }
                        } while (transacionEstado && transacciones>0);
                }
                case 5 -> {
                    System.out.println("Saliendo del sistema...");
                    estado = false;
                }
                default -> {
                    System.out.println("OPCION NO VALIDA. INTENTE DE NUEVO.");
                }
            }
        } while (estado);
    }
}