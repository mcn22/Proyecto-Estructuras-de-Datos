package p_estructuras;

public class NodoCOrd {

    private Orden dato;
    private NodoCOrd atras;

    public NodoCOrd(Orden dato) {
        this.dato = dato;
    }

    public Orden getDato() {
        return dato;
    }

    public void setDato(Orden dato) {
        this.dato = dato;
    }

    public NodoCOrd getAtras() {
        return atras;
    }

    public void setAtras(NodoCOrd atras) {
        this.atras = atras;
    }

    @Override
    public String toString() {
        String s = dato.toString();
        return s;
    }

}//fin de la clase del nodo de la cola de la orden
