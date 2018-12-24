package com.th.documentconversion.asynchronous;

public class Test {
    public static void main(String[] args) {
        int x = a();
        System.out.println(x);
    }
    public static int a(){
        B b=new B();
        A a=new A(b);
        a.ask("1+1=?");
        return 1;
    }
}
