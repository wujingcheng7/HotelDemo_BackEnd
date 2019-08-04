package com.wujingcheng7.hoteldemo_backend.config;

public enum ReturnCode {
    /** 操作成功*/
    SUCCESS("SUCCESS_CODE","SUCCESS_MSG"),

    /** 操作失败*/
    FAIL("FAIL_CODE","FAIL_MSG"),

    /** 空指针异常*/
    NullPointerException("NPE_CODE","NPE_MSG"),

    /** 自定义异常之返回值为空*/
    NullResponseException("NRE_CODE","NRE_MSG"),

    /** 运行时异常*/
    RuntimeException("RTE_CODE","RTE_MSG"),

    /** 请求方式错误异常*/
    HttpRequestMethodNotSupportedException("REQUEST_METHOD_UNSUPPORTED_CODE","REQUEST_METHOD_UNSUPPORTED_MSG"),

    /**INTERNAL_ERROR*/
    BindException("BIND_EXCEPTION_CODE","BIND_EXCEPTION_MSG"),

    /** 页面路径不对*/
    UrlError("UE_CODE","UE_MSG");


    private String value;
    private String message;

    private ReturnCode(String value, String message) {
        this.value=value;
        this.message=message;
    }
    public String getValue(){
        return value;
    }
    public String getMessage(){
        return message;
    }
}
