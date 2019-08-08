package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2019080566116170";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCC7e1ADxLQTxu7NGQNCSxu0U99ydypEywAK5Q/tULrpX3Jy7wQ4Zw27rq2p1j4xjVWO0XuI7OxyeDKjBIH3bmBGXaQKuWHQBNCycdCdpel0/2/sZV91y04pMX9HLpaTyM9OpAtYqyPiw3tg7iAZv//dNVZG8SAqmCW2dbRMBYCEsUkpnbfJeDW7bZ70rC2//Y5jjh1RDTeF3d+KHYYbDwsHDGZZ78lw1+x53pVbZrW9fzMDf779dRsZ5RPdfrghNkN5TSOOrgEQrnRVoIfu11XGq5W+jyjCT54x62DGLYqlBpsB8OEZGal1ZwxVluKwyTyHvN8MGygEbWFgLLV3tLhAgMBAAECggEACELI0FzjG/+RyVsB4QyuIAPW1yHwaT6LbStSvD5MjZ+wcxYGtK33dEPVxgaDB5dB8EHnJKJeCR6qrzztOk/UD4Ayyd/bAZCaZoFisB/Za54XiYvD2d/Eu6kx0MmKPH53w7o5NJPgPWJRq6W+82MMTerqNygYWuHlHD98XVCCYvkDGwAJEHVWAFNvBRj7uQWzNxF8acSal9ZoxktTA+asbSspPqV1ahCnGkDkASJHzI2AD3EW3BmR9S76/MABJRJAcKzjJgrv/qg1bHAa5L38/m3Tuz4twS5X0NAnT4Ai5fcCOH994RZH0ztmgu+sVhsIoRZM+eTuAu3gQiiF0mdvnQKBgQC3NPpn8Par75v/a+wrO7EtLd4AIxcB68ZIpKdh07mtGA/CWcBlbxA0DXRuZFDDEnOaZVgp6r6jW9u31mt7Hy1wuF+3Kn3g0j7+wtxrnVfQwj6s0l9MbhJJF0MUZRuo+RNH03XhKoPab0emF+hE+WzxgZC4YQ1QVHZVj7oaWpPWpwKBgQC284B4JdEyshxzXGvzH/asBiKJ9xrpvbFqfOFE2qn+tnckiNmuELawYmQsEmcjvf18h/JsjPK3DeNUiLRzLsZRzZuKdQFfjCTJMavX7WCn27I01mUDr7opn62TQc6YDWpGlb1iSMeqRRbsW8ljqPawfc8MGpX1245M09zCxWJDNwKBgQCE0voAxahw+yTkR8BPj9ViZfCftNEHaYK2Q/m+aRwirGEwjJV6dM0Qj/ir2DrdUtFRTMxgh3pzQTPI0sHV38K4CFQMndfpWUSmu2vG8aorBckezt6csOi86QqPDMbC+OHLnznFZ2d0xFzzxD13VEZxyXe81VArvzCT08IfPTAV3QKBgE28o77pmr1mzw35nGjfEQpBRRXIaKgfES7FR1bhbtArKe7dM1lyAp5qAFR1sVuPlBEBFvIm5c8AWLMHr10t59jEe63WT7IQs2TF9VW3qJVKlas72go59elPzwo+MRGMybaaU7FaaXShDL97tNPi7IdLvdlPxp6EHy/n6ercwgb7AoGATYurj5AyZ6pTf6BLdHxCidrQGXWevSvyLmN1uRbVw5rPmgamC/lAbPtYOLhXeJaWyEqAOKPxnB/aC9cdD7+tAT02YXoq9OSBMBbZkJkLEwyG1RYsYCwVHmKJCwi8gw/BH8p2lmnFK5NgIzIHaRvPhHy0mS68WEWdXxpBwwHcQTM=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhjqPHSrUZePyWitR7+qlY/VEWvPmTDYZOla9RVRZDdCy4AgGycGtNw0xnc8/KhKhl4ZXVDOOlfPWyyfe6U8M+ne4gjWOZ8y6Bu2IKVRraf1CvKkegRSV09NSVVmnxQ9B71u22qpmDxXzYpTzbOTyXJKLNx1CmqAaTcTIf5f1MLtG9VQ3zUcMrqae/OJWTvEz5pPqoNHSIUIrtLs8IZHpltAGA7U1niAwIoBgthLV04aPx4jCDTO8q7uxy0IfdYu+QV8m85KjrVLYPb89NNj0NzCcxu8BYWaXzV4kf+jG/Uer3owsgQbpNcsloW1qAeXDmRauDXPQMKbmwX8QZlTJFwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8088/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8088/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "/Users/wujingcheng/VisualStudio Projects/mylog";

    //格式
    public static String fromat = "json";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

