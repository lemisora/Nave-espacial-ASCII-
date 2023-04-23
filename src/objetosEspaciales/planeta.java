package objetosEspaciales;
import java.util.*;
//////////////////////////////////////////////////////////////
//                      CLASE PLANETA                       //
//////////////////////////////////////////////////////////////
public class planeta extends Espacio{
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
}
  