import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

class PoligonoTest {
    @Test
    public void testPoligono1() { // Test to verify that the function returns false when polygons do not touch
        List<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(4, 5));
        pontos.add(new Ponto(8, 5));
        pontos.add(new Ponto(8, 7));
        pontos.add(new Ponto(5, 7));
        Poligono p1 = new Poligono(pontos);

        List<Ponto> pontos2 = new ArrayList<>();
        pontos2.add(new Ponto(7, 1));
        pontos2.add(new Ponto(9, 1));
        pontos2.add(new Ponto(9, 3));
        pontos2.add(new Ponto(7, 3));
        Poligono p2 = new Poligono(pontos2);

        assertFalse(p1.Poligonosintersect(p2));
    }

    @Test
    public void testPoligono2() { // Test to verify the intersection function for two polygons
        List<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(5, 5));
        pontos.add(new Ponto(8, 5));
        pontos.add(new Ponto(8, 7));
        pontos.add(new Ponto(5, 7));
        Poligono p1 = new Poligono(pontos);

        List<Ponto> pontos2 = new ArrayList<>();
        pontos2.add(new Ponto(7, 4));
        pontos2.add(new Ponto(9, 4));
        pontos2.add(new Ponto(9, 6));
        pontos2.add(new Ponto(7, 6));
        Poligono p2 = new Poligono(pontos2);

        assertTrue(p1.Poligonosintersect(p2));
    }

    @Test
    public void testPoligono3() { // Test for false when polygons do not touch
        List<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(1, 1));
        pontos.add(new Ponto(4, 2));
        pontos.add(new Ponto(4, 5));
        pontos.add(new Ponto(2, 3));
        Poligono p1 = new Poligono(pontos);

        List<Ponto> pontos2 = new ArrayList<>();
        pontos2.add(new Ponto(6, 4));
        pontos2.add(new Ponto(7, 2));
        pontos2.add(new Ponto(9, 4));
        Poligono p2 = new Poligono(pontos2);

        assertFalse(p1.Poligonosintersect(p2));
    }

    @Test
    public void testPoligono4() { // Test for true when polygons intersect
        List<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(1, 1));
        pontos.add(new Ponto(4, 2));
        pontos.add(new Ponto(4, 5));
        pontos.add(new Ponto(2, 3));
        Poligono p1 = new Poligono(pontos);

        List<Ponto> pontos2 = new ArrayList<>();
        pontos2.add(new Ponto(3, 3));
        pontos2.add(new Ponto(7, 2));
        pontos2.add(new Ponto(9, 4));
        Poligono p2 = new Poligono(pontos2);

        assertTrue(p1.Poligonosintersect(p2));
    }

    @Test
    public void testPoligono5() { // Test for colinearity error
        List<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(10, 10));
        pontos.add(new Ponto(20, 10));
        pontos.add(new Ponto(30, 10));
        Poligono p1 = new Poligono(pontos);

        assertEquals("Poligono:vi", p1.toString());
    }

    @Test
    public void testPoligono6() { // Test the toString function of Polygon
        List<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(5, 5));
        pontos.add(new Ponto(8, 6));
        pontos.add(new Ponto(8, 7));
        pontos.add(new Ponto(5, 7));
        Poligono p1 = new Poligono(pontos);
        assertEquals("Poligono de 4 vertices: [(5,5), (8,6), (8,7), (5,7)]", p1.toString());
    }

    @Test
    public void testRotate() { // Test the rotate function around the centroid of Polygon
        List<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(1, 1));
        pontos.add(new Ponto(3, 1));
        pontos.add(new Ponto(3, 5));
        pontos.add(new Ponto(1, 5));
        Retangulo p1 = new Retangulo(pontos);
        Poligono pol = p1.rotate(90);
        assertEquals("Retangulo: [(4,2), (4,4), (0,4), (0,2)]", pol.toString());
    }
}
