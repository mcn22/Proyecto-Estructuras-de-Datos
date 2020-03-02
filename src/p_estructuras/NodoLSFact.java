package p_estructuras;

public class NodoLSFact {

    private FacturaClien dato;
    private NodoLSFact next;

    public FacturaClien getDato() {
        return dato;
    }

    public void setDato(FacturaClien dato) {
        this.dato = dato;
    }

    public NodoLSFact getNext() {
        return next;
    }

    public void setNext(NodoLSFact next) {
        this.next = next;
    }

    public NodoLSFact(FacturaClien dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        String s = dato.toString();
        return s;
    }

}//fin de nodo lista simple factura
