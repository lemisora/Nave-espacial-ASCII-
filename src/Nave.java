import java.util.Random;
class Nave {
  //Atributos a los que accederá el método main para representarlos en pantalla
  private static final char simNave = '^';
  private static final char simBala = '|';

  private String nombre;
  private String nombrePiloto;
  private int velocidadMax;
  private int noBalas;
  private int vida;

  public Nave(String nombre,String nombrePiloto){ //Constructor de la nave
    this.nombre=nombre;
    this.nombrePiloto=nombrePiloto;
  }

  void Disparar(){
    
  }

  void Desplazarse(){
    
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


}
