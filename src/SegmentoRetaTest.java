import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SegmentoRetaTest {
    @Test
    public void testPositive() // Testa a função intersects, para verificar se um segmento de reta intercepta com outro segmento
    {
        Ponto[] pontos = new Ponto[2];
        pontos[0] = new Ponto(1,3);
        pontos[1] = new Ponto(8,3);
        SegmentoReta seg = new SegmentoReta(pontos[0],pontos[1]);
        Ponto[] pontos2 = new Ponto[2];
        pontos2[0] = new Ponto(4,5);
        pontos2[1] = new Ponto(4,0);
        SegmentoReta seg2 = new SegmentoReta(pontos2[0],pontos2[1]);
        assertTrue(seg.intersects(seg2));

    }

    @Test
    public void testNegative() // Testa a função intersects, para verificar se um segmento de reta não intercepta com outro segmento
    {
        Ponto[] pontos = new Ponto[2];
        pontos[0] = new Ponto(1,3);
        pontos[1] = new Ponto(8,3);
        SegmentoReta seg = new SegmentoReta(pontos[0],pontos[1]);
        Ponto[] pontos2 = new Ponto[2];
        pontos2[0] = new Ponto(1,5);
        pontos2[1] = new Ponto(1,0);
        SegmentoReta seg2 = new SegmentoReta(pontos2[0],pontos2[1]);
        assertFalse(seg.intersects(seg2));

    }

    @Test
    public void testAngle() // Testa a função angleBetweenSegments, para verificar o angulo que um segmento de reta faz com outro segmento
    {
        Ponto[] pontos = new Ponto[2];
        pontos[0] = new Ponto(1,3);
        pontos[1] = new Ponto(8,3);
        SegmentoReta seg = new SegmentoReta(pontos[0],pontos[1]);
        Ponto[] pontos2 = new Ponto[2];
        pontos2[0] = new Ponto(4,5);
        pontos2[1] = new Ponto(4,0);
        SegmentoReta seg2 = new SegmentoReta(pontos2[0],pontos2[1]);
        assertEquals(90.00,seg.angleBetweenSegments(seg2));

    }



}