package p_estructuras;

public class ListaCAdmin {

    NodoLCAdmin cabeza;
    NodoLCAdmin ultimo;
    int size = 0;

    public void insertar(Admin adm) {
        if (cabeza == null) {
            NodoLCAdmin temp = new NodoLCAdmin(adm);
            cabeza = temp;
            ultimo = cabeza;
            ultimo.setNext(cabeza);
            size++;
        }//fin del primer if si la cabeza es nula
        else {
            NodoLCAdmin temp = cabeza;
            NodoLCAdmin aux = new NodoLCAdmin(adm);
            cabeza = aux;
            cabeza.setNext(temp);
            ultimo.setNext(cabeza);
            size++;
        }//fin del else if del segundo caso en el que no es el max
    }//fin de la insercion de un admin

    public boolean buscaCorreo(String correo) {
        boolean enc = false;
        NodoLCAdmin aux = cabeza;
        if (aux != null) {
            do {
                if (aux.getDato().getCorreo().equals(correo)) {
                    enc = true;
                }//fin del if si lo encuentra
                aux = aux.getNext();
            } while (aux != cabeza);
        }//fin del if de validacion si esta vacia
        return enc;
    }//fin de la busqueda del correo

    public NodoLCAdmin extraeUser(String correo) {
        NodoLCAdmin aux = cabeza;
        NodoLCAdmin ext = cabeza;
        if (aux != null) {
            do {
                if (aux.getDato().getCorreo().equals(correo)) {
                    ext = aux;
                }//fin del if si lo encuentra         
                aux = aux.getNext();
            } while (aux != cabeza);
        }//fin del if de validacion si esta vacia
        return ext;
    }//find del extrae cliente

    @Override
    public String toString() {
        NodoLCAdmin aux = cabeza;
        String s = "";
        if (aux != null) {
            do {
                s += aux + "\n";
                aux = aux.getNext();
            } while (aux != cabeza);
        }//fin del if de validacion si esta vacia
        return s;
    }//fin del to string

}//fin de la lista de los admins
