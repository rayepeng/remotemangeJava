package client;

import server.camera;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class cameraView extends JFrame implements WindowListener {
    private JLabel backGround;
    public camera cameraOne;

    public cameraView(camera cameraOne) {
        this.cameraOne = cameraOne;
        setTitle("远程协助工具");
        setSize(1024,768);
//        setLocation(100,100);
        this.backGround = new JLabel();
        JPanel jp = new JPanel();
        jp.add(this.backGround);
        addWindowListener(this);

        JScrollPane scrollPanel = new JScrollPane(jp);
//        setDefaultCloseOperation(3);
        add(scrollPanel);
        this.addWindowListener(this);


        setVisible(true);
        this.backGround.setIcon(new ImageIcon(cameraOne.imagebyte));
        repaint();
    }
//    public void repaintImage(){
//        this.backGround.setIcon(new ImageIcon(cameraOne.imagebyte));
//        repaint();
//
//    }
//    public void draw() {
//        setTitle("远程协助工具");
//        setSize(1024, 768);
//        this.backGround = new JLabel();
//        JPanel jp = new JPanel();
//        jp.add(this.backGround);
//        addWindowListener(this);
//
//        JScrollPane scrollPanel = new JScrollPane(jp);
//        setDefaultCloseOperation(3);
//        add(scrollPanel);
//        this.addWindowListener(this);
//        setVisible(true);
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
        System.out.println("摄像头监视窗口退出");
        dispose();
    }


}
