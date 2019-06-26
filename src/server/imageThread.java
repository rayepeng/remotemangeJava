package server;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class imageThread implements Serializable {
    transient public Robot robot; //Robot不可序列化
    public Dimension dm; //屏幕尺寸
    public Rectangle rect;
    public byte[] imagebyte;
    public int size;
    //转成构造方法，实例化一个对象的时候就已经有imagebyte这些数据了
    public imageThread() {
        try{
            robot = new Robot();
            dm = Toolkit.getDefaultToolkit().getScreenSize();
            rect = new Rectangle(dm);
//BufferedImage是无法反序列化的，所以转成iamgebyte实现序列化传输
            BufferedImage img = robot.createScreenCapture(rect);
            imagebyte = getByteImage(img);


        }catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //debug用的
    public void setSize(int size) {
        this.size = size;
    }
    private byte[] getByteImage(BufferedImage image) throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bout);
        encoder.encode(image);
        return  bout.toByteArray();
    }

    public static void main(String[] args) {
        imageThread ima = new imageThread();
        // ima.getImage();

    }


}
