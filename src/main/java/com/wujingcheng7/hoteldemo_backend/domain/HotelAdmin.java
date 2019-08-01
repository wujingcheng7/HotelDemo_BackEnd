package com.wujingcheng7.hoteldemo_backend.domain;

public class HotelAdmin {
    String hotel_admin_id;
    String hotel_id;
    String hotel_admin_pwd;

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

    public String getHotel_admin_pwd() {
        return hotel_admin_pwd;
    }

    public void setHotel_admin_pwd(String hotel_admin_pwd) {
        this.hotel_admin_pwd = hotel_admin_pwd;
    }

    public HotelAdmin() {
    }

    public HotelAdmin(String hotel_admin_id, String hotel_id, String hotel_admin_pwd) {
        this.hotel_admin_id = hotel_admin_id;
        this.hotel_id = hotel_id;
        this.hotel_admin_pwd = hotel_admin_pwd;
    }
}
