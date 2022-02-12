
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>

<div class="link_container">
    <table>
        <tr>
            <td><a href="${pageContext.request.contextPath}/">На
                главную</a></td>
            <td><a href="${pageContext.request.contextPath}/allDisciplines">Назад</a></td>
        </tr>
    </table>
</div>

<div class="student_creating_container ">

            <div class="main_line">
                In order to create or modify a discipline, fill in all the fields and click the "Apply" button
            </div>



                <form:form action="saveDiscipline" modelAttribute="discipline">

    <form:hidden path="id"/>

    <table style="line-height: 50px">
        <tr>
            <td width="60px">Name of Discipline</td>
            <td style="padding-left: 30px"><form:input path="discipline"/></td>
        </tr>


        <tr>
            <td></td>
            <td style="padding-left: 32px" height="50px">

                        <input type="submit" value="Apply">
                </form:form>

            </td>
        </tr>
    </table>
    </form>
</div>