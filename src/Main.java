import RenderEngine.*;
import RenderEngine.Window;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        final int width = 800;
        final int height = 800;

        UIRect rect = new UIRect(0, 0, 100, 100, 0, Color.RED);
        UIRect rect2 = new UIRect(0, 0, 50, 50, 0, Color.BLUE);

        Window window = new Window(new UIElement[] { rect, rect2 }, "Test Window");

        window.setSize(width, height);
        window.setVisible(true);

        window.draw();
    }
}
