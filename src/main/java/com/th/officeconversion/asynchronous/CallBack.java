package com.th.officeconversion.asynchronous;

public interface CallBack {
    /**
     *A处理结果的方法，为什么要写这个接口呢？
     *因为可能不止A需要用到B的处理过程，如果很多地方需要用到B
     * 那么传入B的方法就不可能只传A类，所以要定义一个接口，
     * 传入B的处理方法的参数就是这个接口对象
     * */
    public void solve(String result);
}
