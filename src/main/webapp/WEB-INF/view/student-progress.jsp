<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="link_container">
    <table>
        <tr>
            <td><a href="${pageContext.request.contextPath}/">Home</a></td>
            <td><a href="${pageContext.request.contextPath}/allStudents">Back</a></td>
        </tr>
    </table>
</div>

<div class="student_list_container">
    <h3>Displayed progress for the next student:</h3>

    <table cellspacing="0">
        <tr>
            <td>
                <table border="1" cellspacing="0" cellpadding="3"
                       style="font-size: small; line-height: 25px; border-color: #D1EEEE">

                    <tr bgcolor="#DCDCDC" align="left" style="border-color: #838B83">
                        <th width="100px">Name</th>
                        <th width="230px">Surname</th>
                        <th width="270px">Group</th>
                        <th width="220px">Date of enrollment</th>
                    </tr>

                    <form:form action="studentProgress" modelAttribute="student" >

                        <form:hidden path="id"/>
                        <tr valign="bottom">

                            <td style="padding-bottom: 20px"><p>${student.name}</p></td>
                            <td style="padding-bottom: 20px"><p>${student.surname}</p></td>
                            <td style="padding-bottom: 20px"><p>${student.group}</p></td>
                            <td style="padding-bottom: 20px"><p>${student.date}</p></td>

                            </td>
                        </tr>



                </table>
            </td>
        </tr>
        <tr>
            <td>
                <table>
                    <tr>
                        <td style="padding: 50px 0 0 0">
                            <table border="1"
                                   cellspacing="0" cellpadding="3"
                                   style="font-size: small; line-height: 100px; border-color: #D1EEEE">
                                <tr bgcolor="#DCDCDC" align="left" style="border-color: #838B83">
                                    <th width="250px">Discipline</th>
                                    <th width="100px">Mark</th>
                                </tr>


                                <c:forEach items="${Disc}" var="Dis">
                                    <tr>
                                        <td style="padding-bottom: 20px">${Dis}</td>
                                        <td style="padding-bottom: 20px"></td>
                                    </tr>
                                </c:forEach>

                            </table>
                        <td/>
                        </form:form>
                        <input type="hidden" name="id" value="">
                        <td style="padding: 50px 0 0 30px" valign="top">
                            <table
                                    style="width: 450px" cellpadding="0" cellspacing="0">
                                <tr align="right">

                                    <form action="${pageContext.request.contextPath}/studentProgressSem" method="get">
                                    <td>Select semester</td>
                                    <td style="padding-left: 10px">

                                        <select name="selectSemestr">
                                            <c:forEach items="${semestr}" var="sem">
                                                <option value="${sem.id}">${sem.name}</option>
                                            </c:forEach>
                                        </select>

                                    </td>
                                    <td style="padding-left: 10px"><input type="submit" value="Select" id="button"
                                                                          style="width: 100px"></td>
                                    </form>

                                </tr>
                                <tr style="line-height: 100px">
                                    <td colspan="3"><big>Average grade per semester: 4
                                        points</big></td>
                                </tr>
                            </table>
                        </td>

                </table>
            </td>
        </tr>
    </table>

</div>
