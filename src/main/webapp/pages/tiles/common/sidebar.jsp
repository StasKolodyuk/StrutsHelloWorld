<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<div id="sidebar">
    <ul>
        <li>
            <h2>Menu</h2>
            <ul>
                <li><html:link forward="showNewsListPage">Show News List</html:link></li>
                <li><html:link forward="addNewsPage">Add News</html:link></li>
            </ul>
        </li>
    </ul>
</div>
