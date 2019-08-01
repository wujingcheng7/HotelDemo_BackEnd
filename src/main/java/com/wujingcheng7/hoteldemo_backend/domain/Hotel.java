package com.wujingcheng7.hoteldemo_backend.domain;

public class Hotel {
    private String hotel_id;
    private String hotel_name;
    private String hotel_longitude;
    private String hotel_latitude;
    private String hotel_stars;
    private String hotel_address;
    private String hotel_text;
    private String hotel_city;
    private String hotel_img_url;

    public Hotel(String hotel_id, String hotel_name, String hotel_longitude, String hotel_latitude, String hotel_stars, String hotel_address, String hotel_text, String hotel_city, String hotel_img_url) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.hotel_longitude = hotel_longitude;
        this.hotel_latitude = hotel_latitude;
        this.hotel_stars = hotel_stars;
        this.hotel_address = hotel_address;
        this.hotel_text = hotel_text;
        this.hotel_city = hotel_city;
        this.hotel_img_url = hotel_img_url;
    }

    public Hotel() {
    }

    public String getHotel_img_url() {
        return hotel_img_url;
    }

    public void setHotel_img_url(String hotel_img_url) {
        this.hotel_img_url = hotel_img_url;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_longitude() {
        return hotel_longitude;
    }

    public void setHotel_longitude(String hotel_longitude) {
        this.hotel_longitude = hotel_longitude;
    }

    public String getHotel_latitude() {
        return hotel_latitude;
    }

    public void setHotel_latitude(String hotel_latitude) {
        this.hotel_latitude = hotel_latitude;
    }

    public String getHotel_stars() {
        return hotel_stars;
    }

    public void setHotel_stars(String hotel_stars) {
        this.hotel_stars = hotel_stars;
    }

    public String getHotel_address() {
        return hotel_address;
    }

    public void setHotel_address(String hotel_address) {
        this.hotel_address = hotel_address;
    }

    public String getHotel_text() {
        return hotel_text;
    }

    public void setHotel_text(String hotel_text) {
        this.hotel_text = hotel_text;
    }

    public String getHotel_city() {
        return hotel_city;
    }

    public void setHotel_city(String hotel_city) {
        this.hotel_city = hotel_city;
    }
}
