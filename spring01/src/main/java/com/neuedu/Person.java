package com.neuedu;

public class Person {

    IHelloMessage helloMessage;

    public void setHelloMessage(IHelloMessage helloMessage) {
        this.helloMessage = helloMessage;
    }

    public void sayHello(){
        helloMessage.sayHello();
    }
}
