
package com.epam.strutshelloworld.controller.action;

import com.epam.strutshelloworld.controller.form.AddNewsForm;
import com.epam.strutshelloworld.controller.form.SingleIdForm;
import com.epam.strutshelloworld.model.businesslogic.INewsManager;
import com.epam.strutshelloworld.model.entity.News;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;


public class NewsAction extends LookupDispatchAction {
    
    private INewsManager newsManager;

    public INewsManager getNewsManager() {
        return newsManager;
    }

    public void setNewsManager(INewsManager newsManager) {
        this.newsManager = newsManager;
    }

    @Override
    protected ActionForward cancelled(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return mapping.findForward("indexPage");
    }
    
    @Override
    protected Map getKeyMethodMap() {
        Map<String, String> keyMethodMap = new HashMap<>();
        keyMethodMap.put("button.view", "view");
        keyMethodMap.put("button.edit", "edit");
        keyMethodMap.put("button.delete", "delete");
        keyMethodMap.put("button.update", "update");
        keyMethodMap.put("button.add", "add");
        return keyMethodMap;
    }
    
    
    public ActionForward delete(ActionMapping mapping, ActionForm form, 
                    HttpServletRequest request, HttpServletResponse response) {
        SingleIdForm singleIdForm = (SingleIdForm)form;
        newsManager.deleteNews(singleIdForm.getId());
        return mapping.findForward("showNewsListPage");
    }
    
    public ActionForward view(ActionMapping mapping, ActionForm form,
                    HttpServletRequest request, HttpServletResponse response) {
        SingleIdForm singleIdForm = (SingleIdForm)form;
        News news = newsManager.findNews(singleIdForm.getId());
        request.setAttribute("news", news);
        return mapping.findForward("showNewsPage");
    }
    
    public ActionForward edit(ActionMapping mapping, ActionForm form,
                    HttpServletRequest request, HttpServletResponse response) {
        SingleIdForm singleIdForm = (SingleIdForm)form;
        News news = newsManager.findNews(singleIdForm.getId());
        request.setAttribute("news", news);
        return mapping.findForward("addNewsPage");
    }
    
    public ActionForward update(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        AddNewsForm addNewsForm = (AddNewsForm) form;
        System.out.println("************************UPDATE************");
        News news = addNewsForm.buildNews();
        System.out.println(news.getId());
        newsManager.updateNews(addNewsForm.buildNews());
        return mapping.findForward("showNewsListPage");
    }
    
    public ActionForward add(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        AddNewsForm addNewsForm = (AddNewsForm) form;
        System.out.println("**************************ADD************");
        News news = addNewsForm.buildNews();
        newsManager.addNews(news);
        return mapping.findForward("showNewsListPage");
    }
    
}
