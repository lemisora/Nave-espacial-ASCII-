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
    protected int nivel;
    protected int controlImprime;

    protected boolean sePuedeDisparar;
    protected boolean subeNivel = false;

    protected Random generaCuerpos = new Random();

    public Niveles(){       //Constructor de la clase
    }
    public void setNivel(int nivel){
        this.nivel = nivel;
    }
    public int getNivel(){
        return nivel;
    }
    public boolean ganaNivel(){
        this.subeNivel = true;
        return this.subeNivel;
    }
    public void determinaSiguienteNivel(){
        if(this.subeNivel == true && this.nivel != 3){
            this.nivel = nivel+1;
            System.out.print("Pasará al siguiente nivel");
        }
        if(this.subeNivel == false){
            System.out.println("¡Lo sentimos ha perdido el juego!");
        }
        if(this.subeNivel == true && this.nivel ==3){
            System.out.println("¡Felicidades ha ganado el juego!");
        }
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
    abstract public int imprimeCuerpos();

}

