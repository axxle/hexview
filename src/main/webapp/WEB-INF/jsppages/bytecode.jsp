<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Разбор файла по спеке JVMS8</title>
    <link href="style.css" rel="stylesheet">
</head>
<body>

<header>
    <div class="container">
        <h1 id="pagetitle">Разбор файла по спеке JVMS8</h1>
    </div>
</header>

<div class="main">
    <div class="container">
        <div class="hexdataview">
            <div class="dropzone" id="dropzone">Drop class-files here to view structure</div>
            <p id="viewzone"></p>
        </div>
    </div>
</div>

<script>
    (function(){

        var dropzone = document.getElementById('dropzone');

        var upload = function (files) {
            var formData = new FormData(),
                xhr = new XMLHttpRequest(),
                x;

            for(x = 0; x < files.length; x = x + 1) {
                formData.append('file[]', files[x]);
            }

            xhr.onload = function(){
                var data = this.response;
                //вывести в нужную область
                console.log(data[0]);
                console.log(data[1]);
                var viewzone = document.getElementById('viewzone');
                viewzone.innerHTML = "";
                var s = '<textarea name="a" id="a" cols="100" rows="50">';
                for(i=0; i<data.length; i++){
                    s = s + data[i];
                }
                s = s + '</textarea>';
                viewzone.innerHTML = s;
            }

            xhr.open('post', 'bytecodeview');
            xhr.responseType = 'json';
            xhr.send(formData);
        }

        dropzone.ondrop = function(e) {
            e.preventDefault();
            this.className = 'dropzone';
            upload(e.dataTransfer.files);
        }

        dropzone.ondragover = function() {
            this.className = 'dropzone dragover';
            return false;
        }

        dropzone.ondragleave = function() {
            this.className = 'dropzone';
            return false;
        }

    }());
</script>
</body>
</html>