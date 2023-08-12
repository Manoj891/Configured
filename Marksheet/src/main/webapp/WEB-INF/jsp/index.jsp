<%
    String path = request.getContextPath();
%>
<html lang="en">
    <head>
        <meta charset="utf-8">        
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" type="image/x-icon" href="<%=path%>/favicon.ico">
        <script src="<%=path%>/bootstrap/js/jquery-3.4.1.min.js" type="text/javascript"></script>
        <script src="<%=path%>/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <link href="<%=path%>/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <script src="<%=path%>/bootstrap/js/bootstrap.js" type="text/javascript"></script>
        <link href="<%=path%>/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="<%=path%>/bootstrap/jqueryToast/jquery.toast.min.js" type="text/javascript"></script>
        <link href="<%=path%>/bootstrap/jqueryToast/jquery.toast.min.css" rel="stylesheet" type="text/css"/>
        <link href="<%=path%>/bootstrap/style.css" rel="stylesheet" type="text/css" />

        <script>
            var path = "<%=path%>";
        </script>

        <title>MS-Ware Solutions</title>
    </head>

    <body id="login-body">
        <div id="logreg-forms">

            <form id="loginForm" class="form-signin">
                <img id="person" draggable="false"
                     class="tc center-block head-image"
                     src="<%=path%>/images/person.png" alt="" /> 
                <img id="no-no" class="tc center-block head-image" draggable="false"
                     src="<%=path%>/images/giphy.gif" alt="" style="display: none;" />
                <h3 id="h2">Mark sheet Login</h3>
                <input type="email" id="userName" name="userName" class="form-control" placeholder="Email address" required autofocus=""> 
                <input type="password" id="userPassword" name="userPassword" class="form-control" placeholder="Password" required style="margin-top: 5px;">
                <button class="btn form-control sub-btn" type="button" onclick="doLogin()">SIGN IN</button>

            </form>

            <script>
                function doLogin() {
                    $(".btn").button("loading");
                    var userPassword = document.getElementById("userPassword").value;
                    var userName = document.getElementById("userName").value;
                    $.ajax({type: "POST", url: "<%=request.getContextPath()%>/Login?userPassword=" + userPassword + "&userName=" + userName, contentType: "application/json; charset=utf-8", dataType: "json",
                        success: function (data) {
                            $(".btn").button("reset");
                            if (data['error']) {
                                errorMSG(data['error']);
                                $("#no-no").show();
                                $("#person").hide();
                                setTimeout(function () {
                                    $("#no-no").hide();
                                    $("#person").show();
                                }, 3000);
                            } else {
                                window.location.assign('<%=request.getContextPath()%>/Login/' + data.token);
                            }
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            $('.btn').button('reset');
                            errorMSG(XMLHttpRequest + " Status: " + textStatus + " Error: " + errorThrown);
                        }
                    });
                }
                function errorMSG(msg) {
                    $(".btn").button("reset");
                    $.toast({
                        heading: "Error",
                        text: msg,
                        icon: 'error',
                        loader: true, // Change it to false to disable loader
                        loaderBg: '#FF0000', // To change the background,
                        position: 'mid-center'
                    });
                }
            </script>
        </div>
    </body>
</html>
