import RenderEngine.*;
import RenderEngine.Window;
import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        final int width = 800;
        final int height = 800;

        UIRect rect = new UIRect(width/2-50, height/2-50, 100, 100, 0, Color.RED);
        UIRect rect2 = new UIRect(width/2-25, height/2-25, 50, 50, 0, Color.BLUE);

        Window window = new Window(new UIElement[] { rect, rect2 }, "Test Window");

        window.setSize(800, 600);
        window.setVisible(true);

        window.draw();
    }
}
