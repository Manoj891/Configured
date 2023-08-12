<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../login/header.jsp"%>
<fieldset>  <legend>Grade-sheet</legend> 
    <form method='POST' id='dataFrom' onsubmit="return (doUpdate());"> 
        <div class="row">
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6' hidden>
                <label>Id</label>
                <input type='text' name='id' id='id' class='form-control'/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6' hidden>
                <label>School</label>
                <input type='text' name='school' id='school' class='form-control'/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Year</label>
                <input type='text' name='year' id='year' class='form-control' value="2077"/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Reg No</label>
                <input type='text' name='regNo' id='regNo' class='form-control' required/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Grade</label>
                <input type='text' name='grade' id='grade' class='form-control' required/>
            </div>
            <div class='col-lg-4 col-sm-4 col-md-4 col-xs-6'>
                <label>Student Name</label>
                <input type='text' name='studentName' id='studentName' class='form-control' required/>
            </div>
        </div>
        <div class="row">
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>DOB</label>
                <input type='text' name='dob' id='dob' class='form-control' required/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Symbol No</label>
                <input type='text' name='symbolNo' id='symbolNo' class='form-control' required/>
            </div>

            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6' hidden>
                <label>Enter By</label>
                <input type='text' name='enterBy' id='enterBy' class='form-control'/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6' hidden>
                <label>Enter Date</label>
                <input type='text' name='enterDate' id='enterDate' class='form-control'/>
            </div>

        </div><br>
        <div class="row" style="width: 650px;">

            <table class='table table-bordered table-hover table-striped' >
                <thead>
                    <tr><th>Sub&nbsp;Code</th>
                        <th>Sub&nbsp;Name</th>                    
                        <th>C.&nbsp;Hour</th>
                        <th>Mark&nbsp;TH</th>
                        <th>Mark&nbsp;PR</th>
                        <th>G.&nbsp;Point</th>
                        <th>Grade&nbsp;TH</th>
                        <th>Grade&nbsp;PR</th>
                        <th>Final&nbsp;Grade</th>
                        <th>Remark</th>
                    </tr></thead>
                <tbody id='detail'>

                </tbody>
            </table>
        </div>
        <div class="row">

            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>GPA</label>
                <input type='text' name='gpa' id='gpa' class='form-control' required/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Date Of Issue</label>
                <input type='text' name='dateOfIssue' id='dateOfIssue' class='form-control' required/>
            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>&nbsp;</label><br>
                <input type='button' value='+' class='btn btn-success' onclick="   addSubrow();"/>

            </div>
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>&nbsp;</label><br>
                <input type='submit' id='Save' value='Save' class='btn btn-success'/>
                <input type='submit' id='Update' value='Update' class='btn btn-success' style='display: none'/>
            </div>
        </div>
    </form>
</fieldset>  <br> <fieldset>  <legend> Data</legend> 
    <div class='row' id='table' ></div>
