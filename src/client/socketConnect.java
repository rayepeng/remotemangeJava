package client;

import server.ObjectTranslate;
import server.TaskList;
import server.camera;
import server.imageThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class socketConnect {

    public socketConnect() {

    }

//    public socketConnect(String ip, int port) {
//        try {
//            Socket socket = new Socket(ip, port);
//            InputStream in = socket.getInputStream();
//            ObjectInputStream oin = new ObjectInputStream(in);
//            Object ooin = oin.readObject();
//            if (ooin instanceof ObjectTranslate) {
//                if (((ObjectTranslate) ooin).taskList instanceof TaskList) {
//                    TaskList taskList = ((ObjectTranslate) ooin).taskList;
//                    clientWindowsgui.taskList = taskList;
//                    System.out.println(taskList);
//                }
//                if (((ObjectTranslate) ooin).image instanceof imageThread) {
//                    //向下转型
//                    imageThread imagethread = ((ObjectTranslate) ooin).image;
//                    clientWindowsgui.imagethread = imagethread;
////                        System.out.println("传输图像");
//
//                }
//                if (((ObjectTranslate) ooin).cameraOne instanceof camera) {
//                    camera cameraOne = ((ObjectTranslate) ooin).cameraOne;
//                    clientWindowsgui.cameraOne = cameraOne;
//
//                }
//        }  catch (IOException e) {
//            e.printStackTrace();
//        }catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
}
