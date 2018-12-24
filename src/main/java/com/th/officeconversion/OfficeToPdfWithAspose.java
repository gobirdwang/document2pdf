package com.th.officeconversion;

import java.io.File;
import java.io.InputStream;
import java.io.FileOutputStream;

import com.aspose.words.License;
import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

/**
 * @description 通过aspose转换word文件到pdf
 * @author WangPengfei
 * @since 2018/12/17
 */
public class OfficeToPdfWithAspose implements Office2Pdf{

/*
    public static void main(String[] args){
        long old = System.currentTimeMillis();
        String sourceFile = Params.oriPath + Params.oriName;
        String destFile = Params.targetPath + Params.targetName;
        for (int i = 0; i <100 ; i++) {
            office2PdfWithAspose(sourceFile, destFile);
        }
        long now = System.currentTimeMillis();
        System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");
    }
*/

    /**
     * @description 进行license验证，没有license会显示水印
     * @return
     */
    public static boolean getLicense() {
        boolean result = false;
        try {
            InputStream is = OfficeToPdfWithAspose.class.getResourceAsStream("/license.xml");
            License aposeLic = new License();
            aposeLic.setLicense(is);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *
     * @param sourceFile
     * @param destFile
     * @return
     */
    @Override
    public int office2Pdf(String sourceFile, String destFile) {
        if (!getLicense()) {
            System.out.println(ResultMessage.ACTIVATE_FAILED_MESSAGE);
            return ResultMessage.ACTIVATE_FAILED_CODE;
        }
        try {
            //加载原始文件
            File inputFile = new File(sourceFile);
            if (!inputFile.exists()) {
                System.out.println(ResultMessage.NONE_ORIGINAL_FILE_MESSAGE);
                return ResultMessage.NONE_ORIGINAL_FILE_CODE;
            }

            //文件夹不存在创建目录
            File outputFile = new File(destFile);
            if (!outputFile.getParentFile().exists()) {
                outputFile.getParentFile().mkdirs();
            }
            FileOutputStream os = new FileOutputStream(outputFile);
            Document doc = new Document(sourceFile);
            doc.save(os, SaveFormat.PDF);
            System.out.println(ResultMessage.CONVERSION_SUCCESS_MESSAGE );
            return ResultMessage.CONVERSION_SUCCESS_CODE;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(ResultMessage.CONVERSION_FAILED_MESSAGE);
            return ResultMessage.CONVERSION_FAILED_CODE;
        }
    }

}
