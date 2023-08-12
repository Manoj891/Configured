<%@page import="com.config.DateConvert"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../login/header.jsp"%>
<div class="modal fade container" id="myModal" role="dialog" tabindex="-1">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>
            <h4 class="modal-title">Mark Entry</h4>
        </div>        
        <div class="modal-body">
            <fieldset>  <legend>Grade-sheet</legend> 
                <form method='POST' id='dataFrom' onsubmit="return (doAction());"> 
                    <div class="row">
                        <div class='col-lg-6 col-sm-6 col-md-6 col-xs-12'>
                            <input type='hidden' name='enterBy' id='enterBy' class='form-control'/>
                            <input type='hidden' name='id' id='id' class='form-control'/>              
                            <input type='hidden' name='school' id='school' class='form-control'/>
                            <input type='hidden' name='enterDate' id='enterDate' class='form-control'/>
                            <div class='col-lg-4 col-sm-4 col-md-4 col-xs-6'>
                                <label>Year</label>
                                <input type='text' name='year' id='year' class='form-control' value="2077"/>
                            </div>
                            <div class='col-lg-4 col-sm-4 col-md-4 col-xs-6'>
                                <label>Reg No</label>
                                <input type='text'  name='regNo' id='regNo' class='form-control'  required/>
                            </div>
                            <div class='col-lg-4 col-sm-4 col-md-4 col-xs-6'>
                                <label>Grade(Class)</label>
                                <input type='text' name='grade' id='grade' class='form-control' required/>
                            </div>
                            <div class='col-lg-8 col-sm-8 col-md-8 col-xs-12'>
                                <label>Student Name</label>
                                <input type='text' name='studentName' id='studentName' class='form-control' required/>
                            </div>

                            <div class='col-lg-4 col-sm-4 col-md-4 col-xs-6'>
                                <label>DOB</label>
                                <input type='text' name='dob' id='dob' class='form-control' required/>
                            </div>
                            <div class='col-lg-4 col-sm-4 col-md-4 col-xs-6'>
                                <label>Symbol No</label>
                                <input type='text' name='symbolNo' id='symbolNo' class='form-control' required/>
                            </div>
                            <div class='col-lg-4 col-sm-4 col-md-4 col-xs-6' hidden>
                                <label>GPA</label>
                                <input type='text' name='gpa' id='gpa' class='form-control'/>
                            </div>
                            <div class='col-lg-4 col-sm-4 col-md-4 col-xs-6'>
                                <label>Date Of Issue</label>
                                <input type='text' name='dateOfIssue' id='dateOfIssue' class='form-control' value='<%= DateConvert.toDay()%>' required/>
                            </div>
                              <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                                <label>&nbsp;</label><br>
                                <input type='button' value='Close' class='btn btn-success' onclick="$('#myModal').modal('hide');document.getElementById('dataFrom').reset()"/>
                            </div>
                             <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                                <label>&nbsp;</label><br>
                                <input type='submit' id='Save' value='Save' class='btn btn-success Save'/>
                                <input type='submit' id='Update' value='Update' class='btn btn-success Update' style='display: none'/>
                            </div>
                           
                        </div>

                        <div class='col-lg-6 col-sm-6 col-md-6 col-xs-12'>
                            <table class='table table-bordered table-hover table-striped' >
                                <thead>
                                    <tr><th>Subject</th>  
                                        <th>TH&nbsp;Obtain</th>
                                        <th>PR&nbsp;Obtain</th>       
                                        <th></th>       
                                    </tr></thead>
                                <tbody id='detail'>

                                </tbody>
                            </table>
                              <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                                <label>&nbsp;</label><br>
                                <input type='button' value='Close' class='btn btn-success' onclick="$('#myModal').modal('hide');document.getElementById('dataFrom').reset()"/>
                            </div>
                             <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                                <label>&nbsp;</label><br>
                                <input type='submit' id='Save' value='Save' class='btn btn-success Save'/>
                                <input type='submit' id='Update' value='Update' class='btn btn-success Update' style='display: none'/>
                            </div>
                           <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6 Update' style='display: none' onclick="deleteSubject()">
                                <label>&nbsp;</label><br>                               
                                <input type='button'  value='Delete' class='btn btn-danger ' />
                            </div>
<!--                            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                                <label>&nbsp;</label><br>
                                <input type='button' value='+' class='btn btn-success' onclick="addSubrow();"/>
                            </div>-->
                           
                        </div>


                </form>

            </fieldset>
        </div>
    </div>
