<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../login/header.jsp"%>
<fieldset>  <legend>Subject Master</legend> 
    <form method='POST' id='dataFrom' onsubmit="return (doAction());"> 
        <div class="row">
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6' hidden>
                <label>Id</label>
                <input type='text' name='id' id='id' class='form-control'/>
            </div>
          
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Subject Code</label>
                <input type='text' name='subjectCode' id='subjectCode' class='form-control' placeholder="001"/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Subject Name</label>
                <input type='text' name='subjectName' id='subjectName' class='form-control' placeholder="Nepali"/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Credit Hour</label>
                <input type='number' step="any" name='creditHour' id='creditHour' class='form-control'  value="4" required/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>TH FM</label>
                <input type='number' step="any" name='thFm' id='thFm' class='form-control' value="0" required/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>PR FM</label>
                <input type='number' step="any" name='prFm' id='prFm' class='form-control' value="0" required/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>

                <label>&nbsp;</label><br>
                <input type='submit' id='Save' value='Save' class='btn btn-success'/>
                <input type='submit' id='Update' value='Update' class='btn btn-success' style='display: none'/>
            </div>
        </div>
    </form>
</fieldset>  <br> <fieldset>  <legend> Data</legend> 
    <div class='row' id='table' style="overflow: auto; "></div>
</fieldset>
<script>
    var actionStatus = true;

    function edit(sn) {
        var data = document.getElementById(sn);
        var id = ['id','subjectCode', 'subjectName', 'creditHour', 'thFm', 'prFm'];
        for (var i = 0; i < id.length; i++)
        {
            document.getElementById(id[i]).value = data.children[i].innerHTML;
        }
        $('#Update').show();
        $('#Save').hide();
        document.getElementById('Update').focus();
        actionStatus = false;
    }
    function callApi(URL, requestData, apiMethod)
    {
        $('.btn').button('loading');
        $.ajax({type: apiMethod, url: URL, headers: {'Authorization': token}, data: JSON.stringify(requestData), contentType: "application/json; charset=utf-8", dataType: "json",
            success: function (data) {
                $('.btn').button('reset');

                $('#Update').hide();
                $('#Save').show();
                actionStatus = true;
                messages(data.message);
                document.getElementById('dataFrom').reset();
                getRecord();
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
        var dataForm = $('form').serializeArray();
        var requestData = {};
        $.each(dataForm, function (i, v) {
            requestData[v.name] = v.value;
        });
        var URL = path + "/api/Utility/SubjectMaster";
        callApi(URL, requestData, "POST");
    }
    function doUpdate()
    {
        var dataForm = $('form').serializeArray();
        var requestData = {};
        $.each(dataForm, function (i, v) {
            requestData[v.name] = v.value;
        });
        var URL = path + "/api/Utility/SubjectMaster/" + document.getElementById('id').value;
        callApi(URL, requestData, "PUT");
    }
    function getRecord()
    {
        var URL = path + "/api/Utility/SubjectMaster";
        $.ajax({type: "GET", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json"
            , success: function (data) {
                if (data.length === 0) {
                    messages('Record Not Found');
                    document.getElementById('table').innerHTML = '';
                    return false;
                }
                document.getElementById('table').innerHTML = `<table class='table table-bordered table-hover table-striped' id='dataTable'><thead>
<tr><th hidden>Id</th><th>Subject Code</th><th>Subject Name</th><th>Credit Hour</th><th>TH FM</th><th>PR FM</th><th style='width: 90px;'>Action</th></tr></thead><tbody></tbody></table>`;
                var tableData;
                for (var i = 0; i < data.length; i++)
                {
                    tableData = `<tr id='` + i + `'>
<td hidden>` + data[i].id + `</td>
<td>` + data[i].subjectCode + `</td>
<td>` + data[i].subjectName + `</td>
<td>` + data[i].creditHour + `</td>
<td>` + data[i].thFm + `</td>
<td>` + data[i].prFm + `</td>
<td>
  <a title='Edit' onclick='edit(` + (i) + `)' class='glyphicon glyphicon-edit' href='#'>Edit</a> 
| <a title='Delete' onclick='recordDelete("` + data[i].id + `")' class='glyphicon glyphicon-remove-circle' href='#'>Del</a>
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
    function recordDelete(id) {
        if (!confirm('Are you sure')) {
            return;
        }
        var URL = path + "/api/Utility/SubjectMaster/" + id;
        callApi(URL, "", "DELETE");
    }
    function doAction() {
        if (actionStatus)
        {
            doSave();
        } else {
            doUpdate();
        }
        return false;
    }
    getRecord();
</script>

<%@include file="../login/footer.jsp" %>

<%--
return "\n{\"id\": \""+id+"\",\"school\": \""+school+"\",\"subjectCode\": \""+subjectCode+"\",\"subjectName\": \""+subjectName+"\"}";
--%>