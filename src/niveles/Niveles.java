package niveles;
import java.util.Random;
abstract public class Niveles {   
    protected int noPlanetas;
    protected int noAsteroides;
    protected int noHoyosNegros;
    protected int noBalas = 16000;
    protected int noObjetosInt;
    protected int noCuerpos;
    protected int noCapsulas;

    protected int nivel;
    protected boolean PASS;
    protected boolean sePuedeDisparar;

    protected Random generaCuerpos = new Random();

    public Niveles(){       //Constructor de la clase
    }
    
    public int determinaSiguienteNivel(){
        return nivel;
    }
    public boolean ganaNivel(){
        return PASS;
    }
    public int calculaRestanteBalas(){
        return noBalas;
    }
    public int calculaRestanteCapsulas(){
        return noCapsulas;
    }
    public boolean posibDisparar(){
        return sePuedeDisparar;
    }
    abstract public int getNoCuerpos();
}

