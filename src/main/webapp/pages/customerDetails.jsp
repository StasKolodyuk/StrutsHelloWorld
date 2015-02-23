<%@ page contentType="text/html;charset=UTF-8" language="java" %> 

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html:html> 
    <head>
    </head> 

    <body> 
        <html:errors/> 
        <html:form action="/addNewsForm"> 
            Title: 
            <html:text property="title" size="16" maxlength="16"/> 
            <BR> 
            Brief
            <html:text property="brief" size="16" maxlength="16"/> 
            <BR> 
            Content:
            <html:textarea property="content" />
            <html:submit> 
                <bean:message key="button.save"/> 
            </html:submit> 
            &nbsp; 
            <html:cancel> 
                <bean:message key="button.cancel"/> 
            </html:cancel> 
        </html:form> 
    </body> 
</html:html> 