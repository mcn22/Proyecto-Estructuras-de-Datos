package p_estructuras;

public class OrdenAtendida {

    private String nombre;
    private int idClte;
    private int numOrden;
    private String lugarEnv;
    private String descrip;

    public OrdenAtendida(String nombre, int idClte, int numOrden, String lugarEnv, String descrip) {
        this.nombre = nombre;
        this.idClte = idClte;
        this.numOrden = numOrden;
        this.lugarEnv = lugarEnv;
        this.descrip = descrip;
    }

    public OrdenAtendida() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdClte() {
        return idClte;
    }

    public void setIdClte(int idClte) {
        this.idClte = idClte;
    }

    public int getNumOrden() {
        return numOrden;
    }

    public void setNumOrden(int numOrden) {
        this.numOrden = numOrden;
    }

    public String getLugarEnv() {
        return lugarEnv;
    }

    public void setLugarEnv(String lugarEnv) {
        this.lugarEnv = lugarEnv;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    @Override
    public String toString() {
        return "\nOrden #" + numOrden + "\nNombre: " + nombre + "\nCódigo cliente: " + idClte
                + "\nLugar de envío: " + lugarEnv
                + "\nDetalle:\n" + descrip;
    }

}//fin de la clase orden atendida
