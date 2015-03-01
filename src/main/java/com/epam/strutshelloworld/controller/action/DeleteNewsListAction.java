
package com.epam.strutshelloworld.controller.action;

import com.epam.strutshelloworld.controller.form.MultipleIdForm;
import com.epam.strutshelloworld.model.businesslogic.INewsManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class DeleteNewsListAction extends Action {
    
    private INewsManager newsManager;

    public INewsManager getNewsManager() {
        return newsManager;
    }

    public void setNewsManager(INewsManager newsManager) {
        this.newsManager = newsManager;
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, 
                    HttpServletRequest request, HttpServletResponse response) {
        MultipleIdForm multipleIdForm = (MultipleIdForm)form;
        newsManager.deleteNewsList(multipleIdForm.getId());
        return mapping.findForward("showNewsListPage");
    }
    
    
}
