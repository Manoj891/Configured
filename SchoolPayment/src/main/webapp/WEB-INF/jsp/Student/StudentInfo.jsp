<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../login/header.jsp"%>
        <fieldset>  <legend>StudentInfo</legend> 
<form method='POST' id='dataFrom' onsubmit="return (doAction());"> 
<div class="row">
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Id</label>
<input type='text' name='id' id='id' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Academic Year</label>
<input type='text' name='academicYear' id='academicYear' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Admission Year</label>
<input type='text' name='admissionYear' id='admissionYear' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Alternative Mobile</label>
<input type='text' name='alternativeMobile' id='alternativeMobile' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Cast Ethnicity</label>
<input type='text' name='castEthnicity' id='castEthnicity' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Citizenship</label>
<input type='text' name='citizenship' id='citizenship' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Class Id</label>
<input type='text' name='classId' id='classId' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Date Of Birth</label>
<input type='text' name='dateOfBirth' id='dateOfBirth' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Disability</label>
<input type='text' name='disability' id='disability' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>District</label>
<input type='text' name='district' id='district' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Districtt</label>
<input type='text' name='districtt' id='districtt' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Drop Out</label>
<input type='text' name='dropOut' id='dropOut' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Email</label>
<input type='text' name='email' id='email' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Enter By</label>
<input type='text' name='enterBy' id='enterBy' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Enter Date</label>
<input type='text' name='enterDate' id='enterDate' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Fathers Designation</label>
<input type='text' name='fathersDesignation' id='fathersDesignation' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Fathers Mobile</label>
<input type='text' name='fathersMobile' id='fathersMobile' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Fathers Name</label>
<input type='text' name='fathersName' id='fathersName' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Fathers Occupation</label>
<input type='text' name='fathersOccupation' id='fathersOccupation' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Fathers Qualification</label>
<input type='text' name='fathersQualification' id='fathersQualification' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Gender</label>
<input type='text' name='gender' id='gender' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Guardians Addrress</label>
<input type='text' name='guardiansAddrress' id='guardiansAddrress' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Guardians Mobile</label>
<input type='text' name='guardiansMobile' id='guardiansMobile' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Guardians Name</label>
<input type='text' name='guardiansName' id='guardiansName' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Guardians Relation</label>
<input type='text' name='guardiansRelation' id='guardiansRelation' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Marital Status</label>
<input type='text' name='maritalStatus' id='maritalStatus' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Mobile No</label>
<input type='text' name='mobileNo' id='mobileNo' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Mothers Designation</label>
<input type='text' name='mothersDesignation' id='mothersDesignation' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Mothers Mobile</label>
<input type='text' name='mothersMobile' id='mothersMobile' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Mothers Name</label>
<input type='text' name='mothersName' id='mothersName' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Mothers Occupation</label>
<input type='text' name='mothersOccupation' id='mothersOccupation' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Mothers Qualification</label>
<input type='text' name='mothersQualification' id='mothersQualification' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Municipal</label>
<input type='text' name='municipal' id='municipal' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Municipalt</label>
<input type='text' name='municipalt' id='municipalt' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Photo</label>
<input type='text' name='photo' id='photo' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Pre Admission</label>
<input type='text' name='preAdmission' id='preAdmission' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Pre School</label>
<input type='text' name='preSchool' id='preSchool' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Program</label>
<input type='text' name='program' id='program' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Province</label>
<input type='text' name='province' id='province' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Provincet</label>
<input type='text' name='provincet' id='provincet' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Religion</label>
<input type='text' name='religion' id='religion' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Roll No</label>
<input type='text' name='rollNo' id='rollNo' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Section</label>
<input type='text' name='section' id='section' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Sn</label>
<input type='text' name='sn' id='sn' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Status</label>
<input type='text' name='status' id='status' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Stu Name</label>
<input type='text' name='stuName' id='stuName' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Stu Password</label>
<input type='text' name='stuPassword' id='stuPassword' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Subject Group</label>
<input type='text' name='subjectGroup' id='subjectGroup' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Tol</label>
<input type='text' name='tol' id='tol' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Tolt</label>
<input type='text' name='tolt' id='tolt' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Ward No</label>
<input type='text' name='wardNo' id='wardNo' class='form-control'/>
</div>
<div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
<label>Ward Not</label>
<input type='text' name='wardNot' id='wardNot' class='form-control'/>
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
var actionStatus=true;

