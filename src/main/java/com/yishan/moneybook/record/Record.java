package com.yishan.moneybook.record;

public class Record {
    private int id;
    private int cost;
    private String title;
    private String date;
    private String detail;

    public Record() {

    }

    public Record(int id, int cost, String title, String date, String detail) {
        this.id = id;
        this.cost = cost;
        this.title = title;
        this.date = date;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
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
