package niveles;

//////////////////////////////////////////////////////////
//                  CLASE DEL NIVEL 3                   //
//////////////////////////////////////////////////////////
public class Niv3 extends Niveles{
    protected int noHoyosNegrosDestruidos;
    protected boolean absorbido;            //Determina si es que se ha "chocado" con un hoyo negro
    public Niv3(){                          //Constructor de la clase Niv3
        super();
        this.noHoyosNegros = generaCuerpos.nextInt(10)+5;
        this.noObjetosInt = generaCuerpos.nextInt(10)+5;
        this.noCuerpos = this.noHoyosNegros + this.noObjetosInt;
    }

    @Override
    public int getNoCuerpos(){
        return this.noCuerpos;
    }
}
