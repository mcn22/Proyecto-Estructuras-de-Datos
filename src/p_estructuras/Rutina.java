package p_estructuras;

import javax.swing.JOptionPane;

public class Rutina {

    /*------------Variables globales-------------*/
    boolean compra = false;
    boolean invNull = false;
    int codFact = 1;
    int codOrd = 1;
    int codClien = 3;
    int codAdmin = 1001;
    int codEmp = 1502;
    int codCarta = 13;
    float total;
    NodoLCClien user = null;
    NodoLCClien invitado = new NodoLCClien(new Cliente("", 0, "", "", 'N', 0, ""), new ListaSFact());
    NodoLCAdmin adminUser = null;
    /*-------------------------------------------*/
    ListaCClien cliente = new ListaCClien();
    ListaSCart carta = new ListaSCart();
    FormFactura factura = new FormFactura();
    ColaOrd orden = new ColaOrd();
    ListaCAdmin admin = new ListaCAdmin();
    PilaOrdAten ordenAten = new PilaOrdAten();
    ListaCCorr correos = new ListaCCorr();
    ListaCEmp empleado = new ListaCEmp();
    PilaSoli solicitud = new PilaSoli();
    ArbolReser reserva = new ArbolReser();

    int mesa[] = {16, 8, 24, 4, 12, 20, 28, 2, 6, 10, 14, 18, 22, 26, 30, 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31};

    public int demeNum(String msj) {
        String s = JOptionPane.showInputDialog(msj);
        int n = Integer.parseInt(s);
        return n;
    }//fin demenum

    public void predeterminado() {
        cliente.insertar(new Cliente("Paola Murillo", 100, "a", "a", 'C', 1, "300mts este templo cat Paraiso"));
        correos.insertar("a");
        cliente.insertar(new Cliente("Daniel Morales", 10000, "s", "s", 'C', 2, "500mts oeste de la POPS, Cartago"));
        correos.insertar("s");
        admin.insertar(new Admin("Admin Sánchez", "admin", "admin", 'A', 1000));
        correos.insertar("1");
        empleado.insertar(new Empleado("Luciana Montero", 'C', 1500, 56894325, "Chef"));
        empleado.insertar(new Empleado("Stefano Gallardo", 'R', 1501, 40235432, "Repartidor"));
        solicitud.push(new NodoPSoli(new Solicitud("Maria Jara", 23, "Chef", 54769823)));
        solicitud.push(new NodoPSoli(new Solicitud("Erick Cabalceta", 32, "Repartidor", 49032718)));
        solicitud.push(new NodoPSoli(new Solicitud("Oscar Camacho", 45, "Chef", 23094323)));
        reserva.modifica("Daniela Murillo", 34982323, 40234323, 20, 40);
    }//fin de predeterminado

    public void cargaArbol() {
        for (int i = 0; i < 31; i++) {
            reserva.insertar(new Reserva("", 0, 0, mesa[i], 0, false));
        }
    }//fin de la carga de los espacios de los arboles

    public void cartaPred() {
        carta.insertar(new Carta("Casado", 1, 'C', 2200));
        carta.insertar(new Carta("Arroz con pollo", 2, 'C', 2200));
        carta.insertar(new Carta("Papas fritas", 3, 'C', 700));
        carta.insertar(new Carta("Lasaña", 4, 'C', 2500));
        carta.insertar(new Carta("Natural cas", 5, 'B', 500));
        carta.insertar(new Carta("Natural mora", 6, 'B', 500));
        carta.insertar(new Carta("Gaseosa", 7, 'B', 400));
        carta.insertar(new Carta("Café", 8, 'B', 600));
        carta.insertar(new Carta("Helado", 9, 'P', 2000));
        carta.insertar(new Carta("Tres leches", 10, 'P', 1800));
        carta.insertar(new Carta("Tiramizú", 11, 'P', 2000));
        carta.insertar(new Carta("Empanada", 12, 'P', 1000));
    }//fin de la carga de los productos predeterminados 

    public void agregaCarta() {
        int opc;
        String nombre = "";
        int precio = 0;
        boolean salir = false;
        do {
            try {
                opc = demeNum("1- Agregar comida\n2- Agregar bebida\n3- Agregar postre\n5- Atrás");
                switch (opc) {
                    case 1:
                        nombre = JOptionPane.showInputDialog("Digita el nombre de la comida");
                        precio = demeNum("Digita el costo del producto");
                        if (!nombre.equals("") && precio != 0) {
                            carta.insertar(new Carta(nombre, codCarta, 'C', precio));
                            JOptionPane.showMessageDialog(null, "Agregado a la carta!");
                            codCarta++;
                        }//fin del if de los datos correctos
                        else {
                            JOptionPane.showMessageDialog(null, "Ha habido un problema con los datos ingresados");
                        }
                        break;
                    case 2:
                        nombre = JOptionPane.showInputDialog("Digita el nombre de la bebida");
                        precio = demeNum("Digita el costo del producto");
                        if (!nombre.equals("") && precio != 0) {
                            carta.insertar(new Carta(nombre, codCarta, 'B', precio));
                            JOptionPane.showMessageDialog(null, "Agregado a la carta!");
                            codCarta++;
                        }//fin del if de los datos correctos
                        else {
                            JOptionPane.showMessageDialog(null, "Ha habido un problema con los datos ingresados");
                        }
                        break;
                    case 3:
                        nombre = JOptionPane.showInputDialog("Digita el nombre del postre");
                        precio = demeNum("Digita el costo del producto");
                        if (!nombre.equals("") && precio != 0) {
                            carta.insertar(new Carta(nombre, codCarta, 'P', precio));
                            JOptionPane.showMessageDialog(null, "Agregado a la carta!");
                            codCarta++;
                        }//fin del if de los datos correctos
                        else {
                            JOptionPane.showMessageDialog(null, "Ha habido un problema con los datos ingresados");
                        }
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }//fin del switch 
            } catch (java.lang.StackOverflowError | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
            }//fin del try catch
        } while (!salir);

    }//fin de la agregacion de nuevos elementos de la carta

