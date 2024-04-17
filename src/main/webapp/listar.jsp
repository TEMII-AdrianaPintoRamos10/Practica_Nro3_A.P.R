<%-- 
    Document   : listar
    Author     : Ramos
--%>
<%@page import="com.emergentes.modelo.Persona"%>
<%@page import="java.util.Date"%>
<%@ page import="java.util.Arrays" %>
<%
    Persona item = (Persona) request.getAttribute("nuevapersona");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Editar</title>
    <style>
        .tabla {
            border: 1px solid black;
            border-collapse: collapse;
            margin-right: 30px; 
            float: left;
        }
        input[type="submit"]:hover {
            background-color: #ff0000;
        }
    </style>
</head>
<body><i>
<h1 style="text-align: center"><%= (item.getId() == 0) ? "Registro en Seminarios" : "Editar"%></h1>
<form action="MainServlet" method="post">
    <input type="hidden" name="id" value="<%= (item != null) ? item.getId() : "" %>"/>
    <table class="tabla">
        <tr>
            <td>
                <fieldset>
                    <legend>Datos</legend>
                    <table>
                        <tr>
                            <td>Fecha:</td>
                            <td><input type="datetime-local" name="fecha" value="<%= (item != null && item.getFecha() != null) ? item.getFecha() : ""%>"/></td>
                        </tr>
                        <tr>
                            <td>Nombre</td>
                            <td><input type="text" name="nombre"  value="<%= (item != null && item.getNombre() != null) ? item.getNombre() : ""%>"/></td>
                        </tr>
                        <tr>
                            <td>Apellido</td>
                            <td><input type="text" name="apellidos"  value="<%= (item != null && item.getApellidos() != null) ? item.getApellidos() : ""%>"/></td>
                        </tr>
                        <tr>
                            <td>Turno:</td>
                            <td>
                                <input type="radio" id="manana" name="turno" value="Mañana" <%= (item != null && item.getTurno() != null && item.getTurno().equals("Mañana")) ? "checked" : ""%>>
                                <label for="manana">Mañana</label>
                                <input type="radio" id="tarde" name="turno" value="Tarde" <%= (item != null && item.getTurno() != null && item.getTurno().equals("Tarde")) ? "checked" : ""%>>
                                <label for="tarde">Tarde</label>
                                <input type="radio" id="noche" name="turno" value="Noche" <%= (item != null && item.getTurno() != null && item.getTurno().equals("Noche")) ? "checked" : ""%>>
                                <label for="noche">Noche</label>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
    </table>
    <table class="tabla"><br>
        <tr>
            <td>
                <fieldset>
                    <legend>Seminarios Disponibles</legend>
                    <table>
                        <tr>
                            <td>
                                <input type="checkbox" id="ia" name="seminarios" value="Inteligencia Artificial" <%= (item != null && item.getSeminarios() != null && Arrays.asList(item.getSeminarios()).contains("Inteligencia Artificial")) ? "checked" : ""%>>
                                <label for="ia">Inteligencia Artificial</label><br>
                                <input type="checkbox" id="maquina" name="seminarios" value="Machine learning" <%= (item != null && item.getSeminarios() != null && Arrays.asList(item.getSeminarios()).contains("Machine learning")) ? "checked" : ""%>>
                                <label for="maquina">Machine learning</label><br>
                                <input type="checkbox" id="simulacion" name="seminarios" value="Simulacion con arena" <%= (item != null && item.getSeminarios() != null && Arrays.asList(item.getSeminarios()).contains("Simulacion con arena")) ? "checked" : ""%>>
                                <label for="simulacion">Simulacion con arena</label><br>
                                <input type="checkbox" id="robotica" name="seminarios" value="Robotica Educativa" <%= (item != null && item.getSeminarios() != null && Arrays.asList(item.getSeminarios()).contains("Robotica Educativa")) ? "checked" : ""%>>
                                <label for="robotica">Robotica Educativa</label><br>
                            </td>
                        </tr>
                    </table>
                </fieldset>
            </td>
        </tr>
    </table><br>
        <div style="text-align: center;">
        <input type="submit" value="Enviar registro">
    </div>
</form>
</i></body>
</html>