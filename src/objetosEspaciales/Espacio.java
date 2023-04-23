package objetosEspaciales;
import java.util.*;
public class Espacio{
  public String nombre;
  protected String tipo;
  protected int distancia;
  protected int velocidad;
  protected int resistencia;                  //Es el que medirá cuanto queda de vida para un objeto en cuestión

  protected Random num = new Random(); 

  static public Nave sh;                      //Asociación de la nave al espacio

  public Espacio(){};                         //Constructor por defecto de la clase Espacio

  public Espacio(String nombre,String tipo){  //Constructor del espacio (objetos celestiales)
    this.nombre=nombre;
    this.tipo=tipo;
  }

  //Métodos setters y getters
  public void setVelocidad(int a,int b){
    this.velocidad = num.nextInt(b)+a;
  }
  public int getVelocidad(){
    return velocidad;
  }
  public void setDistancia(int a,int b){
    this.distancia = num.nextInt(b)+a;
  }

  public String getNombre() {
    return this.nombre;
  }
  public String getTipo() {
    return this.tipo;
  }
}





