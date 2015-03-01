<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<div id="wrapper">
    <div id="page">
        <div id="content">
            <tiles:insert attribute="content" />
        </div>
        <tiles:insert attribute="sidebar" />
    </div>
</div>