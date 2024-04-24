import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SnakeTest {
    @Test
    public void testMover() {
        // Testa o método mover para vesr se os pontos do quadrado são atualizados corretamente

        List<Ponto> pontosEsperados = Arrays.asList(
                new Ponto(1, 1),
                new Ponto(1, 3),
                new Ponto(3, 2)
        );
        Triangulo cabeca = new Triangulo(pontosEsperados);
        Double[] centroideAntigo = cabeca.calculateCentroide(pontosEsperados);
        System.out.println(cabeca.toString());

        Triangulo novoTriangulo = cabeca.rotate(90);
        List<Ponto> pontosDepoisDeRotate = novoTriangulo.getPoligonos();
        for (Ponto ponto : pontosDepoisDeRotate) {
            int antigo = ponto.getY();
            ponto.setY(antigo+2);
        }
        System.out.println(novoTriangulo.toString());
    }

    @Test
    public void testCollision() { // Test to verify the intersection function for two polygons
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
    public void grow(){
        List<Ponto> pontosEsperados = Arrays.asList(
                new Ponto(1, 1),
                new Ponto(1, 3),
                new Ponto(3, 2)
        );
        Triangulo cabeca = new Triangulo(pontosEsperados);
        System.out.println(cabeca.toString());
        List<Ponto> pontosQuadrado = Arrays.asList(
                new Ponto(1,1),
                new Ponto( 1,3),
                new Ponto(3,3),
                new Ponto(3,1)

        );
        Quadrado novoQuadrado = new Quadrado(pontosQuadrado);
        System.out.println(novoQuadrado.toString());
        Triangulo novoTriangulo = cabeca.rotate(90);
        List<Ponto> pontosDepoisDeRotate = novoTriangulo.getPoligonos();
        for (Ponto ponto : pontosDepoisDeRotate) {
            int antigo = ponto.getY();
            ponto.setY(antigo+2);
        }
        System.out.println(novoTriangulo.toString());
    }
}