    public void visualizaClte() {
        String dispo;
        int dato;
        boolean enc = false;
        dispo = cliente.dispoCliente();
        dato = demeNum("Digita el código del cliente a visualizar\n" + dispo);
        enc = cliente.buscaId(dato);
        if (enc) {
            JOptionPane.showMessageDialog(null, cliente.extraeClte(dato));
        }//fin del if de los datos correctos
        else {
            JOptionPane.showMessageDialog(null, "Código no válido!");
        }
    }//fin de la visualizacion de los clientes

    public void eliminaClte() {
        String dispo;
        int dato;
        boolean enc = false;
        dispo = cliente.dispoCliente();
        dato = demeNum("Digita el código del cliente a eliminar\n" + dispo);
        enc = cliente.buscaId(dato);
        if (enc) {
            cliente.elimina(dato);
            JOptionPane.showMessageDialog(null, "Cliente eliminado");
        }//fin del if de los datos correctos
        else {
            JOptionPane.showMessageDialog(null, "Código no válido!");
        }
    }//fin de la eliminacion de los clientes

    public void modificaCarta() {
        int opc;
        int dato;
        int precio = 0;
        boolean salir = false;
        do {
            try {
                opc = demeNum("1- Comida\n2- Bebida\n3- Postre\n9- Atrás");
                boolean enc = false;
                String dispo;
                switch (opc) {
                    case 1:
                        dispo = carta.dispo('C');
                        dato = demeNum("Digita el código del producto a modificar\n" + dispo);
                        enc = carta.busca(dato, 'C');
                        if (enc) {
                            precio = demeNum("Digita el costo del producto");
                            carta.modifica(dato, precio);
                            JOptionPane.showMessageDialog(null, "Modificado!");
                        }//fin del if de los datos correctos
                        else {
                            JOptionPane.showMessageDialog(null, "Código no válido!");
                        }
                        break;
                    case 2:
                        dispo = carta.dispo('B');
                        dato = demeNum("Digita el código del producto a modificar\n" + dispo);
                        enc = carta.busca(dato, 'B');
                        if (enc) {
                            precio = demeNum("Digita el costo del producto");
                            carta.modifica(dato, precio);
                            JOptionPane.showMessageDialog(null, "Modificado!");
                        }//fin del if de los datos correctos
                        else {
                            JOptionPane.showMessageDialog(null, "Código no válido!");
                        }
                        break;
                    case 3:
                        dispo = carta.dispo('P');
                        dato = demeNum("Digita el código del producto a modificar\n" + dispo);
                        enc = carta.busca(dato, 'P');
                        if (enc) {
                            precio = demeNum("Digita el costo del producto");
                            carta.modifica(dato, precio);
                            JOptionPane.showMessageDialog(null, "Modificado!");
                        }//fin del if de los datos correctos
                        else {
                            JOptionPane.showMessageDialog(null, "Código no válido!");
                        }
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }//fin del switch 
            } catch (java.lang.StackOverflowError | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
            }//fin del try catch
        } while (!salir);
    }//fin de la modificacion de los elementos de la carta

    public void eliminaCarta() {
        int opc;
        int dato;
        boolean salir = false;
        do {
            try {
                opc = demeNum("1- Comida\n2- Bebida\n3- Postre\n5- Atrás");
                boolean enc = false;
                String dispo;
                switch (opc) {
                    case 1:
                        dispo = carta.dispo('C');
                        dato = demeNum("Digita el código del producto a eliminar\n" + dispo);
                        enc = carta.busca(dato, 'C');
                        if (enc) {
                            carta.elimina(dato);
                            JOptionPane.showMessageDialog(null, "Eliminado!");
                        }//fin del if de los datos correctos
                        else {
                            JOptionPane.showMessageDialog(null, "Código no válido!");
                        }
                        break;
                    case 2:
                        dispo = carta.dispo('B');
                        dato = demeNum("Digita el código del producto a eliminar\n" + dispo);
                        enc = carta.busca(dato, 'B');
                        if (enc) {
                            carta.elimina(dato);
                            JOptionPane.showMessageDialog(null, "Eliminado!");
                        }//fin del if de los datos correctos
                        else {
                            JOptionPane.showMessageDialog(null, "Código no válido!");
                        }
                        break;
                    case 3:
                        dispo = carta.dispo('P');
                        dato = demeNum("Digita el código del producto a eliminar\n" + dispo);
                        enc = carta.busca(dato, 'P');
                        if (enc) {
                            carta.elimina(dato);
                            JOptionPane.showMessageDialog(null, "Eliminado!");
                        }//fin del if de los datos correctos
                        else {
                            JOptionPane.showMessageDialog(null, "Código no válido!");
                        }
                        break;
                    case 5:
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }//fin del switch 
            } catch (java.lang.StackOverflowError | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
            }//fin del try catch
        } while (!salir);
    }//fin de la eliminacion de los elementos de la carta

