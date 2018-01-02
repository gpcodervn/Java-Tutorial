<%@page import="java.util.List"%>
<%@page import="com.gpcoder.service.StudentService"%>
<%@page import="com.gpcoder.model.Student"%>

<html>
<title>Sample Maven Multi Module</title>
<body>
<h2>Sample Maven Multi Module</h2>
<%
	List<Student> students = StudentService.getStudents();
	
	for (Student student : students) {
		out.println(student);
	}
%>
</body>
</html>
