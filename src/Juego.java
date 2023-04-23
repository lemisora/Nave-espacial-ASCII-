//Importación de paquetes de las mismas clases que ayudan a la ejecución del juego
import java.util.*;
import java.io.Console;

//Paquetes hechos por nosotros para facilitar el uso de múltiples clases entre asociaciones de las mismas 
//y hacer que se interconecten entre todas en el main
import niveles.*;
import objetosEspaciales.*;
import generaCadena.*;
class Juego{
    static final int ANCHO = 50;
    static final int ALTO = 25;
    static int nivel = 1;

    //Carácteres para la representación de los elementos del juego en la pantalla
    private static final char NAVE = '^';
    private static final char ASTEROIDE = '*';
    private static final char PLANETA_VIVO = 'O';
    private static final char PLANETA_COMUN = 'o';
    private static final char HOYO_NEGRO = '0';
    private static final char OBJ_INT = '?';

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
    static boolean enNivel1 = false;
    static boolean enNivel2 = false;
    static boolean enNivel3 = false;

    static int planetasVivos[];
    static int noPlanetasVivos = 0;

    static int x = ANCHO/2;;   //Para el posicionamiento en terminal
    static int y = ALTO-1;

    static void preguntaNivel(){
        System.out.print("¿Desea empezar el nivel "+nivel+" -"+pantalla.sh.nombrePiloto+"-? [s/N] ");
        resp = entrada.next().charAt(0);
        if(resp.equals(no) || resp.equals(NO)){
            System.out.println("El juego finalizará su ejecución...");
            juegoTermino = true;
        }
    }

    

    public static void main(String [] args){
        int i=0;
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
                for(i=0;i<Nivel1.maxPlanetas.length;i++){
                    nombre = nombreCuerpos.generarNombreAleatorio(10);
                    planeta p1 = new planeta(nombre, "Planeta");
                    if(p1.tieneVida() == true){
                        noPlanetasVivos++;
                    }
                    Nivel1.maxPlanetas[i] = p1;
                    //System.out.println(Nivel1.maxPlanetas[i].getNombre());
                }
                for(i=0;i<Nivel1.maxObjInt.length;i++){
                    nombre = nombreCuerpos.generarNombreAleatorio(5);
                    ObjetInt obj = new ObjetInt(nombre, "Objeto de interés");
                    Nivel1.maxObjInt[i] = obj;
                }
                //Inicializar los cuerpos
                int cuerposX[] = new int[(Nivel1.maxObjInt.length)+(Nivel1.maxPlanetas.length)];
                int cuerposY[] = new int[(Nivel1.maxObjInt.length)+(Nivel1.maxPlanetas.length)];
                for(i=0;i<cuerposX.length;i++){
                    cuerposX[i] = numAl.nextInt(ANCHO);
                    cuerposY[i] = -numAl.nextInt(ALTO);
                }
                console.printf("\u001B[2J");
                while(!enNivel1){
                    console.printf("\u001B[H");//Coloca el cursor en 0,0 
                    for(i=0;i<ALTO;i++){
                        for(int j=0;j<ANCHO;j++){
                          if(i==y && j==x){
                            console.printf("%c",NAVE);
                          }else{
                            boolean cuerpoAquí=false;
                            for(int k=0;k<cuerposX.length;k++){
                                if(i == cuerposX[k] && j == cuerposY[k]){
                                    cuerpoAquí = true;
                                    if(Nivel1.imprimeCuerpos() == 1){
                                        if(Nivel1.contPlan < Nivel1.maxPlanetas.length){
                                            if(Nivel1.maxPlanetas[Nivel1.contPlan].tieneVida() == true){
                                                console.printf("%c",PLANETA_VIVO);
                                                if(Nivel1.contPlan+1 != Nivel1.maxPlanetas.length){
                                                   Nivel1.contPlan++;
                                                }
                                                break;
                                            }
                                            if(Nivel1.maxPlanetas[Nivel1.contObj].tieneVida() == false){
                                                console.printf("%c",PLANETA_COMUN);
                                                if(Nivel1.contPlan+1 != Nivel1.maxPlanetas.length){
                                                   Nivel1.contPlan++;
                                                }
                                                break;
                                            }   
                                        }
                                        
                                    }else{
                                        if(Nivel1.contObj < Nivel1.maxObjInt.length){
                                            Nivel1.contObj++;
                                            if(Nivel1.contObj+1 != Nivel1.maxObjInt.length){
                                                   Nivel1.contObj++;
                                            }
                                            console.printf("%c", OBJ_INT);
                                        }
                                        
                                    }
                                    //if(Nivel1.contObj == Nivel1.maxObjInt.length && Nivel1.contPlan == Nivel1.maxPlanetas.length)
                                    //}
                                }
                               
                            }
                            if(!cuerpoAquí){
                              console.printf(".");
                            }
            
                          }
                        }
                        console.printf("\n");
                    }
                    System.out.println("Balas restantes : "+pantalla.sh.getNoBalas());
                        //Mover los cuerpos
                        for(i=0;i<cuerposX.length;i++){
                            cuerposY[i] += 3;
                        }
                        // Mover la nave
                        String input = console.readLine();
                        if (input.equals("a") && x > 0) {
                            x--;
                        } else if (input.equals("d") && x < ANCHO - 1) {
                            x++;
                        } else if(input.equals("w")){
                            pantalla.sh.Disparar(30);
                        }

                        //Comprobar colisiones
                        for (i = 0; i < cuerposX.length; i++) {
                            if (cuerposY[i] == y && cuerposX[i] == x) {
                                juegoTermino = true;
                                break;
                            }
                        }
                }
                
            }
        }
    }
 
    
    
}