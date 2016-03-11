<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Syllabus Record</h3>
<form action= "/student_record/jsp/subjectregister.html" method="post">
Enter Academic Year
<input type="text" name ="year" id="n1" maxlength="20" required><br>
Enter Class(std.) 
<input type="text" name ="std" id="n1" maxlength="20" required><br>
Enter Division
<input type="text" name ="div" id="n1" maxlength="20" required><br>
Enter Student Roll No.
<input type="text" name ="rno" id="n1" maxlength="20" required><br>
Enter Student Name
<input type="text" name ="name" id="n1" maxlength="20" required><br><br>
Enter
<table>

<thead><tr> <th>Subject</th><th>Subject Marks</th><th>Scored Marks</th></tr></thead>
<tbody> 
<%
int i=0;
while(i<10){ %>
<tr> <td><input type="text" name ="subject" id="n1" maxlength="20" ></td>

<td><input type="text" name ="total" id="n1" maxlength="20" ></td>
<td><input type="text" name ="scored" id="n1" maxlength="20" ></td>
</tr>
<%i++;} %>
</tbody>

</table>
<input type="submit" value= "submit" ><br>
</form>

<% try{
	String msg= (String)request.getAttribute("message");
	if (msg!=null){
	%>
	<p  id="w1">${message}</p>
	<%
	}
	}catch(Exception e){}
	
	%>

</body>
</html>