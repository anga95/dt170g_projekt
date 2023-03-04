<%@ page import="martin_test.deeper.web.KanonbasBean" %>
<%@ page import="martin_test.deeper.entities.Kanonbas" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
  KanonbasBean kanonbasBean = new KanonbasBean();
  List<Kanonbas> lista = kanonbasBean.getKanonbas();

%>

<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Radius</th>
    <th>Name</th>
  </tr>
  </thead>
  <tbody>
  <% for (Kanonbas kb : lista) { %>
  <tr>
    <td><%= kb.getId() %></td>
    <td><%= kb.getRadius() %></td>
    <td><%= kb.getName() %></td>
  </tr>
  <% } %>
  </tbody>
</table>



<%--<f:view>--%>
<%--  <h:outputLabel value="Hello, worlewrtd"/>--%>
<%--  <h:dataTable value="#{kanonbasBean.kanonbas}" var="row">--%>
<%--    <h:column>--%>
<%--      <f:facet name="id">ID</f:facet>--%>
<%--      #{row.id}--%>
<%--    </h:column>--%>
<%--    <h:column>--%>
<%--      <f:facet name="radius">radius</f:facet>--%>
<%--      #{row.radius}--%>
<%--    </h:column>--%>
<%--    <h:column>--%>
<%--      <f:facet name="name">Name</f:facet>--%>
<%--      <h:outputLabel value="#{row.name}">--%>
<%--        werasdf--%>
<%--      </h:outputLabel>--%>
<%--    </h:column>--%>
<%--  </h:dataTable>--%>
<%--  This example uses--%>
<%--</f:view>--%>

</body>
</html>
