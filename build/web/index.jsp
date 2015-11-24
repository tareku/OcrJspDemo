<%-- 
    Document   : index
    Created on : 02-Nov-2015, 19:45:14
    Author     : TAREK
--%>
<%%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div id="output" name="output" class="text-center"></div>  
    </body>
</html>
