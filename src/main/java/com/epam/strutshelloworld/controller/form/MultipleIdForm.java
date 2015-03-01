
package com.epam.strutshelloworld.controller.form;

import org.apache.struts.action.ActionForm;


public class MultipleIdForm extends ActionForm {
    
    long[] id;

    public long[] getId() {
        return id;
    }

    public void setId(long[] id) {
        this.id = id;
    }
    
}
