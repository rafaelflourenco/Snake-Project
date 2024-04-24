import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

class QuadradoTest {
    @Test
    public void testQuadrado1() { // Test to verify if the function returns false when the points do not form a square
        List<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(1, 0));
        pontos.add(new Ponto(3, 0));
        pontos.add(new Ponto(3, 4));
        pontos.add(new Ponto(1, 4));
        Quadrado q1 = new Quadrado(pontos);

        assertFalse(q1.isQuadrado(pontos)); // The points do not form a square due to unequal sides
    }

    @Test
    public void testQuadrado2() { // Test to verify the toString function of Quadrado
        List<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(1, 0));
        pontos.add(new Ponto(3, 0));
        pontos.add(new Ponto(3, 2));
        pontos.add(new Ponto(1, 2));
        Quadrado p1 = new Quadrado(pontos);
        assertEquals("Quadrado: [(1,0), (3,0), (3,2), (1,2)]", p1.toString());
        // Expected: Quadrado: [(1,0), (3,0), (3,2), (1,2)]
    }
}
