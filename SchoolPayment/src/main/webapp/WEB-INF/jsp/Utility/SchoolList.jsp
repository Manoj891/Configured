<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../login/header.jsp"%>
<br> <fieldset>  <legend> Data</legend> 
    <div class='row' id='table' style="overflow: auto; "></div>   
</fieldset>
<div class="modal fade" id="myModal" role="dialog" style='height:85%;width:80%;margin:60px auto 0!important;'>
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">&times;</button>                    
        </div>
        <div class="modal-body" style="margin:0 auto;"> 
            <div class="row" id="schoolLogo" style="margin-top: 25px "> </div>
            <div class="row" id="schoolRegistrationCertificate" style="margin-top: 25px;"></div>
            <div class="row" id="panRegistrationCertificate" style="margin-top: 25px;"></div>
            <div class="row" id="taxClearanceCertificate" style="margin-top: 25px;"></div>
        </div>
    </div>
</div>
<script>
    var schoolData = [];
    function viewDocument(i) {
        console.log(schoolData[i]);
        document.getElementById("schoolLogo").innerHTML = `<div>Logo</div><img src="` + schoolData[i].schoolLogo + `" alt="Not Available"/>`;
        document.getElementById("schoolRegistrationCertificate").innerHTML = `<div>School Registration Certificate</div><img src="` + schoolData[i].schoolRegistrationCertificate + `" alt="Not Available"/>`;
        document.getElementById("panRegistrationCertificate").innerHTML = `<div>PAN Registration Certificate</div><img src="` + schoolData[i].panRegistrationCertificate + `" alt="Not Available"/>`;
        document.getElementById("taxClearanceCertificate").innerHTML = `<div>Tax Clearance Certificate</div><img src="` + schoolData[i].taxClearanceCertificate + `" alt="Not Available"/>`;
        $("#myModal").modal();
    }
    function getRecord()
    {
        var URL = path + "/api/Utility/SchoolList";
        $.ajax({type: "GET", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json", success: function (data) {
                schoolData = data;
                if (schoolData.length === 0) {
                    messages('Record Not Found');
                    document.getElementById('table').innerHTML = '';
                    return false;
                }
                document.getElementById('table').innerHTML = `<table class='table table-bordered table-hover table-striped' id='dataTable'><thead>
<tr><th>Code</th><th>Name</th><th>District</th><th>Address</th><th>Contact&nbsp;No</th><th>Email</th><th>Remote Url</th><th>Document</th></tr></thead><tbody></tbody></table>`;
                var tableData;
                for (var i = 0; i < schoolData.length; i++)
                {
                    tableData = "<tr id='" + i + "'><td>" + schoolData[i].id + "</td><td>" + schoolData[i].name + "</td><td>" + schoolData[i].district + "</td><td>" + schoolData[i].address + "</td><td>" + schoolData[i].contactNo + "</td><td>" + schoolData[i].email + "</td><td>" + schoolData[i].remoteUrl + "</td><td> <input type='button' class='btn btn-success btn-xs' value='view' onclick='viewDocument(" + i + ")'></td></tr>";
                    $('#dataTable').append(tableData);
                }
                $('#dataTable').DataTable();
            }
        });
    }
    function recordDelete(id) {
        if (!confirm('Are you sure'))
            return;
        var URL = path + "/api/Utility/SchoolList/" + id;
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
return "\n{\"id\": \""+id+"\",\"name\": \""+name+"\",\"district\": \""+district+"\",\"address\": \""+address+"\",\"schoolApi\": \""+schoolApi+"\",\"email\": \""+email+"\",\"accountNo\": \""+accountNo+"\",\"status\": \""+status+"\"}";
--%>