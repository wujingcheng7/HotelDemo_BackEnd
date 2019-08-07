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
    public static String app_id = "2016101000650541";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAo7T3pm4ov/iFUrlEKmMvqTH6bV/lizOvQMqxZri3DlsSqHHcvZ5UP5x/0aGXmeqycU34xL24d8UeuffUT7Yctt+ez+Fyj/g6tSaFYQ1X2OhZ8YJXO3OjI1HxzDUS0mN9pYfAULCY6pFGDgCAgVi7l1W26fFPkw4lJJ4LB8TdxLpoJV+ocBieSfjPvFXiEuTwNPCWIlEJ4F3TIul/1aWoadRb3yiv9xNwPA7SQ4/WgutclwNSL4IvprTWDM9XDfXZ5EbZnC+96ajeHTgg/D7TFaWEfedYT+P7PKiYjHW+R2uSPNaKvLj099UX/uTfv3LPF7d4IYIjtu51ICjSZWXzgQIDAQAB";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgWEK80l7HZ3321UgMz7dERDMRjSel3sDKB4AxncVZJJyM35dk86/d58HWYbnXunr8sdhRt28PedVWRSi4y5p5umOas/Ff2j91Ddks+UsRofmJIfHwyDIRKnQxKkTmuHuiawsd/xGz84dJehL1c68SmKbBB5ch28ajt/uyDM8p+VWXuEeVU5BIaODMyBLMaeVEbxMJRxgdbfA94GvNkuO4w/ks4uwDJZ6TIwFj5aSLL2kQ9sKvmKdjuHhJuzJEWdXQaSVrWCogoDC7RQNQwkserAkaJfAIGprK/iQY4j4+82Dy5SfqmXN8kQuWBiZWQtRiGTT8vHaM1Php7JH195M1wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";

    // 支付宝网关
    public static String log_path = "/Users/wujingcheng/VisualStudio Projects/mylog";


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

