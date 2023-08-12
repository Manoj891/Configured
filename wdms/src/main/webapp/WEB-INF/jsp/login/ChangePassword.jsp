<%-- 
    Document   : ChangePassword
    Created on : Jan 11, 2020, 1:45:00 PM
    Author     : MS
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../login/header.jsp"%>
<br>
<fieldset>  
    <legend></legend> 
    <form method='POST' id='dataFrom' onsubmit="return (doChange());"> 
        <div class="row">
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Old Password</label>
                <input type="password" name='oldPassword' id='oldPassword' class='form-control ' required/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>New Password</label>
                <input type="password" name='newPassword' id='newPassword' class='form-control '  required/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Re Password</label>
                <input type="password" name='rePassword' id='rePassword' class='form-control '  required/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label id='ActionMSG'>&nbsp;</label><br>
                <input type='submit' id='Save' value='Change' class='btn btn-primary'/>
            </div>  
        </div>
    </form>
    <script>
        function doChange() {
            var dataForm = $('form').serializeArray();
            var requestData = {};
            $.each(dataForm, function (i, v) {
                requestData[v.name] = v.value;
            });
            $('.btn').button('loading');
            var URL = "<%=path%>/api/ChangePassword";
            $.ajax({type: "GET", url: URL, data: requestData, headers: {'Authorization': '<%=token%>'}, contentType: "application/json; charset=utf-8", dataType: "json", success: function (data) {

                    $('.btn').button('reset');
                    if (!data['error']) {
                        messages(data['message']);
                        window.location.assign("<%=path%>/Logout");
                    } else {
                        errorMSG(data['error'].message);
                    }
                }
            });
            return false;
        }
    </script>
    <%@include file="../login/footer.jsp" %>