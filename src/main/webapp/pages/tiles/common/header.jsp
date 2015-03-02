<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<div id="header-wrapper">
    <div id="header">
        <div id="logo">
            <h1><a href="#">Java News</a></h1>
            <html:link action="/changeLanguage.do?language=en" styleClass="language">English</html:link>
            <html:link action="/changeLanguage.do?language=ru" styleClass="language">Русский</html:link>
        </div>
    </div>
</div>