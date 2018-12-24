package com.th.officeconversion;

import java.io.File;
import java.net.ConnectException;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.StreamOpenOfficeDocumentConverter;

/**
 * 通过openoffice转换word到pdf
 * @author WangPengfei
 * @since 2018/12/17
 */
public abstract class OfficeToPdfWithOpenOffice /*implements Office2Pdf*/{
    /**
     * @description 转换office到pdf
     * @param sourceFile
     * @param destFile
     * @return
     */
   // @Override
    public static int office2Pdf(String sourceFile, String destFile) {
        OpenOfficeConnection connection = null;
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

            // 启动OpenOffice的服务,默认使用的是8100端口，启动失败可能是没配置正确的安装路径
            CallOpenOfficeService.callService();
            connection = new SocketOpenOfficeConnection(Params.OPEN_OFFICE_PORT);
            connection.connect();

            // 开始转换
            DocumentConverter converter = new StreamOpenOfficeDocumentConverter(connection);
            converter.convert(inputFile, outputFile);
        } catch (ConnectException e) {
            e.printStackTrace();
        } finally{
            if(connection!=null){
                connection.disconnect();
            }
        }
        System.out.println(ResultMessage.CONVERSION_SUCCESS_MESSAGE);
        return ResultMessage.CONVERSION_SUCCESS_CODE;
    }

    public static void main(String[] args){
        long old = System.currentTimeMillis();
        String sourceFile = Params.oriPath + Params.oriName;
        String destFile = Params.targetPath + Params.targetName;
        for (int i = 0; i <20 ; i++) {
            System.out.println(office2Pdf(sourceFile, destFile));
        }
        long now = System.currentTimeMillis();
        System.out.println("共耗时：" + ((now - old) / 1000.0) + "秒");
    }
}