function edit(sn){
 var data = document.getElementById(sn);
var id = ['id','academicYear','admissionYear','alternativeMobile','castEthnicity','citizenship','classId','dateOfBirth','disability','district','districtt','dropOut','email','enterBy','enterDate','fathersDesignation','fathersMobile','fathersName','fathersOccupation','fathersQualification','gender','guardiansAddrress','guardiansMobile','guardiansName','guardiansRelation','maritalStatus','mobileNo','mothersDesignation','mothersMobile','mothersName','mothersOccupation','mothersQualification','municipal','municipalt','photo','preAdmission','preSchool','program','province','provincet','religion','rollNo','section','sn','status','stuName','stuPassword','subjectGroup','tol','tolt','wardNo','wardNot'];
for( var i=0;i<id.length;i++)
{
document.getElementById(id[i]).value=data.children[i].innerHTML;
}
  $('#Update').show();$('#Save').hide();
document.getElementById('Update').focus();
actionStatus=false;}
  function callApi(URL,requestData,apiMethod)
 {
$('.btn').button('loading');
 $.ajax({ type: apiMethod, url: URL, headers: {'Authorization':token}, data: JSON.stringify(requestData), contentType: "application/json; charset=utf-8",dataType: "json",
 success: function(data) {
$('.btn').button('reset');
 
$('#Update').hide();
$('#Save').show();
actionStatus=true;
messages(data.message);
document.getElementById('dataFrom').reset();
getRecord();
},
    error: function(XMLHttpRequest) {
                $('.btn').button('reset');
                if (XMLHttpRequest.status === 404) {
                    errorMSG("API Not Found!!");
                } else if (XMLHttpRequest.status === 400) {
                    errorMSG(XMLHttpRequest.responseJSON.message);
                }else{
                    errorMSG(XMLHttpRequest.responseJSON.error);
                }
            }
});
   }

 function doSave()
{
 var dataForm = $('form').serializeArray(); var requestData = {}; $.each(dataForm, function(i, v) {requestData[v.name] = v.value;});
var URL=path+"/api/Student/StudentInfo";
callApi(URL,requestData,"POST");
}
 function doUpdate()
{
  var dataForm = $('form').serializeArray(); var requestData = {}; $.each(dataForm, function(i, v) {requestData[v.name] = v.value;});
 var URL=path+"/api/Student/StudentInfo/"+document.getElementById('id').value;
callApi(URL,requestData,"PUT");
}
function getRecord()
    {
    var URL=path+"/api/Student/StudentInfo";
    $.ajax({type: "GET",url: URL,headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json"
, success: function(data){
  if(data.length===0){
messages('Record Not Found');
document.getElementById('table').innerHTML='';
return false;}
document.getElementById('table').innerHTML=`<table class='table table-bordered table-hover table-striped' id='dataTable'><thead>
<tr><th>Id</th><th>Academic Year</th><th>Admission Year</th><th>Alternative Mobile</th><th>Cast Ethnicity</th><th>Citizenship</th><th>Class Id</th><th>Date Of Birth</th><th>Disability</th><th>District</th><th>Districtt</th><th>Drop Out</th><th>Email</th><th>Enter By</th><th>Enter Date</th><th>Fathers Designation</th><th>Fathers Mobile</th><th>Fathers Name</th><th>Fathers Occupation</th><th>Fathers Qualification</th><th>Gender</th><th>Guardians Addrress</th><th>Guardians Mobile</th><th>Guardians Name</th><th>Guardians Relation</th><th>Marital Status</th><th>Mobile No</th><th>Mothers Designation</th><th>Mothers Mobile</th><th>Mothers Name</th><th>Mothers Occupation</th><th>Mothers Qualification</th><th>Municipal</th><th>Municipalt</th><th>Photo</th><th>Pre Admission</th><th>Pre School</th><th>Program</th><th>Province</th><th>Provincet</th><th>Religion</th><th>Roll No</th><th>Section</th><th>Sn</th><th>Status</th><th>Stu Name</th><th>Stu Password</th><th>Subject Group</th><th>Tol</th><th>Tolt</th><th>Ward No</th><th>Ward Not</th><th style='width: 90px;'>Action</th></tr></thead><tbody></tbody></table>`;
var tableData;
for(var i=0;i<data.length;i++)
{
tableData=`<tr id='`+i+`'>
<td>`+data[i].id+`</td>
<td>`+data[i].academicYear+`</td>
<td>`+data[i].admissionYear+`</td>
<td>`+data[i].alternativeMobile+`</td>
<td>`+data[i].castEthnicity+`</td>
<td>`+data[i].citizenship+`</td>
<td>`+data[i].classId+`</td>
<td>`+data[i].dateOfBirth+`</td>
<td>`+data[i].disability+`</td>
<td>`+data[i].district+`</td>
<td>`+data[i].districtt+`</td>
<td>`+data[i].dropOut+`</td>
<td>`+data[i].email+`</td>
<td>`+data[i].enterBy+`</td>
<td>`+data[i].enterDate+`</td>
<td>`+data[i].fathersDesignation+`</td>
<td>`+data[i].fathersMobile+`</td>
<td>`+data[i].fathersName+`</td>
<td>`+data[i].fathersOccupation+`</td>
<td>`+data[i].fathersQualification+`</td>
<td>`+data[i].gender+`</td>
<td>`+data[i].guardiansAddrress+`</td>
<td>`+data[i].guardiansMobile+`</td>
<td>`+data[i].guardiansName+`</td>
<td>`+data[i].guardiansRelation+`</td>
<td>`+data[i].maritalStatus+`</td>
<td>`+data[i].mobileNo+`</td>
<td>`+data[i].mothersDesignation+`</td>
<td>`+data[i].mothersMobile+`</td>
<td>`+data[i].mothersName+`</td>
<td>`+data[i].mothersOccupation+`</td>
<td>`+data[i].mothersQualification+`</td>
<td>`+data[i].municipal+`</td>
<td>`+data[i].municipalt+`</td>
<td>`+data[i].photo+`</td>
<td>`+data[i].preAdmission+`</td>
<td>`+data[i].preSchool+`</td>
<td>`+data[i].program+`</td>
<td>`+data[i].province+`</td>
<td>`+data[i].provincet+`</td>
<td>`+data[i].religion+`</td>
<td>`+data[i].rollNo+`</td>
<td>`+data[i].section+`</td>
<td>`+data[i].sn+`</td>
<td>`+data[i].status+`</td>
<td>`+data[i].stuName+`</td>
<td>`+data[i].stuPassword+`</td>
<td>`+data[i].subjectGroup+`</td>
<td>`+data[i].tol+`</td>
<td>`+data[i].tolt+`</td>
<td>`+data[i].wardNo+`</td>
<td>`+data[i].wardNot+`</td>
<td>
  <a title='Edit' onclick='edit(`+(i)+`)' class='glyphicon glyphicon-edit' href='#'>Edit</a> 
| <a title='Delete' onclick='recordDelete("`+data[i].id+`")' class='glyphicon glyphicon-remove-circle' href='#'>Del</a>
</td></tr>`;
$('#dataTable').append(tableData);
}
 $('#dataTable').DataTable();
}
,    error: function(XMLHttpRequest) {
                $('.btn').button('reset');
                if (XMLHttpRequest.status === 404) {
                    errorMSG("API Not Found!!");
                } else if (XMLHttpRequest.status === 400) {
                    errorMSG(XMLHttpRequest.responseJSON.message);
                }else{
                    errorMSG(XMLHttpRequest.responseJSON.error);
                }
            }
});
}
function recordDelete(id){
if(!confirm('Are you sure')){
return;
}
var URL=path+"/api/Student/StudentInfo/"+id;
callApi(URL,"","DELETE");
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
return "\n{\"id\": \""+id+"\",\"academicYear\": \""+academicYear+"\",\"admissionYear\": \""+admissionYear+"\",\"alternativeMobile\": \""+alternativeMobile+"\",\"castEthnicity\": \""+castEthnicity+"\",\"citizenship\": \""+citizenship+"\",\"classId\": \""+classId+"\",\"dateOfBirth\": \""+dateOfBirth+"\",\"disability\": \""+disability+"\",\"district\": \""+district+"\",\"districtt\": \""+districtt+"\",\"dropOut\": \""+dropOut+"\",\"email\": \""+email+"\",\"enterBy\": \""+enterBy+"\",\"enterDate\": \""+enterDate+"\",\"fathersDesignation\": \""+fathersDesignation+"\",\"fathersMobile\": \""+fathersMobile+"\",\"fathersName\": \""+fathersName+"\",\"fathersOccupation\": \""+fathersOccupation+"\",\"fathersQualification\": \""+fathersQualification+"\",\"gender\": \""+gender+"\",\"guardiansAddrress\": \""+guardiansAddrress+"\",\"guardiansMobile\": \""+guardiansMobile+"\",\"guardiansName\": \""+guardiansName+"\",\"guardiansRelation\": \""+guardiansRelation+"\",\"maritalStatus\": \""+maritalStatus+"\",\"mobileNo\": \""+mobileNo+"\",\"mothersDesignation\": \""+mothersDesignation+"\",\"mothersMobile\": \""+mothersMobile+"\",\"mothersName\": \""+mothersName+"\",\"mothersOccupation\": \""+mothersOccupation+"\",\"mothersQualification\": \""+mothersQualification+"\",\"municipal\": \""+municipal+"\",\"municipalt\": \""+municipalt+"\",\"photo\": \""+photo+"\",\"preAdmission\": \""+preAdmission+"\",\"preSchool\": \""+preSchool+"\",\"program\": \""+program+"\",\"province\": \""+province+"\",\"provincet\": \""+provincet+"\",\"religion\": \""+religion+"\",\"rollNo\": \""+rollNo+"\",\"section\": \""+section+"\",\"sn\": \""+sn+"\",\"status\": \""+status+"\",\"stuName\": \""+stuName+"\",\"stuPassword\": \""+stuPassword+"\",\"subjectGroup\": \""+subjectGroup+"\",\"tol\": \""+tol+"\",\"tolt\": \""+tolt+"\",\"wardNo\": \""+wardNo+"\",\"wardNot\": \""+wardNot+"\"}";
--%>