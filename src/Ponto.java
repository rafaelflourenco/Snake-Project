/**
 * Classe Ponto que tem como argumentos as cordenadas de um ponto, contem um método para verificar se o ponto está no 1º quadrante, um método para calcular a distancia entre dois pontos e um método que dado 3 pontos verifica a orientação do segmento de reta formado.
 * @author (Rafael Lourenço 79771)
 * @version (1.0.0 - 25/02/2024)
 * @inv Ponto:vi - Ponto não se encontra no 1º quadrante
 */
public class Ponto {

    private int x, y;

    /**
     * Construtor que chama um método para verificar se o Ponto se encontra no 1º quadrante.
     * @param x Cordenada x
     * @param y Cordenada y
     */
    Ponto(int x, int y){
        checkFirstQuadrant(x,y);
    }

    /**
     * Método que verifica se o Ponto se encontra no 1º quadrante, se não estiver no 1º quadrante o método printa "Ponto:vi".
     * @param x Cordenada x
     * @param y Cordenada y
     */
    void checkFirstQuadrant (int  x, int y){
        if(x >= 0 && y >= 0){
            this.x = x;
            this.y = y;
        }
        else{
            System.out.println("Ponto:vi");
            System.exit(0);
        }

    }

    /**
     * Método que calcula e devolve a distancia entre 2 pontos
     * @param p Ponto
     * @return distancia entre 2 pontos
     */
    int dist (Ponto p) {

        int dx = x - p.x;

        int dy = y - p.y;

        return (int) Math.sqrt(dx*dx + dy*dy);

    }

    /**
     * Método que dado 3 pontos calcula a orientação do segmento de reta formado pelos 3 pontos
     * @param a Ponto 1
     * @param b Ponto 2
     * @param c Ponto 3
     * @see <a href="https://algs4.cs.princeton.edu/91primitives/">...</a>
     * @return +1 se os 3 pontos formarem um angulo anti-horario, -1 se formar angulo horario e 0 se forem colineares.
     */
    public static int ccw(Ponto a, Ponto b, Ponto c) {
        double result = (b.y - a.y) * (c.x - b.x) - (b.x - a.x) * (c.y - b.y);
        if(Math.abs(result) < 1e-9)
            return 0;
        return (result > 0) ? -1 : 1;
    }

    @Override
    public String toString() {
        return "(" +
                 x +
                "," + y +
                ')';
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}