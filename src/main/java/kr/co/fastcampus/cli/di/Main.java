package kr.co.fastcampus.cli.di;

public class Main {
    public static void main(String[] args) {
        boolean condition = true;
        B b = new B(condition);
        A a = new A(b);
        a.print();
    }
}
