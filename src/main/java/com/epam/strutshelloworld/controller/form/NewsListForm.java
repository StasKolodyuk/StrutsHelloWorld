
package com.epam.strutshelloworld.controller.form;

import org.apache.struts.action.ActionForm;


public class NewsListForm extends ActionForm {

    private long viewEditNewsId;
    private long[] deleteNewsIds;

    public long getViewEditNewsId() {
        return viewEditNewsId;
    }

    public void setViewEditNewsId(long viewEditNewsId) {
        this.viewEditNewsId = viewEditNewsId;
    }

    public long[] getDeleteNewsIds() {
        return deleteNewsIds;
    }

    public void setDeleteNewsIds(long[] deleteNewsIds) {
        this.deleteNewsIds = deleteNewsIds;
    }
    
}
