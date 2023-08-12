<%@page import="com.config.DateConvert"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../login/header.jsp"%>
<%

String date=DateConvert.toDay();
%>
<link href="http://202.166.193.249:8080/SchoolKing/bootstrap/style.css" rel="stylesheet" type="text/css"/>       

<!--        //Data table print and export-->

<link href="http://202.166.193.249:8080/SchoolKing/bootstrap/g_sheet.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <style>
        .name-table{
            text-align: left;
            border: solid 0px;
        }
     
    </style>
    
    <!--    <img src="` + path + `Document/` + logo + `" alt="Logo here" height="100" width="100">  -->
    <div class="container" id="container" style="overflow: auto">
       

        <fieldset> 
            <legend>Student Grade</legend> 
            <div id="studentGrade" style="width: 620px; height: 800px;"></div>
        </fieldset>


        <script>
            function callApi() {
            <%                String id = request.getParameter("id");
                if (id == null)
                    id = "";
            %>

                var URL = "<%=request.getContextPath()%>/api/Utility/OrganizationMaster";
                $.ajax({type: "GET", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json"
                    , success: function (oData) {
                        if (oData.length === 0) {
                            return false;
                        }
                        var organizationName = oData[0].name;
                        var logo = oData[0].logo;
                        var organizationAddress = oData[0].municipal + " - " + oData[0].wardNo + ", " + oData[0].address;
                        URL = "<%=request.getContextPath()%>/api/Utility/GradeShett?id=<%= id%>";
                                        $.ajax({type: "GET", url: URL, headers: {'Authorization': "<%=session.getAttribute("paymentToken")%>"}, contentType: "application/json; charset=utf-8", dataType: "json",
                                            success: function (data) {
                                                for (var i = 0; i < data.length; i++) {

                                                    var detail = data[i].detail;
                                                    var tempData = ``;
                                                    console.log(detail.length);
                                                    for (var j = 0; j < detail.length; j++)
                                                    {
                                                        tempData = tempData + `
        <tr>
        <td >&nbsp;&nbsp;` + detail[j].subjectCode + `</td>
        <td style="text-align: left">&nbsp;&nbsp;` + detail[j].subjectName.replaceAll(" ", '&nbsp;') + `</td>
        <td>` + detail[j].creditHour + `</td>
       <td>` + detail[j].geadePoint + `</td>
        <td>` + detail[j].geadeTh + `</td>       
        <td>` + detail[j].finalGrade + `</td>      
        <td style="text-align: left">&nbsp;&nbsp;` + detail[j].remark + `</td>
</tr>
        `;
                                                    }

                                                    for (var j = detail.length; j < 11; j++)
                                                    {
                                                        tempData = tempData + `
        <tr><td></td>
        <td style="text-align:left;padding-left:3px;"></td>
        <td>&nbsp;</td>
        <td></td><td></td><td></td><td></td></tr>
        `;
                                                    }

                                                    var mkData = `
        <div class="bi-d" id="mark-div">
        <div class="upper-d">
        <div class="row org-h">
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2" style="text-align: center;">                                             
        <img src="` + path + `Document/` + logo + `" alt="Logo here"  height="100" width="100">  
        </div>
        <div class="col-lg-8 col-md-8 col-sm-8 col-xs-8" style="text-align: center;">                                             
        <h3 class="org-d"><b>` + organizationName + `</b></h3>
        <h5 class="org-d">` + organizationAddress + `</h5>                  
        </div>
        <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
             <img src="` + path + `/images/neb_logo.png" alt="NEB LOGO" height="100" width="100"/>
        </div>
        </div>
        <div style="clear: both;"></div>
        <div style="padding:5px;">
        <p class="exam-name-d" style="width: 20%;">GRADE SHEET</p>
        </div>

        <table style="width: 80%;margin-left: 10%">
        <tr><td class='name-table' colspan="3">THE GRADE(S) SECURED BY : &nbsp;&nbsp;<b> ` + data[i].studentName + ` </b></td><td class='name-table'></td></tr>
        <tr><td class='name-table' colspan="3">DATE OF BIRTH&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;:&nbsp; &nbsp;&nbsp;` + data[i].dob + `</b></td><td class='name-table' >SYMBOL NO : </td> <td class='name-table' >` + data[i].symbolNo + `</b></td></tr>
        <tr><td class='name-table' colspan="3">REGISTRATION NO &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:&nbsp;&nbsp;&nbsp; <b> ` + data[i].regNo + `</b></td><td class='name-table'>GRADE :</td> <td class='name-table' >` + data[i].grade + `</b></td></tr>
        </table>
        <br>

        <div style="text-align: center;"><b>GRADE :IN THE ANNUAL EXAMINATION CONDUCTED BY SCHOOL IN 2077 B.S. ARE GIVEN BELLOW.</b></div>
        <br>
        <table style="width:99%;margin-left:3px;">
        <thead>
        <tr>
        <th rowspan="2">CODE</th>
        <th rowspan="2">SUBJECTS</th>
        <th rowspan="2">CREDIT&nbsp;HOUR</th>
        <th rowspan="2">GRADE&nbsp;POINT</th>
        <th rowspan="2">GRADE</th>
        <th rowspan="2">FINAL&nbsp;GRADE </th>   
        <th rowspan="2" style="width:100px;">REMARKS</th>
        </tr>
       
        </thead>
        <tbody>` + tempData + `</tbody>
        <tfoot><tr><td></td><td>TOTAL</td><td colspan="6">GRADE POINT AVERAGE (GPA) : ` + data[i].gpa + ` </td></tr></tfoot>
        </table>
        </div>
        <div style="clear: both;"></div>


        <div class="row fin_d" style="margin-top:150px;">
        <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3" style="text-align: center;">
        <p><%= date %></p>
        <h4 class="sig-l">ISSUE DATE</h4>
        </div>
        <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3" style="text-align: center;">
        <p>&nbsp;</p>
        <h4 class="sig-l">PREPARED BY</h4>
        </div>
        <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3" style="text-align: center;">
        <p>&nbsp;</p>
        <h4 class="sig-l">CHECKED BY</h4>
        </div>
        <div class="col-lg-3 col-sm-3 col-md-3 col-xs-3" style="text-align: center;">
        <p>&nbsp;</p>
        <h4 class="sig-l">CO-ORDINATOR</h4>
        </div>
        <div class="row">&nbsp;<br>&nbsp;
          
        <div class="row org-h"></div>
            <br>&nbsp;
            <div class="col-lg-12 col-sm-12 col-md-12 col-xs-12" style="text-align: left;">
NOTE : ONE CREDIT HOUR EQUALS 32 CLOCK HOURS.
            </div>
<div class="col-lg-4 col-sm-4 col-md-4 col-xs-4">
TH= THEORY
</div><div class="col-lg-4 col-sm-4 col-md-4 col-xs-4">
PR= PRACTICAL
</div><div class="col-lg-4 col-sm-4 col-md-4 col-xs-4">
XC = EXPELLED
</div>
</div><div class="col-lg-4 col-sm-4 col-md-4 col-xs-4">
ABS= ABSENT
</div><div class="col-lg-4 col-sm-4 col-md-4 col-xs-4">
W=WITHHELD
</div>
          

            </div>
        </div>
        </div>
        </div>
        `;
                                                    $("#studentGrade").append(mkData);
                                                }

                                            }
                                        });

                                    }
                                });
                            }
                            callApi();
        </script>

    </div>
</fieldset>
</div>

<div style="margin-top: 50px;"></div>
<footer id="footer">
    <div class="container">
        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4 col-xs-12">
                <p style="padding:2px;"><i class="fa fa-institution"></i> Paradise Computer Institute Lahan</p>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 col-xs-12">              
                <p style="padding: 2px;"><i class="fa fa-copyright"></i> Copy Right 2019-2021</p>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 col-xs-12">              
                <div class="col-xs-10 col-sm-10 col-md-10 col-xs-10">         
                    <p style="margin: 2px;margin-top: 6px;"><i class="fas fa-phone-square-alt"></i>&nbsp;&nbsp; Tel No: 9815710825</p>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 col-xs-2">    
                    <a style="opacity: .4;"> <b class="fa fa-arrow-up">Top</b></a>
                </div>
            </div>
        </div>         
    </div>
</footer> 
</body>
</html>

