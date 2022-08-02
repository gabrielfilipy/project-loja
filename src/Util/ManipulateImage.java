package Util;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class ManipulateImage {

    public ManipulateImage() { }
    
    public static BufferedImage setImageSize(String caminhoImg, Integer imgLargura, Integer imgAltura) {
        Integer newWidth = null;
        Integer newHeight = null;
        Double size = null;
        Graphics2D g2d = null;
        BufferedImage image = null, newImage = null;

        try {
            image = ImageIO.read(new File(caminhoImg));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            Logger.getLogger(ManipulateImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        newWidth =  imgLargura;
        newHeight =  imgAltura;
        newImage = new BufferedImage(newWidth.intValue(), newHeight.intValue(), BufferedImage.TYPE_INT_RGB);
        g2d = newImage.createGraphics();
        g2d.drawImage(image, 0, 0, newWidth.intValue(), newHeight.intValue(), null);

        return newImage;
    }
    
}
