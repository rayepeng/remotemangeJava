package server;


import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.github.sarxos.webcam.WebcamUtils;
import com.github.sarxos.webcam.util.ImageUtils;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;

public class camera implements Serializable {
    private static int num = 0;
    public byte[] imagebyte; //传输的图片字节数组

    public void capture() throws IOException {
        final Webcam webcam = Webcam.getDefault();
        String fileName = "D://" + num;
        //只需要实现截屏功能就行
        WebcamUtils.capture(webcam, fileName, ImageUtils.FORMAT_PNG);
        //转称字节数组
        BufferedImage image = ImageIO.read(new FileInputStream(fileName + ".png"));
        BufferedImage newimage = new BufferedImage(1024, 768, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = newimage.createGraphics();
        g.drawImage(image, 0, 0, 1024, 768, null);

        this.imagebyte = getByteImage(image);

    }
    private byte[] getByteImage(BufferedImage image) throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bout);
        encoder.encode(image);
        return  bout.toByteArray();
    }

    public static void main(String[] args) throws IOException {

        camera cameraone = new camera();
        cameraone.capture();

    }
//    public static void main(String[] args) throws IOException {
//
//        final Webcam webcam = Webcam.getDefault();
//        webcam.setViewSize(WebcamResolution.VGA.getSize());
//        //webcam.setViewSize(WebcamResolution.VGA.getSize());
//        WebcamPanel panel = new WebcamPanel(webcam);
//        panel.setFPSDisplayed(true);
//        panel.setDisplayDebugInfo(true);
//        panel.setImageSizeDisplayed(true);
//        panel.setMirrored(true);
//
//        final JFrame window = new JFrame("摄像头");
//        window.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosed(WindowEvent e) {
//                webcam.close();
//                window.dispose();
//            }
//        });
//
//
//        final JButton button = new JButton("截图");
//        window.add(panel, BorderLayout.CENTER);
//        window.add(button, BorderLayout.SOUTH);
//        window.setResizable(true);
//        window.pack();
//        window.setVisible(true);
//
//        button.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                button.setEnabled(false);
//                String fileName = "D://" + num;
//                WebcamUtils.capture(webcam, fileName, ImageUtils.FORMAT_PNG);
//                SwingUtilities.invokeLater(new Runnable() {
//                    @Override
//                    public void run() {
//                        JOptionPane.showMessageDialog(null, "截图成功");
//                        button.setEnabled(true);
//                        num++;
//                        return;
//
//                    }
//                });
//            }
//        });
//
//
//    }
}
