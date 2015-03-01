<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html:html>
    <head>
        <tiles:insert attribute="head" />
        <title><tiles:getAsString name="title"/></title>
    </head>
    <body>
        <tiles:insert attribute="header" />
        <tiles:insert attribute="body" />
        <tiles:insert attribute="footer" />
    </body>
</html:html>