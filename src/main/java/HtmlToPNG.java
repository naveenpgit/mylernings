import com.google.common.io.Files;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Paths;

public class HtmlToPNG {
    public static void main(String[] args) throws Exception {
        String html = new String(java.nio.file.Files.readAllBytes(Paths.get("input.html")));

        int width = 600, height = 200;

        BufferedImage image = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice().getDefaultConfiguration()
                .createCompatibleImage(width, height);

        Graphics graphics = image.createGraphics();

        JEditorPane jep = new JEditorPane("text/html", html);
        jep.setSize(width, height);
        jep.print(graphics);
        ImageIO.write(image, "png", new File("Image.png"));
    }
}
