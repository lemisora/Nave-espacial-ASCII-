import java.util.Scanner;
import java.io.Console;
import java.util.Random;
import niveles.*;
import generaCadena.*;

class Juego {
    private static final int ANCHO=100;
    private static final int ALTO=50;

    //Carácteres para la representación de la nave y los cuerpos celestes en la consola
    private static final char NAVE = '^';
    private static final char ASTEROIDE = '*';
    private static final char PLANETA_VIVO = 'O';
    private static final char PLANETA_COMUN = 'o';
    private static final char HOYO_NEGRO = '0';
    private static final char OBJ_INT = '?';
    private static final char BALA = '|';

    //Resistencia de cada objeto
    private static final int RES_NAVE = 4000;
    private static final int RES_ASTEROIDE = 3000;
    private static final int RES_PLANETA = 2500;
    private static final int RES_HOYO = 5000;

    private static int velPlaneta;

    private static final int dañoBala = 500;
    private static int maxCuerpos;
    private static Character resp;
    private static Character yes = 's';
    private static Character YES = 'S';

    private static int x = ANCHO / 2;
    private static int y = ALTO - 1;
    private static Random numAl = new Random();
    private static int[] cuerpoX;
    private static int[] cuerpoY;
    private static boolean perdido = false;
    
    static Scanner entrada = new Scanner(System.in);
    static GeneradorNombresAleatorios nombreCuerpos = new GeneradorNombresAleatorios();
    
    ///////////////////////////////////////////////////////////
    //              CLASE EJECUTABLE MAIN                    //
    ///////////////////////////////////////////////////////////
    public static void main(String [] args){
        String nomObjetos;
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
        Pantalla.sh=ship;
        System.out.println("Los nombres ingresados para la nave y el piloto respectivamente son: "+Pantalla.sh.nombre+" y "+Pantalla.sh.nombrePiloto);
        System.out.print("¿Desea comenzar a jugar el nivel 1? [s/N] : ");
        resp = entrada.next().charAt(0);

        if(resp.equals(yes) || resp.equals(YES)){
          Niv1 Nivel1 = new Niv1();
          maxCuerpos = Nivel1.getNoCuerpos();
          nomObjetos = nombreCuerpos.generarNombreAleatorio(10);
          planeta p1 =  new planeta(nomObjetos,"Planeta");
          velPlaneta = p1.getVelocidad(); 
          cuerpoX = new int[maxCuerpos];
          cuerpoY = new int[maxCuerpos];
          for(int i=0;i<maxCuerpos;i++){
            cuerpoX[i] = numAl.nextInt(ANCHO);
            cuerpoY[i] = -numAl.nextInt(ALTO);
          }

        }else{
          System.out.println("Se finaliza la ejecución del juego...");
          System.exit(0);
        }

        terminal.printf("\u001B[2J");
        while(!perdido){
          terminal.printf("\u001B[H");
          for(int i=0;i<ALTO;i++){
            for(int j=0;j<ANCHO;j++){
              if(i==y && j==x){
                terminal.printf("%c",NAVE);
                
              }else{
                boolean cuerpoAquí=false;
                for(int k=0;k<maxCuerpos;k++){
                  if(i==cuerpoY[k] && j == cuerpoX[k]){
                    cuerpoAquí = true;
                    terminal.printf("%c",PLANETA_COMUN);
                    break;
                  }
                }
                if(!cuerpoAquí){
                  terminal.printf(".");
                }

              }
            }
            terminal.printf("\n");
          }
          terminal.printf("\n");
          //Para el movimiento de los asteroides
          for(int i=0;i<maxCuerpos;i++){
            cuerpoY[i] += velPlaneta;
            if(cuerpoX[i] >= ALTO){
              cuerpoX[i] = numAl.nextInt(ANCHO);
              cuerpoY[i] = -numAl.nextInt(ALTO);
            }
          }

          //Para mover la nave y disparar
          String input = terminal.readLine();
          if(input.equals("a") && x>0){
            x--;
          }else if(input.equals("d") && x<ANCHO-1){
            x++;
          }else if(input.equals("l")){
            System.out.print(BALA);
          }
        }
      }
    }

