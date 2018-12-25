package com.th.documentconversion.asynchronous;

import com.th.documentconversion.Params;
import com.th.documentconversion.openoffice.OfficeToPdfWithOpenOffice;

/**
 * @description 文件转换
 * @author WangPengfei
 * @since 2018/12/24
 */ 
public class DocumentConvert {
    public void documentConvert(CallBack callBack){
        System.out.println("现在开始转换！");
        OfficeToPdfWithOpenOffice.office2Pdf(Params.oriPath+Params.oriName,Params.targetPath+Params.targetName);
        String result="文件转换完成！整个文件上传功能完成！";
        //转换完成，可以调用FileUpload中的回调函数，，
        callBack.complete(result);
    }
}