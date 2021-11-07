package com.yishan.moneybook.record;

public class Record {
    private Integer id;
    private Integer cost;
    private String title;
    private String date;
    private String detail;

    public Record() {

    }

    public Record(Integer id, Integer cost, String title, String date, String detail) {
        this.id = id;
        this.cost = cost;
        this.title = title;
        this.date = date;
        this.detail = detail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
