import java.util.Random;
class Espacio{
  String nombre;
  int distancia;
  int velocidad;

  int noPlanetas;
  int noAsteroides;
  int noHoyosNegros;
  int noObjetosInteres;

  public void setDistanciaObjetos(){
    Random rand = new Random();
    this.velocidad=rand.nextInt(5000)+30;
  }
  
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
