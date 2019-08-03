package com.wujingcheng7.hoteldemo_backend.controller;

import com.wujingcheng7.hoteldemo_backend.config.Result;
import com.wujingcheng7.hoteldemo_backend.domain.OrderList;
import com.wujingcheng7.hoteldemo_backend.service.OrderlistService;
import org.apache.ibatis.annotations.Param;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/bookinfo_backend")
public class OrderBackEndController {
    @Autowired
    private OrderlistService orderlistService;
    /*
    * 展示当前订单
    * */
    @GetMapping("")
    public Model showNowOrders(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        String hotel_id = (String)session.getAttribute("hotel_id");
        List<OrderList> NowOrderLists = orderlistService.getNowOrderListsByHotelId(hotel_id);
        model.addAttribute("NowOrderLists",NowOrderLists);
        return model;
    }
    /*
    * 展示历史订单
    * */
    @GetMapping("/history")
    public String showHistoryOrders(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        String hotel_id = (String)session.getAttribute("hotel_id");
        List<OrderList> OldOrderLists = orderlistService.getOldOrderListsByHotelId(hotel_id);
        model.addAttribute("OldOrderLists",OldOrderLists);
        return "/oldbooks_backend";
    }

    /*
    * 修改订单信息
    * 当前可修改信息为：
    * 日期、房间号
    * */
    @PostMapping("/modify")
    public String modifyOrderList(HttpServletRequest request,Model model,@Param("order_id")int order_id,@Param("order_indate")Date order_indate,@Param("order_outdate") Date order_outdate,@Param("room_id")String room_id){
        HttpSession session = request.getSession();
        String hotel_id = (String)session.getAttribute("hotel_id");
        String hotel_admin_id = (String)session.getAttribute("hotel_admin_id") ;
        OrderList orderListBackUp = orderlistService.getOrderListByOrderId(order_id);//备份
        String user_tel = orderListBackUp.getUser_tel();
        Result result = orderlistService.modifyOrderList(orderListBackUp,user_tel,hotel_id,room_id,order_indate,order_outdate,hotel_admin_id);
        if(result.isSuccess()) {
            model.addAttribute("msg", "修改成功");
        }
        else {
            model.addAttribute("msg", "您要修改的订单与已有订单冲突");
        }
        return "/bookinfo_backend";
    }
}
