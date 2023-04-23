import java.io.Console;
import java.util.Random;

public class Game {

    private static final int WIDTH = 80;
    private static final int HEIGHT = 25;
    private static final char SHIP = '^';
    private static final char ASTEROID = '*';
    private static final char BALA = '|';
    private static final int ASTEROID_SPEED = 3;
    private static final int MAX_ASTEROIDS = 5;

    private static int x = WIDTH / 2;
    private static int y = HEIGHT - 1;
    private static Random random = new Random();
    private static int[] asteroidX = new int[MAX_ASTEROIDS];
    private static int[] asteroidY = new int[MAX_ASTEROIDS];
    private static boolean gameOver = false;

    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.err.println("Error: La consola no está disponible.");
            System.exit(1);
        }

        // Inicializar asteroides
        for (int i = 0; i < MAX_ASTEROIDS; i++) {
            asteroidX[i] = random.nextInt(WIDTH);
            asteroidY[i] = -random.nextInt(HEIGHT);
        }

        // Dibujar el juego
        console.printf("\u001B[2J"); // Limpiar la pantalla
        while (!gameOver) {
            console.printf("\u001B[H"); // Colocar el cursor en la posición 0,0
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    if (i == y && j == x) {
                        console.printf("%c", SHIP);
                    } else {
                        boolean asteroidHere = false;
                        for (int k = 0; k < MAX_ASTEROIDS; k++) {
                            if (i == asteroidY[k] && j == asteroidX[k]) {
                                asteroidHere = true;
                                console.printf("%c", ASTEROID);
                                break;
                            }
                        }
                        if (!asteroidHere) {
                            console.printf(".");
                        }
                    }
                }
                console.printf("\n");
            }

            // Mover asteroides
            for (int i = 0; i < MAX_ASTEROIDS; i++) {
                asteroidY[i] += ASTEROID_SPEED;
                if (asteroidY[i] >= HEIGHT) {
                    asteroidX[i] = random.nextInt(WIDTH);
                    asteroidY[i] = -random.nextInt(HEIGHT);
                }
            }

            // Mover la nave
            String input = console.readLine();
            if (input.equals("a") && x > 0) {
                x--;
            } else if (input.equals("d") && x < WIDTH - 1) {
                x++;
            } else if(input.equals("l")){
                System.out.print(BALA);
            }

            // Comprobar colisión con asteroides
            for (int i = 0; i < MAX_ASTEROIDS; i++) {
                if (y == asteroidY[i] && x == asteroidX[i]) {
                    gameOver = true;
                    break;
                }
            }
        }

        // Juego terminado
        console.printf("\u001B[2J"); // Limpiar la pantalla
        console.printf("\u001B[H"); // Col
    }
}    
