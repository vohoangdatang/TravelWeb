

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>MoMo Sandbox</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.4.1/css/bootstrap.min.css"/>
    <link rel="stylesheet"
          href="./statics/eonasdan-bootstrap-datetimepicker/build/css/bootstrap-datetimepicker.min.css"/>
    <!-- CSS -->
</head>
<body>
<div class="container">
    <div id="datacart"> </div>
    <button onclick="momoaa()">click</button>
</div>
    <script>
        function momoaa()
        {
            fetch("/quanli/momo/pay",{
                method:"get",
            }).then(function(res){
                return res.json()
            }).then(function(data){
                console.log(data)
            })
        }
    </script>

</html>