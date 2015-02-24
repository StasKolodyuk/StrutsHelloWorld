<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>


<html:html>
    <head>
        <title><tiles:getAsString name="title"/></title>
    </head>
    <body>
        <table>
            <tr>
                <td colspan="2">
                    <tiles:insert attribute="header" />
                </td>
            </tr>
            <tr>
                <td>
                    <tiles:insert attribute="sidebar" />
                </td>
                <td>
                    <tiles:insert attribute="body" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <tiles:insert attribute="footer" />
                </td>
            </tr>
        </table>
    </body>
</html:html>