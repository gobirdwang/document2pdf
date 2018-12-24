package com.th.officeconversion;

import java.net.ConnectException;

import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;

/**
 * @description 操作openoffice相关的服务，由于部署在服务器上，启动后不再关闭服务
 * @author WangPengfei
 * @since 2018/12/19
 */ 
public class CallOpenOfficeService {

    /**
     * @description 查看服务是否已经启动，openoffice默认的是8100端口
     * @return
     */
    public static boolean isServiceStarted(){
        OpenOfficeConnection conn = new SocketOpenOfficeConnection(Params.OPEN_OFFICE_PORT);
        try{
            conn.connect();
        } catch (ConnectException e) {
            return false;
        }
        conn.disconnect();
        return true;
    }

    /**
     * @description 判断服务是启动，未启动则启动
     * @return
     */ 
    public static void callService(){
        if(isServiceStarted()){
            return;
        }
        Runtime rn = Runtime.getRuntime();
        Process p = null;
        try{
            String filePath = CallOpenOfficeService.class.getResource("/").getPath();
            filePath = filePath.substring(1,filePath.length());
            String os = System.getProperty("os.name");
            if(os.toLowerCase().startsWith("win")){
                filePath += "openoffice.bat";
                System.out.println(filePath);
                p = rn.exec("cmd.exe /C "+filePath);
            } else {
                filePath += "openoffice.sh";
                p = rn.exec("sh "+filePath);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
