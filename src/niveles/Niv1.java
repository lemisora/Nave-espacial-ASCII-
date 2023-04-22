package niveles;

/////////////////////////////////////////////////////////
//                   CLASE DEL NIVEL 1                 //
/////////////////////////////////////////////////////////
public class Niv1 extends Niveles{
    protected int planetasSinVidaDestruidos;
    protected boolean planetaConVidaDestruido;
    public Niv1(){          //Constructor de la clase Niv1
        super();
        this.noPlanetas = generaCuerpos.nextInt(10)+5;
        this.noObjetosInt = generaCuerpos.nextInt(10)+5;
        this.noCuerpos = this.noPlanetas + this.noObjetosInt;    
    }
    @Override
    public int getNoCuerpos(){
        return this.noCuerpos;
    }
}
