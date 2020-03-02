package p_estructuras;

import javax.swing.JOptionPane;

public class PilaSoli {

    private NodoPSoli top;
    public int size = 0;

    public int demeNum(String msj) {
        String s = JOptionPane.showInputDialog(msj);
        int n = Integer.parseInt(s);
        return n;
    }//fin demenum

    public void push(NodoPSoli n) {
        if (top == null) {
            top = n;
        }//fin if
        else {
            n.setAbajo(top);
            top = n;
        }//fin else
        size++;
    }//fin del push

    public NodoPSoli pop() {
        NodoPSoli aux = null;
        if (top != null) {
            aux = top;
            top = aux.getAbajo();
        }//fin del if
        size--;
        return aux;
    }//fin del pop

    @Override
    public String toString() {
        String mensaje = "";
        NodoPSoli aux = top;
        while (aux != null) {
            mensaje += aux + "\n";
            aux = aux.getAbajo();
        }//fin del while
        return mensaje;
    }//fin del to string

}//fin de la clase pila para el manejo de las solicitudes
