<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = "/", token = "", userType = "";
    try {
        token = session.getAttribute("paymentToken").toString();
        userType = session.getAttribute("userType").toString();
        path = request.getContextPath();
        if (token.length() < 100 || userType.length() <= 0) {
            out.print("<script>window.location.assign('" + path + "');</script>");
        }
    } catch (Exception e) {
        out.print("<script>window.location.assign('" + path + "');</script>");
    }

%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <script>
            var path = "<%=path%>";
            var token = "<%=token%>";
        </script>
        <title>Welcome in MsWare</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="robots" content="index, follow" />
        <link rel="shortcut icon" type="image/x-icon" href="<%=path%>/images/favicon.ico">

        <link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="<%=path%>/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script src="<%=path%>/bootstrap/js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="<%=path%>/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="<%=path%>/bootstrap/jqueryToast/jquery.toast.min.js" type="text/javascript"></script>
        <link href="<%=path%>/bootstrap/jqueryToast/jquery.toast.min.css" rel="stylesheet" type="text/css"/>
        <link href="<%=path%>/bootstrap/style.css" rel="stylesheet" type="text/css"/>       
        <script src="<%=path%>/bootstrap/datatables.js" type="text/javascript"></script>
        <link href="<%=path%>/bootstrap/datatables.css" rel="stylesheet" type="text/css"/>
        <script src="<%=path%>/bootstrap/js/jswithcss.js" type="text/javascript"></script>
    </head>
    <body>


        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="collapse navbar-collapse" id="myNavbar">

                <ul class="nav navbar-nav navbar-right" style="padding-right: 100px;">
                    <%
                        // out.print(userType);
                        // out.print(session.getAttribute("userName"));
                        // out.print(session.getAttribute("userId"));
                        if (userType.equalsIgnoreCase("ADM")) {
                    %>
                    <li><a href="<%= path%>/Utility/PersonnelCompany" style="color:red;" class="log-ot">Company</a><li>
                    <li><a href="<%= path%>/Utility/DeviceLogin" style="color:red;" class="log-ot">User</a><li>
                    <li><a href="<%= path%>/Utility/UserDeviceAccess" style="color:red;" class="log-ot">User Access</a><li>
                        <%}%>
                    <li><a href="<%= path%>/Utility/Transaction" style="color:red;" class="log-ot"> Transaction</a><li>
                    <!--<li><a href="<%= path%>/Utility/PersonnelEmployee" style="color:red;" class="log-ot"> Employee</a><li>-->
                    <li><a href="<%= path%>/ChangePassword" style="color:red;" class="log-ot">Change Password</a><li>
                    <li><a href="<%= path%>/Logout" style="color:red;" class="log-ot">Log Out</a><li>
                </ul>           
            </div>                      
        </nav>
        <div class="container" id="container" style="overflow: auto">
