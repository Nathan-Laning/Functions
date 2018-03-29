import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Converts ImageData to Normal Map Data, then it can be called in formats.
 */

public class Convert {
    private BufferedImage source,output;
    private int[][] r,g,b,a;
    Convert(String imageName){
        loadImage(imageName);
        outputImage(source);
        rebuild();
    }
    public void outputImage(){
        Graphics2D g = output.createGraphics();
        g.drawImage(output, 0, 0, null);
        g.dispose();
    }
    private void outputImage(BufferedImage bi){
        Graphics2D g = bi.createGraphics();
        g.drawImage(bi, 0, 0, null);
        g.dispose();
    }
    private void loadImage(String imageName){
        try {
            source = ImageIO.read(new File(imageName));
            r=new int[source.getHeight()][source.getWidth()];
            g=new int[source.getHeight()][source.getWidth()];
            b=new int[source.getHeight()][source.getWidth()];
            a=new int[source.getHeight()][source.getWidth()];
            for (int i = 0; i < source.getHeight(); i++) {
                for (int j = 0; j < source.getWidth(); j++) {
                    int[] colors=convertToRGBA(source.getRGB(j,i));
                    r[i][j]=colors[0];
                    g[i][j]=colors[1];
                    b[i][j]=colors[2];
                    a[i][j]=colors[3];
                }
            }
        }catch (IOException i) {
            System.out.println("failed to find file");
        }
    }
    private int[] convertToRGBA(int source){
        int[] RGBA=new int[4];
        Color color =  new Color(source,true);
        RGBA[0]=color.getRed();
        RGBA[1]=color.getGreen();
        RGBA[2]=color.getBlue();
        RGBA[3]=color.getAlpha();
        return RGBA;
    }
    private void rebuild(){
        output = new BufferedImage(
                source.getWidth(), output.getHeight(),
                BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < output.getHeight(); i++) {
            for (int j = 0; j < output.getWidth(); j++) {
                Color color = new Color(r[i][j],g[i][j],b[i][j],a[i][j]);
                source.setRGB(i,j,color.getRGB());

            }
        }
    }
}
