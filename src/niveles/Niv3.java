package niveles;

//////////////////////////////////////////////////////////
//                  CLASE DEL NIVEL 3                   //
//////////////////////////////////////////////////////////
public class Niv3 extends Niveles{
    protected int noHoyosNegrosDestruidos;
    protected boolean absorbido;            //Determina si es que se ha "chocado" con un hoyo negro
    public Niv3(){                          //Constructor de la clase Niv3
        super();
        this.nivel = 3;
        this.HoyosNegros = generaCuerpos.nextInt(10)+5;
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
