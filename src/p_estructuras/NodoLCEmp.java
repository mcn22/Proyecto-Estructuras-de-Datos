package p_estructuras;

public class NodoLCEmp {

    private Empleado dato;
    private NodoLCEmp next;

    public NodoLCEmp(Empleado dato) {
        this.dato = dato;
    }

    public NodoLCEmp() {
    }

    public Empleado getDato() {
        return dato;
    }

    public void setDato(Empleado dato) {
        this.dato = dato;
    }

    public NodoLCEmp getNext() {
        return next;
    }

    public void setNext(NodoLCEmp next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return dato.toString();
    }

}//fin de la clase nodolcemp