    public void visualizaCarta() {
        int opc;
        boolean salir = false;
        do {
            try {
                opc = demeNum("1- Comida\n2- Bebida\n3- Postre\n9- Atrás");
                String dispo;
                switch (opc) {
                    case 1:
                        dispo = carta.dispo('C');
                        JOptionPane.showMessageDialog(null, "Lista actual:\n" + dispo);
                        break;
                    case 2:
                        dispo = carta.dispo('B');
                        JOptionPane.showMessageDialog(null, "Lista actual:\n" + dispo);
                        break;
                    case 3:
                        dispo = carta.dispo('P');
                        JOptionPane.showMessageDialog(null, "Lista actual:\n" + dispo);
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }//fin del switch 
            } catch (java.lang.StackOverflowError | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
            }//fin del try catch
        } while (!salir);
    }//fin de la visualizacion de los elementos de la carta

    public NodoLCClien sesion(NodoLCClien dato) {
        int continua = 0;
        NodoLCClien usuario = null;
        boolean encP = false;
        NodoLCClien sesion = dato;
        String password = dato.getDato().getPass();
        try {
            do {
                String intro = String.format("Hola %s!\nDigita tu contraseña", sesion.getDato().getNombre());
                String pass = JOptionPane.showInputDialog(intro);
                if (password.equals(pass)) {
                    usuario = sesion;
                    encP = true;
                }//fin del if si esta
                else {
                    JOptionPane.showMessageDialog(null, "Contraseña inválida!");
                    continua = JOptionPane.showConfirmDialog(null, "Quieres intentarlo de nuevo?",
                            "Seleccione opción", JOptionPane.YES_NO_OPTION);
                }//fin del else
            } while (!encP && continua == 0);
        } catch (java.lang.StackOverflowError | NumberFormatException | NullPointerException e) {
        }//fin del try catch
        return usuario;
    }//fin de extraer los datos del usuario 

    public NodoLCAdmin sesionAdm(NodoLCAdmin dato) {
        int continua = 0;
        NodoLCAdmin usuario = null;
        boolean encP = false;
        NodoLCAdmin sesion = dato;
        String password = dato.getDato().getPass();
        try {
            do {
                String intro = String.format("Hola %s!\nDigita tu contraseña", sesion.getDato().getNombre());
                String pass = JOptionPane.showInputDialog(intro);
                if (password.equals(pass)) {
                    usuario = sesion;
                    encP = true;
                }//fin del if si esta
                else {
                    JOptionPane.showMessageDialog(null, "Contraseña inválida!");
                    continua = JOptionPane.showConfirmDialog(null, "Quieres intentarlo de nuevo?",
                            "Seleccione opción", JOptionPane.YES_NO_OPTION);
                }//fin del else
            } while (!encP && continua == 0);
        } catch (java.lang.StackOverflowError | NumberFormatException | NullPointerException e) {
        }//fin del try catch
        return usuario;
    }//fin de extraer los datos del usuario 

    public void miCuenta() {
        int opc;
        boolean salir = false;
        do {
            try {
                opc = demeNum("1- Mis datos\n2- Modificar mis datos\n4- Historial de compras\n9- Atrás");
                switch (opc) {
                    case 1:
                        String datos = "Nombre: " + user.getDato().getNombre() + "\n";
                        datos += "Código de usuario: " + user.getDato().getId() + "\n";
                        datos += "Correo: " + user.getDato().getCorreo() + "\n";
                        datos += "Lugar de envío predeterminado:\n" + user.getDato().getEnvio() + "\n";
                        datos += "Puntos acumulados: " + user.getDato().getPuntos() + "\n";
                        JOptionPane.showMessageDialog(null, datos);
                        break;
                    case 2:
                        modificaCliente();
                        break;
                    case 3:
                        break;
                    case 4:
                        impFactura(user);
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }//fin del switch 
            } catch (java.lang.StackOverflowError | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
            }//fin del try catch
        } while (!salir);
    }//fin de mi cuenta que modifica datos o revisa historial de compras

    public void modificaCliente() {
        int opc;
        boolean salir = false;
        do {
            try {
                opc = demeNum("1- Mi nombre\n2- Mi correo\n3- Mi contraseña\n"
                        + "4- Mi dirección de envío\n9- Atrás");
                switch (opc) {
                    case 1:
                        cliente.modNombre(user.getDato().getId());
                        break;
                    case 2:
                        String correo = "";
                        boolean enc = false;
                        do {
                            correo = JOptionPane.showInputDialog("Digita tu nuevo correo");
                            enc = cliente.buscaCorreo(correo);
                            if (enc) {
                                JOptionPane.showMessageDialog(null, "Ese correo ya está en uso, intenta con otro");
                            }//fin del correo repetido
                        } while (enc);
                        cliente.modCorreo(user.getDato().getId(), correo);
                        break;
                    case 3:
                        cliente.modPass(user.getDato().getId());
                        break;
                    case 4:
                        cliente.modEnvio(user.getDato().getId());
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }//fin del switch 
            } catch (java.lang.StackOverflowError | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
            }//fin del try catch
        } while (!salir);
    }//fin de menu de la compra del cliente

