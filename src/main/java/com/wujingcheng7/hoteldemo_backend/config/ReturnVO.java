package com.wujingcheng7.hoteldemo_backend.config;

import java.util.Properties;
/**
 *定义一个统一的返回类ReturnVO
 * 具体的错误信息和错误代码保存到了response.properties
 */
public class ReturnVO {
    private static Properties properties = ReadPropertiesUtil.getProperties(System.getProperty("user.dir")+"/HotelDemo_BackEnd/src/main/resource/response.properties");

    /**
     * 返回代码
     */
    private String code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据
     */
    private Object data;
    /**
     * 返回数据
     */

    /**
     * 默认构造，返回操作正确的返回代码和信息
     */
    private ReturnVO(){
        this.setCode(properties.getProperty(ReturnCode.SUCCESS.getValue()));
        this.setMessage(properties.getProperty(ReturnCode.SUCCESS.getMessage()));
    }

    /**
     * 构造一个返回特定代码的ReturnVO对象
     * @param code
     */
    public ReturnVO(ReturnCode code){
        this.setCode(properties.getProperty(code.getValue()));
        this.setMessage(properties.getProperty(code.getMessage()));
    }

    /**
     * 默认值返回，默认返回正确的code和message
     * @param data
     */
    public ReturnVO(Object data){
        this.setCode(properties.getProperty(ReturnCode.SUCCESS.getValue()));
        this.setMessage(properties.getProperty(ReturnCode.SUCCESS.getMessage()));
        this.setData(data);
    }

    /**
     * 构造返回代码，以及自定义的错误信息
     * @param code
     * @param message
     */
    public ReturnVO(ReturnCode code,String message){
        this.setCode(properties.getProperty(code.getValue()));
        this.setMessage(message);
    }

    /**
     * 构造自定义的code,message,以及data
     * @param code
     * @param message
     * @param data
     */
    public ReturnVO(ReturnCode code,String message,Object data){
        this.setCode(code.getValue());
        this.setMessage(message);
        this.setData(data);
    }

    @Override
    public String toString(){
        return "ReturnVO{"+
                "code='"+code+'\''+
                ",message='"+message+'\''+
                ",data="+data+
                '}';
    }

    public static Properties getProperties() {
        return properties;
    }

    public static void setProperties(Properties properties) {
        ReturnVO.properties = properties;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
