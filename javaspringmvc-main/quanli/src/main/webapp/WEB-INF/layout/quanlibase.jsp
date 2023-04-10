


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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

        <title><tiles:insertAttribute name="title"/></title>
        <style>
           ul li a{
                color: black;
                text-decoration: none;
            }
             ul li:active{
                color: white;
                text-decoration: none;
                background-color: #007bff;
            }
             ul li a:hover{
                
                text-decoration: none;
             }
            div .contentright
            {
                   float: left;
                   width: 80%;
                  
            }
             h1{
                text-align: center;
            }
            .table.table-bordered
            {
                width: 75%;
                text-align: center;
                margin: 50px;
            }
            a{
                color:white;
            }
            a:hover
            {
                 text-decoration: none;
                 color: white;
            }
            li.list-group-item.active{
                background-color: #007bff;
            }
        </style>
    </head>
    <body>
        <tiles:insertAttribute name="header"/>
        <div class="row">
             <tiles:insertAttribute name="contentleft"/>
             <tiles:insertAttribute name="content"/>
        </div>
       
        <tiles:insertAttribute name="footer"/>
    </body>
</html>