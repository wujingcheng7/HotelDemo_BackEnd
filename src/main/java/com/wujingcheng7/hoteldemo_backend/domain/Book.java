package com.wujingcheng7.hoteldemo_backend.domain;

public class Book {
    private String book_id;
    private String hotel_id;
    private String user_tel;
    private String room_id;
    private String book_time;
    private String live_time;
    private String last_time;

    public Book() {
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
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

    public String getBook_time() {
        return book_time;
    }

    public void setBook_time(String book_time) {
        this.book_time = book_time;
    }

    public String getLive_time() {
        return live_time;
    }

    public void setLive_time(String live_time) {
        this.live_time = live_time;
    }

    public String getLast_time() {
        return last_time;
    }

    public void setLast_time(String last_time) {
        this.last_time = last_time;
    }

    public Book(String book_id, String hotel_id, String user_tel, String room_id, String book_time, String live_time, String last_time) {
        this.book_id = book_id;
        this.hotel_id = hotel_id;
        this.user_tel = user_tel;
        this.room_id = room_id;
        this.book_time = book_time;
        this.live_time = live_time;
        this.last_time = last_time;
    }
}
