package com.example.retrofitlibrary.Modals;

public class Modal1 {
    private int userId,id;
    private String title,boby;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBoby() {
        return boby;
    }

    public void setBoby(String boby) {
        this.boby = boby;
    }

    @Override
    public String toString() {
        return "Modal1{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", boby='" + boby + '\'' +
                '}';
    }
}
