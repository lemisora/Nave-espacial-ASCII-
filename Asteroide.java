class Asteroide extends Espacio{
    private static final char simAstro ='*';
    
    public Asteroide (String nombre, String tipo){
        super (nombre,tipo);

    }
    public String getNombre() {
      return this.nombre;
    }

    public String getTipo() {
      return this.tipo;
    }
 

}