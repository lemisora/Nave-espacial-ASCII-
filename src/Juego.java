import java.util.Scanner;
import java.io.Console;
import java.util.Random;

class Juego {
    private static final int ANCHO=100;
    private static final int ALTO=50;
    
    static Scanner entrada = new Scanner(System.in);
    
    ///////////////////////////////////////////////////////////
    //              CLASE EJECUTABLE MAIN                    //
    ///////////////////////////////////////////////////////////
    public static void main(String [] args){
        String nombreNave;
        String nombreNavePiloto;
        Console terminal = System.console();
        if(terminal==null){
            System.err.println("¡Error! La consola no está disponible");
            System.exit(1);
        }
        Espacio Pantalla = new Espacio();
        System.out.print("Ingrese el nombre de la nave: ");
        nombreNave = entrada.next();
        System.out.print("Ingrese el nombre del piloto: ");
        nombreNavePiloto = entrada.next();
        Nave ship = new Nave(nombreNave,nombreNavePiloto);
        Espacio.sh=ship;
    }
}
