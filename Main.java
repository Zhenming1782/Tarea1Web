
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Scanner;

/**
 * A simple example, used on the jsoup website.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Tareas tareas = new Tareas();


        Scanner scanner = new Scanner(System.in);

        char op;
        boolean bye = true;

        while (true) {
            System.out.print("------------------------------------------------------ \n");
            System.out.print("Seleccione una letra [A-B-C-D-E-F] y [Q] para salir : \n");
            op = scanner.next().toUpperCase().charAt(0);
            switch (op) {
                case 'A':
                    tareas.parteA();
                    break;
                case 'B':
                    tareas.parteB();
                    break;
                case 'C':
                    tareas.parteC();
                    break;
                case 'D':
                    tareas.parteD();
                    break;
                case 'E':
                    tareas.parteE();
                    break;
                case 'F':
                    tareas.parteF();
                    break;
                case 'Q':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Error.");
            }


        }


    }
}

