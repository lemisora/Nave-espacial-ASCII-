import java.util.Random;
abstract class Espacio{
  protected String nombre;
  protected String tipo;
  protected int distancia;
  protected int velocidad;

  static public Nave sh;                      //Asoociación de la nave al espacio

  public Espacio(){};                         //Constructor por defecto de la clase Espacio

  public Espacio(String nombre,String tipo){  //Constructor del espacio (objetos celestiales)
    this.nombre=nombre;
    this.tipo=tipo;
  }

  //Métodos abstractos
  public abstract void setDistancia();
  public abstract void setNoObjetos();
}


