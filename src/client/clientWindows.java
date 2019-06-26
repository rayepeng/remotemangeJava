package client;

//import server.KeyBoard;
import server.TaskList;
import server.camera;
import server.imageThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.Socket;

public class clientWindows extends JFrame implements WindowListener {

    public JFrame jf;
    public JButton jButton1, jButton2, jButton3;
    JPanel jPanel;
    public JLabel background;
    public Container container;
    public TaskList taskList;
    public imageThread imagethread;
    public camera cameraOne;

    //    public KeyBoard keyBoard;
    public clientWindows() {

        jf = new JFrame("远程管理软件");
        //加入两个按钮
        jButton1 = new JButton("进程管理");
        jButton2 = new JButton("屏幕监控");
        jButton3 = new JButton("摄像头截屏");
//        jButton4 = new JButton("键盘记录");


        background = new JLabel();
        //容器
        container = jf.getContentPane();
        jPanel = new JPanel();
        jPanel.add(jButton1);
        jPanel.add(jButton2);
        jPanel.add(jButton3);
//        jPanel.add(jButton4);
        container.setLayout(new FlowLayout());
        container.add(jPanel);
        jButton1.addActionListener(new ProcessListener());
        jButton2.addActionListener(new imageListener());
        jButton3.addActionListener(new cameraListener());

        jf.setVisible(true);
        jf.add(background);
        jf.setSize(500, 500);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
        this.addWindowListener(this);

//        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }



    public void windowClosed(WindowEvent arg0) {}
    public void windowOpened(WindowEvent we) {}
    public void windowIconified(WindowEvent we) {}
    public void windowDeiconified(WindowEvent we) {}
    public void windowActivated(WindowEvent we) {}
    public void windowDeactivated(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
//		System.exit(0);
        System.out.println("关闭了子窗口");
//        dispose();
    }
    class ProcessListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                new ProcessView(taskList);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class imageListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                imageView ima = new imageView(imagethread);
//                ima.draw();
//                ima.repaintImage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class cameraListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            try {
                cameraView cameraview = new cameraView(cameraOne);
//                cameraview.draw();
//                cameraview.repaintImage();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //    class keyBoardListener implements ActionListener {
//
//        @Override
//        public void actionPerformed(ActionEvent event) {
//            try {
//                new keyBoardView(keyBoard);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
    public static void main(String[] args) {
        new clientWindows();

    }

}
