package com.wujingcheng7.hoteldemo_backend.domain;

import java.util.Date;

public class Log {
    private String log_id;
    private String log_operation;
    private String log_man;
    private Date   log_time;
    private int order_id;
    private String hotel_id;

    public String getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(String hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Log() {
    }

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public String getLog_operation() {
        return log_operation;
    }

    public void setLog_operation(String log_operation) {
        this.log_operation = log_operation;
    }

    public String getLog_man() {
        return log_man;
    }

    public void setLog_man(String log_man) {
        this.log_man = log_man;
    }

    public Date getLog_time() {
        return log_time;
    }

    public void setLog_time(Date log_time) {
        this.log_time = log_time;
    }


}
