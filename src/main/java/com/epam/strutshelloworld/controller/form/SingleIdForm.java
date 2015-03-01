
package com.epam.strutshelloworld.controller.form;

import org.apache.struts.action.ActionForm;


public class SingleIdForm extends ActionForm {
    
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
}
