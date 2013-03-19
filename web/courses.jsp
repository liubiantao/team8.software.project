<%-- 
    Document   : courses.jsp
    Created on : 13-Mar-2013, 15:59:45
    Author     : Tommy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*;"%>
<jsp:useBean id="dbmanager" class="database.DbManager" scope="session"/>

<!DOCTYPE html> 
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>
        Courses
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Le styles -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <style>
      body { padding-top: 60px; /* 60px to make the container go all the way
      to the bottom of the topbar */ }
    </style>
    <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js">
      </script>
    <![endif]-->
    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
    <style>
    </style>
  </head>
  <body>
    <div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container-fluid">
          <form class="navbar-form pull-right">
            <input name="textinput1" type="email" placeholder="Email" class="span2">
            <input name="textinput2" type="password" placeholder="Password" class="span2">
            <button class="btn btn-primary">
              Log in
            </button>
            <button class="btn">
              Sign up
            </button>
          </form>
          <a class="brand" href="#">
            <em>
              <strong>
               UCC
              </strong>
            </em>
          </a>
          <ul class="nav">
            <li>
              <a href="index.jsp">
                <strong>
                  Home
                </strong>
              </a>
            </li>
            <li  class="active">
              <a href="courses.jsp">
                <div>
                  Courses
                </div>
              </a>
            </li>
            <li>
              <a href="contact.jsp">
                Contact
              </a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    
    <div>
        <table>
            <caption>Courses</caption>
            <thead>
                <th>Course Title</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Available Places</th>
                <th>Fee</th>
            </thead>
            <tbody>
            <% 
                dbmanager.connect();
                ResultSet resultSet = dbmanager.query("SELECT title, s_date, f_date, avail_places, total_fee " +
                                                         "FROM courses");

                while(resultSet.next()) {
                    out.println("<tr>");
                    String title = resultSet.getString("title");
                    Date sdate = resultSet.getDate("s_date");
                    Date fdate = resultSet.getDate("f_date");
                    int avail_places = resultSet.getInt("avail_places");
                    int fee = resultSet.getInt("total_fee");
                    out.println("<td>" + title + "</td>" +
                                "<td>" + sdate + "</td>" + 
                                "<td>" + fdate + "</td>" + 
                                "<td>" + avail_places + "</td>" + 
                                "<td>" + fee + "</td>");
                    out.println("</tr>");
                } 
                dbmanager.disconnect();
            %> 
            </tbody>
        </table>
    </div>


    <style>
      
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js">
    </script>
    <script src="assets/js/bootstrap.js">
    </script>
  </body>
</html>