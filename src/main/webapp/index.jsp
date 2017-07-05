<%@ page import="java.util.List" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<form method="post" action="MagicPacketServlet">
    <input type="hidden" name="actionPassword" value="createMagicPacketPassword">
    <input type="submit" name="actionCode" value="Create Magic Packet">
    <input type="submit" name="actionCode" value="Delete Magic Packet">
</form>

<jsp:useBean id="wakeOnLanBean" class="ru.tesoft.calculator.WakeOnLanBean" scope="application"/>

<h2>Is there a magic packet: <%= wakeOnLanBean.isMagicPacket()%></h2>
<br>
<br>
History of checking for magic packet:
<br>
<%
    List<String> history = wakeOnLanBean.getHistory();
    for (String record : history) {
%>
<%= record %><br>
<%
    }
%>


</body>
</html>
