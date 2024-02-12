<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="Modelo.*" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="styles/resumen.css">
    <script src="js/scriptResumen.js"></script>
</head>
<body>
    <div id="container">
        <h1>Datos de los Trenes</h1>

        <% 
            List<Tren> trenes = (List<Tren>) session.getAttribute("trenLista");

            if (trenes != null && !trenes.isEmpty()) {
        %>
            <table>
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Marca</th>
                        <th>Modelo</th>
                        <th>Tipo de Locomotora</th>
                        <th>Destino</th>
                        <th>Potencia</th>
                        <th>Hora de Salida</th>
                        <th>Hora de Llegada</th>
                        <th>Número de Vía</th>
                        <th>Vagones</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Tren tren : trenes) { %>
                        <tr>
                            <td><%= tren.getLocomotora().getCodigo() %></td>
                            <td><%= tren.getLocomotora().getMarca() %></td>
                            <td><%= tren.getLocomotora().getModelo() %></td>
                            <td><%= tren.getLocomotora().getTipo() %></td>
                            <td><%= tren.getDestino() %></td>
                            <td><%= tren.getLocomotora().getPotencia() %></td>
                            <td><%= tren.getHoraSalida() %></td>
                            <td><%= tren.getHoraLlegada() %></td>
                            <td><%= tren.getNumeroVia() %></td>
                            <td>
                                <ul>
                                    <% for (Vagon vagon : tren.getVagones()) { %>
                                        <li>
                                            <%= vagon instanceof VagonPasajeros ? "Vagon de Pasajeros" : "Vagon de Mercancías" %>
                                            - Código: <%= vagon.getCodigo() %>
                                            - Marca: <%= vagon.getMarca() %>
                                            - Modelo: <%= vagon.getModelo() %>
                                            <% if (vagon instanceof VagonPasajeros) { %>
                                                - Número de Asientos: <%= ((VagonPasajeros) vagon).getNumeroAsientos() %>
                                            <% } else if (vagon instanceof VagonMercancias) { %>
                                                - Capacidad de Carga: <%= ((VagonMercancias) vagon).getCapacidadCarga() %> toneladas
                                            <% } %>
                                        </li>
                                    <% } %>
                                </ul>
                            </td>
                        </tr>
                    <% } %>
                </tbody>
            </table>
        <%
            } else {
        %>
            <p>No hay trenes disponibles en la sesión.</p>
        <%
            }
        %>

        <button id="volver">Volver al menú.</button>
    </div>
</body>
</html>
