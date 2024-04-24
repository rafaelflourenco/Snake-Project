import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

class RetanguloTest {

    @Test
    public void testIsRetanguki() { // Test the function for checking points possibility to form a rectangle
        List<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(0, 1));
        pontos.add(new Ponto(2, 1));
        pontos.add(new Ponto(2, 3));
        pontos.add(new Ponto(0, 3));

        Retangulo r = new Retangulo(pontos);

        assertTrue(r.isRetangulo(pontos)); // Verify if the points can form a rectangle
    }

    @Test
    public void testRetanguloParaString() { // Test to verify the toString function of Retangulo
        List<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(1, 0));
        pontos.add(new Ponto(3, 0));
        pontos.add(new Ponto(3, 2));
        pontos.add(new Ponto(1, 2));

        Retangulo p1 = new Retangulo(pontos);
        assertEquals("Retangulo: [(1,0), (3,0), (3,2), (1,2)]", p1.toString());
        // Expected output: Retangulo: [(1,0), (3,0), (3,2), (1,2)]
    }
}
