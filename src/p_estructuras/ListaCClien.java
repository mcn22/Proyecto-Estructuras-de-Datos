package p_estructuras;

import javax.swing.JOptionPane;

public class ListaCClien {

    NodoLCClien cabeza;
    NodoLCClien ultimo;
    int size = 0;

    public void insertar(Cliente clt) {
        ListaSFact listaFact = new ListaSFact();
        if (cabeza == null) {
            NodoLCClien temp = new NodoLCClien(clt, listaFact);
            cabeza = temp;
            ultimo = cabeza;
            ultimo.setNext(cabeza);
            size++;
        }//fin del primer if si la cabeza es nula
        else {
            NodoLCClien temp = cabeza;
            NodoLCClien aux = new NodoLCClien(clt, listaFact);
            cabeza = aux;
            cabeza.setNext(temp);
            ultimo.setNext(cabeza);
            size++;
        }//fin del else if del segundo caso en el que no es el max
    }//fin de la insercion de un cliente

    public void insertaFact(int id, FacturaClien fact) {
        NodoLCClien aux = cabeza;
        if (aux != null) {
            do {
                if (aux.getDato().getId() == id) {
                    aux.getDatoFact().insertar(fact);
                }//fin si lo encuentra
                aux = aux.getNext();
            } while (aux != cabeza);
        }//fin del if de validacion si esta vacia
    }//fin de la insercion de facturas

    public boolean buscaCorreo(String correo) {
        boolean enc = false;
        NodoLCClien aux = cabeza;
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

    public boolean buscaId(int id) {
        boolean enc = false;
        NodoLCClien aux = cabeza;
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

    public NodoLCClien extraeUser(String correo) {
        NodoLCClien aux = cabeza;
        NodoLCClien ext = cabeza;
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

    public NodoLCClien extraeClte(int id) {
        NodoLCClien aux = cabeza;
        NodoLCClien ext = null;
        if (aux != null) {
            do {
                if (aux.getDato().getId() == id) {
                    ext = aux;
                }//fin del if si lo encuentra
                aux = aux.getNext();
            } while (aux != cabeza);
        }//fin del if de validacion si esta vacia
        return ext;
    }//find del extrae cliente

    public NodoLSFact extraeFact(int cod, NodoLCClien user) {
        NodoLCClien aux = user;
        NodoLSFact ext = null;
        ext = aux.getDatoFact().extrae(cod);
        return ext;
    }//find del extrae cliente

    public String codigosFactura(NodoLCClien user) {
        NodoLCClien aux = user;
        String ext = "Código(s) de tu(s) factura(s):\n";
        ext += aux.getDatoFact().imprime();
        return ext;
    }//find del extrae cliente

    public void modNombre(int cod) {
        NodoLCClien aux = cabeza;
        if (aux != null) {
            do {
                if (aux.getDato().getId() == cod) {
                    String dato = JOptionPane.showInputDialog("Digita tu nuevo nombre");
                    aux.getDato().setNombre(dato);
                    JOptionPane.showMessageDialog(null, "Cambio exitoso!");
                }//fin del if cuando lo encuentra
                aux = aux.getNext();
            } while (aux != cabeza);
        }//fin del if de validacion si esta vacia
    }//fin de la modificacion del nombre

    public void modCorreo(int cod, String correo) {
        NodoLCClien aux = cabeza;
        if (aux != null) {
            do {
                if (aux.getDato().getId() == cod) {
                    aux.getDato().setCorreo(correo);
                    JOptionPane.showMessageDialog(null, "Cambio exitoso!");
                }//fin del if cuando lo encuentra
                aux = aux.getNext();
            } while (aux != cabeza);
        }//fin del if de validacion si esta vacia
    }//fin de la modificacion del correo

    public void modPass(int cod) {
        NodoLCClien aux = cabeza;
        if (aux != null) {
            do {
                if (aux.getDato().getId() == cod) {
                    String dato = JOptionPane.showInputDialog("Digita tu nueva contraseña");
                    aux.getDato().setPass(dato);
                    JOptionPane.showMessageDialog(null, "Cambio exitoso!");
                }//fin del if cuando lo encuentra
                aux = aux.getNext();
            } while (aux != cabeza);
        }//fin del if de validacion si esta vacia
    }//fin de la modificacion del pass

    public void modEnvio(int cod) {
        NodoLCClien aux = cabeza;
        if (aux != null) {
            do {
                if (aux.getDato().getId() == cod) {
                    String dato = JOptionPane.showInputDialog("Digita tu nueva dirección de envío");
                    aux.getDato().setEnvio(dato);
                    JOptionPane.showMessageDialog(null, "Cambio exitoso!");
                }//fin del if cuando lo encuentra
                aux = aux.getNext();
            } while (aux != cabeza);
        }//fin del if de validacion si esta vacia
    }//fin de la modificacion del nombre

    public String dispoCliente() {
        NodoLCClien aux = cabeza;
        String s = "";
        if (aux != null) {
            do {
                s += aux.getDato().getId() + "- " + aux.getDato().getNombre() + "\n";
                aux = aux.getNext();
            } while (aux != cabeza);
        }//fin del if de validacion si esta vacia
        return s;
    }//fin del dispocliente

    public void elimina(int id) {
        NodoLCClien act = cabeza;
        NodoLCClien ant = ultimo;
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

    @Override
    public String toString() {
        NodoLCClien aux = cabeza;
        String s = "";
        if (aux != null) {
            do {
                s += aux + "\n";
                aux = aux.getNext();
            } while (aux != cabeza);
        }//fin del if de validacion si esta vacia
        return s;
    }//fin del to string

}//fin de la lista circular del cliente
