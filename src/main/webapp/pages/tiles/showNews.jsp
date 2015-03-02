<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html:form action="/submitNewsForm">
    <div class="post">
        <h2 class="title">${news.title}</h2>
        <p class="meta"><span class="posted">Posted on <strong><fmt:formatDate value="${news.date}" type="date" dateStyle="short" /></strong></span></p>
        <div style="clear: both;">&nbsp;</div>
        <div class="entry">
            <p>${news.content}</p>
            <html:hidden property="id" value="${news.id}" />
            <html:submit styleClass="submit" property="action"><bean:message key="button.edit" /></html:submit>
            <html:submit styleClass="submit" property="action"><bean:message key="button.delete" /></html:submit>
        </div>
    </div>
</html:form>