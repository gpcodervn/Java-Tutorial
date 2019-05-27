<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleHelloWorldProxyid" scope="session" class="com.gpcoder.ws.HelloWorldProxy" />
<%
	if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleHelloWorldProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
	String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleHelloWorldProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp%>
<%
	}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
%>
        <%=tempResultreturnp3%>
        <%
        	}
        break;
        case 5:
                gotMethod = true;
                String endpoint_0id=  request.getParameter("endpoint8");
                    java.lang.String endpoint_0idTemp = null;
                if(!endpoint_0id.equals("")){
                 endpoint_0idTemp  = endpoint_0id;
                }
                sampleHelloWorldProxyid.setEndpoint(endpoint_0idTemp);
        break;
        case 10:
                gotMethod = true;
                com.gpcoder.ws.HelloWorld getHelloWorld10mtemp = sampleHelloWorldProxyid.getHelloWorld();
        if(getHelloWorld10mtemp == null){
        %>
<%=getHelloWorld10mtemp %>
<%
}else{
        if(getHelloWorld10mtemp!= null){
        String tempreturnp11 = getHelloWorld10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String name_1id=  request.getParameter("name16");
            java.lang.String name_1idTemp = null;
        if(!name_1id.equals("")){
         name_1idTemp  = name_1id;
        }
        java.lang.String sayHelloWorld13mtemp = sampleHelloWorldProxyid.sayHelloWorld(name_1idTemp);
if(sayHelloWorld13mtemp == null){
%>
<%=sayHelloWorld13mtemp %>
<%
}else{
        String tempResultreturnp14 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(sayHelloWorld13mtemp));
        %>
        <%= tempResultreturnp14 %>
        <%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>