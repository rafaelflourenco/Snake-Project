import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

class RetaTest {

    @Test
    public void testPositive() { // Test if a point is colinear with a segment of the line
        List<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(1, 0));
        pontos.add(new Ponto(8, 0));
        Reta reta = new Reta(pontos);
        Ponto terceiroPonto = new Ponto(5, 0);
        assertTrue(reta.onSegment(terceiroPonto));
    }

    @Test
    public void testNegative() { // Test if a point is not colinear with a segment of the line
        List<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(1, 0));
        pontos.add(new Ponto(8, 0));
        Reta reta = new Reta(pontos);
        Ponto terceiroPonto = new Ponto(3, 4);
        assertFalse(reta.onSegment(terceiroPonto));
    }

}
