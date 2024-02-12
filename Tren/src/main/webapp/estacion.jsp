 <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Modelo.*" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="Stylesheet" href="styles/style.css">
        <script src="js/scriptResumen.js"></script>
    </head>
    <body>
        <div id="container">
            <h1>Creacion de estación</h1>
            <%
    List<Tren> trenes = (List<Tren>) session.getAttribute("trenLista");
    if(trenes!=null){
        List<String> destinosDisponibles = Tren.obtenerDestinos(trenes);
%>
        <form action="SvEstacion" method="POST">
                <label> Nombre de la estación: </label>
                <input type="text" name="nombreEstacion"/>
                <label> Ciudad donde se encuentra: </label>
                <input type="text" name="nombreCiudad"/>
                <label for="listaTrenes"> Trenes que quieres agregar: </label>

                <% for (String destino : destinosDisponibles) { %>
                <fieldset>
                    <p><%= destino %></p>
                    <% for (Tren tren : trenes) {
                        if (tren.getDestino().equals(destino)) { %>
                    <label>
                        <input type="checkbox" name="trenesSeleccionados" value="<%= tren.getLocomotora().getCodigo() %>">
                        Tren con dirección a <%= destino %> con hora de salida <%= tren.getHoraSalida() %> y con hora de llegada <%= tren.getHoraLlegada() %>
                    </label>
                    
                    <br>
                    <% }
                    } %>
                </fieldset>
                <% } %>

                <button type="submit">Crear Estación</button>
            </form>
                <%}else{
%>
<div id="mensajeError"><p>No hay trenes disponibles. Cree trenes antes de crear una estación.</p></div>
            <%}%>


            <button id="volver">Volver al menú.</button>

        </div>
    </body>
</html>