    public void creaCliente() {
        String correo = "";
        boolean enc = false;
        try {
            String nombre = JOptionPane.showInputDialog("Digita tu nombre");
            do {
                correo = JOptionPane.showInputDialog("Digita tu correo");
                enc = correos.buscaCorreo(correo);
                if (enc) {
                    JOptionPane.showMessageDialog(null, "Ese correo ya está en uso, intenta con otro");
                }//fin del correo repetido
            } while (enc);
            String pass = JOptionPane.showInputDialog("Digita tu contraseña");
            String envio = JOptionPane.showInputDialog("Digita la dirección donde te enviaremos frecuentemente tu compra");
            if (!nombre.equals("") && !correo.equals("") && !pass.equals("") && !envio.equals("")) {
                cliente.insertar(new Cliente(nombre, 0, correo, pass, 'C', codClien, envio));
                codClien++;
                JOptionPane.showMessageDialog(null, "Te damos la bienvenida " + nombre + "!"
                        + "\ninicia sesión para comenzar a disfrutar los beneficios");
                correos.insertar(correo);
            }//fin del if de los datos correctos
            else {
                JOptionPane.showMessageDialog(null, "Ha habido un problema con los datos ingresados");
            }
        } catch (java.lang.StackOverflowError | NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
        }//fin del try catch
    }//fin de la creacion del cliente

    public void creaAdmin() {
        String correo = "";
        boolean enc = false;
        String nombre = JOptionPane.showInputDialog("Digita el nombre");
        do {
            correo = JOptionPane.showInputDialog("Digita el correo");
            enc = correos.buscaCorreo(correo);
            if (enc) {
                JOptionPane.showMessageDialog(null, "Ese correo ya está en uso, intenta con otro");
            }//fin del correo repetido
        } while (enc);
        String pass = JOptionPane.showInputDialog("Digita la contraseña");
        if (!nombre.equals("") && !correo.equals("") && !pass.equals("")) {
            admin.insertar(new Admin(nombre, correo, pass, 'A', codAdmin));
            codAdmin++;
            JOptionPane.showMessageDialog(null, "Administrador agregado");
            correos.insertar(correo);
        }//fin del if de los datos correctos
        else {
            JOptionPane.showMessageDialog(null, "Ha habido un problema con los datos ingresados");
        }
    }//fin de la creacion del admin

    public void muestraCarta(char tipo) {
        String cart = carta.extraeLista(tipo);
        int sel = demeNum(cart);
        NodoLSCart dato = carta.extraeDato(sel, tipo);
        if (dato != null) {
            int cant = demeNum("Digite la cantidad");
            factura.formato(dato, cant, user.getDato().getPuntos());
            compra = true;
            user.getDato().setPuntos(factura.puntos);
        }//fin del if si el producto esta
        else {
            JOptionPane.showMessageDialog(null, "Código no válido");
        }//fin del else de un error
    }//fin de la muestra de la carta

    public void compra() {
        int continua = 1;
        int pagoPuntos = 1;
        String lugar = "";
        String nombre = "";
        String fact = factura.factura(user.getDato(), codFact);
        total = factura.totPago;
        try {
            if (user.getDato().getNivel() == 'C') {
                if (user.getDato().getPuntos() >= total) {
                    pagoPuntos = JOptionPane.showConfirmDialog(null, "Quieres pagar " + total + " con tus puntos?\nTienes "
                            + user.getDato().getPuntos(),
                            "Seleccione opción", JOptionPane.YES_NO_OPTION);
                    if (pagoPuntos == 0) {
                        pagoReg(total);
                    }//fin del pagar con puntos 
                    else {
                        JOptionPane.showMessageDialog(null, "El pago se descontará de tu tarjeta");
                        JOptionPane.showMessageDialog(null, "Procesando transacción...");
                        JOptionPane.showMessageDialog(null, "Transaccion exitosa");
                    }//fin del else si no tiene puntos necesarios                
                }//fin del if del pago con puntos
                else {
                    JOptionPane.showMessageDialog(null, "El pago se descontará de tu tarjeta");
                    JOptionPane.showMessageDialog(null, "Transaccion exitosa");
                }//fin del elsesi no tiene puntos necesarios
                fact += factura.insertPuntos(user.getDato().getPuntos());
                user.getDatoFact().insertar(new FacturaClien(fact, codFact, user.getDato().getId()));
                String envio = user.getDato().getEnvio();
                continua = JOptionPane.showConfirmDialog(null, "Quieres que te lo enviemos a esta dirección:\n" + envio + "?",
                        "Seleccione opción", JOptionPane.YES_NO_OPTION);
                if (continua == 0) {
                    lugar = user.getDato().getEnvio();
                }//fin del if para usar la direccion predeterminada
                else {
                    lugar = JOptionPane.showInputDialog("Dónde te enviaremos el pedido?");
                }//fin del else si usa otra direccion
                String ord = factura.ordenFormat();
                orden.encola(new NodoCOrd(new Orden(user.getDato().getNombre(), user.getDato().getId(), codOrd, lugar, ord)));
                System.out.println(fact);
            }//fin del if si es nivel C 
            if (user.getDato().getNivel() == 'N') {
                JOptionPane.showInputDialog("Digite el número de tarjeta");
                JOptionPane.showInputDialog("Digite el código de la tarjeta");
                JOptionPane.showMessageDialog(null, "Transacción exitosa");
                String ord = factura.ordenFormat();
                nombre = JOptionPane.showInputDialog("Digita tu nombre");
                lugar = JOptionPane.showInputDialog("Dónde te enviaremos el pedido?");
                if (!nombre.equals("") && !lugar.equals("")) {
                    orden.encola(new NodoCOrd(new Orden(nombre, user.getDato().getId(), codOrd, lugar, ord)));
                    System.out.println(fact);
                }//fin de la validacion si el nombre esta vacio
                else {
                    JOptionPane.showMessageDialog(null, "Hay un problema con los datos ingresados");
                }//fin del vacio
            }//fin del if si es nivel n
        } catch (java.lang.StackOverflowError | NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
        }//fin del try catch
        codOrd++;
        codFact++;
    }//fin del metodo encargado de la compra

