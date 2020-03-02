package p_estructuras;

public class NodoPOrdAten {

    private OrdenAtendida dato;
    private NodoPOrdAten abajo;

    public NodoPOrdAten(OrdenAtendida dato) {
        this.dato = dato;
    }

    public NodoPOrdAten getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoPOrdAten abajo) {
        this.abajo = abajo;
    }

    public OrdenAtendida getDato() {
        return dato;
    }

    public void setDato(OrdenAtendida dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        String s = dato.toString();
        return s;
    }

}//fin de la clase nodo orden atendida
