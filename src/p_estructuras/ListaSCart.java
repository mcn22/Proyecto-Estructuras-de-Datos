package p_estructuras;

public class ListaSCart {

    private NodoLSCart cabeza;

    public void insertar(Carta cart) {
        if (cabeza == null) {
            cabeza = new NodoLSCart(cart);
        }//fin del cabeza null
        else {
            NodoLSCart temp = cabeza;
            cabeza = new NodoLSCart(cart);
            cabeza.setNext(temp);
        }//fin del else para el otro caso
    }//fin inserta

    public String extraeLista(char tipo) {
        String datos = "";
        NodoLSCart aux = cabeza;
        while (aux != null) {
            if (aux.getDato().getTipo() == tipo) {
                datos += aux.getDato().getCod() + " - " + aux.getDato().getNombre() + " - ¢" + aux.getDato().getPrecio() + "\n";
            }//fin del if de los char        
            aux = aux.getNext();
        }
        return datos;
    }//fin del extrae lista de productos disponibles

    public NodoLSCart extraeDato(int cod, char tipo) {
        NodoLSCart aux = cabeza;
        NodoLSCart compra = null;
        while (aux != null) {
            if (aux.getDato().getCod() == cod && aux.getDato().getTipo() == tipo) {
                compra = aux;
            }//fin del if de los char        
            aux = aux.getNext();
        }
        return compra;
    }//fin del extrae la compra

    public void elimina(int id) {
        NodoLSCart aux = cabeza;
        while (aux != null) {
            if (cabeza.getDato().getCod() == id) {
                cabeza = aux.getNext();
                break;
            }//fin del primer caso
            else if (aux.getNext().getDato().getCod() == id) {
                NodoLSCart temp = aux.getNext();
                aux.setNext(temp.getNext());
                break;
            } else {
                aux = aux.getNext();
            }//fin del else
        }//fin del while
    }//fin de la busqueda

    public void modifica(int cod, float precio) {
        NodoLSCart aux = cabeza;
        while (aux != null) {
            if (aux.getDato().getCod() == cod) {
                aux.getDato().setPrecio(precio);
            }//fin del if de los char        
            aux = aux.getNext();
        }
    }//fin del extrae la compra

    public boolean busca(int cod, char tipo) {
        boolean enc = false;
        NodoLSCart aux = cabeza;
        while (aux != null) {
            if (aux.getDato().getCod() == cod && aux.getDato().getTipo() == tipo) {
                enc = true;
            }//fin del if de los char        
            aux = aux.getNext();
        }
        return enc;
    }//fin de la busqueda

    public String dispo(char tipo) {
        String s = "";
        NodoLSCart aux = cabeza;
        while (aux != null) {
            if (aux.getDato().getTipo() == tipo) {
                s += aux.getDato().getCod() + "- " + aux.getDato().getNombre() + "\n";
            }//fin del if si es del tipo 
            aux = aux.getNext();
        }
        return s;
    }//fin del dispo

    @Override
    public String toString() {
        String s = "";
        NodoLSCart aux = cabeza;
        while (aux != null) {
            s += aux + "\n";
            aux = aux.getNext();
        }
        return s;
    }//fin del to string

}//fin de la lista simple de los productos
