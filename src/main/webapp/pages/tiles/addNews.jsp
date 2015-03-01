<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html:form action="/submitSaveNewsForm" method="post">
        <h2>Title:</h2>
        <html:text property="title" styleClass="search-text" value="${news.title}" />
        <h2>Date:</h2>
        <input type="date" class="search-text" value="${news.date}" />
        <h2>Brief:</h2>
        <html:textarea property="brief" value="${news.brief}" styleClass="search-text" rows="3" />
        <h2>Content:</h2>
        <html:textarea property="content" value="${news.content}" styleClass="search-text" rows="10"/>
        <div style="clear: both;">&nbsp;</div>
        <html:hidden property="id" value="${news.id}"/>
        <c:set var="action" value="${empty news.id ? 'add' : 'update'}" />
        <html:submit styleClass="submit" property="action" value="${action}" />
        <html:cancel styleClass="submit" property="action" value="${action}" />
</html:form>
<div style="clear: both;">&nbsp;</div>