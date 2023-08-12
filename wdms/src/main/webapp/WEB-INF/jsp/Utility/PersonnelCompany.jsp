<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../login/header.jsp"%>
<fieldset>  <legend>Company</legend> 
    <div class="modal fade container" id="myModal" role="dialog" tabindex="-1">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Generate Password</h4>
            </div>        
            <div class="modal-body">
                <form method='POST' id='passwordReset' onsubmit="return (generatePassword());"> 
                    <div class="row">
                        <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6' hidden="">
                            <label>Id</label>
                            <input type='text' name='id' id='idReset' class='form-control'/>
                        </div>
                        <div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
                            <label>email</label>
                            <input type='email' name='email' id='emailReset' class='form-control'/>
                        </div>
                        <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                            <label>&nbsp;</label><br>
                            <input type='submit' id='Save' value='Reset' class='btn btn-success'/>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <form method='POST' id='dataFrom' onsubmit="return (doUpdate()());"> 
        <div class="row">
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6' hidden="">
                <label>Id</label>
                <input type='text' name='id' id='id' class='form-control'/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Company Code</label>
                <input type='text' name='companyCode' id='companyCode' class='form-control' readonly/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Company Name</label>
                <input type='text' name='companyName' id='companyName' class='form-control'/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6' hidden>
                <label>Is Default</label>
                <input type='text' name='isDefault' id='isDefault' class='form-control'/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Email</label>
                <input type='email' name='email' id='email' class='form-control' required/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6' hidden>
                <label>Db Password</label>
                <input type='text' name='dbPassword' id='dbPassword' class='form-control'/>
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
        var id = ['id', 'companyCode', 'companyName', 'isDefault', 'email', 'dbPassword'];
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

    function generatePassword()
    {
       
        var URL = path + "/api/Utility/PersonnelCompany/" + document.getElementById("idReset").value;
        callApi(URL, document.getElementById("emailReset").value, "PUT");
        return false;
    }
    function doUpdate()
    {
        var dataForm = $('form').serializeArray();
        var requestData = {};
        $.each(dataForm, function (i, v) {
            requestData[v.name] = v.value;
        });
        var URL = path + "/api/Utility/PersonnelCompany";
        callApi(URL, requestData, "PUT");
        return false;
    }
    function getRecord()
    {
        var URL = path + "/api/Utility/PersonnelCompany";
        $.ajax({type: "GET", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json"
            , success: function (data) {
                if (data.length === 0) {
                    messages('Record Not Found');
                    document.getElementById('table').innerHTML = '';
                    return false;
                }
                document.getElementById('table').innerHTML = `<table class='table table-bordered table-hover table-striped' id='dataTable'><thead>
<tr><th hidden>Id</th><th>Company Code</th><th>Company Name</th><th hidden>Is Default</th><th>Email</th><th hidden>Db Password</th><th style='width: 90px;'>Action</th></tr></thead><tbody></tbody></table>`;
                var tableData;
                for (var i = 0; i < data.length; i++)
                {
                    tableData = `<tr id='` + i + `'>
<td hidden>` + data[i].id + `</td>
<td>` + data[i].companyCode + `</td>
<td>` + data[i].companyName + `</td>
<td hidden>` + data[i].isDefault + `</td>
<td>` + data[i].email + `</td>
<td hidden>` + data[i].dbPassword + `</td>
<td>
  <a title='Edit' onclick='edit(` + (i) + `)' class='glyphicon glyphicon-edit' href='#'></a> 
| <a title='Password' onclick='recordDelete("` + data[i].id + `")' href='#'>Password</a>
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
        $("#myModal").modal();
        document.getElementById("idReset").value = id;
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
return "\n{\"id\": \""+id+"\",\"companyCode\": \""+companyCode+"\",\"companyName\": \""+companyName+"\",\"isDefault\": \""+isDefault+"\",\"email\": \""+email+"\",\"dbPassword\": \""+dbPassword+"\"}";
--%>