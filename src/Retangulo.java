import java.util.List;
import java.util.ArrayList;

public class Retangulo extends Poligono {

    public Retangulo(List<Ponto> pontos) {
        super(pontos);
        if (!isRetangulo(pontos)) {
            System.out.println("Retangulo:vi");
            System.exit(0);
        }
    }

    public boolean isRetangulo(List<Ponto> pontos) {
        if (pontos.size() != 4) {
            return false;
        }
        List<SegmentoReta> segmentoRetangulo = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            segmentoRetangulo.add(new SegmentoReta(pontos.get(i), pontos.get((i + 1) % 4)));
        }

        for (int i = 0; i < 4; i++) {
            if (segmentoRetangulo.get(i).angleBetweenSegments(segmentoRetangulo.get((i + 1) % 4)) != 90) {
                return false;
            }
        }

        if (pontos.get(0).dist(pontos.get(1)) != pontos.get(2).dist(pontos.get(3)) ||
                pontos.get(1).dist(pontos.get(2)) != pontos.get(3).dist(pontos.get(0))) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "Retangulo: " + getPoligonos();
    }

    public Retangulo rotate(int rotAngle, double xP, double yP) {
        List<Ponto> novosPontos = new ArrayList<>();
        double angle = Math.toRadians(rotAngle);
        for (Ponto ponto : getPoligonos()) {
            int x = (int) (Math.round(xP + ((ponto.getX() - xP) * Math.cos(angle)) - ((ponto.getY() - yP) * Math.sin(angle))));
            int y = (int) (Math.round(yP + ((ponto.getX() - xP) * Math.sin(angle)) + ((ponto.getY() - yP) * Math.cos(angle))));
            novosPontos.add(new Ponto(x, y));
        }
        return new Retangulo(novosPontos);
    }

    public Retangulo rotate(int rotAngle) {
        Double[] centroide = calculateCentroide(new ArrayList<>(getPoligonos()));
        return rotate(rotAngle, centroide[0], centroide[1]);
    }
}