    public void pagoReg(float total) {
        float puntos = user.getDato().getPuntos();
        if (puntos >= total) {
            user.getDato().setPuntos(puntos - total);
            JOptionPane.showMessageDialog(null, "Pago exitoso con puntos");
        }//fin si hay puntos disponibles
        else {
            JOptionPane.showMessageDialog(null, "No tienes puntos suficientes");
        }
    }//fin del pago de usuario registrado

    public void menuCompraClte() {
        int opc;
        boolean salir = false;
        do {
            try {
                opc = demeNum("1- Crear pedido\n2- Reservaciones\n3- Mi cuenta\n4- Formar parte del equipo\n9- Cerrar sesión");
                switch (opc) {
                    case 1:
                        menuCompraCarta();
                        break;
                    case 2:
                        menuReservClte();
                        break;
                    case 3:
                        miCuenta();
                        break;
                    case 4:
                        solicitud();
                        break;
                    case 9:
                        salir = true;
                        user = null;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }//fin del switch 
            } catch (java.lang.StackOverflowError | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
            }//fin del try catch
        } while (!salir);
    }//fin de menu de la compra del cliente

    public void menuCompraInvi() {
        int opc;
        boolean salir = false;
        do {
            try {
                opc = demeNum("1- Crear pedido\n2- Formar parte del equipo\n9- Atrás");
                switch (opc) {
                    case 1:
                        menuCompraCarta();
                        break;
                    case 2:
                        solicitud();
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }//fin del switch 
            } catch (java.lang.StackOverflowError | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
            }//fin del try catch
        } while (!salir);
    }//fin de menu de la compra del cliente invitado

    public void menuCompraCarta() {
        int opc;
        boolean salir = false;
        do {
            try {
                opc = demeNum("1- Comidas\n2- Bebidas\n3- Postres\n4- Confirmar compra\n9- Atrás");
                switch (opc) {
                    case 1:
                        muestraCarta('C');
                        break;
                    case 2:
                        muestraCarta('B');
                        break;
                    case 3:
                        muestraCarta('P');
                        break;
                    case 4:
                        if (compra) {
                            compra();
                            JOptionPane.showMessageDialog(null, "Pedido enviado!");
                            salir = true;
                            compra = false;
                        }//si hay compra
                        else {
                            JOptionPane.showMessageDialog(null, "No hay ningún producto agregado");
                        }//fin del else si no ha comprado nada
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }//fin del switch 
            } catch (java.lang.StackOverflowError | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
            }//fin del try catch
        } while (!salir);
    }//fin de menu de la seleccion del producto

    public void menuInicio() {
        int opc;
        boolean salir = false;
        boolean enc = false;
        boolean encA = false;
        NodoLCClien sesion = null;
        NodoLCAdmin sesionAdm = null;
        do {
            try {
                opc = demeNum("1- Iniciar sesion\n2- Ingresar como invitado\n3- No tienes cuenta?\n9- Salir");
                switch (opc) {
                    case 1:
                        try {
                            do {
                                String correo = JOptionPane.showInputDialog("Introduce tu correo electrónico");
                                if (!correo.equals("")) {
                                    enc = cliente.buscaCorreo(correo);
                                    encA = admin.buscaCorreo(correo);
                                    if (enc) {
                                        sesion = cliente.extraeUser(correo);
                                        user = sesion(sesion);
                                    } else if (encA) {
                                        sesionAdm = admin.extraeUser(correo);
                                        adminUser = sesionAdm(sesionAdm);
                                    }//fin del else if del admin
                                    else {
                                        JOptionPane.showMessageDialog(null, "Correo inválido!");
                                    }
                                }
                            } while (!enc && !encA);
                        } catch (java.lang.StackOverflowError | NumberFormatException | NullPointerException e) {
                        }//fin del try catch
                        if (user != null && user.getDato().getNivel() == 'C') {
                            menuCompraClte();
                        }//fin del if null
                        if (adminUser != null && adminUser.getDato().getNivel() == 'A') {
                            menuAdmin();
                        }//fin del if null
                        break;
                    case 2:
                        user = invitado;
                        menuCompraInvi();
                        break;
                    case 3:
                        creaCliente();
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }//fin del switch 
            } catch (java.lang.StackOverflowError | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
            }//fin del try catch
        } while (!salir);
    }//fin de menu de la compra del cliente

