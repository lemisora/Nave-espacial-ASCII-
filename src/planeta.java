class Planeta extends Espacio{
    private boolean tieneVida;
    Random vida = new Random();
    int controlVida;
    public Planeta(String nombre, String tipo) { //Constructor del planeta
      super(nombre,tipo);
      this.controlVida = vida.nextInt(2)+1; //Mediante un número aleatorio se define si el planeta posee vida o nombre
                                            //Posee vida si es que el número es 1
                                            //Si es 2 entonces no posee vida
      if (controlVida==1){
        this.tieneVida=true;
      }else{
        this.tieneVida=false;
      }
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

}
