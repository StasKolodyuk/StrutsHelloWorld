
package com.epam.strutshelloworld.model.entity;

import java.util.Date;


public class News {
    
    private Date date;
    private String title;
    private String brief;
    private String content;

    public News() {
        date = new Date();
        title = "";
        brief = "";
        content = "";
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