    public void impFactura(NodoLCClien user) {
        String disp = cliente.codigosFactura(user);
        int cod = demeNum(disp);
        String dato = cliente.extraeFact(cod, user).toString();
        System.out.println(dato);
    }//fin de la muestra de las facturas del cliente

    public void menuAdmin() {
        int opc;
        boolean salir = false;
        do {
            try {
                opc = demeNum("1- Atender pedido\n2- Gestion carta\n3- Crear cuenta administrativa\n4- Revisar ordenes atendidas"
                        + "\n5- Gestion clientes\n6- Gestion empleados\n7- Ver reservas\n9- Cerrar sesión");
                switch (opc) {
                    case 1:
                        atiendePedido();
                        break;
                    case 2:
                        menuGestCarta();
                        break;
                    case 3:
                        creaAdmin();
                        break;
                    case 4:
                        ordenAtendida();
                        break;
                    case 5:
                        menuGestClte();
                        break;
                    case 6:
                        menuGestEmple();
                        break;
                    case 7:
                        imprimeReservas();
                        break;
                    case 9:
                        salir = true;
                        adminUser = null;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }//fin del switch 
            } catch (java.lang.StackOverflowError | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
            }//fin del try catch
        } while (!salir);
    }//fin de menuadmin

    public void menuGestCarta() {
        int opc;
        boolean salir = false;
        do {
            try {
                opc = demeNum("1- Nuevo producto\n2- Modifica producto\n3- Elimina producto\n4- Ver productos"
                        + "\n9- Atrás");
                switch (opc) {
                    case 1:
                        agregaCarta();
                        break;
                    case 2:
                        modificaCarta();
                        break;
                    case 3:
                        eliminaCarta();
                        break;
                    case 4:
                        visualizaCarta();
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }//fin del switch 
            } catch (java.lang.StackOverflowError | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
            }//fin del try catch
        } while (!salir);
    }//fin de menugestcarta

    public void menuGestClte() {
        int opc;
        boolean salir = false;
        do {
            try {
                opc = demeNum("1- Visualiza cliente\n2- Elimina cliente\n9- Atrás");
                switch (opc) {
                    case 1:
                        visualizaClte();
                        break;
                    case 2:
                        eliminaClte();
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }//fin del switch 
            } catch (java.lang.StackOverflowError | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
            }//fin del try catch
        } while (!salir);
    }//fin de menugestcarta

    public void atiendePedido() {
        NodoCOrd aten = orden.atiende();
        if (aten != null) {
            System.out.println("Atendido:\n" + aten);
            ordenAten.push(new NodoPOrdAten(new OrdenAtendida(aten.getDato().getNombre(), aten.getDato().getIdClte(),
                    aten.getDato().getNumOrden(), aten.getDato().getLugarEnv(), aten.getDato().getDescrip())));
        }//fin del if si es null
        else {
            JOptionPane.showMessageDialog(null, "No hay pedidos pendientes");
        }//fin del no hay pedidos
    }//fin del atiende pedido

    public void ordenAtendida() {
        int continua = 0;
        int cant = ordenAten.numDisponible();
        if (cant > 0) {
            while (continua == 0) {
                int ext = demeNum("Digite el número de orden a consultar\nHay " + cant + " ordenes atendidas");
                boolean enc = ordenAten.busca(ext);
                if (enc) {
                    NodoPOrdAten extrae = ordenAten.extrae(ext);
                    System.out.println("Datos de la orden:\n" + extrae);
                } else {
                    JOptionPane.showMessageDialog(null, "Esa orden no se encuentra");
                }
                continua = JOptionPane.showConfirmDialog(null, "Desea consultar otra orden?", "Seleccione opción", JOptionPane.YES_NO_OPTION);
            }//fin del while
        }//fin del if si hay mas de una orden atendida
        else {
            JOptionPane.showMessageDialog(null, "No hay ninguna orden atendida aún");
        }//fin del else de no hay ordenes atendidas aun
    }//fin de la visualizacion de las ordenes pasadas

    public void menuGestEmple() {
        int opc;
        boolean salir = false;
        do {
            try {
                opc = demeNum("1- Nuevo Empleado\n2- Solicitudes de empleo\n3- Elimina empleado\n4- Ver empleados"
                        + "\n9- Atrás");
                switch (opc) {
                    case 1:
                        menuCreaEmp();
                        break;
                    case 2:
                        revisaSolicitud();
                        break;
                    case 3:
                        eliminaEmp();
                        break;
                    case 4:
                        visualizaEmp();
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }//fin del switch 
            } catch (java.lang.StackOverflowError | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
            }//fin del try catch
        } while (!salir);
    }//fin de menugestcarta

