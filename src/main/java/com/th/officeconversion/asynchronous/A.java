package com.th.officeconversion.asynchronous;

public class A implements CallBack {
    private B b;

    public A(B b){
        this.b=b;
    }

    /**
     * A需要解决一个问题，所以他把问题交给B处理，B单独创建一个线程，不影响A的运行
     */
    public void ask(final String question){
        System.out.println("A问了B一个问题");
        new Thread(()->{
            //B想要帮A处理东西，就必须知道谁让自己处理的，所以要传入a，也要知道a想处理什么，所以要传入question
            b.executeMessage(A.this,question);
        }).start();
        //A把要处理的事情交给b之后，就可以自己去玩耍了，或者去处理其他事情
        play();
    }

    public void play(){
        System.out.println("我要逛街去了");
    }

    @Override
    public void solve(String result) {
        System.out.println("B告诉A的答案是--》"+result);
    }

}
