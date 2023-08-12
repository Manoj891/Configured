<%@include file="../login/header.jsp"%>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    google.charts.load('current', {'packages': ['bar']});
    google.charts.load("current", {packages: ["corechart"]});

    var classData = [];
    var billData = [];
    var paichartTitle = "";
    var URL = "<%=path%>/api/Dashboard";
    $.ajax({type: "GET", url: URL, headers: {'Authorization': '<%=token%>'}, contentType: "application/json; charset=utf-8", dataType: "json",
        success: function (res) {
            classData = res.classData;
            billData = res.billData;
            google.charts.setOnLoadCallback(drawChart);
            google.charts.setOnLoadCallback(drawPieChart);
            var totalStudent = 0;
            for (var i = 1; i < classData.length; i++) {
                totalStudent = totalStudent + classData[i][1];
            }
            paichartTitle = "Student Record - Total Student " + totalStudent;
        }
    });
    function drawChart() {
        var data = google.visualization.arrayToDataTable(billData);
        var www = document.getElementById("container").offsetWidth - 50;
        if (www < 800)
            www = 800;
        var options = {
            width: www,
            height: 450,
            chart: {
                title: 'Organization Performance',
                subtitle: 'Student Fee Recept'
            }
        };
        var chart = new google.charts.Bar(document.getElementById('columnchart_material'));
        chart.draw(data, google.charts.Bar.convertOptions(options));
    }

    function drawPieChart() {
        var data = google.visualization.arrayToDataTable(classData);
        var options = {
            height: 350,
            title: paichartTitle,
            pieHole: 0.35,
        };
        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
    }
</script>
<div class="row h-c-m">
    <div class="h-c-c" id="piechart_3d" ></div>
    <div class="h-c-c" id="columnchart_material"></div>
</div>

<%@include file="../login/footer.jsp" %>