    public void menuCreaEmp() {
        int opc;
        boolean salir = false;
        do {
            try {
                opc = demeNum("1- Chef\n2- Repartidor\n9- Atrás");
                switch (opc) {
                    case 1:
                        nuevoEmp('C');
                        break;
                    case 2:
                        nuevoEmp('R');
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }//fin del switch 
            } catch (java.lang.StackOverflowError | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
            }//fin del try catch
        } while (!salir);
    }//fin de menu de la seleccion del producto

    public void nuevoEmp(char tipo) {
        String puesto;
        String nombre = JOptionPane.showInputDialog("Digita el nombre");
        int tel = demeNum("Digita el numero de telefono");
        if (tipo == 'C') {
            puesto = "Chef";
        }//fin del if de los puestos
        else {
            puesto = "Repartidor";
        }
        if (!nombre.equals("")) {
            empleado.insertar(new Empleado(nombre, tipo, codEmp, tel, puesto));
            codEmp++;
            JOptionPane.showMessageDialog(null, "Empleado agregado!");
        }//fin del if de los datos correctos
        else {
            JOptionPane.showMessageDialog(null, "Ha habido un problema con los datos ingresados");
        }
    }//fin de la creacion de nuevos empleados

    public void eliminaEmp() {
        String dispo;
        int dato;
        boolean enc = false;
        dispo = empleado.dispoEmpleado();
        dato = demeNum("Digita el código del empleado a eliminar\n" + dispo);
        enc = empleado.buscaId(dato);
        if (enc) {
            empleado.elimina(dato);
            JOptionPane.showMessageDialog(null, "Empleado eliminado");
        }//fin del if de los datos correctos
        else {
            JOptionPane.showMessageDialog(null, "Código no válido!");
        }
    }//fin de la eliminacion de los empleados

    public void visualizaEmp() {
        String dispo;
        int dato;
        boolean enc = false;
        dispo = empleado.dispoEmpleado();
        dato = demeNum("Digita el código del cliente a visualizar\n" + dispo);
        enc = empleado.buscaId(dato);
        if (enc) {
            JOptionPane.showMessageDialog(null, empleado.extraeClte(dato));
        }//fin del if de los datos correctos
        else {
            JOptionPane.showMessageDialog(null, "Código no válido!");
        }
    }//fin de la visualizacion de los clientes

    public void solicitud() {
        String nombre;
        String puesto = "";
        int puest;
        int edad = 0;
        try {
            if (user.getDato().getNivel() == 'C') {
                nombre = user.getDato().getNombre();
            }//fin del if del nombre de cliente con registro
            else {
                nombre = JOptionPane.showInputDialog("Digita tu nombre");
            }//fin del else del cliente normal
            int tel = demeNum("Digita tu numero de teléfono");
            puest = demeNum("Puestos diponibles:\n1- Chef\n2- Repartidor\n\nDigita el numero del puesto");
            if (puest == 1) {
                puesto = "Chef";
            }//fin del if puesto caso 1
            else if (puest == 2) {
                puesto = "Repartidor";
            }
            edad = demeNum("Digita tu edad");
            if (edad >= 18) {
            }//fin del correo repetido
            else {
                JOptionPane.showMessageDialog(null, "No se pueden enviar solicitudes de menores de edad");
            }
            if (!nombre.equals("") && tel > 0 && !puesto.equals("") && edad >= 18) {
                solicitud.push(new NodoPSoli(new Solicitud(nombre, edad, puesto, tel)));
                JOptionPane.showMessageDialog(null, "La solicitud ha sido enviada");
            }//fin del if de los datos correctos
            else {
                JOptionPane.showMessageDialog(null, "Ha habido un problema con los datos ingresados");
            }
        } catch (java.lang.StackOverflowError | NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
        }//fin del try catch
    }//fin de forma parte del equipo

