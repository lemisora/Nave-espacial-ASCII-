package niveles;

/////////////////////////////////////////////////////////
//                  CLASE DEL NIVEL 2                  //
/////////////////////////////////////////////////////////
public class Niv2 extends Niveles{
    protected int noAsteroidesDestruidos;
    protected boolean asteroideChocado;
    public Niv2(){          //Constructor de la clase Niv2
        super();
        this.noAsteroides = generaCuerpos.nextInt(10)+5;
        this.noObjetosInt = generaCuerpos.nextInt(10)+5;
        this.noCuerpos = this.noAsteroides + this.noObjetosInt;
    }

    @Override
    public int getNoCuerpos(){
        return this.noCuerpos;
    }
}