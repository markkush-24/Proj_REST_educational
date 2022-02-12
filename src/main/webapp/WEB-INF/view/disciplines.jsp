<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page isELIgnored="false" %>
<div class="link_container">
    <table>
        <tr>
            <td><a href="${pageContext.request.contextPath}/">Home</a></td>
        </tr>
    </table>
</div>

<div class="disciplines_List_container">
    <div style="padding-left: 30px; font-size: larger; height: 60px">List of disciplines
    </div>

    <tr>
        <td style="padding-bottom: 60px; padding-down: 0px;">
            <security:authorize access="hasRole('ADMIN')">
            <input type="submit" value="Create discipline" onclick="window.location.href = 'creteNewDiscipline'"></td>
        </security:authorize>
    </tr>


    <table>
        <tr>
            <td style="padding-left: 30px; width: 430px;">
                <table
                        cellspacing="0" cellpadding="3" id="small_font_100_380" border="1">
                    <tr bgcolor="#DCDCDC" align="left" style="border-color: #8B8989;">
                        <th width="320px">Name of the discipline</th>
                        <th width="140px">Buttons of control</th>
                    </tr>

                    <c:forEach items="${allDisc}" var="d">

                        <c:url var="updateButton" value="/updateDiscipline">
                            <c:param name="discId" value="${d.id}"/>
                        </c:url>


                        <c:url var="deleteButton" value="/deleteDiscipline">
                            <c:param name="discId" value="${d.id}"/>
                        </c:url>

                        <tr>
                            <td align="left">${d.discipline}</td>
                            <td style="padding-bottom: 20px">
                                <security:authorize access="hasRole('ADMIN')">
                                <input onclick="window.location.href = '${updateButton}'" type="submit"
                                       value="Modify">
                                <input onclick="window.location.href = '${deleteButton}'" type="submit"
                                       value="Delete">
                                </security:authorize>
                            </td>

                        </tr>
                    </c:forEach>

                </table>
            </td>

            <td valign="top" align="left" style="padding: 0">
                <table cellspacing="0">


                </table>
            </td>

        </tr>
    </table>

</div>

