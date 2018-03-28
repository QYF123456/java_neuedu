package com.neuedu;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    /*  Person mPerson= new Person();
      mPerson.setHelloMessage(new HelloWord());
      mPerson.sayHello();*/
   ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("classpath:beans.xml");
 Person mPerson= (Person) context.getBean("mPerson");
      //  HelloWord helloMessage=(HelloWord) context.getBean("HelloWord");
       mPerson.sayHello();

    }
}
