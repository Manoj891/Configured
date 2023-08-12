<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../login/header.jsp"%>
<br>
<fieldset>  
    <legend></legend> 
    <input type='button' value='Generate Token' onclick="callApi()" class='btn btn-success'/>
</fieldset>
<script>
    function callApi()
    {
        $('.btn').button('loading');
        var URL = path + "/api/Utility/GenerateToken";
        $.ajax({type: "POST", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json",
            success: function (data) {
                $('.btn').button('reset');
                if (!data['error']) {
                    messages(data['message']);

                } else {
                    errorMSG(data['error'].message);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $('.btn').button('reset');
                errorMSG(XMLHttpRequest + " Status: " + textStatus + " Error: " + errorThrown);
            }});
    }
</script>

<%@include file="../login/footer.jsp" %>

<%--
return "\n{\"id\": \""+id+"\",\"name\": \""+name+"\",\"email\": \""+email+"\",\"mobileNo\": \""+mobileNo+"\",\"loginPass\": \""+loginPass+"\",\"contactPerson\": \""+contactPerson+"\",\"personNo\": \""+personNo+"\"}";
--%>