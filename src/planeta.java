public class Planeta extends Espacio{
    private String nombre;
    private String tipo;
    private boolean tieneVida;

    public Planeta(String nombre, String tipo, boolean tieneVida) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.tieneVida = tieneVida;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getTipo() {
        return this.tipo;
    }

    public boolean tieneVida() {
        return this.tieneVida;
    }

    @Override
    public String toString() {
        return "Planeta " + this.nombre + " (" + this.tipo + "), " +
                (this.tieneVida ? "con vida" : "sin vida");
    }
}
