import java.util.Random;
class Nave{
  private String nombre;
  private String nombrePiloto;
  protected int velocidadMax;
  protected int noBalas;
  protected int vida;

  public Nave(String nombre,String nombrePiloto){ //Constructor de la nave
    this.nombre=nombre;
    this.nombrePiloto=nombrePiloto;
  }

  public void Disparar(){
    this.noBalas=this.noBalas-100;
  }

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
    Random rand = new Random();
    this.velocidadMax=rand.nextInt(500)+100;
  }
  public void setNoBalas(int balas){
    this.noBalas=balas;
  }
  public int getNoBalas(){
    return noBalas;
  }


}