import java.awt.*;
import java.lang.reflect.Constructor;
import java.util.Scanner;

/**
 * Classe usada pelo user para dar input
 * @author (Rafael Lourenço - 79771)
 * @version (1.0.0 - 25/02/2024)
 */
public class Cliente {
    public static String capital(String s) {
        if (s == null || s.isEmpty())
            return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Constructor<?> constructor;
        Class<?> cl;
        Poligono p;
        int countPoligono = 0;
        Poligono[] conjuntoPoligonos = new Poligono[100];
        String s;
        int angulo = 0;
        int PontoX = 0;
        int PontoY = 0;
        boolean pontoProvided = false;
        String[] aos;
        while (sc.hasNextLine()) {
            s = sc.nextLine();
            if (s.isEmpty())
                break;
            aos = s.split(" ", 2);
            try {
                cl = Class.forName(capital(aos[0]));
                constructor = cl.getConstructor(Ponto[].class);
                String[] coordinates = aos[1].split(" ");
                Ponto[] pontos= new Ponto[coordinates.length/2];
                int count = aos[0].equals("Poligono") ? 1 : 0;
                for(int i = 0; i < pontos.length; i++){
                    int x = Integer.parseInt(coordinates[count]);
                    int y = Integer.parseInt(coordinates[count+1]);
                    count = count + 2;
                    pontos[i] = new Ponto(x,y);
                }
                p = (Poligono) constructor.newInstance((Object) pontos);
                conjuntoPoligonos[countPoligono] = p;
                countPoligono++;
            }
            catch (ClassNotFoundException cnfe) {
                System.out.println("Não foi encontrada a classe: " + cnfe.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
            }

            String line = sc.nextLine();
            String[] argumentos = line.split(" ");
            angulo = Integer.parseInt(argumentos[0]);
            if (argumentos.length > 1) {
                PontoX = Integer.parseInt(argumentos[1]);
                if (argumentos.length > 2) {
                    PontoY = Integer.parseInt(argumentos[2]);
                    pontoProvided = true;
                }
            }

        }
        if (pontoProvided) {
            Poligono poligonoprint = conjuntoPoligonos[0].rotate(angulo, PontoX,PontoY);
            System.out.println(poligonoprint.toString());
        } else {
            Poligono poligonoPrint = conjuntoPoligonos[0].rotate(angulo);
            System.out.println(poligonoPrint.toString());
        }

        sc.close();
    }
}
