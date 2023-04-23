package niveles;

/////////////////////////////////////////////////////////
//                  CLASE DEL NIVEL 2                  //
/////////////////////////////////////////////////////////
public class Niv2 extends Niveles{
    protected int noAsteroidesDestruidos;
    protected boolean asteroideChocado;
    public Niv2(){          //Constructor de la clase Niv2
        super();
        this.Asteroides = generaCuerpos.nextInt(10)+5;
        this.ObjetosInt = generaCuerpos.nextInt(10)+5;
        this.Cuerpos = this.Asteroides + this.ObjetosInt;
    }

    @Override
    public int getNoCuerposDestruidos(){
        return this.Cuerpos;
    }
}