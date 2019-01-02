package com.th.documentconversion.asynchronous;

public class Test {
    public static void main(String[] args) {
        DocumentConvert documentConvert =new DocumentConvert();
        FileUpload fileUpload =new FileUpload(documentConvert);
        System.out.println(fileUpload.uploadFiles());
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
