<%-- 
    Document   : addcourse
    Created on : 14-Mar-2013, 14:12:34
    Author     : Tommy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="courses.Course"%>
<%  // if returning to this page after entering errors, get errors
    int errorCount;
    String[] errors;
    try{
        Course course = (Course) request.getAttribute("course");
        errors = course.getErrors(); 
        errorCount  = course.getErrorCount();
    }
    catch(NullPointerException e){
        errorCount = 0;
        errors = new String[0];
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a course</title>
    </head>
    <body>
        <div id="courseForm">
            <%  //display errors (if any)
                if(errorCount > 0) {
                    out.print("<ul>");
                    for(int i = 0; i < errorCount; i++) {
                       out.print("<li>");
                       out.print(errors[i]);
                       out.print("</li>"); 
                    }
                    out.print("</ul>");
                }
            %>
                <h1>Add a course</h1>
                <form action ="validateAddCourse" method="POST" autocomplete="on">
                Course code:<br>
                <input type="text" name="course_code" maxlength="6"><br>
                Course title:<br>
                <input type="text" name="title" maxlength="100"><br>
                Start date:<br>
                <input type="text" name="s_date" maxlength="10" 
                       placeholder="YYYY-MM-DD"><br>
                Finish date:<br> 
                <input type="text" name="f_date" maxlength="10"
                       placeholder="YYYY-MM-DD"><br>
                Max places:<br>
                <input type="text" name="max_places"><br>
                Total fee (euros):<br>
                <input type="text" name="total_fee"><br>
                Deposit (euros):<br>
                <input type="text" name="deposit"><br>
                Description:<br>
                <textarea name="description" maxlength="10000"></textarea><br>
                <input type="submit" value="Add Course">
            </form>
        </div>
    </body>
</html>