    public void revisaSolicitud() {
        int opc;
        boolean salir = false;

        do {
            try {
                opc = demeNum("1- Revisar solicitud\n2- Cantidad pendiente\n9- Atrás");
                switch (opc) {
                    case 1:
                        revisaSoli();
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "Tienes " + solicitud.size + " solicitudes por revisar");
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }//fin del switch 
            } catch (java.lang.StackOverflowError | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
            }//fin del try catch
        } while (!salir);
    }//fin de la revision de las solicitudes

    public void revisaSoli() {
        int agrega = 0;
        int continua = 0;
        if (solicitud.size > 0) {
            while (continua == 0 && solicitud.size > 0) {
                NodoPSoli temp = solicitud.pop();
                agrega = JOptionPane.showConfirmDialog(null, temp + "\n\n\nDeseas agregarlo al equipo?",
                        "Seleccione opción", JOptionPane.YES_NO_OPTION);
                if (agrega == 0) {
                    nuevoEmpSoli(temp.getDato().getPuesto(), temp.getDato().getNombre(),
                            temp.getDato().getTelefono());
                }//fin del si quiero agregarlo
                else {
                    JOptionPane.showMessageDialog(null, "Solicitud eliminada");
                }//fin del no agregar
                if (solicitud.size > 0) {
                    continua = JOptionPane.showConfirmDialog(null, "Deseas revisar la siguiente solicitud?",
                            "Seleccione opción", JOptionPane.YES_NO_OPTION);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay más solicitudes por revisar");
                }
            }//fin del while de revisar
        }//fin del if si hay solicitudes
        else {
            JOptionPane.showMessageDialog(null, "No hay solicitudes por revisar");
        }//fin del else de solcitudes vacias
    }//fin de la revision de las solicitudes

    public void nuevoEmpSoli(String niv, String nomb, int telf) {
        String puesto;
        String nombre = nomb;
        char nivel = 'N';
        int tel = telf;
        if (niv.equals("Chef")) {
            nivel = 'C';
            puesto = "Chef";
        }//fin del if de los puestos
        else {
            puesto = "Repartidor";
            nivel = 'R';
        }
        if (!nombre.equals("")) {
            empleado.insertar(new Empleado(nombre, nivel, codEmp, tel, puesto));
            codEmp++;
            JOptionPane.showMessageDialog(null, "Empleado agregado!");
        }//fin del if de los datos correctos
        else {
            JOptionPane.showMessageDialog(null, "Ha habido un problema con los datos ingresados");
        }
    }//fin de la creacion de nuevos empleados

    public void menuReservClte() {
        int opc;
        boolean resConfirm = false;
        boolean salir = false;
        int continua = 0;
        do {
            try {
                opc = demeNum("1- Crear una reservación\n2- Eliminar reserva\n3- Mi reserva\n9- Atrás");
                switch (opc) {
                    case 1:
                        resConfirm = reserva.buscaUser(user.getDato().getId());
                        if (!resConfirm) {
                            continua = JOptionPane.showConfirmDialog(null, "Quieres reservar a tu nombre?",
                                    "Seleccione opción", JOptionPane.YES_NO_OPTION);
                            if (continua == 0) {
                                reservar(user.getDato().getNombre());
                            }//fin del if para usar la direccion predeterminada
                            else {
                                reservar("");
                            }//fin del else si usa otra direccion                           
                        }//fin de la reserva unica
                        else {
                            JOptionPane.showMessageDialog(null, "Ya tienes una reserva confirmada");
                        }//fin del else de ya confirmada
                        break;
                    case 2:
                        resConfirm = reserva.buscaUser(user.getDato().getId());
                        if (resConfirm) {
                            liberaReserva();
                        }//fin del si tiene una reserva
                        else {
                            JOptionPane.showMessageDialog(null, "No tienes una reserva confirmada");
                        }//no tienes reserva
                        break;
                    case 3:
                        resConfirm = reserva.buscaUser(user.getDato().getId());
                        if (resConfirm) {
                            JOptionPane.showMessageDialog(null, reserva.datos(user.getDato().getId()));
                        }//fin del si tiene una reserva
                        else {
                            JOptionPane.showMessageDialog(null, "No tienes una reserva confirmada");
                        }//no tienes reserva
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                }//fin del switch 
            } catch (java.lang.StackOverflowError | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
            }//fin del try catch
        } while (!salir);
    }//fin del menu de la reserva del cliente

    public void reservar(String nomb) {
        boolean enc = false;
        int mesa = 0;
        int cedula;
        int tel;
        String nombre = nomb;
        try {
            if (nombre.equals("")) {
                nombre = JOptionPane.showInputDialog("Digita tu nombre");
            }//fin del nombre de usuario
            do {
                mesa = demeNum("Selecciona la mesa que deseas\nTenemos 30 mesas\nNumeros de mesas ya reservadas:\n" + reserva.reservas());
                if (mesa < 31 && mesa > 0) {
                    enc = reserva.busca(mesa);
                } else {
                    enc = true;
                }
                if (enc) {
                    JOptionPane.showMessageDialog(null, "Esa mesa no se puede seleccionar, intenta con otra");
                }//fin de la mesa ocupada
            } while (enc);
            cedula = demeNum("Digita tu numero de cedula");
            tel = demeNum("Digita tu numero de teléfono");
            if (!nombre.equals("") && cedula != 0 && tel != 0 && mesa != 0) {
                reserva.modifica(nombre, cedula, tel, mesa, user.getDato().getId());
                JOptionPane.showMessageDialog(null, "Mesa reservada con éxito, te esperamos!");
            }//fin del if de los datos correctos
            else {
                JOptionPane.showMessageDialog(null, "Ha habido un problema con los datos ingresados");
            }
        } catch (java.lang.StackOverflowError | NumberFormatException | NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Hay algún error al ejecutar esa tarea", "Error!", JOptionPane.ERROR_MESSAGE);
        }//fin del try catch
    }//fin del metodo de la reservacion

    public void imprimeReservas() {
        boolean enc = false;
        int continua = 0;
        do {
            String reservas = reserva.reservas();
            int sel = demeNum("Digite el número de la mesa para visualizar los datos\n" + reservas);
            enc = reserva.busca(sel);
            if (enc) {
                JOptionPane.showMessageDialog(null, reserva.extraeDato(sel));
            }//fin del if de los datos correctos
            else {
                JOptionPane.showMessageDialog(null, "Código no válido!");
            }
            continua = JOptionPane.showConfirmDialog(null, "Deseas visualizar otra mesa?",
                    "Seleccione opción", JOptionPane.YES_NO_OPTION);
        } while (continua == 0);
    }//fin de la impresion de las reservas

    public void liberaReserva() {
        reserva.libera(user.getDato().getId());
        JOptionPane.showMessageDialog(null, "Reserva eliminada con éxito");
    }//fin de la libreacion de la mesa para las reservas

}//fin de la clase factura
