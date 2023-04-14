import java.util.Random;
public class Nave {
  private String nombre;
  private String nombrePiloto;
  private int velocidadMax;

  //Getters y setters del nombre
  public void setNombre(String nombre){
    this.nombre=nombre;
  }
  public String getNombre(){
    return this.nombre;
  }

  //Getters y setters del nombre del nombrePiloto
  public void setNombrePiloto(String nombrePiloto){
    this.nombrePiloto=nombrePiloto;
  }

  public String getNombrePiloto(){
    return this.nombrePiloto;
  }

  public void generaVelocidad(){
    Random rand = new Random;
    this.velocidadMax=rand.nextInt(500)+100;
  }

}
