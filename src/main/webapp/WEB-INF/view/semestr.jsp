<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="form" uri="http://java.sun.com/jstl/xml_rt" %>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page isELIgnored="false" %>

<div class="link_container">
    <table>
        <tr>
            <td><a href="${pageContext.request.contextPath}/">Home</a></td>
        </tr>
    </table>

</div>
<div class="terms_list_container">
    <table cellspacing="0" style="margin-top: 20px">

<%--        <form action="${pageContext.request.contextPath}/allSemestrsSem", method="get">--%>
            <form:form action="allSemestrsSem" method="get" id="selectSemestr" modelAttribute="semestr">
            <tr>
                <td style="font-size: large;">Select semester</td>
                <td style="padding-left: 50px">

                    <select name="selectSemestr">

                        <c:forEach items="${semestr}" var="semestr">
                            <option value="${semestr.id}">${semestr.name}</option>
                        </c:forEach>

                    </select>
                </td>
                <td style="padding-left: 20px">
                    <security:authorize access="hasRole('ADMIN')">
                    <input type="submit" id="button" value="select"/></td>
                </security:authorize>
            </tr>
<%--        </form>--%>

        <tr height="80px" style="font-size: large; font-weight: bold;">
            <td colspan="3">Semester duration:<c:forEach items="${semestr}" var="semestr"> ${semestr.duration} </c:forEach></td>
        </tr>

            </form:form>
        <tr style="font-size: large;">
            <td colspan="3">List of disciplines of the semester</td>
        </tr>
    </table>

    <table style="margin-top: 20px">
        <tr>
            <td style="padding: 0" width="450px">
                <table cellspacing="0"
                       cellpadding="3" id="small_font_100_380" border="1px">
                    <tr bgcolor="#DCDCDC" align="left" style="border-color: #8B8989;">
                        <th>Name of the discipline</th>
                    </tr>

                    <c:forEach var="discip" items="${allDisc}">
                        <tr>

                            <td>${discip}</td>

                        </tr>
                    </c:forEach>


                </table>
            </td>

            <td align="left" valign="top" style="padding: 0">

                <table cellspacing="0">
                    <tr>
                        <td style="padding-bottom: 20px; padding-top: 0"><security:authorize access="hasRole('ADMIN')">
                            <input type="submit" value="Create semester" onclick="window.location.href = 'creteNewSemester'">
                        </td>
                    </tr>

                    <tr>
                        <td style="padding-bottom: 20px"><input type="submit" value="Modify current semester"></td>
                    </tr>

                    <tr>
                        <td style="padding-bottom: 20px"><input type="submit" value="Delete current semester"
                                                                onclick="window.location.href = 'deleteSemestr'"></td>
                    </tr>
                    </security:authorize>

                </table>
            </td>
    </table>
</div>
