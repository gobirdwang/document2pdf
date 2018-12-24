package com.th.documentconversion.asynchronous;

public class Test {
    public static void main(String[] args) {
        DocumentConvert documentConvert =new DocumentConvert();
        FileUpload fileUpload =new FileUpload(documentConvert);
        fileUpload.uploadFiles();
        System.out.println("上传结束，做转换的同时，开始做其他的事情~");
        doOtherThing();
    }

    public static void doOtherThing(){
        try {
            System.out.println("现在在做其他事情！");
            Thread.sleep(1000);
            System.out.println("其他事情做完了！");
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
