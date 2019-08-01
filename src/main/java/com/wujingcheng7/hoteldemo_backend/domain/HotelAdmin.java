package com.wujingcheng7.hoteldemo_backend.domain;

public class HotelAdmin {
    String hotel_admin_id;
    String hotel_id;
    String hotel_admin_psw;

    public String getHotel_admin_id() {
        return hotel_admin_id;
    }

    public void setHotel_admin_id(String hotel_admin_id) {
        this.hotel_admin_id = hotel_admin_id;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_admin_psw() {
        return hotel_admin_psw;
    }

    public void setHotel_admin_psw(String hotel_admin_psw) {
        this.hotel_admin_psw = hotel_admin_psw;
    }

    public HotelAdmin() {
    }

    public HotelAdmin(String hotel_admin_id, String hotel_id, String hotel_admin_psw) {
        this.hotel_admin_id = hotel_admin_id;
        this.hotel_id = hotel_id;
        this.hotel_admin_psw = hotel_admin_psw;
    }
}
