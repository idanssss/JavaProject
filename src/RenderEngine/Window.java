package RenderEngine;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Window extends JFrame {

    // region UIElements
    private final ArrayList<UIElement> elements;

    public void addElement(UIElement element) {
        elements.add(element);
    }

    public void removeElementsWithTag(String tag) {
        for (int i = 0; i < elements.size(); i++) {
            if (elements.get(i).getTag().equals(tag)) {
                elements.remove(i);
                i--;
            }
        }
    }

    // Remove an element with a specific instance
    public boolean removeElement(UIElement element) {
        return elements.remove(element);
    }


    private boolean isOrderedByRenderOrder() {
        for (int i = 0; i < elements.size() - 1; i++) {
            if (elements.get(i).getRenderOrder() > elements.get(i + 1).getRenderOrder())
                return false;
        }

        return true;
    }

    private void orderByRenderOrder() {
        if (isOrderedByRenderOrder())
            return;

        // Sort the elements
        elements.sort(Comparator.comparingInt(UIElement::getRenderOrder));
    }

    // endregion

    // region Constructors

    public Window(UIElement[] els, String title) {
        this(title);

        for (UIElement el : els)
            addElement(el);
    }

    public Window(String title) {
        super(title);

        elements = new ArrayList<>();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Window() { this("Unnamed Window"); }

    // endregion

    // region Rendering Methods

    @Override
    public void paint(Graphics g) {}

    @Override
    public Graphics getGraphics() {
        Graphics g =  super.getGraphics();

        g.translate(getWidth()/2, getHeight()/2);

        return g;
    }

    public void repaint() { draw(); }

    public void draw() {
        orderByRenderOrder();

        Graphics g = getGraphics();

        for (UIElement el : elements)
            draw(el, g);
    }

    public void draw(int renderOrder) {
        orderByRenderOrder();

        Graphics g = getGraphics();

        for (UIElement el : elements) {
            if (el.getRenderOrder() == renderOrder)
                draw(el, g);
        }
    }

    public void draw(UIElement element, Graphics g) {
        element.render(g);
    }

    // endregion
}
