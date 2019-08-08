package com.wujingcheng7.hoteldemo_backend.controller.front;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradePayModel;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.config.AlipayConfig;
import com.wujingcheng7.hoteldemo_backend.domain.OrderList;
import com.wujingcheng7.hoteldemo_backend.service.HotelRoomService;
import com.wujingcheng7.hoteldemo_backend.service.HotelService;
import com.wujingcheng7.hoteldemo_backend.service.OrderlistService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
public class AliController {
    //获取配置文件的信息
    String app_id = AlipayConfig.app_id;
    String private_key = AlipayConfig.merchant_private_key;
    String notify_url = AlipayConfig.notify_url;
    String return_url = AlipayConfig.return_url;
    String url = AlipayConfig.gatewayUrl;
    String charset = AlipayConfig.charset;
    String format = AlipayConfig.fromat;
    String public_key = AlipayConfig.alipay_public_key;
    String signtype = AlipayConfig.sign_type;

    @Autowired
    OrderlistService orderlistService;
    @Autowired
    HotelRoomService hotelRoomService;
    @Autowired
    HotelService hotelService;



    /**
     * 支付请求
     * @param response
     * @param request
     * @throws IOException
     * @throws AlipayApiException
     */
    @RequestMapping("/alipay")
    public void pay(HttpServletResponse response, HttpServletRequest request,@Param("order_id")int order_id)throws IOException, AlipayApiException {

        //从后台获取订单信息（尤其是金额），用于支付。拒绝从前端获取，增加安全性
        OrderList orderList = orderlistService.getOrderListByOrderId(order_id);
        String hotelName=hotelService.getHotelById(orderList.getHotel_id()).getHotel_name();
        String roomName=hotelRoomService.getRoomByHotelRoomId(orderList.getHotel_room_id()).getRoom_type();
        String money=orderList.getOrder_price();
        String stringOderId=String.valueOf(order_id);


        //支付请求
        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do", app_id, private_key, format, charset, public_key, signtype); //获得初始化的AlipayClient
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();//创建API对应的request
        alipayRequest.setReturnUrl("http://localhost/returnUrl");
        alipayRequest.setNotifyUrl("http://localhost/notifyUrl");//在公共参数中设置回跳和通知地址
        alipayRequest.setBizContent("{" +
                "    \"out_trade_no\":\""+stringOderId+"\"," +
                "    \"product_code\":\"FAST_INSTANT_TRADE_PAY\"," +
                "    \"total_amount\":"+money+"," +
                "    \"subject\":"+"\""+hotelName+" "+roomName+"\"," +
                "    \"body\":"+"\""+hotelName+" "+roomName+"\"," +
                "    \"passback_params\":\"merchantBizType%3d3C%26merchantBizNo%3d2016010101111\"," +
                "    \"extend_params\":{" +
                "    \"sys_service_provider_id\":\"2088511833207846\"" +
                "    }"+
                "  }");//填充业务参数
        String form="";
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=" + charset);
        response.getWriter().write(form);//直接将完整的表单html输出到页面
        response.getWriter().flush();
        response.getWriter().close();
    }

    /**
     * 同步跳转
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/returnUrl")
    public String returnUrl(HttpServletRequest request) throws Exception {
//        ModelAndView mav = new ModelAndView();

        // 获取支付宝GET过来反馈信息（官方固定代码）
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV1(params, public_key, charset, signtype); // 调用SDK验证签名

        // 返回界面
        if (signVerified) {
            System.out.println("前往支付成功页面");
            String StringOrderId = request.getParameter("out_trade_no");
            int order_id=Integer.parseInt(StringOrderId);
            orderlistService.setPayState(true,order_id);
            return "/index";
//            mav.setViewName("books_display");
        } else {
            System.out.println("前往支付失败页面");
//            mav.setViewName("books_display");
            return "/index";
        }
//        return mav;

    }

    /**
     * 支付宝服务器异步通知
     * @param request
     * @throws Exception
     */
    @RequestMapping("/notifyUrl")
    public void notifyUrl(HttpServletRequest request) throws Exception {
        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            params.put(name, valueStr);
        }

        boolean signVerified = AlipaySignature.rsaCheckV1(params, public_key, charset, signtype); // 调用SDK验证签名

        if (signVerified) { // 验证成功 更新订单信息
            System.out.println("异步通知成功");
            // 商户订单号
            String out_trade_no = request.getParameter("out_trade_no");
            // 交易状态
            String trade_status = request.getParameter("trade_status");
            // 修改数据库
            int OrderId = Integer.parseInt(out_trade_no);
            System.out.println("异步收到订单号：   "+OrderId);
            System.out.println("异步收到订单状态：  "+trade_status);
        } else {
            System.out.println("异步通知失败");
        }
    }


}
