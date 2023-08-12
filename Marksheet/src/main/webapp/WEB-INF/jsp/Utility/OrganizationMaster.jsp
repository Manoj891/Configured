<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../login/header.jsp"%>
<fieldset>  <legend>Organization Master</legend> 
    <form method='POST' id='dataFrom' onsubmit="return (doSave());"> 
        <div class="row">
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6' hidden>
                <label>Id</label>
                <input type='text' name='id' id='id' class='form-control' />
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>School Code</label>
                <input type='text' name='schoolCode' id='schoolCode' class='form-control'/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Name</label>
                <input type='text' name='name' id='name' class='form-control'/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Province</label>
                <input type='text' name='province' id='province' class='form-control'/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>District</label>
                <input type='text' name='district' id='district' class='form-control'/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Municipal</label>
                <input type='text' name='municipal' id='municipal' class='form-control'/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Ward No</label>
                <input type='text' name='wardNo' id='wardNo' class='form-control'/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Address</label>
                <input type='text' name='address' id='address' class='form-control'/>
            </div>


            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Email</label>
                <input type='text' name='email' id='email' class='form-control'/>
            </div>


            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Tel</label>
                <input type='text' name='tel' id='tel' class='form-control'/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Url</label>
                <input type='text' name='url' id='url' class='form-control'/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Establish Year</label>
                <input type='text' name='establishYear' id='establishYear' class='form-control'/>
            </div>

            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>About School</label>
                <input type='text' name='aboutSchool' id='aboutSchool' class='form-control'/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>

                <label>&nbsp;</label><br>
                <input type='submit' id='Save' value='Save' class='btn btn-success'/>
                <input type='submit' id='Update' value='Update' class='btn btn-success' style='display: none'/></div>
        </div>
    </form>
</fieldset> 
<br><fieldset><legend>Upload Logo</legend>
    <form method='POST' id='uploadLogo'> 
        <div class="row">
            <div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
                <label>Upload</label>
                <input type='file' accept=".png , .jpeg , .jpg" name='logo' onchange="readURL(this);" required>
            </div>
            <div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
                <label>&nbsp;</label><br>
                <input type='submit' value='Save' class='btn btn-primary'/>
            </div>
            <div class='col-lg-3 col-sm-3 col-md-3 col-xs-6'>
                <img src="<%= request.getContextPath()%>Document/Organization/Logo.png" id="OrganizationLogo"  height='100' width="100"/>
            </div>
        </div>
    </form>
</fieldset> <fieldset hidden>  
    <legend> Data</legend> 
    <div class='row' id='table'></div>
</fieldset>
<script>
      function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#OrganizationLogo')
                        .attr('src', e.target.result)
                        .width(100)
                        .height(100);
            };

            reader.readAsDataURL(input.files[0]);
        }
    }

    $('#uploadLogo').submit(function (event) {
        event.preventDefault();
        var formData = new FormData(this);
        $('.btn').button('loading');
        $.ajax({type: "POST", url: path + "/api/Utility/OrganizationMaster/Logo",
            headers: {'Authorization': '<%=token%>'}, contentType: false, dataType: "json", data: formData, catch : false, processData: false,
            success: function (data) {
                console.log(data);
                $('.btn').button('reset');
                if (data['error']) {
                    errorMSG(data['error'].message);
                } else {
                    console.log(data.message);
                    messages(data.message);
                }
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $('.btn').button('reset');
                errorMSG(XMLHttpRequest + " Status: " + textStatus + " Error: " + errorThrown);
            }
        });
    });



    var actionStatus = true;

    function edit(sn) {
        var data = document.getElementById(sn);
        var id = ['id', 'aboutSchool', 'address', 'district', 'email', 'establishYear', 'municipal', 'name', 'province', 'schoolCode', 'tel', 'url', 'wardNo'];
        for (var i = 0; i < id.length; i++)
        {
            document.getElementById(id[i]).value = data.children[i].innerHTML;
        }
         $('#OrganizationLogo')
                        .attr('src',path+"Document/"+ data.children[id.length].innerHTML)
                        .width(100)
                        .height(100);
            
      
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
        var URL = path + "/api/Utility/OrganizationMaster";
        callApi(URL, requestData, "POST");
        return false;
    }

    function getRecord()
    {
        var URL = path + "/api/Utility/OrganizationMaster";
        $.ajax({type: "GET", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json"
            , success: function (data) {
                if (data.length === 0) {
                    messages('Record Not Found');
                    document.getElementById('table').innerHTML = '';
                    return false;
                }
                document.getElementById('table').innerHTML = `<table class='table table-bordered table-hover table-striped' id='dataTable'><thead>
<tr><th>Id</th><th>About School</th><th>Address</th><th>District</th><th>Email</th><th>Establish Year</th><th>Municipal</th><th>Name</th><th>Province</th><th>School Code</th><th>Tel</th><th>Url</th><th>Ward No</th><th hidden></th><th style='width: 90px;'>Action</th></tr></thead><tbody></tbody></table>`;
                var tableData;
                for (var i = 0; i < data.length; i++)
                {
                    tableData = `<tr id='` + i + `'>
<td>` + data[i].id + `</td>
<td>` + data[i].aboutSchool + `</td>
<td>` + data[i].address + `</td>
<td>` + data[i].district + `</td>
<td>` + data[i].email + `</td>
<td>` + data[i].establishYear + `</td>
<td>` + data[i].municipal + `</td>
<td>` + data[i].name + `</td>
<td>` + data[i].province + `</td>
<td>` + data[i].schoolCode + `</td>
<td>` + data[i].tel + `</td>
<td>` + data[i].url + `</td>
<td>` + data[i].wardNo + `</td>
            <td hidden>` + data[i].logo + `</td>
<td>
  <a title='Edit' onclick='edit(` + (i) + `)' class='glyphicon glyphicon-edit' href='#'>Edit</a>
</td></tr>`;
                    $('#dataTable').append(tableData);
                    edit(0);
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
        var URL = path + "/api/Utility/OrganizationMaster/" + id;
        callApi(URL, "", "DELETE");
    }

    getRecord();
</script>

<%@include file="../login/footer.jsp" %>

<%--
return "\n{\"id\": \""+id+"\",\"aboutSchool\": \""+aboutSchool+"\",\"address\": \""+address+"\",\"district\": \""+district+"\",\"email\": \""+email+"\",\"establishYear\": \""+establishYear+"\",\"municipal\": \""+municipal+"\",\"name\": \""+name+"\",\"province\": \""+province+"\",\"schoolCode\": \""+schoolCode+"\",\"tel\": \""+tel+"\",\"url\": \""+url+"\",\"wardNo\": \""+wardNo+"\"}";
--%>