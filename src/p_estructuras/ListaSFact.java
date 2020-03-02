package p_estructuras;

import javax.swing.JOptionPane;

public class ListaSFact {

    private NodoLSFact cabeza;

    public int demeNum(String msj) {
        String s = JOptionPane.showInputDialog(msj);
        int n = Integer.parseInt(s);
        return n;
    }//fin demenum

    public void insertar(FacturaClien fac) {
        if (cabeza == null) {
            cabeza = new NodoLSFact(fac);
        } else if (fac.getCodFact() < cabeza.getDato().getCodFact()) {
            NodoLSFact aux = new NodoLSFact(fac);
            aux.setNext(cabeza);
            cabeza = aux;
        } else if (cabeza.getNext() == null) {
            cabeza.setNext(new NodoLSFact(fac));
        } else {
            NodoLSFact aux = cabeza;
            while (aux.getNext() != null && aux.getNext().getDato().getCodFact() < fac.getCodFact()) {
                aux = aux.getNext();
            }
            NodoLSFact temp = new NodoLSFact(fac);
            temp.setNext(aux.getNext());
            aux.setNext(temp);
        }//fin else
    }//fin inserta

    public String imprime() {
        String s = "";
        NodoLSFact aux = cabeza;
        while (aux != null) {
            s += "# " + aux.getDato().getCodFact() + "\n";
            aux = aux.getNext();
        }
        return s;
    }//fin del imprime

    public NodoLSFact extrae(int cod) {
        NodoLSFact aux = cabeza;
        NodoLSFact dato = null;
        while (aux != null) {
            if (aux.getDato().getCodFact() == cod) {
                dato = aux;
            }//fin del if si esta
            aux = aux.getNext();
        }
        return dato;
    }//fin del extrae

    @Override
    public String toString() {
        String s = "";
        NodoLSFact aux = cabeza;
        while (aux != null) {
            s += aux + "\n";
            aux = aux.getNext();
        }
        return s;
    }//fin del to string

}//fin de la lista de las facturas
