package com.wujingcheng7.hoteldemo_backend.domain;

public class HotelRoom {
    private String hotel_room_id;
    private String room_id;
    private String hotel_id;
    private String book_id;
    private String room_type;
    private String room_price;
    private String room_text;

    public HotelRoom() {
    }

    public String getHotel_room_id() {
        return hotel_room_id;
    }

    public void setHotel_room_id(String hotel_room_id) {
        this.hotel_room_id = hotel_room_id;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getRoom_price() {
        return room_price;
    }

    public void setRoom_price(String room_price) {
        this.room_price = room_price;
    }

    public String getRoom_text() {
        return room_text;
    }

    public void setRoom_text(String room_text) {
        this.room_text = room_text;
    }

    public HotelRoom(String hotel_room_id, String room_id, String hotel_id, String book_id, String room_type, String room_price, String room_text) {
        this.hotel_room_id = hotel_room_id;
        this.room_id = room_id;
        this.hotel_id = hotel_id;
        this.book_id = book_id;
        this.room_type = room_type;
        this.room_price = room_price;
        this.room_text = room_text;
    }
}
