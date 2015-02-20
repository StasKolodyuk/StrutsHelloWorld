
package com.epam.strutshelloworld.controller.action;

import com.epam.strutshelloworld.controller.form.CustomerForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class CustomerAction extends Action {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, 
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        if(isCancelled(request)) {
            System.out.println("Operation cancelled");
            return mapping.findForward("mainpage");
        }
        
        CustomerForm customerForm = (CustomerForm)form;
        String firstName = customerForm.getFirstName();
        String lastName = customerForm.getLastName();
        System.out.println(firstName + " " + lastName);
        return mapping.findForward("success");
    }
    
}
