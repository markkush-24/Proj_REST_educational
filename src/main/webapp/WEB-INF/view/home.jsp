<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title> Title </title>
<%--<link rel="stylesheet" type="text/css" href="/resources/css/webtasks.css"/>--%>
<%--    <link href="<c:url value="resources/css/webtasks.css"/>"--%>

<%--          rel="stylesheet"/> </head>--%>
<body>
<header>
    <table>
        <tr>
            <td>Student management system and their progress</td>
        </tr>
    </table>
</header>



<div class="title_page_container">
    <table cellpadding="0">
        <tr>
            <td align="left"><a
                    href="${pageContext.request.contextPath}/allStudents">Students</a></td>
            <td align="center"><a
                    href="${pageContext.request.contextPath}/allDisciplines">Disciplines</a></td>
            <td align="center"><a href="">Submit grades</a></td>
            <td align="right"><a href="${pageContext.request.contextPath}/allSemestrs">Semesters</a></td>
        </tr>
    </table>
</div>

</body>
</html>