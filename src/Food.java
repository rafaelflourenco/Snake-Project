public class Food {
    private Quadrado quadrado;
    private boolean isActive;

    public Food(Quadrado quadrado) {
        this.quadrado = quadrado;
        this.isActive = true;  // Initially, food is active
    }

    public void deactivate() {
        this.isActive = false;  // Deactivates the food
    }

    public void activate() {
        this.isActive = true;  // Reactivates the food
    }

    public boolean isActive() {
        return isActive;
    }
    public Quadrado getQuadrado() {
        return quadrado;
    }

    public void regenerate(int width, int height) {
        // Randomly place the food in a new position
        int x = (int) (Math.random() * (width - 10));
        int y = (int) (Math.random() * (height - 10));
        this.setLocation(x, y);
        activate(); // Make food visible again after regeneration
    }


    public void setLocation(int newX, int newY) {
        if (this.getQuadrado().getPoligonos().isEmpty()) return;

        // Calculate current top-left corner as a reference
        int currentX = Integer.MAX_VALUE;
        int currentY = Integer.MAX_VALUE;
        for (Ponto p : this.getQuadrado().getPoligonos()) {
            if (p.getX() < currentX) currentX = p.getX();
            if (p.getY() < currentY) currentY = p.getY();
        }

        // Calculate the shift required to move the Quadrado to the new location
        int deltaX = newX - currentX;
        int deltaY = newY - currentY;

        // Apply the shift to each point
        for (int i = 0; i < this.getQuadrado().getPoligonos().size(); i++) {
            Ponto p = this.getQuadrado().getPoligonos().get(i);
            this.getQuadrado().getPoligonos().set(i, new Ponto(p.getX() + deltaX, p.getY() + deltaY));
        }
    }
}
