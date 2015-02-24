
package com.epam.strutshelloworld.controller.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class CustomerForm extends ActionForm {
    
    private String firstName;
    private String lastName;

    public CustomerForm() {
        this.firstName = "";
        this.lastName = "";
    }

    public CustomerForm(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    

    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors(); 
        if (firstName == null || firstName.trim().equals("")) { 
            errors.add("firstName", new ActionMessage("error.cust.firstname.null")); 
        } 
        return errors;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
