<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
span.error {
	color: red;
	margin-left: 5px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('button[type= submit]').click(
				function(e) {
					e.preventDefault();
					$('input').next().remove();

					$.post({
						url : 'saveEmployee',
						data : $('form[name=employeeForm]').serialize(),
						success : function(res) {
							console.log(res)
							if (res.validated) {
								//Set response
								console.log("testing..........")
								$('#resultContainer pre code').text(
										JSON.stringify(res.employee));
								$('#resultContainer').show();

							} else {
								//Set error messages
								$.each(res.errorMessages, function(key, value) {
									$('input[name=' + key + ']').after(
											'<span class="error">' + value
													+ '</span>');
								});
							}
						}
					})
				});
	});
</script>
</head>
<body>
	<h1>Employee Form</h1>
	<hr />
	<form action="saveEmployee" method="post" name="employeeForm">
		<table>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><input type="text" name="designation"></td>
			</tr>
			<tr>
				<td></td>
				<td><button type="submit">Submit</button></td>
			</tr>
		</table>
	</form>
	<div id="resultContainer" style="display: none;">
		<hr />
		<h4 style="color: green;">JSON Response From Server</h4>
		<pre style="color: green;">
    <code></code>
   </pre>
	</div>
</body>
</html>