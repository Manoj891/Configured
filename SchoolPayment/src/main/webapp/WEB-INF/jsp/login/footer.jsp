
</div>
<div style="margin-top: 50px;"></div>
<footer id="footer">
    <div class="container">
        <div class="row">
            <div class="col-xs-4 col-sm-4 col-md-4 col-xs-12">
                <p style="padding:2px;"></p>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 col-xs-12">              
                <p style="padding: 2px;"> </p>
            </div>
            <div class="col-xs-4 col-sm-4 col-md-4 col-xs-12">              
                <div class="col-xs-10 col-sm-10 col-md-10 col-xs-10">         
                    <p style="margin: 2px;margin-top: 6px;"></p>
                </div>
                <div class="col-xs-2 col-sm-2 col-md-2 col-xs-2">    

                </div>
            </div>
        </div>         
    </div>
</footer> 
<script>
    function errorMSG(msg) {
        $(".btn").button("reset");
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
    }</script>
</body>
</html>