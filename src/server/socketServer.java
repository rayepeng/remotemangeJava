package server;


import javafx.concurrent.Task;
import javafx.scene.control.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class socketServer extends JFrame {
    JButton button1 = new JButton("确定");
    JButton button2 = new JButton("取消");

    public socketServer() {
//        setTitle("远程控制");
////        JLabel str1 = new JLabel("是否允许远程控制");
////        add(str1);
//        setLayout(new FlowLayout());
//        add(button1);
//        add(button2);
//        button1.addActionListener(new buttonListener());
//        button2.addActionListener(new button2Listener());
//        setSize(300, 100);
//        setLocation(300, 100);
//        setVisible(true);
        JOptionPane.showConfirmDialog(null, "警告！是否允许远程控制", "是否允许远程控制", JOptionPane.YES_NO_OPTION);

    }

    class buttonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            String text = ((JButton) event.getSource()).getText();
            if (text.equals("button1")) {
                JOptionPane.showConfirmDialog(null, "2333");
            }

            setVisible(false);
        }

    }

    class button2Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            System.exit(0);

        }
    }
    public static void main(String[] args) throws IOException {
        try {
            //服务端程序
            int n = JOptionPane.showConfirmDialog(null, "警告！是否允许远程控制?", "是否允许远程控制", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "退出", "退出", JOptionPane.ERROR_MESSAGE);

                System.exit(0);

            }
//            new socketServer();
            ServerSocket sock = new ServerSocket(3333);
            System.out.println("等待连接");
            Socket client = sock.accept();
            if (client != null) {
                System.out.println("已经连接");
            }
            while (true) {
//                OutputStream out = client.getOutputStream();
//                ObjectOutputStream oout = new ObjectOutputStream(out);
//                ProcessViewer p = new ProcessViewer();
//                oout.writeObject(p);

//                InputStream in = client.getInputStream(); //服务端的输入流连接到客户端的输出流
//                BufferedReader bin = new BufferedReader(new InputStreamReader(in));
//                System.out.println(bin.readLine());
                TaskList taskList = new TaskList();
                imageThread image = new imageThread();
                camera cameraOne = new camera();
//                KeyBoard keyBoard = new KeyBoard();
                cameraOne.capture();


                image.setSize(30);

                ObjectTranslate objectTranslate = new ObjectTranslate();
                objectTranslate.taskList = taskList;
                objectTranslate.image = image;
                objectTranslate.cameraOne = cameraOne;
//                objectTranslate.keyBoard = keyBoard;
                OutputStream out = client.getOutputStream();
                ObjectOutputStream oout = new ObjectOutputStream(out);
                oout.writeObject(objectTranslate);

            }

        } catch (NotSerializableException e) {
//            System.out.println("不可反序列化");
            e.printStackTrace();

        } catch (IOException e) {

            System.out.println("客户端已经断开连接");
        }
    }
}
