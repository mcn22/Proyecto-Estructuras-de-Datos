package p_estructuras;

public class FacturaClien {

    private String datos;
    private int codFact;
    private int codUser;

    public FacturaClien(String datos, int codFact, int codUser) {
        this.datos = datos;
        this.codFact = codFact;
        this.codUser = codUser;
    }

    public FacturaClien() {
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public int getCodFact() {
        return codFact;
    }

    public void setCodFact(int codFact) {
        this.codFact = codFact;
    }

    public int getCodUser() {
        return codUser;
    }

    public void setCodUser(int codUser) {
        this.codUser = codUser;
    }

    @Override
    public String toString() {
        return "\n" + datos;
    }

}//fin de la clase factura
