import java.util.List;
import java.util.ArrayList;

public class Quadrado extends Retangulo {
    public Quadrado(List<Ponto> pontos) {
        super(pontos);
        if (!isQuadrado(pontos)) {
            System.out.println("Quadrado:vi");
            System.exit(0);
        }
    }

    /**
     * @param pontos List of points
     * @return true if the points form a square, false otherwise
     */
    public boolean isQuadrado(List<Ponto> pontos) {
        if (!isRetangulo(pontos)) {  // Utilize the rectangle's method to check for 90 degree angles and 4 points
            return false;
        }

        double sideLength = pontos.get(0).dist(pontos.get(1));
        for (int i = 1; i < pontos.size(); i++) {
            if (pontos.get(i).dist(pontos.get((i + 1) % pontos.size())) != sideLength) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Quadrado: " + getPoligonos();
    }

    @Override
    public Quadrado rotate(int rotAngle, double xP, double yP) {
        List<Ponto> novosPontos = new ArrayList<>();
        double angle = Math.toRadians(rotAngle);
        for (Ponto ponto : getPoligonos()) {
            int x = (int) (Math.round(xP + ((ponto.getX() - xP) * Math.cos(angle)) - ((ponto.getY() - yP) * Math.sin(angle))));
            int y = (int) (Math.round(yP + ((ponto.getX() - xP) * Math.sin(angle)) + ((ponto.getY() - yP) * Math.cos(angle))));
            novosPontos.add(new Ponto(x, y));
        }
        return new Quadrado(novosPontos);
    }

    @Override
    public Quadrado rotate(int rotAngle) {
        Double[] centroide = calculateCentroide(new ArrayList<>(getPoligonos()));
        return rotate(rotAngle, centroide[0], centroide[1]);
    }

    public Quadrado Translate(int dx, int dy){
        List<Ponto> pontos = this.getPoligonos();
        Quadrado novoPoligono;
        List<Ponto> novosPontos = new ArrayList<>(pontos);
        for(int i = 0; i < pontos.size(); i++){
            int x = pontos.get(i).getX() + dx;
            int y = pontos.get(i).getY() + dy;
            novosPontos.add(new Ponto(x,y));
        }
        novoPoligono = new Quadrado(novosPontos);
        return  novoPoligono;
    }

    /**
     * @param newCentroidX Cordenada X do novo centroide
     * @param newCentroidY Cordenada Y do novo centroide
     * @return novo Poligono movido para o novo centroide
     */
    public Quadrado translateToNewCentroid(int newCentroidX, int newCentroidY) {
        List<Ponto> originalPoints = this.getPoligonos();
        List<Ponto> translatedPoints = new ArrayList<>();
        double currentCentroidX = 0;
        double currentCentroidY = 0;

        // Calculate the current centroid of the polygon
        for (Ponto point : originalPoints) {
            currentCentroidX += point.getX();
            currentCentroidY += point.getY();
        }
        currentCentroidX /= originalPoints.size();
        currentCentroidY /= originalPoints.size();

        // Calculate the difference between the current centroid and the new centroid
        int deltaX = newCentroidX - (int)currentCentroidX;
        int deltaY = newCentroidY - (int)currentCentroidY;

        // Translate each point by the difference to align the centroid with the new centroid
        for (Ponto point : originalPoints) {
            translatedPoints.add(new Ponto(point.getX() + deltaX, point.getY() + deltaY));
        }

        return new Quadrado(translatedPoints);
    }




}
