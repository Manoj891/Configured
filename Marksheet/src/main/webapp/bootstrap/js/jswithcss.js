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

function getVoucher(voucherNo, divId)
{
    var URL = path + "/api/Account/VoucherData/" + voucherNo;
    $.ajax({type: "GET", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json", success: function (res) {
            if (res['error']) {
                messages(res['message']);
                return false;
            }
            var tableData = ` <div class="modal fade" id="myModal" role="dialog" style='height:85%;width:80%;margin:60px auto 0!important;'>
            <div class="modal-content">
            <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>                    
             </div>
            <div class="modal-body" style="margin:0 auto;" id='voucherDataPrint'>             
            <table class='table table-bordered table-hover table-striped' id='voucherDataExcel'>
                    <tr><td colspan='8' ><b>
                        <div style="text-align: center;font-size: 20px;"> ` + localStorage.getItem("organizationName") + `</div>
                        <div style="text-align: center;font-size: 14px;"> ` + localStorage.getItem("organizationAddress") + `</div>
                           <div style="text-align: center;font-size: 20px;"><b>Voucher</b></div>
                          <div style="text-align: right"> Voucher No : ` + res.voucherNo + `</div>
                        <div style="text-align: right"> Voucher Amount : ` + res.voucherAmount + `</div>
                    </b></td></tr>    
                    <tr><td>SN</td><td>Ac Code</td><td>Ac Name</td><td>Particular</td><td>Cheque No</td><td>Bill No</td><td>Dr</td><td>Cr</td></tr>`;

            var data = res.detail;
            for (var i = 0; i < data.length; i++)
            {
                tableData = tableData + `<tr><td>` + (i + 1) + `</td><td>` + data[i].acCode + `</td><td>` + data[i].acName + `</td><td>` + data[i].particular + `</td><td>` + data[i].billNo + `</td><td>` + data[i].chequeNo + `</td><td>` + data[i].dr + `</td><td>` + data[i].cr + `</td></tr>`;
            }
            tableData = tableData + `<tr><td colspan='8' style="text-align: left"> Narration : ` + res.narration + `</td></tr>`;
            tableData = tableData + `<tr><td colspan='3' style="text-align: left">
            <div>-------------------------</div>
            <div>Enter By : ` + res.enterBy + `</div>
            <div>Enter Date : ` + res.enterDate + `</div>
            </td>
            <td colspan='5' style="text-align: left"> 
            <div>-------------------------</div>
            <div>Approve By : ` + res.approveBy + `</div>
            <div>Approve Date : ` + res.approveDate + `</div></td></tr>
        </table> 
        </div>
            <div class="modal-footer print">
                 <input type="button" class="btn btn-primary" style='width:100px;' onclick='excelExport("voucherDataExcel")' value='Excel'>
                <input type="button" class="btn btn-primary" style='width:100px;' onclick='printDiv("voucherDataPrint")' value='Print'>
                <input type="button" class="btn btn-danger" style='width:100px;' data-dismiss="modal" value='Close'>
            </div>
        </div>
        </div>`;
            document.getElementById(divId).innerHTML = tableData;
            $("#myModal").modal();
        }
    });
}


function getPurchaseOrder(orderNo, divId)
{
    var URL = path + "/api/Inventory/PurchaseOrder/" + orderNo;
    $.ajax({type: "GET", url: URL, headers: {'Authorization': token}, contentType: "application/json; charset=utf-8", dataType: "json", success: function (res) {
            if (res['error']) {
                messages(res['message']);
                return false;
            }
            var tableData = ` <div class="modal fade" id="myModal" role="dialog" style='height:85%;width:60%;margin:60px auto 0!important;'>
            <div class="modal-content">
            <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>                    
             </div>
            <div class="modal-body" style="margin:0 auto;" id='voucherDataPrint'>             
            <table class='table table-bordered table-hover table-striped' id='voucherDataExcel'>
                    <tr><td colspan='8' ><b>
                        <div style="text-align: center;font-size: 20px;"> ` + localStorage.getItem("organizationName") + `</div>
                        <div style="text-align: center;font-size: 14px;"> ` + localStorage.getItem("organizationAddress") + `</div>
              <div style="text-align: center;font-size: 20px;"><b>Purchase Order</b></div>
                         <div style="text-align: right"> Order No : ` + res.orderNo + ` Order Date : ` + res.enterDate + `  Delivery Date : ` + res.withinDate + `</div>
                    </b></td></tr>    
                    <tr><td>SN</td><td>Ac Code</td><td>Ac Name</td><td>Specification</td><td>Quantity</td><td>Rate</td><td>Total</td></tr>`;
            console.log(res);
            var data = res.detail;
//            console.log(data.length);
            console.log(data);
            for (var i = 0; i < data.length; i++)
            {
                tableData = tableData + `<tr><td>` + (i + 1) + `</td><td>` + data[i].acCode.acCode + `</td><td>` + data[i].acCode.acName + `</td><td>` + data[i].specification + `</td><td>` + data[i].orderQty + `</td><td>` + data[i].rate + `</td><td>` + data[i].total + `</td></tr>`;
            }
            tableData = tableData + `<tr><td colspan='8' style="text-align: left"> Narration : ` + res.narration + `</td></tr>`;
            tableData = tableData + `<tr><td colspan='3' style="text-align: left">
            <div>-------------------------</div>
            <div>Enter By : ` + res.enterBy + `</div>
            <div>Enter Date : ` + res.enterDate + `</div>
            </td>
            <td colspan='5' style="text-align: left"> 
            <div>-------------------------</div>
            <div>Approve By : ` + res.approveBy + `</div>
            <div>Approve Date : ` + res.approveDate + `</div></td></tr>
        </table> 
        </div>
            <div class="modal-footer print">
                 <input type="button" class="btn btn-primary" style='width:100px;' onclick='excelExport("voucherDataExcel")' value='Excel'>
                <input type="button" class="btn btn-primary" style='width:100px;' onclick='printDiv("voucherDataPrint")' value='Print'>
                <input type="button" class="btn btn-danger" style='width:100px;' data-dismiss="modal" value='Close'>
            </div>
        </div>
        </div>`;
            document.getElementById(divId).innerHTML = tableData;
            $("#myModal").modal();
        }
    });
}