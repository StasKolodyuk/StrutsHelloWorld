
package com.epam.strutshelloworld.controller.action;

import com.epam.strutshelloworld.controller.form.AddNewsForm;
import com.epam.strutshelloworld.model.businesslogic.INewsManager;
import com.epam.strutshelloworld.model.entity.News;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class AddNewsAction extends Action {
    
    private static final Logger LOGGER = Logger.getLogger(AddNewsAction.class);
    
    private INewsManager newsManager;

    public INewsManager getNewsManager() {
        return newsManager;
    }

    public void setNewsManager(INewsManager newsManager) {
        this.newsManager = newsManager;
    }
    
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        AddNewsForm addNewsForm = (AddNewsForm)form;
        News news = addNewsForm.buildNews();
        newsManager.addNews(news);
        return mapping.findForward("mainpage");
    }
    
}
