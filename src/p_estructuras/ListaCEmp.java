package p_estructuras;

public class ListaCEmp {

    NodoLCEmp cabeza;
    NodoLCEmp ultimo;
    int size = 0;

    public void insertar(Empleado emp) {
        if (cabeza == null) {
            NodoLCEmp temp = new NodoLCEmp(emp);
            cabeza = temp;
            ultimo = cabeza;
            ultimo.setNext(cabeza);
            size++;
        }//fin del primer if si la cabeza es nula
        else {
            NodoLCEmp temp = cabeza;
            NodoLCEmp aux = new NodoLCEmp(emp);
            cabeza = aux;
            cabeza.setNext(temp);
            ultimo.setNext(cabeza);
            size++;
        }//fin del else if del segundo caso en el que no es el max
    }//fin de la insercion de un admin

    public void elimina(int id) {
        NodoLCEmp act = cabeza;
        NodoLCEmp ant = ultimo;
        if (cabeza == cabeza.getNext() && cabeza.getDato().getId() == id && ultimo == cabeza) {
            cabeza = null;
            size--;
        }//fin si queda solo uno
        else {
            do {
                if (act.getDato().getId() == id) {
                    if (act == cabeza) {
                        cabeza = cabeza.getNext();
                        ultimo.setNext(cabeza);
                        size--;
                    }//fin del primero
                    else if (act == ultimo) {
                        ant.setNext(ultimo.getNext());
                        ultimo = ant;
                        size--;
                    }//fin del segundo si es ultimo
                    else {
                        ant.setNext(act.getNext());
                        size--;
                    }//fin del tercer caso
                }//fin del if
                ant = act;
                act = act.getNext();
            } while (act != cabeza);
        }//fin del else en caso que no solo quede un dato
    }//fin de la eliminacion

    public String dispoEmpleado() {
        NodoLCEmp aux = cabeza;
        String s = "";
        if (aux != null) {
            do {
                s += aux.getDato().getId() + "- " + aux.getDato().getNombre() + "\n";
                aux = aux.getNext();
            } while (aux != cabeza);
        }//fin del if de validacion si esta vacia
        return s;
    }//fin del dispocliente

    public boolean buscaId(int id) {
        boolean enc = false;
        NodoLCEmp aux = cabeza;
        if (aux != null) {
            do {
                if (aux.getDato().getId() == id) {
                    enc = true;
                }//fin del if si lo encuentra
                aux = aux.getNext();
            } while (aux != cabeza);
        }//fin del if de validacion si esta vacia
        return enc;
    }//fin de la busqueda del correo

    public NodoLCEmp extraeClte(int id) {
        NodoLCEmp aux = cabeza;
        NodoLCEmp ext = null;
        if (aux != null) {
            do {
                if (aux.getDato().getId() == id) {
                    ext = aux;
                }//fin del if si lo encuentra
                aux = aux.getNext();
            } while (aux != cabeza);
        }//fin del if de validacion si esta vacia
        return ext;
    }//find del extrae empleado

    @Override
    public String toString() {
        NodoLCEmp aux = cabeza;
        String s = "";
        if (aux != null) {
            do {
                s += aux + "\n";
                aux = aux.getNext();
            } while (aux != cabeza);
        }//fin del if de validacion si esta vacia
        return s;
    }//fin del to string

}//fin de la listaCEmp
