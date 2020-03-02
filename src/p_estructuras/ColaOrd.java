package p_estructuras;

import javax.swing.JOptionPane;

public class ColaOrd {

    private NodoCOrd frente;
    private NodoCOrd ultimo;
    public int size = 0;

    public int demeNum(String msj) {
        String s = JOptionPane.showInputDialog(msj);
        int n = Integer.parseInt(s);
        return n;
    }//fin demenum

    public void encola(NodoCOrd d) {
        if (frente == null) {
            frente = d;
            ultimo = d;
        } else {
            ultimo.setAtras(d);
            ultimo = d;
        }
        size++;
    }//fin encola

    public NodoCOrd atiende() {
        NodoCOrd aux = frente;
        if (frente != null) {
            frente = frente.getAtras();
            aux.setAtras(null);
        }
        size--;
        return aux;
    }//fin atiende

    @Override
    public String toString() {
        String s = "";
        NodoCOrd aux = frente;
        while (aux != null) {
            s += aux + "\n";
            aux = aux.getAtras();
        }
        return s;
    }//fin del to string

}//fin de la clase de la cola de las ordenes
