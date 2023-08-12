<%-- 
    Document   : GenerateGrade
    Created on : Mar 20, 2021, 1:55:51 PM
    Author     : MS
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../login/header.jsp"%>
<fieldset>  <legend>Generate Mark sheet</legend> 
    <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>

        <label>&nbsp;</label><br>
        <input type='submit' id='Save' onclick="callApi()" value='Generate' class='btn btn-success'/>

    </div>
</fieldset>
<script>
    function callApi()
    {
        var URL = path + "/api/Utility/Grade";
        $('.btn').button('loading');
        $.ajax({type: "PUT", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json",
            success: function (data) {
                $('.btn').button('reset');
                messages(data.message);
                return false;
            },
            error: function (XMLHttpRequest) {
                $('.btn').button('reset');
                if (XMLHttpRequest.status === 404) {
                    errorMSG("API Not Found!!");
                } else if (XMLHttpRequest.status === 400) {
                    errorMSG(XMLHttpRequest.responseJSON.message);
                } else {
                    errorMSG(XMLHttpRequest.responseJSON.error);
                }
                return false;
            }
        });
        return false;
    }


</script>

<%@include file="../login/footer.jsp" %>