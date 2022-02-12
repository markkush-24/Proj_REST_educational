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

<div class="student_list_container">

    <table>
        <tr>
            <td>
                <security:authorize access="hasRole('ADMIN')">
            <td style="padding-left: 20px">
                <input type="submit" value="Create student" onclick="window.location.href = 'creteNewStudent'"></td>
            </security:authorize>
        </tr>
        <tr>

        </tr>
    </table>
    <table style="margin-top: 30px" width="100%">
        <tr>
            <td align="left" style="font-size: large;">Students list</td>
        </tr>
        <tr>
            <td>
                <table border="2" cellspacing="0" cellpadding="4"
                       id="student_list_table">
                    <tr bgcolor="#DCDCDC" valign="bottom" align="left"
                        style="border-color: #838B83">

                        <th width="30%" style="padding-bottom: 20px">Surname</th>
                        <th width="30%" style="padding-bottom: 20px">Name</th>
                        <th width="15%" style="padding-bottom: 20px">Group</th>
                        <th width="15%" style="padding-bottom: 20px">Date of enrollment</th>
                        <th width="15%" style="padding-bottom: 20px">Buttons of control</th>
                    </tr>
                    <c:forEach items="${allStud}" var="stud">

                        <c:url var="updateButton" value="/updateStudent">
                            <c:param name="studId" value="${stud.id}"/>
                        </c:url>

                        <c:url var="deleteButton" value="/deleteStudent">
                            <c:param name="studId" value="${stud.id}"/>
                        </c:url>

                        <c:url var="progressButton" value="/studentProgress">
                            <c:param name="studId" value="${stud.id}"/>
                        </c:url>

                        <tr valign="bottom">

                            <td style="padding-bottom: 20px">${stud.name}</td>
                            <td style="padding-bottom: 20px">${stud.surname}</td>
                            <td style="padding-bottom: 20px">${stud.group}</td>
                            <td style="padding-bottom: 20px">${stud.date}</td>
                            <td style="padding-bottom: 20px">
                                <security:authorize access="hasRole('ADMIN')">
                                <input type="submit"
                                       value="Modify selected student"
                                       onclick="window.location.href = '${updateButton}'"/>
                                <input type="submit"
                                       value="Delete selected students"
                                       onclick="window.location.href = '${deleteButton}'"/>
                                <input type="submit"
                                       value="View Orientation at Student"
                                       onclick="window.location.href = '${progressButton}'"></td>
                            </security:authorize>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </table>
</div>

