<%-- 
    Document   : MobileApp
    Created on : May 23, 2020, 12:52:49 PM
    Author     : MS
--%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%     String path = request.getContextPath();%>
        <title>Education Management System</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript"></script>
        <!--<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

        <!-- jQuery -->
        <script src="<%=path%>/loginDesign/assets/js/jquery.min.js"></script>
        <!-- jQuery Easing -->
        <script src="<%=path%>/loginDesign/assets/js/jquery.easing.1.3.js"></script>

        <script src="<%=path%>/loginDesign/assets/js/jquery.waypoints.min.js"></script>
        <!-- Carousel -->
        <script src="<%=path%>/loginDesign/assets/js/owl.carousel.min.js"></script>
        <!-- countTo -->
        <script src="<%=path%>/loginDesign/assets/js/jquery.countTo.js"></script>

        <!-- Stellar -->
        <script src="<%=path%>/loginDesign/assets/js/jquery.stellar.min.js"></script>
        <link href="https://fonts.googleapis.com/css?family=Dancing+Script" rel="stylesheet">

        <!--<script src="js/modernizr-2.6.2.min.js"></script>-->
        <link href="<%=path%>/styleLogin.css" rel="stylesheet" type="text/css"/>
    </head>

    <body style="overflow: auto">

        <div class="loading-image"></div>
        <div id="page">



            <header class="cover-image" role="banner" style="background-image:url(<%=path%>/images/background_login.jpg);" data-stellar-background-ratio="0.5">
                <div class="overlay"></div>
                <div class="animate">


                    <div style="padding-left: 50px;line-height:1">
                        <span style="font-size: 50px;color:white">EDUCATION MANAGEMENT INFORMATION SYSTEM</span>

                    </div>
                    <div class="col-lg-offset-4 col-md-offset-4 col-lg-4 col-md-4 col-sm-4 col-xl-12">

                        <select class="form-control" id="organization">  </select>
                    </div>
                    <div class="display-t">

                        <div class="display-tc text-center">

                            <div class="parliament-switch text-center">

                                <a href="#" onclick="doStudentsLogin()" class="btn btn-lg btn-student" style="width: 240px;">
                                    <q>&nbsp;&nbsp;&nbsp;STUDENT&nbsp;&nbsp;&nbsp;</q> 
                                </a>
                                <a href="#" onclick="doTeachersLogin()" class="btn btn-lg btn-blue" style="width: 240px;">
                                    <q>&nbsp;&nbsp;&nbsp;TEACHER&nbsp;&nbsp;&nbsp;</q> 
                                </a>

                            </div>
                        </div>                      
                    </div>

                </div>

            </header>
        </div>  
        <script src="<%=path%>/mainLogin.js" type="text/javascript"></script>
        <script>
                                    var data = [];
                                    function doTeachersLogin() {
                                        var organization = document.getElementById("organization").selectedIndex;
                                        if (organization <= 0) {
                                            alert("Please select School/College");
                                            return false;
                                        }
                                        var schoolApi = data[organization - 1].schoolApi;
                                        localStorage.setItem("infowebschoolApi", schoolApi);
                                        localStorage.setItem("infowebLoginType", "T");
                                        window.location.assign(schoolApi + "Teacher/");
                                    }
                                    function doStudentsLogin() {
                                        var organization = document.getElementById("organization").selectedIndex;
                                        if (organization <= 0) {
                                            alert("Please select School/College");
                                            return false;
                                        }
                                        var schoolApi = data[organization - 1].schoolApi;
                                        localStorage.setItem("infowebschoolApi", schoolApi);
                                        localStorage.setItem("infowebLoginType", "S");
                                        window.location.assign(schoolApi + "Student/");
                                    }
                                    function getRecord()
                                    {
                                        if (localStorage.getItem("infowebschoolApi")) {
                                            var schoolApi = localStorage.getItem("infowebschoolApi");
                                            var infowebLoginType = localStorage.getItem("infowebLoginType");
                                            if (infowebLoginType === "T")
                                            {
                                                window.location.assign(schoolApi + "Teacher/");
                                            } else if (infowebLoginType === "S")
                                            {
                                                window.location.assign(schoolApi + "Student/");
                                            }
                                        }
                                        tableData = "<option value=''>Select</option>";
                                        $('#organization').empty().append(tableData);
                                        var URL = "<%= request.getContextPath()%>/api/Utility/SchoolList";
                                        $.ajax({type: "GET", url: URL, contentType: "application/json; charset=utf-8",
                                            dataType: "json", success: function (res) {
                                                data = res;
                                                for (var i = 0; i < data.length; i++)
                                                {
                                                    tableData = "<option value='" + data[i].id + "'>" + data[i].name + "</option>";
                                                    $('#organization').append(tableData);
                                                }

                                            }
                                        });
                                    }
                                    getRecord();

        </script>
    </body>
</html>
