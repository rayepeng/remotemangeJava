package client;
//已经废弃


import server.*;

import java.io.*;
import java.net.Socket;
import java.security.Key;

//public class socketClient {
//    public static void main(String[] args) {
//        while (true) {
//            try {
//                clientWindowsGUI clientWindowsgui = new clientWindowsGUI();
//                Socket sock= clientWindowsgui.socket;
////                Socket sock = new Socket("127.0.0.1", 3333);
//
//
//                InputStream in = sock.getInputStream(); //得到输入流，这个输入流连接到服务端的输出流，所以会有数据传输过来
//                while (in == null) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//
//                ObjectInputStream oin = new ObjectInputStream(in);
//                Object ooin = oin.readObject();
////                clientWindows client = new clientWindows();
//
//                //读出来的类进行判断，然后传递过去
//                if (ooin instanceof ObjectTranslate) {
//                    if (((ObjectTranslate) ooin).taskList instanceof TaskList) {
//                        TaskList taskList = ((ObjectTranslate) ooin).taskList;
//                        clientWindowsgui.taskList = taskList;
//                        System.out.println(taskList);
//                    }
//                    if (((ObjectTranslate) ooin).image instanceof imageThread) {
//                        //向下转型
//                        imageThread imagethread = ((ObjectTranslate) ooin).image;
////                        clientWindowsgui.imagethread = imagethread;
////                        System.out.println("传输图像");
//
//                    }
//                    if (((ObjectTranslate) ooin).cameraOne instanceof camera) {
//                        camera cameraOne = ((ObjectTranslate) ooin).cameraOne;
////                        clientWindowsgui.cameraOne = cameraOne;
//
//                    }
////                    if (((ObjectTranslate) ooin).keyBoard instanceof KeyBoard) {
////                        KeyBoard keyBoard = ((ObjectTranslate) ooin).keyBoard;
////
////                    }
//                }
//
//
////
////
////                BufferedReader bin = new BufferedReader(new InputStreamReader(in));
////                String line;
////                while((line = bin.readLine() )!= null){
////                    System.out.println(line);
////                    sock.close();
////                }
////
////                sock.close();
//
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }catch (IOException e) {
//                e.printStackTrace();
//
//
//            }
//        }
//
//    }
//
//}
