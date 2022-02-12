<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>

<div class="link_container">
    <table>
        <tr>
            <td><a href="${pageContext.request.contextPath}/">Home</a></td>
            <td><a href="${pageContext.request.contextPath}/allSemestrs">Back</a></td>
        </tr>
    </table>
</div>

<div class="terms_list_container">
    <br>

    <div class="main_line">

        To create a semester, fill in the following data and click the "Create" button.

    </div>

    <br>
    <table class="under_main_table" style="font-family: cursive;">

        <form:form action="saveNewSemester" modelAttribute="semestr">

        <tr>

            <td width="210px">Semester name</td>

            <td><form:input path="name"/></td>

        </tr>
        <br>
        <tr>
            <td width="210px">Duration (in weeks)</td>

            <td><form:input path="duration"/></td>
        </tr>
        <br>
        <tr>
            <td style="padding-top: 30px" valign="top">Disciplines in a semester</td>
            <td style="padding-top: 30px">

                <table>
                    <tr>
                        <td style="padding: 0"><select multiple size="6" name="AllDiscipline"
                                                       id="multi_list">
                            <c:forEach items="${allDisc}" var="d">
                                <option value="${d.id}">${d.discipline}</option>
                            </c:forEach>
                        </select></td>
                    </tr>
                    <tr>
                        <td style="padding-top: 20px">
                            <input type="submit" value="Create"/>
                        </td>
                    </tr>
                </table>
                </form:form>
                </form>

            </td>
        </tr>
    </table>


</div>