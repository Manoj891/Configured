function findCompany(id)
{
    $(id).empty().append('<option value="">Select</option>');
    var URL = path + "/api/Utility/PersonnelCompany";
    $.ajax({type: "GET", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json"
        , success: function (data) {

            for (var i = 0; i < data.length; i++)
            {
                $(id).append('<option value="' + data[i].id + '">' + data[i].companyName + '</option>');
            }

        }
    });
}
function findCompanyAccess(id)
{
    $(id).empty().append('<option value="">Select</option>');
    var URL = path + "/api/Utility/PersonnelCompany/Access";
    $.ajax({type: "GET", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json"
        , success: function (data) {

            for (var i = 0; i < data.length; i++)
            {
                $(id).append('<option value="' + data[i].id + '">' + data[i].companyName + '</option>');
            }

        }
    });
}
function findUser(id)
{
    $(id).empty().append('<option value="">Select</option>');
    var URL = path + "/api/Utility/DeviceLogin";
    $.ajax({type: "GET", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json"
        , success: function (data) {

            for (var i = 0; i < data.length; i++)
            {
                $(id).append('<option value="' + data[i].id + '">' + data[i].loginId + '</option>');
            }

        }
    });
}

function findDevice(id)
{
    $(id).empty().append('<option value="">Select</option>');
    var URL = path + "/api/Utility/IclockTerminal";
    $.ajax({type: "GET", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json"
        , success: function (data) {

            for (var i = 0; i < data.length; i++)
            {
                $(id).append('<option value="' + data[i].id + '">' + data[i].alias + '</option>');
            }

        }
    });
}
function resetForm() {
    $('#Update').hide();
    $('#Cancel').hide();
    $('#Save').show();
    actionStatus = true;
    document.getElementById('dataFrom').reset();
}
function errorMSG(msg) {
    $.toast({
        heading: "Error",
        text: msg,
        icon: 'error',
        loader: true, // Change it to false to disable loader
        loaderBg: '#FF0000', // To change the background,
        position: 'mid-center'
    });
}
function messages(msg) {
    $.toast({
        heading: "Messages",
        text: msg,
        icon: 'info',
        loader: true, // Change it to false to disable loader
        loaderBg: '#FFFFFF', // To change the background,
        position: 'mid-center'
    });
}

function excelExport(tableId)
{
    $(".print").hide();
    var htmltable = document.getElementById(tableId);
    var html = htmltable.outerHTML;
    window.open('data:application/vnd.ms-excel,' + encodeURIComponent(html));
    $(".print").show();
}

function printDiv(div) {
    $('.print').hide();
    let printContents, popupWin;
    printContents = document.getElementById(div).innerHTML;
    popupWin = window.open('', '_blank', 'top=0,left=0,height=100%,width=auto');
    popupWin.document.open();
    popupWin.document.write(`
            <html>
              <head>
                <title>Print tab</title>
                <style>
                .p{
                  margin-bottom: 5px;
                }
                .table-bordered {
                    border: 1px solid #eceeef;
                }
                .table {
                  position:relative;
                  width: 100%;
                  max-width: 100%;
                  margin-top: 20px;
                  margin-bottom: 1rem;
                  font-size: smaller;
                }
                .table {
                  border-collapse: collapse;
                  background-color: transparent;
                }
                .table-bordered th, .table-bordered td {
                    border: 1px solid #eceeef;
                }
                .table th, .table td {
                    padding: 0.55rem;
                    vertical-align: top;
                    border-top: 1px solid #eceeef;
                    text-align:left;
                }
                .last-td{
                  display:none;
                }
                //........Customized style.......
                </style>
              </head>
          <body onload="window.print();window.close()">` + printContents + `</body>
            </html>`
            );
    $('.print').show();
    popupWin.document.close();
}
