<%-- 
    Document   : index
    Created on : 8 ene 2024, 9:29:40
    Author     : bernardomartinez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>ˆ
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="Stylesheet" href="styles/style.css">
    </head>
    <body>
        <div id="container">
        <h1>I like trains, hope you too</h1>
        <form action="SvIndex" method="POST">
            <p>En primer lugar tienes que elegir la locomotora</p>
            <label>Codigo de locomotora</label>
            <input type="number" name="codigoLocomotora"/>
            <label>Marca de la locomotora</label>
            <input type="text" name="marcaLocomotora"/>
            <label> Modelo de la locomotora</label>
            <input type="text" name="modeloLocomotora"/>
            <label>Tipo de combustible 'E' para electrico 'D' para Diesel</label>
            <input type="text" name="tipoCombustible"/>
            <label>Potencia de la Locomotora</label>
            <input type="number" name="potenciaLocomotora"/>
            <input type="submit" name="Enviar">
        </form>
        </div>
    </body>
</html>

