import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Poligono {

    private final List<Ponto> poligonos;
    private final List<SegmentoReta> segmentoPol;

    public Poligono(List<Ponto> p) {
        if (p.size() <= 2) {
            System.out.println("Poligono:vi");
            System.exit(0);
        }
        Reta reta = new Reta(p);
        List<SegmentoReta> s = new ArrayList<>();
        for (int i = 0; i < p.size(); i++) {
            s.add(new SegmentoReta(reta.getRetas().get(i), reta.getRetas().get((i + 1) % p.size())));
        }

        for (int i = 2; i < p.size(); i++) {
            if (reta.onSegment(p.get(i))) {
                System.out.println("Poligono:vi");
                System.exit(0);
            }
        }

        for (int i = 0; i < p.size(); i++) {
            for (int j = i + 1; j < p.size(); j++) {
                if (s.get(i).intersects(s.get(j))) {
                    System.out.println("Poligono:vi");
                    System.exit(0);
                }
            }
        }
        this.segmentoPol = s;
        List<Ponto> mediano = new ArrayList<>();
        for (int i = 0; i < p.size() - 1; i++) {
            if (i == 0) {
                mediano.add(s.get(i).getA());
                mediano.add(s.get(i).getB());
            } else {
                mediano.add(s.get(i).getB());
            }
        }
        this.poligonos = mediano;
    }

    @Override
    public String toString() {
        return "Poligono de " + this.poligonos.size() + " vertices: " + this.poligonos;
    }

    public boolean Poligonosintersect(Poligono p) {
        for (int pontoIndex = 0; pontoIndex < this.poligonos.size(); pontoIndex++) {
            for (int poliIndex = 0; poliIndex < p.getPoligonos().size(); poliIndex++) {
                if (this.segmentoPol.get(pontoIndex).intersects(p.getSegmentoPol().get(poliIndex)) || p.equals(this)) {

                    return true;
                }
            }
        }
        return false;
    }

    public Double[] calculateCentroide(List<Ponto> pontos) {
        double somaX = 0, somaY = 0;
        for (Ponto ponto : pontos) {
            somaX += ponto.getX();
            somaY += ponto.getY();
        }
        return new Double[]{somaX / pontos.size(), somaY / pontos.size()};
    }

    public Poligono rotate(int rotAngle, double xP, double yP) {
        List<Ponto> pontos = this.getPoligonos();
        List<Ponto> novosPontos = new ArrayList<>();
        double angle = Math.toRadians(rotAngle);
        for (Ponto ponto : pontos) {
            int x = (int) (Math.round(xP + ((ponto.getX() - xP) * Math.cos(angle) - (ponto.getY() - yP) * Math.sin(angle))));
            int y = (int) (Math.round(yP + ((ponto.getX() - xP) * Math.sin(angle) + (ponto.getY() - yP) * Math.cos(angle))));
            novosPontos.add(new Ponto(x, y));
        }
        return new Poligono(novosPontos);
    }

    public Poligono rotate(int rotAngle) {
        Double[] ponto = calculateCentroide(new ArrayList<>(poligonos));
        return rotate(rotAngle, ponto[0], ponto[1]);
    }

    public boolean samePoints(Poligono other) {
        if (other == null || poligonos.size() != other.getPoligonos().size()) {
            return false;
        }
        for (Ponto p1 : poligonos) {
            boolean matchFound = false;
            for (Ponto p2 : other.getPoligonos()) {
                if (p1.equals(p2)) {
                    matchFound = true;
                    break;
                }
            }
            if (!matchFound) return false;
        }
        return true;
    }

    public Poligono Translate(int dx, int dy){
        List<Ponto> pontos = this.getPoligonos();
        Poligono novoPoligono;
        List<Ponto> novosPontos = new ArrayList<>(pontos);
        for(int i = 0; i < pontos.size(); i++){
            int x = pontos.get(i).getX() + dx;
            int y = pontos.get(i).getY() + dy;
            novosPontos.add(new Ponto(x,y));
        }
        novoPoligono = new Poligono(novosPontos);
        return  novoPoligono;
    }

    /**
     * @param newCentroidX Cordenada X do novo centroide
     * @param newCentroidY Cordenada Y do novo centroide
     * @return novo Poligono movido para o novo centroide
     */
    public Poligono translateToNewCentroid(int newCentroidX, int newCentroidY) {
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

        return new Poligono(translatedPoints);
    }

    public List<Ponto> getPoligonos() {
        return poligonos;
    }

    public List<SegmentoReta> getSegmentoPol() {
        return segmentoPol;
    }
}
