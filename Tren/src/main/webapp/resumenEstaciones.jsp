<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="Modelo.Estacion" %>
<%@ page import="Modelo.Tren" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estación</title>
        <link rel="stylesheet" href="styles/estiloResumenes.css">
    </head>
    <body>
        <div id="container">
            <%
                List<Estacion> listaEstaciones = (List<Estacion>) session.getAttribute("listaEstaciones");
                if (listaEstaciones != null) {
                    for (Estacion estacion : listaEstaciones) {
            %>
            <h2>Estación: <%= estacion.getNombre() %></h2>
            <h3>Ciudad: <%= estacion.getCiudad() %></h3>
            <h4>Trenes:</h4>
            <ul>
                <%
                    for (Tren tren : estacion.getTrenes()) {
                %>
                <li>Tren: <%= tren.getLocomotora().getCodigo() %> - Hora de salida: <%= tren.getHoraSalida() %> - Destino: <%= tren.getDestino() %></li>
                <%
                    }
                %>
            </ul>
            <%
                    }
                } else {
            %>
            <p>No se encontraron estaciones</p>
            <%
                }
            %>
        </div>
    </body>
</html>