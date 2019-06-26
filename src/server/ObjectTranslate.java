package server;

import java.io.Serializable;

//将对象组合成一个类进行传输
public class ObjectTranslate implements Serializable {
    public imageThread image;
    public TaskList taskList;
    public camera cameraOne;
//    public KeyBoard keyBoard;

}
