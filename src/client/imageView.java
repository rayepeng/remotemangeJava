package client;

import javax.swing.*;

import server.imageThread;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class imageView extends JFrame implements WindowListener {
    private JLabel backGround;


    //imageThread image ;
    public imageThread imagethread;

    public imageView(imageThread imagethread) {

        this.imagethread = imagethread;
        setTitle("屏幕监控");
        setSize(1024,768);
        this.backGround = new JLabel();
        JPanel jp = new JPanel();
        jp.add(this.backGround);


        JScrollPane scrollPanel = new JScrollPane(jp);
//        setDefaultCloseOperation(3);
        add(scrollPanel);
        this.addWindowListener(this);
        this.setVisible(true);
//        image.getImage();
        this.backGround.setIcon(new ImageIcon(imagethread.imagebyte));
        repaint();

    }

//    public void repaintImage() {
//        this.backGround.setIcon(new ImageIcon(imagethread.imagebyte)); //捕获屏幕之后画图
//        repaint();
//    }
//    public void draw() {
//        setTitle("远程协助工具");
//        setSize(1024,768);
//        this.backGround = new JLabel();
//        JPanel jp = new JPanel();
//        jp.add(this.backGround);
//
//
//        JScrollPane scrollPanel = new JScrollPane(jp);
//        setDefaultCloseOperation(3);
//        add(scrollPanel);
//        this.addWindowListener(this);
//        setVisible(true);
//
////        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//    }

    public void windowClosed(WindowEvent arg0) {}
    public void windowOpened(WindowEvent we) {}
    public void windowIconified(WindowEvent we) {}
    public void windowDeiconified(WindowEvent we) {}
    public void windowActivated(WindowEvent we) {}
    public void windowDeactivated(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
//		System.exit(0);
        System.out.println("屏幕监视窗口退出");
        dispose();
        setVisible(false);
    }
    public static void main(String[] args) {
//        imageView ima = new imageView();
//        ima.draw();
//        ima.repaintImage();
    }

}
