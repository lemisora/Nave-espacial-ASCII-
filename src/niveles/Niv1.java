package niveles;
import objetosEspaciales.*;

/////////////////////////////////////////////////////////
//                   CLASE DEL NIVEL 1                 //
/////////////////////////////////////////////////////////
public class Niv1 extends Niveles{
    public planeta [] maxPlanetas;
    public ObjetInt [] maxObjInt;
    protected int planetasSinVidaDestruidos;
    protected boolean planetaConVidaDestruido;
    public Niv1(){          //Constructor de la clase Niv1
        super();
        this.Capsulas = 2000;//Establece la cantidad inicial de capsulas
        this.Balas = 10000;//Establece el número de balas inicial
        //Se genera una cantidad aleatoria de planetas y objetos de interés
        this.Planetas = generaCuerpos.nextInt(5)+3;
        this.ObjetosInt = generaCuerpos.nextInt(5)+3; 
        
    }
    @Override
    public int getNoCuerposDestruidos(){
        return this.Cuerpos;
    }

}
