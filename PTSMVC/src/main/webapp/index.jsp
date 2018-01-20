<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css"><%@ include file="resources/css/login.css" %></style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="332631784105-tgmil8clq8fs27fh25i3hjncqq8ieqo6.apps.googleusercontent.com">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js" type="text/javascript"></script>
<title>Picture That</title>
</head>
<body>
	<div>
		<h1 id="header">Picture That</h1>
	</div>
	<div class="g-signin2" data-onsuccess="onSignIn"></div>
</body>

<script>
function onSignIn(googleUser) {
	var profile = googleUser.getBasicProfile();
	console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	console.log('Name: ' + profile.getName());
	console.log('Image URL: ' + profile.getImageUrl());
	console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
	var id_token = googleUser.getAuthResponse().id_token;
    console.log("ID Token: " + id_token);
	window.location = "PictureThat?token=" +id_token +"&name=" + profile.getName() + "&id=" + profile.getId();
}
</script>
</html>