</fieldset>
<script>
    var actionStatus = true;
    function addSubrow() {
        var rowData = `
<tr><td><input type="text" style="width: 80px" class="form-control subjectCode"></td>
    <td><input type="text" style="width: 160px" class="form-control subjectName"></td>                    
    <td><input type="text" style="width: 80px" class="form-control creditHour"> </td>
    <td><input type="text" style="width: 80px" class="form-control obtain-th"></td>
    <td><input type="text" style="width: 80px" class="form-control obtain-pr"></td>
    <td><input type="text" style="width: 80px" class="form-control gradePoint"></td>
    <td><input type="text" style="width: 80px" class="form-control grade-th"></td>
    <td><input type="text" style="width: 80px" class="form-control grade-pr"></td>
    <td><input type="text" style="width: 80px" class="form-control finalGrade"></td>
    <td><input type="text" style="width: 160px" class="form-control remark"></td>
</tr>
`;


        $("#detail").append(rowData);
    }
    function add8Row() {
        $("#detail").empty();
        for (var i = 1; i <= 8; i++) {
            addSubrow();
        }
    }
    add8Row();

    function edit(sn) {
        var data = document.getElementById(sn);
        var id = ['id', 'school', 'year', 'regNo', 'studentName', 'dob', 'symbolNo', 'grade', 'gpa', 'dateOfIssue', 'enterBy', 'enterDate'];
        for (var i = 0; i < id.length; i++)
        {
            document.getElementById(id[i]).value = data.children[i].innerHTML;
        }
        $('#Update').show();
        $('#Save').hide();
        add8Row();
        var subjectData = JSON.parse(data.children[id.length].innerHTML);
        var subjectCode = document.querySelectorAll('.subjectCode');
        console.log(subjectData.length);
        console.log(subjectCode.length);

        for (var i = subjectCode.length; i < subjectData.length; i++) {
            addSubrow();
        }
        var subjectCode = document.querySelectorAll('.subjectCode');
        var subjectName = document.querySelectorAll('.subjectName');
        var creditHour = document.querySelectorAll('.creditHour');
        var gradePoint = document.querySelectorAll('.gradePoint');
        var gradeTh = document.querySelectorAll('.grade-th');
        var gradePr = document.querySelectorAll('.grade-pr');
        var finalGrade = document.querySelectorAll('.finalGrade');
        var remark = document.querySelectorAll('.remark');

        var obtainTH = document.querySelectorAll('.obtain-th');
        var obtainPR = document.querySelectorAll('.obtain-pr');

        for (var i = 0; i < subjectData.length; i++) {
            subjectCode[i].value = subjectData[i].subjectCode;
            subjectName[i].value = subjectData[i].subjectName;
            creditHour[i].value = subjectData[i].creditHour;
            gradePoint[i].value = subjectData[i].geadePoint;
            gradeTh[i].value = subjectData[i].geadeTh;
            gradePr[i].value = subjectData[i].geadePr;
            finalGrade[i].value = subjectData[i].finalGrade;
            remark[i].value = subjectData[i].remark;
            obtainTH[i].value = subjectData[i].thObtain;
            obtainPR[i].value = subjectData[i].prObtain;
        }
        document.getElementById('Update').focus();
        actionStatus = false;
    }
    function callApi(URL, requestData, apiMethod)
    {
        $('.btn').button('loading');
        var subjectCode = document.querySelectorAll('.subjectCode');
        var subjectName = document.querySelectorAll('.subjectName');
        var creditHour = document.querySelectorAll('.creditHour');
        var gradePoint = document.querySelectorAll('.gradePoint');
        var gradeTh = document.querySelectorAll('.grade-th');
        var gradePr = document.querySelectorAll('.grade-pr');
        var finalGrade = document.querySelectorAll('.finalGrade');
        var remark = document.querySelectorAll('.remark');
        var obtainTH = document.querySelectorAll('.obtain-th');
        var obtainPR = document.querySelectorAll('.obtain-pr');

        var detail = [];
        for (var i = 0; i < subjectCode.length; i++) {
            if (subjectCode[i].value === "") {
            } else {
                detail.push({
                    "subjectCode": subjectCode[i].value,
                    "subjectName": subjectName[i].value,
                    "creditHour": creditHour[i].value,
                    "geadePoint": gradePoint[i].value,
                    "geadeTh": gradeTh[i].value,
                    "geadePr": gradePr[i].value,
                    "finalGrade": finalGrade[i].value,
                    "remark": remark[i].value,
                    "thObtain": obtainTH[i].value,
                    "prObtain": obtainPR[i].value
                });
            }
        }
        requestData['detail'] = detail;
        $.ajax({type: apiMethod, url: URL, headers: {'Authorization': token}, data: JSON.stringify(requestData), contentType: "application/json; charset=utf-8", dataType: "json",
            success: function (data) {
                $('.btn').button('reset');
                add8Row();
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


    function doUpdate()
    {
        var dataForm = $('form').serializeArray();
        var requestData = {};
        $.each(dataForm, function (i, v) {
            requestData[v.name] = v.value;
        });
        var URL = path + "/api/Utility/GradeShett/" + document.getElementById('id').value;
        callApi(URL, requestData, "PATCH");
        return false;
    }
    function getRecord()
    {
        var URL = path + "/api/Utility/GradeShett";
        $.ajax({type: "GET", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json"
            , success: function (data) {
                if (data.length === 0) {
                    messages('Record Not Found');
                    document.getElementById('table').innerHTML = '';
                    return false;
                }
                document.getElementById('table').innerHTML = `<table class='table table-bordered table-hover table-striped' id='dataTable'><thead>
<tr><th hidden>Id</th><th hidden>School</th><th>Reg No</th><th>Student Name</th><th>Dob</th><th>Symbol No</th><th>Grade</th><th>Gpa</th><th>Date Of Issue</th><th hidden>Enter By</th><th hidden>Enter Date</th><th hidden></th><th style='width: 90px;'>Action</th></tr></thead><tbody></tbody></table>`;
                var tableData;
                for (var i = 0; i < data.length; i++)
                {
                    tableData = `<tr id='` + i + `'>
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
        var URL = path + "/api/Utility/GradeShett/" + id;
        callApi(URL, "", "DELETE");
    }

    getRecord();
</script>
<!--<a title='Print' target="_balnk" href='`+path+`/Utility/MarksheetPrint?id=` + data[i].id + `'>Print</a>-->
<%@include file="../login/footer.jsp" %>

<%--
return "\n{\"id\": \""+id+"\",\"school\": \""+school+"\",\"regNo\": \""+regNo+"\",\"studentName\": \""+studentName+"\",\"dob\": \""+dob+"\",\"symbolNo\": \""+symbolNo+"\",\"grade\": \""+grade+"\",\"gpa\": \""+gpa+"\",\"dateOfIssue\": \""+dateOfIssue+"\",\"enterBy\": \""+enterBy+"\",\"enterDate\": \""+enterDate+"\"}";
--%>