package client;

import server.ObjectTranslate;
import server.TaskList;
import server.camera;
import server.imageThread;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class clientWindowsGUI extends JFrame {

    private JPanel contentPane;
    private JTextField txtGhjkl;
    private JTextField textField;
    public TaskList taskList;
    public imageThread imagethreadOne;
    public camera cameraThreadOne;
    public Socket socket;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    clientWindowsGUI frame = new clientWindowsGUI();
                   // frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public clientWindowsGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 586, 409);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNewButton = new JButton("\u6253\u5F00\u6444\u50CF\u5934");
        btnNewButton.setFont(new Font("等线", Font.PLAIN, 19));
        btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
//        btnNewButton.setSelectedIcon(new ImageIcon("C:\\Users\\zz\\Desktop\\icon1.jpg"));
        btnNewButton.setToolTipText("");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    cameraView cameraview = new cameraView(cameraThreadOne);
//                cameraview.draw();
//                cameraview.repaintImage();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        btnNewButton.setIcon(new ImageIcon("icon1.jpg"));
        btnNewButton.setBounds(14, 7, 233, 114);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("\u5C4F\u5E55\u76D1\u63A7");
        btnNewButton_1.setFont(new Font("等线", Font.PLAIN, 19));
        btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    imageView ima = new imageView(imagethreadOne);
//                ima.draw();
//                ima.repaintImage();
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        Icon icon1 = new ImageIcon("timg.jpg");
        btnNewButton_1.setIcon(icon1);

        btnNewButton_1.setBounds(14, 123, 233, 114);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("\u8FDB\u7A0B\u7BA1\u7406");
        btnNewButton_2.setFont(new Font("等线", Font.PLAIN, 19));
        btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
        btnNewButton_2.setIcon(new ImageIcon("Snipaste_2019-06-25_14-35-14.png"));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new ProcessView(taskList);

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_2.setBounds(14, 240, 233, 114);
        contentPane.add(btnNewButton_2);

        txtGhjkl = new JTextField();
        txtGhjkl.setFont(new Font("宋体", Font.PLAIN, 20));
//		txtGhjkl.setText("ghjkl");
        txtGhjkl.setBounds(336, 86, 218, 41);
        contentPane.add(txtGhjkl);
        txtGhjkl.setColumns(10);

        JLabel lblIp = new JLabel("IP\u5730\u5740");
        lblIp.setFont(new Font("等线", Font.PLAIN, 20));
        lblIp.setBounds(267, 98, 72, 18);
        contentPane.add(lblIp);

        JLabel label = new JLabel("\u7AEF\u53E3\u53F7");
        label.setFont(new Font("等线", Font.PLAIN, 20));
        label.setBounds(267, 157, 72, 18);
        contentPane.add(label);

        textField = new JTextField();

        textField.setFont(new Font("宋体", Font.PLAIN, 20));
        textField.setColumns(10);
        textField.setBounds(336, 145, 218, 41);

        contentPane.add(textField);
        //按下按钮的时候建立连接
        JButton button = new JButton("\u8FDE\u63A5");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ip = txtGhjkl.getText();
                String port = textField.getText();
                try {
                    socket = new Socket(ip, Integer.parseInt(port));
                    InputStream in = socket.getInputStream();
                    ObjectInputStream oin = new ObjectInputStream(in);
                    Object ooin = oin.readObject();
                    if (ooin instanceof ObjectTranslate) {
                        if (((ObjectTranslate) ooin).taskList instanceof TaskList) {
                            TaskList TaskList = ((ObjectTranslate) ooin).taskList;
                            taskList = TaskList;
                        }
                        if (((ObjectTranslate) ooin).image instanceof imageThread) {
                            imageThread imagethread = ((ObjectTranslate) ooin).image;
                            imagethreadOne = imagethread;
                        }
                        if (((ObjectTranslate) ooin).cameraOne instanceof camera) {
                            camera cameraone = ((ObjectTranslate) ooin).cameraOne;

                            cameraThreadOne = cameraone;
                        }
                        JOptionPane.showMessageDialog(null, "连接成功");

                    }

//                clientWindows client = new clientWindows();
                } catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        button.setFont(new Font("等线", Font.PLAIN, 22));
        button.setBounds(336, 211, 113, 79);
        contentPane.add(button);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(77, 84, 52, 41);
        contentPane.add(textArea);
        setTitle("远程控制软件  作者:彭馨勇，徐锦盈，范子颖，邓洋涛");
        setVisible(true);

//		contentPane.setLayout(new FlowLayout());
    }
}
