<%-- 
    Document   : addcourse
    Created on : 14-Mar-2013, 14:12:34
    Author     : Tommy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="courses.Course"%>
<%  // if returning to this page after entering errors, get errors
    // and previous values entered
    String[] errors;
    int errorCount = 0;
    String course_code = "";
    String title = "";
    String s_date = "";
    String f_date = "";
    String max_places = "";
    String total_fee = "";
    String deposit = "";
    String description = "";
    try{
        Course course = (Course) request.getAttribute("course");
        errors = course.getErrors(); 
        errorCount  = course.getErrorCount();
        course_code = course.getCourse_code();
        title = course.getTitle();
        s_date = course.getS_date();
        f_date = course.getF_date();
        max_places = course.getMax_places();
        total_fee = course.getTotal_fee();
        deposit = course.getDeposit();
        description = course.getDescription();
    }
    catch(NullPointerException e){ 
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
                <input type="text" name="course_code" maxlength="6" value="<%=course_code%>"><br>
                Course title:<br>
                <input type="text" name="title" maxlength="100" value ="<%=title%>"><br>
                Start date:<br>
                <input type="text" name="s_date" maxlength="10" value ="<%=s_date%>"
                       placeholder="YYYY-MM-DD"><br>
                Finish date:<br> 
                <input type="text" name="f_date" maxlength="10" value ="<%=f_date%>"
                       placeholder="YYYY-MM-DD"><br>
                Max places:<br>
                <input type="text" name="max_places" <%=max_places%>><br>
                Total fee (euros):<br>
                <input type="text" name="total_fee" <%=total_fee%>><br>
                Deposit (euros):<br>
                <input type="text" name="deposit" <%=deposit%>><br>
                Description:<br>
                <textarea name="description" maxlength="10000"><%=description%></textarea><br>
                <input type="submit" value="Add Course">
            </form>
        </div>
    </body>
</html>
