<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<logic:iterate name="newsList" id="news">
    <html:form action="/submitNewsForm">
        <div class="post">
            <h2 class="title">${news.title}</h2>
            <p class="meta"><span class="posted"><bean:message key="label.posted" /> <strong><fmt:formatDate value="${news.date}" type="date" dateStyle="short" /></strong></span></p>
            <div style="clear: both;">&nbsp;</div>
            <div class="entry">
                <p>${news.brief}</p>
                <html:hidden property="id" value="${news.id}"/>
                <html:submit styleClass="submit" property="action"><bean:message key="button.view" /></html:submit>
                <html:submit styleClass="submit" property="action"><bean:message key="button.edit" /></html:submit>
                <input type="checkbox" class="checkbox" name="id" value="${news.id}" form="deleteNewsForm" />
            </div>
        </div>
    </html:form>
</logic:iterate>
<div style="clear: both;">&nbsp;</div>
<html:form action="/submitDeleteNewsListForm" styleId="deleteNewsForm" method="post">
    <html:submit styleClass="submit"><bean:message key="button.deleteChecked" /></html:submit>
</html:form>
<div style="clear: both;">&nbsp;</div>