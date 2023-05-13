package niveles;

/////////////////////////////////////////////////////////
//                  CLASE DEL NIVEL 2                  //
/////////////////////////////////////////////////////////
public class Niv2 extends Niveles{
    protected int noAsteroidesDestruidos;
    protected boolean asteroideChocado;
    public Niv2(){          //Constructor de la clase Niv2
        super();
        this.nivel = 2;
        this.Asteroides = generaCuerpos.nextInt(10)+5;
        this.ObjetosInt = generaCuerpos.nextInt(10)+5;
    }

    @Override
    public int getNoCuerposDestruidos(){
        return this.Cuerpos;
    }
    @Override
    public int imprimeCuerpos(){
        controlImprime = generaCuerpos.nextInt(2)+1;
        return controlImprime;
    }
}