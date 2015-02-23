
package com.epam.strutshelloworld.controller.form;

import com.epam.strutshelloworld.model.entity.News;
import java.util.Date;
import org.apache.struts.action.ActionForm;
import org.springframework.beans.BeanUtils;


public class AddNewsForm extends ActionForm {
    
    private long id;
    private Date date;
    private String title;
    private String brief;
    private String content;

    public AddNewsForm() {
        date = new Date();
        title = "";
        brief = "";
        content = "";
    }
    
    public News buildNews() {
        News news = new News();
        BeanUtils.copyProperties(this, news);
        return news;
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
