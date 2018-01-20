<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<%@ include file="../../resources/css/picturethat.css" %>
</style>
<meta name="google-signin-client_id" content="332631784105-tgmil8clq8fs27fh25i3hjncqq8ieqo6.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js?onload=onLoad" async defer></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Picture That</title>
</head>
<body>
	<div>
		<h3 id="logout">
			<a href="#" onclick="signOut();">Sign out</a>
		</h3>
	</div>
	<h1 id="header">Picture That</h1>
	<h2 id="username"></h2>
	<div id="image">Insert images here!!!</div>
</body>

<script>
function signOut() {
	gapi.auth2.init();
	var auth2 = gapi.auth2.getAuthInstance();
	auth2.signOut().then(function () {
	console.log('User signed out.');
	window.location = "logout";
 	});
}

function onLoad() {
    gapi.load('auth2', function() {
      gapi.auth2.init();
    });
    //var profile = googleUser.getBasicProfile();
    gapi.load('plus','v1', function(){
    	alert("bronagh");
 		var request = gapi.client.plus.people.get({
   			'userId': 'me'
 		});
 		request.execute(function(resp) {
   		console.log('Retrieved profile for:' + resp.displayName);
 		});
	});
    $("username").append("Bronagh Deane");
}
</script>
</html>