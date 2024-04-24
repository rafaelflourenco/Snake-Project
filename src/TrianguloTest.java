import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

class TrianguloTest {
    @Test
    public void testPositive() { // Test to verify if a set of points can form a triangle
        List<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(1, 0));
        pontos.add(new Ponto(3, 0));
        pontos.add(new Ponto(2, 2));
        Triangulo triangulo = new Triangulo(pontos);
        assertTrue(triangulo.isTriangulo(pontos)); // Assuming the method also checks using these points
    }

    @Test
    public void testNegative() { // Test to verify if a set of points does not form a triangle due to collinearity
        List<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(1, 0));
        pontos.add(new Ponto(3, 0));
        pontos.add(new Ponto(2, 0));
        Triangulo triangulo = new Triangulo(pontos);
        assertFalse(triangulo.isTriangulo(pontos)); // Assuming the triangle creation doesn't prevent this assertion from running
    }

    @Test
    public void testParaString() { // Test the toString method to verify correct output
        List<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(1, 0));
        pontos.add(new Ponto(3, 0));
        pontos.add(new Ponto(2, 2));
        Triangulo triangulo = new Triangulo(pontos);
        assertEquals("Triangulo: [(1,0), (3,0), (2,2)]", triangulo.toString());
        // Expected: Triangulo: [(1,0), (3,0), (2,2)]
    }
}
