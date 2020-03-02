package p_estructuras;

import javax.swing.JOptionPane;

public class PilaOrdAten {

    private NodoPOrdAten top;
    public int size = 0;

    public int demeNum(String msj) {
        String s = JOptionPane.showInputDialog(msj);
        int n = Integer.parseInt(s);
        return n;
    }//fin demenum

    public void push(NodoPOrdAten n) {
        if (top == null) {
            top = n;
        }//fin if
        else {
            n.setAbajo(top);
            top = n;
        }//fin else
        size++;
    }//fin del push

    public boolean busca(int busca) {
        boolean enc = false;
        NodoPOrdAten aux = top;
        while (aux != null) {
            if (aux.getDato().getNumOrden() == busca) {
                enc = true;
                break;
            }//fin del if para cuando encuentra algo 
            else {
                aux = aux.getAbajo();
            }//fin del else
        }//fin del while
        return enc;
    }//fin de encontrar

    public NodoPOrdAten extrae(int id) {
        NodoPOrdAten aux = top;
        NodoPOrdAten ext = null;
        while (aux != null) {
            if (aux.getDato().getNumOrden() == id) {
                ext = aux;
            }//fin del primer caso          
            aux = aux.getAbajo();
        }//fin del while
        return ext;
    }//fin del extrae

    public int numDisponible() {
        NodoPOrdAten aux = top;
        int cant = 0;
        while (aux != null) {
            cant++;
            aux = aux.getAbajo();
        }//fin del while
        return cant;
    }//fin del to string

    @Override
    public String toString() {
        String mensaje = "";
        NodoPOrdAten aux = top;
        while (aux != null) {
            mensaje += aux + "\n";
            aux = aux.getAbajo();
        }//fin del while
        return mensaje;
    }//fin del to string

}//fin de la clase pila orden atendida
