import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Snake {
    private LinkedList<Quadrado> body; // List to hold the segments of the snake
    private Quadrado head; // This will always be the first element of the list
    private String direction;
    private Food comida;
    public Snake(Quadrado quadradoInicial){
        body = new LinkedList<>();
        body.add(quadradoInicial);
        head = quadradoInicial;
        direction = "Right";
    }
    public void setDirection(String direction) {
        this.direction = direction;
    }
    public Quadrado getHead() {
        return head;
    }
    public LinkedList<Quadrado> getBody() {
        return body;
    }
    public void move() {
        Double[] centroid = head.calculateCentroide(head.getPoligonos());
        int x = centroid[0].intValue();
        int y = centroid[1].intValue();

        switch (direction) {
            case "UP":
                y -= 5;
                break;
            case "DOWN":
                y += 5;
                break;
            case "LEFT":
                x -= 5;
                break;
            case "RIGHT":
                x += 5;
                break;
        }
        Quadrado movedHead = head.translateToNewCentroid(x , y );
        body.addFirst(movedHead);
        head = movedHead;
        body.removeLast();
        if(head.Poligonosintersect(comida.getQuadrado())){
            grow();
            comida.deactivate();
            comida.regenerate(500,500);
        }
    }
    public void grow() {
        // Create a new Quadrado at the current head's position for the new segment
        List<Ponto> newHeadPoints = new ArrayList<>();
        for (Ponto ponto : head.getPoligonos()) {
            // Assuming a deep copy is necessary to avoid mutating the original points
            newHeadPoints.add(new Ponto(ponto.getX(), ponto.getY()));
        }
        Quadrado newHead = new Quadrado(newHeadPoints);

        // Add the new segment at the head's position (it will move forward on the next move call)
        body.addFirst(newHead);
        head = newHead;

    }



    public String getDirection() {
        return direction;
    }

    public void setComida(Food comida) {
        this.comida = comida;
    }
}
