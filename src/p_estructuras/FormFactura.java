package p_estructuras;

public class FormFactura {

    String papel = "Nombre           Precio c/u   Unid       Total\n";
    float total = 0;
    float totPago = 0;
    float puntos = 0;
    String orden = "";

    public void formato(NodoLSCart prod, int cant, float userPoints) {
        papel += String.format("%-16s %-12s %-6d %9s\n", prod.getDato().getNombre(),
                prod.getDato().getPrecio(), cant, (prod.getDato().getPrecio() * cant));
        puntos = userPoints;
        puntos += (prod.getDato().getPrecio() * cant) * 0.08f;
        total += prod.getDato().getPrecio() * cant;
    }//fin del formato de la factura

    public void muestraF() {
        System.out.println(papel);
    }//fin de la muestra de la factura

    public String factura(Cliente user, int codFact) {
        float descuento = total * 0.10f;
        String factura = "";
        factura += "─────────────────────────────\n";
        factura += "Cliente: " + user.getNombre() + "\nLista de compra:\n";
        factura += papel + "\n";
        orden += papel;
        factura += "----------------------------------------------\n";
        orden += "----------------------------------------------\n";
        if (user.getNivel() == 'C') {
            factura += String.format("Subtotal : %36s", total + "\n");
            factura += "----------------------------------------------\n";
            factura += String.format("Descuento : %35s", total * 0.10 + "\n");
            factura += String.format("Total : %39s", (total - descuento) + "\n");
            totPago = (total - descuento);
            factura += "----------------------------------------------\n";
            orden += String.format("Total : %39s", (total - descuento) + "\n");
        }//fin del descuento
        else {
            factura += String.format("Total : %39s", total + "\n");
            orden += String.format("Total : %39s", total + "\n");
        }
        factura += "Código de factura: " + "[" + codFact + "]" + "\n";
        factura += "─────────────────────────────\n";
        orden += "─────────────────────────────\n";
        descuento = 0;
        reset();
        return factura;
    }//fin de la facturacion 

    public String insertPuntos(float puntos) {
        String fac = "";
        fac += "Puntos acumulados: " + puntos + "\n";
        fac += "─────────────────────────────\n";
        return fac;
    }//fin de la insercion de los puntos acumulados en la factura

    public String ordenFormat() {
        String ord = orden;
        orden = "";
        return ord;
    }//fin del formato de la orden

    public void reset() {
        papel = "Nombre           Precio c/u   Unid       Total\n";
        total = 0;
        puntos = 0;
    }//fin del reset de los puntos y todo luego de la compra

}//fin del formato de la factura
