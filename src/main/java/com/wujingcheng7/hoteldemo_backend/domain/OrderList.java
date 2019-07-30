package com.wujingcheng7.hoteldemo_backend.domain;

public class OrderList {
    private int order_id;
    private String hotel_id;
    private String user_tel;
    private String room_id;
    private String hotel_room_id;
    private String order_price;
    private String order_indate;
    private String order_outdate;
    private String order_howmanyday;

    public OrderList(int order_id, String hotel_id, String user_tel, String room_id, String hotel_room_id, String order_price, String order_indate, String order_outdate, String order_howmanyday) {
        this.order_id = order_id;
        this.hotel_id = hotel_id;
        this.user_tel = user_tel;
        this.room_id = room_id;
        this.hotel_room_id = hotel_room_id;
        this.order_price = order_price;
        this.order_indate = order_indate;
        this.order_outdate = order_outdate;
        this.order_howmanyday = order_howmanyday;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getUser_tel() {
        return user_tel;
    }

    public void setUser_tel(String user_tel) {
        this.user_tel = user_tel;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getHotel_room_id() {
        return hotel_room_id;
    }

    public void setHotel_room_id(String hotel_room_id) {
        this.hotel_room_id = hotel_room_id;
    }

    public String getOrder_price() {
        return order_price;
    }

    public void setOrder_price(String order_price) {
        this.order_price = order_price;
    }

    public String getOrder_indate() {
        return order_indate;
    }

    public void setOrder_indate(String order_indate) {
        this.order_indate = order_indate;
    }

    public String getOrder_outdate() {
        return order_outdate;
    }

    public void setOrder_outdate(String order_outdate) {
        this.order_outdate = order_outdate;
    }

    public String getOrder_howmanyday() {
        return order_howmanyday;
    }

    public void setOrder_howmanyday(String order_howmanyday) {
        this.order_howmanyday = order_howmanyday;
    }
}
