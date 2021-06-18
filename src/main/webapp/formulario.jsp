<%-- 
    Document   : formulario
    Created on : 2 jun. 2021, 11:09:04
    Author     : SergioCaballeroSáez
--%>

<%@page import="modelo.Cuota"%>
<%@page import="modelo.Prestamo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Banco Bosco</h1>
        <h2>Solicitud de Préstamos</h2>

        <%ArrayList<String> lista = (ArrayList) request.getAttribute("lista");%>
        <%ArrayList<Cuota> cuotas = new ArrayList();%>
        <%
            Prestamo tmp = (Prestamo) request.getAttribute("tmp");
            String nombre = (String) request.getAttribute("nombre");

            if (tmp == null) {
                nombre = "";
                tmp = new Prestamo();
                tmp.setCapital(0);
                tmp.setInteres(0);

            }
        %>

        <form action="servletBanco" method="post">
            Nombre: <input type="text" name="nombre" value="<%=nombre%>"><br>
            Capital que solicita: <input type="number" step="any" name="capital"  value="<%=tmp.getCapital()%>"><br>
            Interes: <input type="number" step="any" name="interes"  value="<%=tmp.getInteres()%>"><br>
            Tiempo <select name="tiempo">
                <% for (String t : lista) {
                        String seleccion = "";
                        if (t.equals(String.valueOf(tmp.getTiempo()))) {
                            seleccion = "selected";
                        }

                %>
                <option <%=t%> <%=seleccion%> value="<%=t%>"><%=t%></option>
                <%}%>
            </select>

            <input type="submit" value="Consultar">


        </form>
        <%if (tmp != null) {
        %><h1>Préstamo: <%=tmp.getImportePrestamo()%> €</h1>
        <% cuotas = (ArrayList<Cuota>) request.getAttribute("cuotas");
            }  %>



        <table class="table" style="border: 2px solid red;">

            <%if (cuotas != null) {%>
            <th>NºCuota</th>
            <th>Importe</th>
            <th>Capital</th>
            <th>Interes</th>
                <%
                        for (Cuota a : cuotas) {%>


            <tr>

                <td style="border: solid;"><%=a.getNumeroCuota()%></td>
                <td style="border: solid;"><%=a.getImporteCuota()%></td>
                <td style="border: solid;"><%=a.getCapital()%></td>
                <td style="border: solid;"><%=a.getIntereses()%></td>
            </tr>
            <%}
                }%> 


        </table>

    </body>
</html>
