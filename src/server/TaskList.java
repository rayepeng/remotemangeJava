package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

public class TaskList implements Serializable {
    transient public BufferedReader br=null;
    public String [][] result=new String[200][5];
    public String [] title={"映像名称","PID","会话名","会话#","内存使用"};

    public  TaskList(){
        Process proc;
        try {
            proc = Runtime.getRuntime().exec("tasklist /NH /FO csv");
            br=new BufferedReader(new InputStreamReader(proc.getInputStream())); //字节流转为字符流
            String res=null;
            int x = 0;
            //逐次读取一行
            while((res=br.readLine())!=null){
                String[] value=res.replace("\",\"", ";").replace
                        ("\"", "").split(";");
                if(value.length==5){
                    for(int i = 0;i<5;i++){
                        result[x][i] = value[i];
                    }
                }
                x++;
                if(x==200)
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return "TaskList";
    }
    public static void main(String[] args) {

    }
}