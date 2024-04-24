public class AreaQuadrado
{
    /*
     *  ld = LeftDown ru = RightUp
     */
    private Ponto ld, ru;


    /**
     * Cria a area/retangulo do poligono.
     *
     * @author (Diogo Silva a79764)
     * @version (1.0.0 - 19/02/24)
     * @param valores (X and Y)
     */
    public AreaQuadrado(int[] valores)
    {
        this.ld = new Ponto(valores[0], valores[1]);
        this.ru = new Ponto(valores[2], valores[3]);
    }
    public int getxMax() {
        return this.ld.getX();
    }
    public int getyMax() {
        return this.ld.getY();
    }
    public int getxMin() {
        return this.ru.getX();
    }
    public int getyMin() {
        return this.ru.getY();
    }

    /**
     * Check X and Y to see if they are in the first square (positives)
     *
     * @author (Diogo Silva a79764)
     * @version (1.0.0 - 19/02/24)
     * @return If it's in first squere = true or not.
     */

    public boolean intercept(AreaQuadrado pr1)
    {
        if((this.getxMax() == pr1.getxMax() && this.getxMin() == pr1.getxMin()) && ((this.getyMin() < pr1.getxMax() && pr1.getyMax() <= this.getyMax()) || (pr1.getyMin() <= this.getyMax() && this.getyMax() <= pr1.getyMax())))
        {
            return true;
        }
        else if ((this.getyMax() == pr1.getyMax() && this.getyMin() == pr1.getyMin()) && ((this.getxMin() < pr1.getxMax() && pr1.getxMax() < this.getxMax()) || (pr1.getxMin() < this.getxMax() && this.getxMax() < pr1.getxMax())))
        {
            return true;
        }
        else if(((this.getxMin() < pr1.getxMax() && pr1.getxMax() < this.getxMax()) || (pr1.getxMin() < this.getxMax() && this.getxMax() < pr1.getxMax())) && ((this.getyMin() < pr1.getyMax() && pr1.getyMax() < this.getyMax()) || (pr1.getyMin() < this.getyMax() && this.getyMax() < pr1.getyMax())))
        {
            return true;
        }
        return false;
    }
}
