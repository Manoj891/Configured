<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../login/header.jsp"%>
<%    if (!session.getAttribute("userName").toString().equalsIgnoreCase("ADMIN")) {
        out.print("<script>window.location.assign('" + path + "');</script>");
    }
%>
<fieldset>  <legend>School List</legend> 
    <form method='POST' id='dataFrom' onsubmit="return (doSave());"> 
        <div class="row">
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Code</label>
                <input type='text' name='id' id='id' class='form-control' required/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Name</label>
                <input type='text' name='name' id='name' class='form-control' required/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>District</label>
                <input type='text' name='district' id='district' class='form-control' required/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Address</label>
                <input type='text' name='address' id='address' class='form-control'/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>School Api</label>
                <input type='text' name='schoolApi' id='schoolApi' class='form-control' required/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Email</label>
                <input type='text' name='email' id='email' class='form-control' required/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Account No</label>
                <input type='text' name='accountNo' id='accountNo' class='form-control'/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Status</label>
                <select name='status' id='status' class='form-control'>
                    <option value="Y">Active</option>
                    <option value="N">Passive</option>
                </select>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>

                <label>&nbsp;</label><br>
                <input type='submit' id='Save' value='Save' class='btn btn-success'/>
                <input type='submit' id='Update' value='Update' class='btn btn-success' style='display: none'/></div>
        </div>
    </form>
</fieldset>  <br> <fieldset>  <legend> Data</legend> 
    <div class='row' id='table' style="overflow: auto; "></div>
</fieldset>
<script>
    var actionStatus = true;

    function edit(sn) {
        var data = document.getElementById(sn);
        var id = ['id', 'name', 'district', 'address', 'schoolApi', 'email', 'accountNo', 'status'];
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
                if (data['error']) {
                    errorMSG(data['error']);
                    return false;
                }
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
        var URL = path + "/api/Utility/SchoolList";
        callApi(URL, requestData, "POST");
        return false;
    }

    function getRecord()
    {
        var URL = path + "/api/Utility/SchoolList";
        $.ajax({type: "GET", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json"
            , success: function (data) {
                if (data.length === 0) {
                    messages('Record Not Found');
                    document.getElementById('table').innerHTML = '';
                    return false;
                }
                document.getElementById('table').innerHTML = `<table class='table table-bordered table-hover table-striped' id='dataTable'><thead>
<tr><th>Id</th><th>Name</th><th>District</th><th hidden>Address</th><th hidden>School Api</th><th hidden>Email</th><th hidden>Account No</th><th>Status</th><th style='width: 90px;'>Action</th></tr></thead><tbody></tbody></table>`;
                var tableData;
                for (var i = 0; i < data.length; i++)
                {
                    tableData = `<tr id='` + i + `'>
<td>` + data[i].id + `</td>
<td>` + data[i].name + `</td>
<td>` + data[i].district + `</td>
<td hidden>` + data[i].address + `</td>
<td hidden>` + data[i].schoolApi + `</td>
<td hidden>` + data[i].email + `</td>
<td hidden>` + data[i].accountNo + `</td>
<td>` + data[i].status + `</td>
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
        var URL = path + "/api/Utility/SchoolList/" + id;
        callApi(URL, "", "DELETE");
    }

    getRecord();
</script>

<%@include file="../login/footer.jsp" %>

<%--
return "\n{\"id\": \""+id+"\",\"name\": \""+name+"\",\"district\": \""+district+"\",\"address\": \""+address+"\",\"schoolApi\": \""+schoolApi+"\",\"email\": \""+email+"\",\"accountNo\": \""+accountNo+"\",\"status\": \""+status+"\"}";
--%>