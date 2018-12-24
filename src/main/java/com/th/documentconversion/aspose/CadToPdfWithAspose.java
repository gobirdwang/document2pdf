package com.th.documentconversion.aspose;

import java.io.File;
import java.io.InputStream;

import com.aspose.cad.*;
import com.aspose.words.License;
import com.aspose.cad.imageoptions.PdfOptions;
import com.aspose.cad.imageoptions.CadRasterizationOptions;
import com.th.documentconversion.Params;

/**
 * @description 通过aspose将cad文档转换为pdf
 * @author WangPengfei
 * @since 2018/12/17
 */
public class CadToPdfWithAspose {

    public static void main(String[] args){
        long old = System.currentTimeMillis();
        String sourceFile = Params.oriPath + "1.dwg";
        String destFile = Params.targetPath + Params.targetName;
        cad2PdfWithAspose(sourceFile, destFile);
        long now = System.currentTimeMillis();
        System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");
    }
    /**
     * 转化cad到pdf
     * @param sourceFile 原文件路径
     * @param destFile pdf路径
     */
    public static void cad2PdfWithAspose(String sourceFile, String destFile){
        if (!getLicense()){
            return ;
        }
        //加载原始文件
        File inputFile = new File(sourceFile);
        if (!inputFile.exists()) {
            return ;
        }

        //文件夹不存在创建目录
        File outputFile = new File(destFile);
        if (!outputFile.getParentFile().exists()) {
            outputFile.getParentFile().mkdirs();
        }

        com.aspose.cad.Image image = com.aspose.cad.Image.load(sourceFile);
        //
        CadRasterizationOptions cadRasterizationOption = new CadRasterizationOptions();
        cadRasterizationOption.setBackgroundColor(Color.getWhite());
        cadRasterizationOption.setPageHeight(1600);
        cadRasterizationOption.setPageWidth(1600);
        //
        PdfOptions pdfOption = new PdfOptions();
        pdfOption.setVectorRasterizationOptions(cadRasterizationOption);
        //
        image.save(destFile, pdfOption);
    }
    /**
     * @description 进行license验证，破解失败会显示水印
     * @return boolean 验证是否通过
     */
    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = OfficeToPdfWithAspose.class.getResourceAsStream("/license.xml");
            com.aspose.words.License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
