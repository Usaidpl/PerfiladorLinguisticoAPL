package gt.lea.usaid.perfiladorlinguistico.view;

/**
 * Created by brimc on 21/04/2016.
 */
public class Developer {
    private String nombre;
    private String carnet;
    private String correo;
    private String telefono;
    private String twitter;
    private int foto;

    public Developer(String nombre, String carnet, String correo, String telefono, String twitter, int foto) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.correo = correo;
        this.telefono = telefono;
        this.twitter = twitter;
        this.foto = foto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
}
