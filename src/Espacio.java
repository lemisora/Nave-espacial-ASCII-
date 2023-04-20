import java.util.Random;
class Espacio{
  protected String nombre;
  protected String tipo;
  protected int distancia;
  protected int velocidad;

  private int noPlanetas;
  private int noAsteroides;
  private int noHoyosNegros;
  private int noObjetosInteres;

  static public Nave sh;

  public Espacio(){}; //Constructor por defecto de la clase Espacio

  public Espacio(String nombre,String tipo){  //Constructor del espacio (objetos celestiales)
    this.nombre=nombre;
    this.tipo=tipo;
  }

  //Métodos abstractos
  public abstract void setDistancia();
  public abstract void setNoObjetos();

  public void setVelocidad(){
    Random rand2=new Random();
    this.distancia=rand2.nextInt(1500)+1;
   }

  public void setNoPlanetas(){
    Random planetas=new Random();
    this.noPlanetas=planetas.nextInt(10)+1;
  }

  public void setNoAsteroides(){
    Random aster=new Random();
    this.noAsteroides=aster.nextInt(10)+1;
  }

  public void setNoObjetosInt(){
    Random obj=new Random();
    this.noObjetosInteres=obj.nextInt(10)+1;
  }
}
