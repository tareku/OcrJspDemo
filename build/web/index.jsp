<%-- 
    Document   : index
    Created on : 02-Nov-2015, 19:45:14
    Author     : TAREK
--%>
<%%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="ocr.Data.PassportDetail" %>
<!DOCTYPE html>
<html>
    <head>
        <title>OCR Demo</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <link rel="stylesheet" type="text/css" href="style.css">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script>
            function load_file() {
                var reader = new FileReader();
                reader.onload = function () {
                    var img = new Image();
                    img.src = reader.result;
                    img.onload = function () {
                        document.getElementById('output').innerHTML = '';
                        document.getElementById('output').appendChild(img);
//                        OCRAD(img, function (text) {
//                            document.getElementById('transcription').className = "done";
//                            document.getElementById('transcription').innerText = text;
//                        });
                    };
                };
                reader.readAsDataURL(document.getElementById('picker').files[0]);
            }
        </script>
    </head>
    <body>
        <form action="GetPassportData" method="post" enctype="multipart/form-data">
            <input type="file" class="file" onchange="load_file()" id="picker" name="upload" />
            <input type="submit" class="btn btn-info" value="Submit Button">
            <!--<input type="submit" value="Get Passport Data" name="submit" />-->             
        </form>
        <jsp:useBean id="PassportDetail" class="ocr.Data.PassportDetail" scope="request" />
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
                            <td><jsp:getProperty property="doctypevalue" name="PassportDetail"/></td>
                            <td><jsp:getProperty property="doctypecode" name="PassportDetail"/></td>
                        </tr>
                        <tr>                                
                            <td>Issuing State</td>
                            <td><jsp:getProperty property="statevalue" name="PassportDetail"/></td>
                            <td><jsp:getProperty property="statecode" name="PassportDetail"/></td>
                        </tr>
                        <tr>
                            <td>Type</td>
                            <td><jsp:getProperty property="type" name="PassportDetail"/></td>
                            <td><jsp:getProperty property="type" name="PassportDetail"/></td>
                        </tr>
                        <tr>                               
                            <td>Name</td>
                            <td><jsp:getProperty property="namevalue" name="PassportDetail"/></td>
                            <td><jsp:getProperty property="namecode" name="PassportDetail"/></td>
                        </tr>
                        <tr>                               
                            <td>Passport Number</td>
                            <td><jsp:getProperty property="passnumbercode" name="PassportDetail"/></td>
                            <td><jsp:getProperty property="passnumbercode" name="PassportDetail"/></td>
                        </tr>
                        <tr>                               
                            <td>Passport Number Check Digit</td>
                            <td><jsp:getProperty property="passnumbercheckdigit" name="PassportDetail"/></td>
                            <td><jsp:getProperty property="passnumbercheckdigit" name="PassportDetail"/></td>
                        </tr>
                        <tr>                               
                            <td>Nationality</td>
                            <td><jsp:getProperty property="nationalityvalue" name="PassportDetail"/></td>
                            <td><jsp:getProperty property="nationalitycode" name="PassportDetail"/></td>
                        </tr>
                        <tr>                               
                            <td>Date of Birth</td>
                            <td><jsp:getProperty property="birthdayvalue" name="PassportDetail"/></td>
                            <td><jsp:getProperty property="birthdaycode" name="PassportDetail"/></td>
                        </tr>
                        <tr>                               
                            <td>Date of Birth Check Digit</td>
                            <td><jsp:getProperty property="birthdaycheck" name="PassportDetail"/></td>
                            <td><jsp:getProperty property="birthdaycheck" name="PassportDetail"/></td>
                        </tr>                        
                        <tr>                               
                            <td>Sex</td>
                            <td><jsp:getProperty property="sexvalue" name="PassportDetail"/></td>
                            <td><jsp:getProperty property="sex" name="PassportDetail"/></td>
                        </tr>
                        <tr>                               
                            <td>Date of Expiry</td>
                            <td><jsp:getProperty property="expirationdatevalue" name="PassportDetail"/></td>
                            <td><jsp:getProperty property="expirationdatecode" name="PassportDetail"/></td>
                        </tr>
                        <tr>                               
                            <td>Date of Expiry Check Digit</td>
                            <td><jsp:getProperty property="expirationdatecheck" name="PassportDetail"/></td>
                            <td><jsp:getProperty property="expirationdatecheck" name="PassportDetail"/></td>
                        </tr>
                        <tr>                               
                            <td>Personal Number</td>
                            <td><jsp:getProperty property="personalnumbervalue" name="PassportDetail"/></td>
                            <td><jsp:getProperty property="personalnumbercode" name="PassportDetail"/></td>
                        </tr>
                        <tr>                               
                            <td>Personal Number Check Digit</td>
                            <td><jsp:getProperty property="personalnumbercheck" name="PassportDetail"/></td>
                            <td><jsp:getProperty property="personalnumbercheck" name="PassportDetail"/></td>
                        </tr>
                        <tr>                               
                            <td>Composite Number Check Digit</td>
                            <td><jsp:getProperty property="compositenumber" name="PassportDetail"/></td>
                            <td><jsp:getProperty property="compositenumber" name="PassportDetail"/></td>
                        </tr>                       
                    </tbody>
                </table>                
            </div><!-- table-responsive -->
        </div>
        <div class="col-sm-5">
            <textarea class="form-control" rows="5">
                <jsp:getProperty property="mrz" name="PassportDetail"/>
            </textarea>
        </div>
                <!--<img src="SetPassportImage?id=<jsp:getProperty property="img" name="PassportDetail"/>" width="100" height="100"/>-->
        <div id="output" name="output" class="text-center"></div>  
    </body>
</html>
