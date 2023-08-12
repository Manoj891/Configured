<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../login/header.jsp"%>
<fieldset>  <legend>Transaction</legend> 
    <form method='POST' id='dataFrom' onsubmit="return (doSave());"> 
        <div class="row">
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Date From</label>
                <input type='text' id='dateFrom' value='<%= session.getAttribute("bsdate")%>'  class='form-control'/>
            </div> 
            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Date To</label>
                <input type='text' id='dateTo' value='<%= session.getAttribute("bsdate")%>' class='form-control'/>
            </div>

            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>
                <label>Device</label>
                <select id="company" name="company" class="form-control"></select>
            </div>

            <div class='col-lg-2 col-sm-2 col-md-2 col-xs-6'>

                <label>&nbsp;</label><br>
                <input type='button' id='Save' value='Search' onclick="getRecord()" class='btn btn-success'/>
            </div>
        </div>
    </form>
</fieldset>  <br> <fieldset>  <legend> Data</legend> 
    <div class='row' id='table' style="overflow: auto; "></div>
</fieldset>
<script>
    findCompanyAccess("#company");
    var actionStatus = true;
    function getRecord()
    {
        var dateFrom = document.getElementById("dateFrom").value;
        var dateTo = document.getElementById("dateTo").value;
        var company = document.getElementById("company").value;
        if (company === "") {
            errorMSG("Please provide company");
            return false;
        }
        var URL = path + "/api/Utility/IclockTransaction?company=" + company + "&dateFrom=" + dateFrom + "&dateTo=" + dateTo;
        $.ajax({type: "GET", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json"
            , success: function (data) {
                if (data.length === 0) {
                    messages('Record Not Found');
                    document.getElementById('table').innerHTML = '';
                    return false;
                }
                document.getElementById('table').innerHTML = `<table class='table table-bordered table-hover table-striped' id='dataTable'><thead>
<tr><th>Company Name</th><th>Emp Code</th><th>Emp Name</th><th>Date</th><th>Time</th></tr></thead><tbody></tbody></table>`;
                var tableData;
                for (var i = 0; i < data.length; i++)
                {
                    tableData = `<tr><td>` + data[i].deviceName + `</td><td>` + data[i].empCode + `</td><td>` + data[i].empName + `</td> <td>` + data[i].date + `</td><td>` + data[i].time + `</td></tr>`;
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

</script>

<%@include file="../login/footer.jsp" %>

<%--
return "\n{\"loginId\": \""+loginId+"\",\"terminalId\": \""+terminalId+"\"}";
--%>