import processing.core.PApplet;

public class Wall {
     float x;
     float openingY;
     float wallWidth;
     float wallHeight;
     float speed;

    public Wall(float x, float openingY, float wallWidth, float wallHeight, float speed) {
        this.x = x;
        this.openingY = openingY;
        this.wallWidth = wallWidth;
        this.wallHeight = wallHeight;
        this.speed = speed;
    }

    public void draw(PApplet p) {
        p.fill(0, 0, 0); // Set the color of the walls
        p.rect(x, 0, wallWidth, openingY); // Upper wall
        p.rect(x, 600, wallWidth, p.height - openingY - wallHeight); // Lower wall
    }

    public void move() {
        x -= speed;
    }

    public boolean isOutOfScreen() {
        return x + wallWidth < 0;
    }

    
}