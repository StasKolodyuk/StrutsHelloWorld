<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<div id="sidebar">
    <ul>
        <li>
            <h2><bean:message key="label.menu" /></h2>
            <ul>
                <li><html:link forward="showNewsListPage"><bean:message key="link.showNewsList" /></html:link></li>
                <li><html:link forward="addNewsPage"><bean:message key="link.addNews" /></html:link></li>
            </ul>
        </li>
    </ul>
</div>
