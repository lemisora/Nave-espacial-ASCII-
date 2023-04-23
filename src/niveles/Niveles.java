package niveles;
import java.util.Random;
abstract public class Niveles {   
    public int Planetas;
    public int ObjetosInt;
    
    protected int Asteroides;
    protected int HoyosNegros;
    protected int Balas;
    
    protected int Cuerpos;
    protected int Capsulas;

    protected boolean sePuedeDisparar;

    protected Random generaCuerpos = new Random();

    public Niveles(){       //Constructor de la clase
    }
    public int calculaRestanteBalas(){
        return Balas;
    }
    public int calculaRestanteCapsulas(){
        return Capsulas;
    }
    public boolean posibDisparar(){
        return sePuedeDisparar;
    }
    abstract public int getNoCuerposDestruidos();

}

