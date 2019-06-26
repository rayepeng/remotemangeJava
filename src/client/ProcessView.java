package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import server.TaskList;

public class ProcessView extends JFrame implements WindowListener {

    private BorderLayout borderlayout = new BorderLayout();
    private FlowLayout flowlayout = new FlowLayout(FlowLayout.RIGHT);
    private JPanel jpl = new JPanel();
    private JPanel jplbutton = new JPanel();
    private JTable jtable;
    private JButton jbutton;
    private JButton jbutton2;
    private JScrollPane jscrollPane;

    public  ProcessView(TaskList taskList) {
//            TaskList tasklist = new TaskList();
        // taskList.init();

        jtable = new JTable(taskList.result,taskList.title);
        jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jscrollPane  = new JScrollPane(jtable);
        jbutton = new JButton("结束进程");
        jbutton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String process = (String) jtable.getValueAt(jtable.getSelectedRow(), 0);
                try {
                    Runtime.getRuntime().exec("taskkill /f /im "+process);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                //taskList.init();
                jtable.updateUI();
                jpl.repaint();
                System.out.println(process);
            }
        });
        jbutton2 = new JButton("刷新进程");
        jbutton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //taskList.init();
                jtable.updateUI();
                jpl.repaint();
            }
        });

        jpl.setLayout(borderlayout);
        jpl.add(jscrollPane);
        jplbutton.setLayout(flowlayout);
        jplbutton.add(jbutton2);
        jplbutton.add(jbutton);

        this.pack();
        this.setTitle("进程管理器");
        this.add(jpl,BorderLayout.CENTER);
        this.add(jplbutton,BorderLayout.SOUTH);
//        this.setBounds(400, 200, 600, 400);
        this.setSize(1024,768);
        this.setVisible(true);
        this.addWindowListener(this);

//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    //多实现了一个windowListener接口
    public void windowClosed(WindowEvent arg0) {}
    public void windowOpened(WindowEvent we) {}
    public void windowIconified(WindowEvent we) {}
    public void windowDeiconified(WindowEvent we) {}
    public void windowActivated(WindowEvent we) {}
    public void windowDeactivated(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
//		System.exit(0);
        dispose();
        System.out.println("进程监视窗口退出");

    }


    public static void main(String[] args) {
        new ProcessView(new TaskList());
    }
}
