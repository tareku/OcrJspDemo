<%-- 
    Document   : output
    Created on : 03-Nov-2015, 21:38:09
    Author     : TAREK
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="ocr.Data.PassportDetail" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <link href="Template/css/style.default.css" rel="stylesheet">
        <link href="Template/css/jquery.tagsinput.css" rel="stylesheet" />
        <link href="Template/css/toggles.css" rel="stylesheet" />
        <link href="Template/css/bootstrap-timepicker.min.css" rel="stylesheet" />
        <link href="Template/css/select2.css" rel="stylesheet" />
        <link href="Template/css/colorpicker.css" rel="stylesheet" />
        <link href="Template/css/dropzone.css" rel="stylesheet" />
    </head>
    <body>
        <jsp:useBean id="PassportDetail" class="ocr.Data.PassportDetail" scope="request" />
        <h1>Passport MRZ</h1>
        <div class="col-sm-5">
            <textarea class="form-control" rows="5">
                <jsp:getProperty property="mrz" name="PassportDetail"/>
            </textarea>
            <div class="col-md-9">
                <div class="table-responsive">
                    <table class="table table-bordered mb30">
                        <thead>
                            <tr>                                
                                <th>Data Element</th>
                                <th>Value</th>
                                <th>Code</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>                                
                                <td>Document Type</td>
                                <td><jsp:getProperty property="doctype" name="PassportDetail"/></td>
                                <td><jsp:getProperty property="doctype" name="PassportDetail"/></td>
                            </tr>
                            <tr>
                                
                                <td>Type</td>
                                <td><jsp:getProperty property="type" name="PassportDetail"/></td>
                                <td><jsp:getProperty property="type" name="PassportDetail"/></td>
                            </tr>
                            <tr>                               
                                <td>Name</td>
                                <td><jsp:getProperty property="name" name="PassportDetail"/></td>
                                <td><jsp:getProperty property="name" name="PassportDetail"/></td>
                            </tr>
                            <tr>                               
                                <td>Passport Number</td>
                                <td><jsp:getProperty property="passnumber" name="PassportDetail"/></td>
                                <td><jsp:getProperty property="passnumber" name="PassportDetail"/></td>
                            </tr>
                        </tbody>
                    </table>
                </div><!-- table-responsive -->
            </div>
        </div>
        <!--        <input type="text"               
                       value="<jsp:getProperty property="mrz" name="PassportDetail"/>"
                       id="PDetails" />-->
                <!--<img src="<jsp:getProperty property="passportPath" name="PassportDetail"/>"/>-->
        <!--<div id="output" name="output"></div>-->
    </body>
</html>
