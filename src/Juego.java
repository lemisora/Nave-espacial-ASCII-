import java.util.*;
import java.io.Console;
import niveles.*;
import objetosEspaciales.*;
import generaCadena.*;
class Juego{
    static final int ANCHO = 50;
    static final int ALTO = 25;
    static int nivel = 1;
    static String nombre;
    static String nombrePiloto;
    static Character resp;
    static final Character no = 'n';
    static final Character NO = 'N';
    static Scanner entrada = new Scanner(System.in);
    static Random numAl = new Random();
    static Espacio pantalla = new Espacio();
    static GeneradorNombresAleatorios nombreCuerpos = new GeneradorNombresAleatorios();
    static boolean juegoTermino = false;

    static void preguntaNivel(){
        System.out.print("¿Desea empezar el nivel "+nivel+" -"+pantalla.sh.nombrePiloto+"-? [s/N] ");
        resp = entrada.next().charAt(0);
        if(resp.equals(no) || resp.equals(NO)){
            System.out.println("El juego finalizará su ejecución...");
            juegoTermino = true;
        }
    }



    public static void main(String [] args){
        Console console = System.console();
        console.printf("Ingrese el nombre de la nave: ");
        nombre = entrada.next();
        console.printf("Ingrese el nombre del piloto: ");
        nombrePiloto = entrada.next();
        Nave cohete = new Nave(nombre, nombrePiloto);
        pantalla.sh = cohete;

        while(!juegoTermino){
            if(nivel==1){
                preguntaNivel();
                Niv1 Nivel1 = new Niv1();
                Nivel1.maxPlanetas = new planeta[Nivel1.Planetas];
                Nivel1.maxObjInt = new ObjetInt[Nivel1.ObjetosInt];
                for(int i=0;i<Nivel1.maxPlanetas.length;i++){
                    nombre = nombreCuerpos.generarNombreAleatorio(10);
                    planeta p1 = new planeta(nombre, "Planeta");
                    Nivel1.maxPlanetas[i] = p1;
                    //System.out.println(Nivel1.maxPlanetas[i].getNombre());
                }
                for(int i=0;i<Nivel1.maxObjInt.length;i++){
                    nombre = nombreCuerpos.generarNombreAleatorio(5);
                    ObjetInt obj = new ObjetInt(nombre, "Objeto de interés");
                    Nivel1.maxObjInt[i] = obj;
                }
                //Condicionar el paso al siguiente nivel con un booleano
            }

            
        }
    }
}