
package com.epam.strutshelloworld.controller.action;

import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class ChangeLanguageAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Locale locale = Locale.forLanguageTag(request.getParameter("language"));
        request.getSession().setAttribute(Globals.LOCALE_KEY, locale);
        return mapping.findForward("indexPage");
    }
    
}
