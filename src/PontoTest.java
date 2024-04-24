import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PontoTest {

    @Test
    public void testNegative() // Testa o erro de cordenadas fora do 1 quadrante
    {
        assertEquals("Ponto:vi", new Ponto(-3, 0).toString());
        assertEquals("Ponto:vi", new Ponto(-3, -4).toString());
        assertEquals("Ponto:vi", new Ponto(3, -5).toString());
        assertEquals("Ponto:vi", new Ponto(3, 4).toString());
    }

    @Test
    public void testOritent() // Testa a função de orientação de um ponto
    {
        Ponto ponto0 = new Ponto(0,1);
        Ponto ponto1 = new Ponto(10,5);
        Ponto ponto2 = new Ponto(7,2);

        assertEquals(-1, Ponto.ccw(ponto0,ponto1,ponto2));
    }







}