import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class MyPanel extends JPanel {
    private final int BOX_SIZE = 10;
    private Snake snake;
    private Food comida;
    private String direction = "RIGHT";

    public MyPanel() {
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.BLACK);
        List<Ponto> pontos = new ArrayList<>();
        pontos.add(new Ponto(50, 50));  // Simplified to start at a clear position
        pontos.add(new Ponto(50, 60));
        pontos.add(new Ponto(60, 60));
        pontos.add(new Ponto(60, 50));

        List<Ponto> pontos2 = new ArrayList<>();
        pontos2.add(new Ponto(100, 100));
        pontos2.add(new Ponto(100, 100 + BOX_SIZE));
        pontos2.add(new Ponto(100 + BOX_SIZE, 100 + BOX_SIZE));
        pontos2.add(new Ponto(100 + BOX_SIZE, 100));

        Quadrado quadradoComida = new Quadrado(pontos2);
        comida = new Food(quadradoComida);
        Quadrado quadradoInicial = new Quadrado(pontos);
        snake = new Snake(quadradoInicial);
        snake.setComida(comida);
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String currentDirection = snake.getDirection();
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        if (!"DOWN".equals(currentDirection))
                            snake.setDirection("UP");
                        break;
                    case KeyEvent.VK_DOWN:
                        if (!"UP".equals(currentDirection))
                            snake.setDirection("DOWN");
                        break;
                    case KeyEvent.VK_LEFT:
                        if (!"RIGHT".equals(currentDirection))
                            snake.setDirection("LEFT");
                        break;
                    case KeyEvent.VK_RIGHT:
                        if (!"LEFT".equals(currentDirection))
                            snake.setDirection("RIGHT");

                        break;
                }
            }
        });

        // Simple game loop
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                    snake.move();
                    repaint();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        for (Quadrado quad : snake.getBody()) {
            for (Ponto p : quad.getPoligonos()) {
                g.fillRect(p.getX(), p.getY(), BOX_SIZE, BOX_SIZE);
            }
        }
        g.setColor(Color.RED);
        Quadrado foodQuad = comida.getQuadrado();
        for (Ponto p : foodQuad.getPoligonos()) {
            g.fillRect(p.getX(), p.getY(), BOX_SIZE, BOX_SIZE);
        }
    }

}
