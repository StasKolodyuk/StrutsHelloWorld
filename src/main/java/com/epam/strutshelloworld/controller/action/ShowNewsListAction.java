
package com.epam.strutshelloworld.controller.action;

import com.epam.strutshelloworld.model.businesslogic.INewsManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ShowNewsListAction extends Action {
    
    private INewsManager newsManager;

    public INewsManager getNewsManager() {
        return newsManager;
    }

    public void setNewsManager(INewsManager newsManager) {
        this.newsManager = newsManager;
    }

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setAttribute("newsList", newsManager.findAllNews());
        return mapping.findForward("showNewsListPage");
    }
    
}