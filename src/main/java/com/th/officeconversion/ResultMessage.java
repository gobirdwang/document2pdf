package com.th.officeconversion;
/**
 * @description 定义转换相关的代码及内容
 * @author WangPengfei
 * @since 2018/12/20
 */ 
public class ResultMessage {

    //转换成功code
    public static final int CONVERSION_SUCCESS_CODE = 1;
    //转换成功message
    public static final String CONVERSION_SUCCESS_MESSAGE  = "文件转换成功";

    //未找到原始文件code
    public static final int NONE_ORIGINAL_FILE_CODE = -1;
    //为找到原始文件message
    public static final String NONE_ORIGINAL_FILE_MESSAGE = "未找到原始文件";

    //OpenOffice服务启动失败code
    public static final int START_SERVICE_FAILED_CODE = -2;
    //OpenOffice服务启动失败message
    public static final String START_SERVICE_FAILED_MESSAGE = "OpenOffice服务启动失败";

    //Aspose未成功激活
    public static final int ACTIVATE_FAILED_CODE = -3;
    //Aspose未成功激活
    public static final String ACTIVATE_FAILED_MESSAGE = "Aspose激活失败";

    //转换失败
    public static final int CONVERSION_FAILED_CODE = -4;
    public static final String CONVERSION_FAILED_MESSAGE = "转换失败,请联系管理员";



}
