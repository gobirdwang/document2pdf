package com.th.documentconversion;

import com.th.documentconversion.aspose.CadToPdfWithAspose;
import com.th.documentconversion.aspose.OfficeToPdfWithAspose;
import com.th.documentconversion.openoffice.OfficeToPdfWithOpenOffice;

public class main {
    public static void main(String[] args){
        //使用openoffice转换office文档
        OfficeToPdfWithOpenOffice.office2Pdf(Params.oriPath+Params.oriName,Params.targetPath+Params.targetName);
        //使用Aspose转换office文档
        OfficeToPdfWithAspose.office2Pdf(Params.oriPath+Params.oriName,Params.targetPath+Params.targetName);
        //使用Aspose转换cad文档
        CadToPdfWithAspose.cad2PdfWithAspose(Params.oriPath+"1.dwg",Params.targetPath+"2.pdf");
    }
}
