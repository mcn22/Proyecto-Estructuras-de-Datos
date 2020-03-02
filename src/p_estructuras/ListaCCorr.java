package p_estructuras;

public class ListaCCorr {

    NodoLSCorr cabeza;
    NodoLSCorr ultimo;
    int size = 0;

    public void insertar(String dato) {
        if (cabeza == null) {
            NodoLSCorr temp = new NodoLSCorr(dato);
            cabeza = temp;
            ultimo = cabeza;
            ultimo.setNext(cabeza);
            size++;
        }//fin del primer if si la cabeza es nula
        else {
            NodoLSCorr temp = cabeza;
            NodoLSCorr aux = new NodoLSCorr(dato);
            cabeza = aux;
            cabeza.setNext(temp);
            ultimo.setNext(cabeza);
            size++;
        }//fin del else if del segundo caso en el que no es el max
    }//fin de la insercion de un cliente

    public boolean buscaCorreo(String correo) {
        boolean enc = false;
        NodoLSCorr aux = cabeza;
        if (aux != null) {
            do {
                if (aux.getDato().equals(correo)) {
                    enc = true;
                }//fin del if si lo encuentra
                aux = aux.getNext();
            } while (aux != cabeza);
        }//fin del if de validacion si esta vacia
        return enc;
    }//fin de la busqueda del correo

}//fin de la listaCCorr
