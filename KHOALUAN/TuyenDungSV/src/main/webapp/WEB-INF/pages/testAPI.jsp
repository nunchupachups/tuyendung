<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<a href="http://ums-dev.husc.edu.vn/apigateway/account/v1/authorize/student">show</a>
	<script>
	function getData(){
		
		const myHeaders = new Headers();
		/*  myHeaders.append('Origin', 'http://localhost:8080');*/
		myHeaders.append('Content-Type', 'application/json');
		myHeaders.append('ums-application', 'TestApp');
		myHeaders.append('ums-time', '20220401230000');
		myHeaders.append('ums-signature', '1adcbf88065227d7c8cdbaf25be7aa00');
		
		
		let text = '{ "UserName":"18T1021326" , "Password":"b027a4ee25b6cfde014f2083563929fa" }';
		
		const myRequest = new Request('http://ums-dev.husc.edu.vn/apigateway/account/v1/authorize/student', {
		  method: 'POST',
		  headers: myHeaders,
		  body: JSON.parse(text),
		  mode: 'no-cors' 
		}); 

		fetch(myRequest)
		  .then(response => response.body)
		  .then(body => body.json())
		  .then(json => console.log(json));
		
		
};
		
</script>
</body>
</html>