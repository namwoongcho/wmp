<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <form:form method="POST"
          action="/" modelAttribute="request">
             <table>
                <tr>
                    <td><form:label path="url">URL</form:label></td>
                    <td><form:input path="url"/></td>
                </tr>
                <tr>
                    <td><form:label path="type">Type</form:label></td>
                    <td><form:select path="type">
      						<form:option value="excludeHTML"/>
      						<form:option value="Text"/>
   						</form:select></td>
                </tr>
                <tr>
                    <td><form:label path="division">출력묵음단위(자연수)</form:label></td>
                    <td><form:input path="division"/></td>
                </tr>
                <tr>
                    <td><form:label path="quotient">
                     몫:</form:label></td>
                    <td><form:textarea readonly="true" path="quotient" rows="30" cols="100"/></td>
                </tr>
                 <tr>
                    <td><form:label path="remainder">
                     나머지:</form:label></td>
                    <td><form:textarea readonly="true" path="remainder" rows="30" cols="100"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>