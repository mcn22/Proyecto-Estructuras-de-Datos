package p_estructuras;

public class ArbolReser {

    private NodoAReser raiz;
    private boolean encontrado = false;
    private boolean encUser = false;
    private String dato = "";
    private String ocup = "";
    NodoAReser extrae = null;

    public void insertar(Reserva res) {
        if (raiz == null) {
            raiz = new NodoAReser(res);
        } else {
            insertarRec(raiz, res);
        }
    }//fin del inserta

    private void insertarRec(NodoAReser raiz, Reserva res) {
        if (res.getMesa() <= raiz.getDato().getMesa()) {
            if (raiz.getHijoIzq() == null) {
                raiz.setHijoIzq(new NodoAReser(res));
            }//fin if izq 
            else {
                insertarRec(raiz.getHijoIzq(), res);
            }
        }//fin primer if
        else {
            if (raiz.getHijoDer() == null) {
                raiz.setHijoDer(new NodoAReser(res));
            }//fin if 1 der
            else {
                insertarRec(raiz.getHijoDer(), res);
            }
        }//fin del else del primer if
    }//fin del insertarRec

    public String inOrden() {
        String ocupadas = "";
        ocup = "";
        if (raiz != null) {
            inOrdenR(raiz);
            ocupadas = ocup;
        } else {
            System.out.println("Arbol vacio");
        }
        System.out.println("");
        return ocupadas;
    }//fin de in orden

    private void inOrdenR(NodoAReser n) {
        if (n != null) {
            if (n.getDato().isOcupado() == true) {
                dato += "• " + n.getDato().getMesa() + "\n";
            }//fin del if para la disponibilidad del booleano
            inOrdenR(n.getHijoIzq());
            inOrdenR(n.getHijoDer());
        }
    }//fin de inOrdenRecursivo

    public boolean busca(int mesa) {
        boolean enc = false;
        encontrado = false;
        if (raiz != null) {
            enc = buscaR(raiz, mesa);
        } else {
            System.out.println("Arbol vacio");
        }
        System.out.println("");
        return enc;
    }//fin de busca

    private boolean buscaR(NodoAReser n, int mesa) {
        if (n != null) {
            if (n.getDato().isOcupado() == true && n.getDato().getMesa() == mesa) {
                encontrado = true;
            }//fin del if del encontrado
            else {
                buscaR(n.getHijoIzq(), mesa);
                buscaR(n.getHijoDer(), mesa);
            }
        }
        return encontrado;
    }//fin del busca

    public boolean buscaUser(int id) {
        boolean enc = false;
        encUser = false;
        if (raiz != null) {
            enc = buscaUserR(raiz, id);
        } else {
            System.out.println("Arbol vacio");
        }
        System.out.println("");
        return enc;
    }//fin de busca user

    private boolean buscaUserR(NodoAReser n, int id) {
        if (n != null) {
            if (n.getDato().getIdUser() == id) {
                encUser = true;
            }//fin del if del encontrado
            else {
                buscaUserR(n.getHijoIzq(), id);
                buscaUserR(n.getHijoDer(), id);
            }
        }
        return encUser;
    }//fin del busca user

    public String datos(int id) {
        dato = "";
        if (raiz != null) {
            dato = buscaDatoR(raiz, id);
        } else {
            System.out.println("Arbol vacio");
        }
        System.out.println("");
        return dato;
    }//fin de busca user

    private String buscaDatoR(NodoAReser n, int id) {
        if (n != null) {
            if (n.getDato().getIdUser() == id) {
                dato = n.getDato().toString();
            }//fin del if del encontrado
            else {
                buscaDatoR(n.getHijoIzq(), id);
                buscaDatoR(n.getHijoDer(), id);
            }
        }
        return dato;
    }//fin del busca user

    public String reservas() {
        dato = "";
        if (raiz != null) {
            dato = reservasR(raiz);
        } else {
            System.out.println("Arbol vacio");
        }
        System.out.println("");
        return dato;
    }//fin de busca user

    private String reservasR(NodoAReser n) {
        if (n != null) {
            if (n.getDato().isOcupado()) {
                dato += "• " + n.getDato().getMesa() + "\n";
            }//fin del if para la disponibilidad del booleano
            reservasR(n.getHijoIzq());
            reservasR(n.getHijoDer());
        }
        return dato;
    }//fin del busca user

    public NodoAReser extraeDato(int mesa) {
        NodoAReser dat = null;
        if (raiz != null) {
            dat = extraeDatoR(raiz, mesa);
        } else {
            System.out.println("Arbol vacio");
        }
        System.out.println("");
        return dat;
    }//fin de busca user

    private NodoAReser extraeDatoR(NodoAReser n, int id) {
        if (n != null) {
            if (n.getDato().getMesa() == id) {
                extrae = n;
            }
            extraeDatoR(n.getHijoIzq(), id);
            extraeDatoR(n.getHijoDer(), id);
        }
        return extrae;
    }//fin del busca user

    public void modifica(String nombre, int cedula, int telefono, int mesa, int idUser) {
        if (raiz != null) {
            modificaR(raiz, nombre, cedula, telefono, mesa, idUser);
        } else {
            System.out.println("Arbol vacio");
        }
        System.out.println("");
    }//fin de busca user

    private void modificaR(NodoAReser n, String nombre, int cedula, int telefono, int mesa, int idUser) {
        if (n != null) {
            if (n.getDato().getMesa() == mesa) {
                n.getDato().setNombre(nombre);
                n.getDato().setCedula(cedula);
                n.getDato().setTelefono(telefono);
                n.getDato().setIdUser(idUser);
                n.getDato().setOcupado(true);
            }//fin del if del encontrado
            else {
                modificaR(n.getHijoIzq(), nombre, cedula, telefono, mesa, idUser);
                modificaR(n.getHijoDer(), nombre, cedula, telefono, mesa, idUser);
            }
        }
    }//fin del modifica

    public void libera(int idUser) {
        if (raiz != null) {
            liberaR(raiz, idUser);
        } else {
            System.out.println("Arbol vacio");
        }
        System.out.println("");
    }//fin de busca user

    private void liberaR(NodoAReser n, int idUser) {
        if (n != null) {
            if (n.getDato().getIdUser() == idUser) {
                n.getDato().setNombre("");
                n.getDato().setCedula(0);
                n.getDato().setTelefono(0);
                n.getDato().setIdUser(0);
                n.getDato().setOcupado(false);
            }//fin del if del encontrado
            else {
                liberaR(n.getHijoIzq(), idUser);
                liberaR(n.getHijoDer(), idUser);
            }
        }
    }//fin del modifica

}//fin de la clase del arbol de la reserva
