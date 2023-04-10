

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<link href="css/bootstrap.min.css" rel="stylesheet" media="screen"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <title><tiles:insertAttribute name="title"/></title>
        <style>
            h3{
                text-align: center;
            }
            .left{
                float: left;
                padding-left: 7px;
                padding-top: 50px;
                width: 20%;
            }
            .dropdown{
                padding-bottom: 5px;
            }
            .dropdown button{
                width: 100%;
               
            }
            .dropdown-menu{
                width: 100%;
                text-align: center;
            }
            .container{
               
            }
            a{
                color: white;
                text-decoration: none;
            }
            a.card-body {
                text-decoration: none;
            }
            a.card-body:hover {
                color: white;
            }
            .box-detail-tour{
   
    margin-bottom: 5px;
    padding: 15px;

}
.box-gia-tour{
    float: left;
     margin-bottom: 20px;
    padding: 15px;
}
.book-tour{
    display: block;
    text-align: center;
    font-size: 16px;
    line-height: 25px;
    padding: 10px;
    background: #d82727;
    color: #ffffff;
    text-transform: uppercase;
    font-weight: bold;
    margin: 10px 0;
    
}
.book-tour:hover{
    text-decoration: none;
    color: white;
}
#danhsach{
    color:black;
    text-decoration: none;
}

        </style>
    </head>
    <body>
        <tiles:insertAttribute name="header"/>
        <tiles:insertAttribute name="content"/>
        <tiles:insertAttribute name="footer"/>
    </body>
</html>
