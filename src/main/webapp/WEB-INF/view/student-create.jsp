<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<div class="link_container">
    <table>
        <tr>
            <td><a href="${pageContext.request.contextPath}/">Home</a></td>
            <br>
            <td><a href="${pageContext.request.contextPath}/allStudents">Back</a></td>
        </tr>
        <form>

        </form>
    </table>
</div>
<br><br>
<div class="student_creating_container ">

                <div class="main_line">
                    In order to create or modify a student, enter a new field value and click the "Apply" button.
                </div>


    <table cellpadding="4">
<form:form action="saveStudent" modelAttribute="student">

        <form:hidden path="id"/>
        <tr>
            <td width="115px" align="right">Surname</td>
            <td><form:input path ="name"/></td>
        </tr>

        <tr>
            <td align="right">Name</td>
            <td><form:input path ="surname"/></td>
        </tr>

        <tr>
            <td align="right">Group</td>
            <td><form:input path ="group"/></td>
        </tr>

        <tr>
            <td align="right">Date of enrollment</td>
            <td><form:input path ="date"/></td>
        </tr>




        <tr>
            <td>&nbsp;</td>

            <td style="padding-left: 6px" height="80px">


                        <input type="submit" value="Apply">

                </form:form>

            </td>
        </tr>

    </table>
    </form>


</div>
