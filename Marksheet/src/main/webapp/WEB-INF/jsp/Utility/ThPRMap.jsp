<%-- 
    Document   : ThPRMap
    Created on : Mar 18, 2021, 7:04:39 AM
    Author     : MS
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../login/header.jsp"%>
<fieldset>  <legend>Subject Master</legend> 

    <div class="row">
        <div class='col-lg-3 col-sm-3 col-md-3 col-xs-6' >
            <label>TH</label>
            <select name='th' id='th' class='form-control subject'>

            </select>
        </div>

        <div class='col-lg-3 col-sm-3 col-md-3 col-xs-6' >
            <label>PR</label>
            <select name='pr' id='pr' class='form-control subject'></select>
        </div>
        <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>

            <label>&nbsp;</label><br>
            <input type='submit' id='Save' onclick="doSave()" value='Save' class='btn btn-success'/>

        </div>
    </div>
</fieldset>
<br> <fieldset>  <legend> Data</legend> 
    <div class='row' id='table'></div>
</fieldset>
<script>
    function callApi(URL, requestData, apiMethod)
    {
        $('.btn').button('loading');
        $.ajax({type: apiMethod, url: URL, headers: {'Authorization': token}, data: JSON.stringify(requestData), contentType: "application/json; charset=utf-8", dataType: "json",
            success: function (data) {
                $('.btn').button('reset');
                messages(data.message);
                 getRecordPR();
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
            }
        });
    }

    function doSave()
    {
        var th = document.getElementById("th").value;
        var pr = document.getElementById("pr").value;
        var URL = path + "/api/Utility/SubjectMaster";
        callApi(URL, {"id": th, "prSubject": pr}, "PATCH");
        return false;
    }
    function getRecord()
    {
        var URL = path + "/api/Utility/SubjectMaster";
        $.ajax({type: "GET", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json"
            , success: function (data) {

                for (var i = 0; i < data.length; i++)
                {
                    $('.subject').append("<option value='" + data[i].id + "'>" + data[i].subjectName + " (" + data[i].subjectCode + ")</option>");
                }

            }
            , error: function (XMLHttpRequest) {
                $('.btn').button('reset');
                if (XMLHttpRequest.status === 404) {
                    errorMSG("API Not Found!!");
                } else if (XMLHttpRequest.status === 400) {
                    errorMSG(XMLHttpRequest.responseJSON.message);
                } else {
                    errorMSG(XMLHttpRequest.responseJSON.error);
                }
            }
        });
    }
    function recordDelete(id) {
        if (!confirm('Are you sure')) {
            return;
        }
        var URL = path + "/api/Utility/SubjectMaster/" + id;
        callApi(URL, "", "PATCH");
    }
    function getRecordPR()
    {
        var URL = path + "/api/Utility/SubjectMaster/PR";
        $.ajax({type: "GET", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json"
            , success: function (data) {
                if (data.length === 0) {
                    messages('Record Not Found');
                    document.getElementById('table').innerHTML = '';
                    return false;
                }
                document.getElementById('table').innerHTML = `<table class='table table-bordered table-hover table-striped' id='dataTable'><thead>
<tr><th hidden>Id</th><th>TH Code</th><th>TH Subject Name</th><th>PR Subject </th><th style='width: 90px;'>Action</th></tr></thead><tbody></tbody></table>`;
                var tableData;
                for (var i = 0; i < data.length; i++)
                {
                    tableData = `<tr id='` + i + `'>                    
<td hidden>` + data[i][0] + `</td>
<td>` + data[i][1] + `</td>
<td>` + data[i][2] + `</td>
<td>` + data[i][3] + `</td>
<td>
 <a title='Delete' onclick='recordDelete("` + data[i][0] + `")' class='glyphicon glyphicon-remove-circle' href='#'>Del</a>
</td></tr>`;
                    $('#dataTable').append(tableData);
                }
                $('#dataTable').DataTable();
            }
            , error: function (XMLHttpRequest) {
                $('.btn').button('reset');
                if (XMLHttpRequest.status === 404) {
                    errorMSG("API Not Found!!");
                } else if (XMLHttpRequest.status === 400) {
                    errorMSG(XMLHttpRequest.responseJSON.message);
                } else {
                    errorMSG(XMLHttpRequest.responseJSON.error);
                }
            }
        });
    }
    getRecordPR();
    getRecord();
</script>

<%@include file="../login/footer.jsp" %>