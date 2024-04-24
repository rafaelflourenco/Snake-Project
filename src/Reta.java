import java.util.List;
import java.util.ArrayList;

public class Reta {
    private List<Ponto> retas;

    public Reta(List<Ponto> pontos) {
        if (pontos.get(0).equals(pontos.get(pontos.size() - 1))) {  // Check if the first point connects back to the last
            System.out.println("Reta:vi");
            System.exit(0);
        }
        for (int i = 0; i < pontos.size(); i++) {
            Ponto a = pontos.get(i);
            Ponto b = pontos.get((i + 1) % pontos.size());
            if (a.equals(b)) { // Check if two points are the same (overlapping)
                System.out.println("Reta:vi");
                System.exit(0);
            }
        }
        this.retas = new ArrayList<>(pontos);
    }

    public boolean onSegment(Ponto p3) {
        Ponto p1 = retas.get(0);
        Ponto p2 = retas.get(1);
        int area = (p1.getX() * (p2.getY() - p3.getY())) + (p2.getX() * (p3.getY() - p1.getY())) + (p3.getX() * (p1.getY() - p2.getY()));
        return Math.abs(area) < 1e-9; // Check for collinearity
    }

    public List<Ponto> getRetas() {
        return retas;
    }
}
