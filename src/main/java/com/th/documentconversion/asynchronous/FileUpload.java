package com.th.documentconversion.asynchronous;
/**
 * @description 模拟文件上传，上传后开始进行异步转换
 * @author WangPengfei
 * @since 2018/12/24
 */ 
public class FileUpload implements CallBack {
    private DocumentConvert documentConvert;

    public FileUpload(DocumentConvert documentConvert){
        this.documentConvert = documentConvert;
    }

    /**
     * 文件上传后，把任务交给转换，不影响上传功能。
     */
    public void uploadFiles(){
        System.out.println("开始上传！");
        new Thread(()->{
            documentConvert.documentConvert(FileUpload.this);
        }).start();
        //文件上传成功，可以进行后续的其他操作，此时转换进行中。
        System.out.println("上传完成！");
    }

    @Override
    public void complete(String result) {
        System.out.println(result);
    }
}
