package p_estructuras;

public class NodoLCAdmin {

    private Admin dato;
    private NodoLCAdmin next;

    public NodoLCAdmin(Admin dato) {
        this.dato = dato;
    }

    public NodoLCAdmin() {
    }

    public Admin getDato() {
        return dato;
    }

    public void setDato(Admin dato) {
        this.dato = dato;
    }

    public NodoLCAdmin getNext() {
        return next;
    }

    public void setNext(NodoLCAdmin next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return dato.toString();
    }

}//fin del nodoLCadmin
