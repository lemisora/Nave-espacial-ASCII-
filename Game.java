import java.util.Random;
import java.util.Scanner;

public class Game {

    private static final int WIDTH = 80;
    private static final int HEIGHT = 25;
    private static final char SHIP = '^';
    private static final char ASTEROID = '*';
    private static final char PROJECTILE = '|';
    private static final int ASTEROID_SPEED = 3;
    private static final int PROJECTILE_SPEED = 2;
    private static final int MAX_ASTEROIDS = 5;

    private static int x = WIDTH / 2;
    private static int y = HEIGHT - 1;
    private static Random random = new Random();
    private static int[] asteroidX = new int[MAX_ASTEROIDS];
    private static int[] asteroidY = new int[MAX_ASTEROIDS];
    private static boolean gameOver = false;
    private static int projectileX;
    private static int projectileY;
    private static boolean projectileActive = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicializar asteroides
        for (int i = 0; i < MAX_ASTEROIDS; i++) {
            asteroidX[i] = random.nextInt(WIDTH);
            asteroidY[i] = -random.nextInt(HEIGHT);
        }

        // Dibujar el juego
        clearScreen();
        while (!gameOver) {
            drawShip();
            drawAsteroids();
            if (projectileActive) {
                drawProjectile();
                moveProjectile();
            }
            moveAsteroids();
            moveShip(scanner.next().charAt(0));
            checkCollisions();
            clearScreen();
        }

        // Juego terminado
        clearScreen();
        System.out.println("GAME OVER");
        scanner.close();
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static void drawShip() {
        for (int i = 0; i < WIDTH + 2; i++) {
            System.out.print("=");
        }
        System.out.println();
        for (int i = 0; i < HEIGHT; i++) {
            System.out.print("|");
            for (int j = 0; j < WIDTH; j++) {
                if (i == y && j == x) {
                    System.out.print(SHIP);
                } else if (i == projectileY && j == projectileX && projectileActive) {
                    System.out.print(PROJECTILE);
                } else {
                    boolean asteroidHere = false;
                    for (int k = 0; k < MAX_ASTEROIDS; k++) {
                        if (i == asteroidY[k] && j == asteroidX[k]) {
                            asteroidHere = true;
                            System.out.print(ASTEROID);
                            break;
                        }
                    }
                    if (!asteroidHere) {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println("|");
        }
        for (int i = 0; i < WIDTH + 2; i++) {
            System.out.print("=");
        }
        System.out.println();
    }
    private static void drawAsteroids() {
    for (int i = 0; i < MAX_ASTEROIDS; i++) {
        System.out.print(" ");
        for (int j = 0; j < WIDTH; j++) {
            if (i == asteroidY[i] && j == asteroidX[i]) {
                System.out.print(ASTEROID);
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}
    private static void drawProjectile() {
    for (int i = 0; i < HEIGHT; i++) {
        if (i == projectileY) {
            System.out.print(PROJECTILE);
        } else {
            System.out.print(" ");
        }
    }
    System.out.println();
}

private static void moveProjectile() {
    projectileY -= PROJECTILE_SPEED;
    if (projectileY < 0) {
        projectileActive = false;
    }
}

private static void moveAsteroids() {
    for (int i = 0; i < MAX_ASTEROIDS; i++) {
       asteroidY[i] += ASTEROID_SPEED;
        if (asteroidY[i] >= HEIGHT) {
            asteroidX[i] = random.nextInt(WIDTH);
            asteroidY[i] = -random.nextInt(HEIGHT);
        }
    }
}

private static void moveShip(char input) {
    switch (input) {
        case 'a':
            x--;
            break;
        case 'd':
            x++;
            break;
        case 'x':
            if (!projectileActive) {
                projectileX = x;
                projectileY = y - 1;
                projectileActive = true;
            }
            break;
    }
    if (x < 0) {
        x = 0;
    } else if (x >= WIDTH) {
        x = WIDTH - 1;
    }
}

private static void checkCollisions() {
    for (int i = 0; i < MAX_ASTEROIDS; i++) {
        if (asteroidY[i] == y && asteroidX[i] == x) {
            gameOver = true;
            break;
        }
        if (projectileActive && asteroidY[i] == projectileY && asteroidX[i] == projectileX) {
            asteroidX[i] = random.nextInt(WIDTH);
            asteroidY[i] = -random.nextInt(HEIGHT);
            projectileActive = false;
        }
    }
}

}
 
/*
clearScreen(): Este método simplemente limpia la pantalla de la consola. Se usa para que el juego se vea bien cada vez que se actualiza la pantalla.
drawShip(): Este método dibuja la nave, los asteroides y el proyectil en la pantalla. Primero dibuja una línea superior e inferior de igual (=) para el marco de la pantalla. Luego, dibuja una barra vertical (|) a cada lado de la pantalla y llena el espacio en el medio con la nave, los asteroides y el proyectil si están activos.
drawAsteroids(): Este método dibuja los asteroides en la pantalla. Para cada asteroide, dibuja una línea que representa el asteroide. Si el asteroide no está en esa fila, dibuja un espacio en blanco.
drawProjectile(): Este método dibuja el proyectil en la pantalla. Para cada fila en la pantalla, dibuja el proyectil en la fila correcta, o un espacio en blanco si no hay proyectil activo.
moveProjectile(): Este método mueve el proyectil hacia arriba en la pantalla (en la dirección opuesta a la que se mueven los asteroides) y desactiva el proyectil si llega al borde superior de la pantalla.
moveAsteroids(): Este método mueve los asteroides hacia abajo en la pantalla. Si un asteroide se mueve fuera de la pantalla en la parte inferior, se vuelve a generar en la parte superior de la pantalla en una ubicación aleatoria.
moveShip(char input): Este método mueve la nave hacia la izquierda o hacia la derecha según la entrada del usuario. Si el usuario presiona la tecla "x", dispara un proyectil si no hay uno activo.
checkCollisions(): Este método comprueba si algún asteroide ha chocado con la nave del jugador o con un proyectil. Si un asteroide choca con la nave, el juego termina. Si un asteroide choca con un proyectil, el proyectil se desactiva y el asteroide se vuelve a generar en la parte superior de la pantalla en una ubicación aleatoria.
*/