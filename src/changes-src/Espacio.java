import java.util.Random;
abstract class Espacio{
  protected String nombre;
  protected String tipo;
  protected int distancia;
  protected int velocidad;
  protected int resistencia;                  //Es el que medirá cuanto queda de vida para un objeto en cuestión

  static public Nave sh;                      //Asoociación de la nave al espacio

  public Espacio(){};                         //Constructor por defecto de la clase Espacio

  public Espacio(String nombre,String tipo){  //Constructor del espacio (objetos celestiales)
    this.nombre=nombre;
    this.tipo=tipo;
  }

  //Método abstracto
  public abstract void setResistencia();

  //Métodos setters y getters
  public void setVelocidad(){
  }
  public void setDistancia(){
  }  
  public String getNombre() {
    return this.nombre;
  }
  public String getTipo() {
    return this.tipo;
  }
}

//////////////////////////////////////////////////////////////
//                      CLASE PLANETA                       //
//////////////////////////////////////////////////////////////
class planeta extends Espacio{
  private boolean tieneVida;
  Random vida = new Random();
  int controlVida;
  public planeta(String nombre, String tipo) { //Constructor del planeta
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
  public boolean tieneVida() {
    return this.tieneVida;
  }
  @Override
  public void setResistencia(){
    Random res = new Random();
    this.resistencia=res.nextInt(800)+200;
  }
}

////////////////////////////////////////////////////////
//                  CLASE ASTEROIDE                   //
////////////////////////////////////////////////////////
class Asteroide extends Espacio{
  public Asteroide(String nombre,String tipo){
    super(nombre,tipo);
  }
  @Override
  public void setResistencia(){
    Random res = new Random();
    this.resistencia=res.nextInt(1200)+600;
  }
}

////////////////////////////////////////////////////////
//                 CLASE HOYO NEGRO                   //
////////////////////////////////////////////////////////
class HoyoNegro extends Espacio{
  public HoyoNegro(String nombre,String tipo){
    super(nombre, tipo);
  }
  @Override
  public void setResistencia(){
    Random res = new Random();
    this.resistencia=res.nextInt(3000)+1500;
  }
}

////////////////////////////////////////////////////////
//                CLASE OBJETOS DE INTERÉS            //
////////////////////////////////////////////////////////
class ObjetInt extends Espacio{
  public ObjetInt(String nombre,String tipo){
    super(nombre, tipo);
  }
  @Override
  public void setResistencia(){
    Random res = new Random();
    this.resistencia=res.nextInt(600)+200;
  }
}