</div>



<fieldset>  <legend> <a href="#" onclick='$("#myModal").modal(); document.getElementById("dataFrom").reset();'>Add</a></legend> 
    <div class='row' id='table' ></div>
</fieldset>
<script>
    function deleteSubject() {
        var regNo = document.getElementById("id").value;
        var subjectId = document.querySelectorAll('.subjectId');
        var deleteColumn = document.querySelectorAll('.delete-column');
        for (var i = 0; i < subjectId.length; i++) {
            if (deleteColumn[i].checked) {
                deleteSubjectApi(path + "/api/Utility/GradeShett/" + regNo + "/" + subjectId[i].value);

            }
        }

    }

    function deleteSubjectApi(URL)
    {
        console.log(URL);
        $.ajax({type: "DELETE", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json",
            success: function (data) {
                $('.Update').hide();
                $('.Save').show();
                actionStatus = true;
                messages(data.message);              
                $('#myModal').modal('hide');
                 getRecord();
            }
        });
    }
    var subjectMaster = []
    function getSubject()
    {
        var URL = path + "/api/Utility/SubjectMaster";
        $.ajax({type: "GET", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json"
            , success: function (data) {
                subjectMaster = data;
                $(".subjectId").empty().append(`<option value=''>Choose Subject</option>`);
                for (var i = 0; i < subjectMaster.length; i++)
                {
                    $(".subjectId").append(`<option value='` + subjectMaster[i].id + `'>` + subjectMaster[i].subjectCode + ` - ` + subjectMaster[i].subjectName + `</option>`)
                }
            }
        });
    }
    getSubject();
    var actionStatus = true;
    function addSubrow() {
        var rowData = `
<tr><td> <select style="width: 280px"  class='form-control subjectId'></select></td>                  
      <td><input type="text" style="width: 80px" class="form-control thObtain"></td>
      <td><input type="text" style="width: 80px" class="form-control prObtain"></td>   
      <td><input type="checkbox" class="delete-column"></td>   
</tr>
`;


        $("#detail").append(rowData);
    }
    function add8Row() {
        $("#detail").empty();
        for (var i = 1; i <= 11; i++) {
            addSubrow();
        }
        $(".subjectId").empty().append(`<option value=''>Choose Subject</option>`);
        for (var i = 0; i < subjectMaster.length; i++)
        {
            $(".subjectId").append(`<option value='` + subjectMaster[i].id + `'>` + subjectMaster[i].subjectCode + ` - ` + subjectMaster[i].subjectName + `</option>`)
        }
    }
    add8Row();
    var selectRow = 0;
    function edit(sn) {
        var data = document.getElementById(sn);
        var id = ['id', 'school', 'year', 'regNo', 'studentName', 'dob', 'symbolNo', 'grade', 'gpa', 'dateOfIssue', 'enterBy', 'enterDate'];
        for (var i = 0; i < id.length; i++)
        {
            document.getElementById(id[i]).value = data.children[i].innerHTML;
        }
        $('.Update').show();
        $('.Save').hide();
        add8Row();
        var subjectData = JSON.parse(data.children[id.length].innerHTML);
        var subjectId = document.querySelectorAll('.subjectId');
        for (var i = subjectId.length; i < subjectId.length; i++) {
            addSubrow();
        }
        var thObtain = document.querySelectorAll('.thObtain');
        var prObtain = document.querySelectorAll('.prObtain');
        for (var i = 0; i < subjectData.length; i++) {
            subjectId[i].value = subjectData[i].subjectId;
            thObtain[i].value = subjectData[i].thObtain;
            prObtain[i].value = subjectData[i].prObtain;
        }
        actionStatus = false;
        $("#myModal").modal();
        selectRow = sn;
    }
    function callApi(URL, requestData, apiMethod)
    {
        $('.btn').button('loading');
        var subjectId = document.querySelectorAll('.subjectId');
        var gradeTh = document.querySelectorAll('.thObtain');
        var gradePr = document.querySelectorAll('.prObtain');
        var detail = [];
        var th, pr;
        for (var i = 0; i < subjectId.length; i++) {
            if (subjectId[i].value === "") {
            } else {
                if (gradeTh[i].value === "")
                    th = 0;
                else {
                    th = parseFloat(gradeTh[i].value + "")
                }
                if (gradePr[i].value === "")
                    pr = 0;
                else {
                    pr = parseFloat(gradePr[i].value + "")
                }
                if (th === 0 && pr === 0) {
                    continue;
                }
                detail.push({
                    "subjectId": subjectId[i].value,
                    "thObtain": th,
                    "prObtain": pr
                });
            }
        }
        requestData['detail'] = detail;
        $.ajax({type: apiMethod, url: URL, headers: {'Authorization': token}, data: JSON.stringify(requestData), contentType: "application/json; charset=utf-8", dataType: "json",
            success: function (data) {
                $('.btn').button('reset');
                add8Row();
                $('.Update').hide();
                $('.Save').show();
                actionStatus = true;
                messages(data.message);
                document.getElementById('dataFrom').reset();
                if (apiMethod === "PUT") {

                    $('#myModal').modal('hide');
//                    document.getElementById(selectRow).focus();
                    $("tr[tabindex=" + selectRow + "]").focus();
                } else {
                    document.getElementById('dataFrom').reset()
                }
//                getRecord();
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
        var URL = path + "/api/Utility/GradeShett";
        callApi(URL, requestData, "POST");
    }
    function doUpdate()
    {
        var dataForm = $('form').serializeArray();
        var requestData = {};
        $.each(dataForm, function (i, v) {
            requestData[v.name] = v.value;
        });
        var URL = path + "/api/Utility/GradeShett/" + document.getElementById('id').value;
        callApi(URL, requestData, "PUT");
    }
    function getRecord()
    {
        var URL = path + "/api/Utility/GradeShett?id=<%= request.getParameter("id") %>";
        $.ajax({type: "GET", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json"
            , success: function (data) {
                if (data.length === 0) {
                    messages('Record Not Found');
                    document.getElementById('table').innerHTML = '';
                    return false;
                }
                document.getElementById('table').innerHTML = `<table class='table table-bordered table-hover table-striped' id='dataTable'><thead>
<tr><th hidden>Id</th><th hidden>School</th><th>Reg No</th><th>Student Name</th><th>Dob</th><th>Symbol No</th><th>Grade</th><th>Gpa</th><th>Date Of Issue</th><th hidden>Enter By</th><th hidden>Enter Date</th><th hidden></th><th style='width: 90px;'>Action</th><th>SN</th></tr></thead><tbody></tbody></table>`;
                var tableData;
                for (var i = 0; i < data.length; i++)
                {
                    tableData = `<tr tabindex="'` + i + `'" id='` + i + `'>
<td hidden>` + data[i].id + `</td>
<td hidden>` + data[i].school + `</td>
<td hidden>` + data[i].year + `</td>
<td>` + data[i].regNo + `</td>
<td>` + data[i].studentName + `</td>
<td>` + data[i].dob + `</td>
<td>` + data[i].symbolNo + `</td>
<td>` + data[i].grade + `</td>
<td>` + data[i].gpa + `</td>
<td>` + data[i].dateOfIssue + `</td>
<td hidden>` + data[i].enterBy + `</td>
<td hidden>` + data[i].enterDate + `</td>
            <td hidden>` + JSON.stringify(data[i].detail) + `</td>
<td>
  <a title='Edit' onclick='edit(` + (i) + `)' class='glyphicon glyphicon-edit' href='#'>Edit</a> 
| <a title='Print' href='` + path + `/Utility/MarksheetPrint?id=` + data[i].id + `'  target="_balnk" >Print</a>
</td>
<td>` + (i + 1) + `</td>
</tr>`;
                    $('#dataTable').append(tableData);
                    edit(0);
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
        var URL = path + "/api/Utility/GradeShett/" + id;
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
<!--<a title='Print' target="_balnk" href='`+path+`/Utility/MarksheetPrint?id=` + data[i].id + `'>Print</a>-->
<%@include file="../login/footer.jsp" %>

<%--
return "\n{\"id\": \""+id+"\",\"school\": \""+school+"\",\"regNo\": \""+regNo+"\",\"studentName\": \""+studentName+"\",\"dob\": \""+dob+"\",\"symbolNo\": \""+symbolNo+"\",\"grade\": \""+grade+"\",\"gpa\": \""+gpa+"\",\"dateOfIssue\": \""+dateOfIssue+"\",\"enterBy\": \""+enterBy+"\",\"enterDate\": \""+enterDate+"\"}";
--%>