<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
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
    <BR>
    <html:submit> 
        <bean:message key="button.save"/> 
    </html:submit>     
    <html:cancel> 
        <bean:message key="button.cancel"/> 
    </html:cancel> 
</html:form> 