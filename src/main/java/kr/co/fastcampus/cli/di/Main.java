package kr.co.fastcampus.cli.di;

import kr.co.fastcampus.cli.Dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("dao.xml");
        A a = context.getBean("a", A.class);
        a.print();
    }
}
