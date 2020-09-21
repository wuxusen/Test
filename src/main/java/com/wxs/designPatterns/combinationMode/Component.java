package com.wxs.designPatterns.combinationMode;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-06-24
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public abstract class Component {

    String name;

    public Component(String name){
        this.name = name;
    }
    public abstract void show();

}

class WinForm extends Component{

    private List<Component> subList = new ArrayList<>();

    public WinForm(String name) {
        super(name);
    }

    @Override
    public void show() {
        System.out.println(name);
        subList.forEach(e ->{ e.show();});
    }
    public void addComponent(Component component) {
        subList.add(component);
    }
}

class Frame extends Component{

    private List<Component> subList = new ArrayList<>();

    public Frame(String name) {
        super(name);
    }
    @Override
    public void show() {
        System.out.println(name);
        subList.forEach(e ->{ e.show();});
    }
    public void addComponent(Component component) {
        subList.add(component);
    }
}

class Button extends Component{
    public Button(String name) {
        super(name);
    }
    @Override
    public void show() {
        System.out.println(name);
    }
}

class Picture extends Component{
    public Picture(String name) {
        super(name);
    }
    @Override
    public void show() {
        System.out.println(name);
    }
}

class TextBox extends Component{
    public TextBox(String name) {
        super(name);
    }
    @Override
    public void show() {
        System.out.println(name);
    }
}

class Lable extends Component{

    public Lable(String name) {
        super(name);
    }
    @Override
    public void show() {
        System.out.println(name);
    }
}

class PasswordBox extends Component{
    public PasswordBox(String name) {
        super(name);
    }
    @Override
    public void show() {
        System.out.println(name);
    }
}

class CheckBox extends Component{
    public CheckBox(String name) {
        super(name);
    }
    @Override
    public void show() {
        System.out.println(name);
    }
}

class LinkLable extends Component{
    public LinkLable(String name) {
        super(name);
    }
    @Override
    public void show() {
        System.out.println(name);
    }
}



class Test{
    public static void main(String[] args) {
        WinForm container = new WinForm("WinForm(WINDOW窗口)");
        container.addComponent(new Picture("Picture(LOGO图片)"));
        container.addComponent(new Button("Button(登录)"));
        container.addComponent(new Button("Button(注册)"));

        Frame frame = new Frame("Frame(FRAME1)");
        frame.addComponent(new Lable("Lable(用户名)"));
        frame.addComponent(new TextBox("TextBox(文本框)"));
        frame.addComponent(new Lable("Lable(密码)"));
        frame.addComponent(new PasswordBox("PasswordBox(密码框)"));
        frame.addComponent(new CheckBox("CheckBox(复选框)"));
        frame.addComponent(new TextBox("TextBox(记住用户名)"));
        frame.addComponent(new LinkLable("LinkLable(忘记密码)"));

        container.addComponent(frame);
        container.show();
    }
}