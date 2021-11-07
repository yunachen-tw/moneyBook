package com.yishan.moneybook.record;

import javax.validation.constraints.NotNull;

public class Record {
    @NotNull(message = "id 不得為空值")
    private Integer id;
    @NotNull(message = "花費尚未填寫")
    private Integer cost;
    @NotNull(message = "標題尚未填寫")
    private String title;
    @NotNull(message = "日期尚未填寫")
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
