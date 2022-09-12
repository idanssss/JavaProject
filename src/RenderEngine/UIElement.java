package RenderEngine;

import java.awt.*;

// Base class for UIElement
public class UIElement {

    // region Properties

    // --- Tag ---

    private final String tag;
    public String getTag() { return tag; }


    // --- Position ---

    protected int x, y;

    public int getX() { return x; }
    public int getY() { return y; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }


    // --- Render Order ---

    private final int renderOrder;
    public int getRenderOrder() { return renderOrder; }

    // endregion

    // region Constructors

    public UIElement(String tag) { this(0, tag); }

    public UIElement(int renderOrder, String tag) { this(0, 0, renderOrder, tag); }

    public UIElement(int x, int y, String tag) { this(x, y, 0, tag); }

    public UIElement(int x, int y, int renderOrder, String tag) {
        this.x = x;
        this.y = y;

        this.renderOrder = renderOrder;

        this.tag = tag;
    }

    // endregion

    // region Rendering Methods

    public void render(Graphics g) {}

    // endregion
}
