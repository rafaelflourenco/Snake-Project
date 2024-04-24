import java.util.List;
import java.util.ArrayList;

public class Triangulo extends Poligono {
    public Triangulo(List<Ponto> pontos) {
        super(pontos);
        if (!isTriangulo(pontos)) {
            System.out.println("Triangulo:vi");
            System.exit(0);
        }
    }

    /**
     * Checks if the given points form a valid triangle.
     *
     * @param pontos List of points
     * @return true if the points form a triangle, false otherwise
     */
    public boolean isTriangulo(List<Ponto> pontos) {
        if (pontos.size() != 3) {
            return false;
        }
        double ab = pontos.get(0).dist(pontos.get(1));
        double bc = pontos.get(1).dist(pontos.get(2));
        double ca = pontos.get(2).dist(pontos.get(0));

        // Check for triangle inequality theorem
        return (ab + bc > ca) && (ab + ca > bc) && (bc + ca > ab);
    }

    /**
     * Rotates the triangle around a given point.
     *
     * @param rotAngle Rotation angle in degrees
     * @param xP x-coordinate of the pivot point
     * @param yP y-coordinate of the pivot point
     * @return new rotated Triangle
     */
    public Triangulo rotate(int rotAngle, double xP, double yP) {
        List<Ponto> pontos = new ArrayList<>(getPoligonos());
        double angle = Math.toRadians(rotAngle);
        List<Ponto> novosPontos = new ArrayList<>();
        for (Ponto ponto : pontos) {
            int x = (int) (Math.round(xP + ((ponto.getX() - xP) * Math.cos(angle)) - ((ponto.getY() - yP) * Math.sin(angle))));
            int y = (int) (Math.round(yP + ((ponto.getX() - xP) * Math.sin(angle)) + ((ponto.getY() - yP) * Math.cos(angle))));
            novosPontos.add(new Ponto(x, y));
        }
        return new Triangulo(novosPontos);
    }

    /**
     * Rotates the triangle around its centroid.
     *
     * @param rotAngle Rotation angle in degrees
     * @return new rotated Triangle
     */
    public Triangulo rotate(int rotAngle) {
        Double[] centroide = calculateCentroide(new ArrayList<>(getPoligonos()));
        return rotate(rotAngle, centroide[0], centroide[1]);
    }

    @Override
    public String toString() {
        return "Triangulo: " + getPoligonos();
    }
}
