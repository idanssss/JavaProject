package RenderEngine;

import java.awt.*;

public class UIRect extends UIElement {

    // region Properties

    private int width, height;
    private Color color;

    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public Color getColor() { return color; }

    public void setWidth(int width) {
        if (width <= 0)
            throw new IllegalArgumentException("Width must be greater than 0");

        this.width = width;
    }

    public void setHeight(int height) {
        if (height <= 0)
            throw new IllegalArgumentException("Height must be greater than 0");

        this.height = height;
    }

    public void setColor(Color color) { this.color = color; }

    // endregion

    // region Constructors

    public UIRect(int x, int y, int width, int height, Color color) {
        this(x, y, width, height,  0, color);
    }

    public UIRect(int x, int y, int width, int height, int renderOrder, Color color) {
        super(x, y, renderOrder, "Cube");

        setWidth(width);
        setHeight(height);
        setColor(color);
    }

    // endregion

    // region Rendering Methods

    @Override
    public void render(Graphics g) {
        g.setColor(color);

        int x = getX() - getWidth()/2;
        int y = getY() - getHeight()/2;

        g.fillRect(x, y, width, height);
    }

    // endregion
}
