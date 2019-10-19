<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
	<title>Connexion</title>
	<link rel="stylesheet" type="text/css"
		  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
	<link rel="stylesheet" type="text/css"
		  href="<%= request.getContextPath()%>/vendor/foundation-6.5.1/css/foundation.min.css"/>
	<link rel="stylesheet" href="<%= request.getContextPath()%>/css/style.css"/>
</head>
<body>
<div class="callout large primary">
	<div class="row column text-center">
		<h1>Connexion</h1>
	</div>
</div>
<div class="row small-5 small-centered">

	<c:if test="${ !empty loginModel.authentResult}">
		<div class="callout alert">
			<p>${loginModel.authentResult}</p>
		</div>
	</c:if>

	<form method="POST" action="login">
		<div class="form-icons">
			<div class="input-group">
						<span class="input-group-label">
							<i class="fa fa-user"></i>
						</span>
				<input class="input-group-field" type="text" placeholder="Login" name="form-login"
					   value="${loginModel.login}"/>
			</div>
			<div class="input-group">
						<span class="input-group-label">
							<i class="fa fa-key"></i>
						</span>
				<input class="input-group-field" type="password" placeholder="Password" name="form-pwd"
					   value=""/>
			</div>
		</div>
		<button class="button expanded">Connexion</button>
	</form>
	<button class="button expanded">Inscription</button>


</div>
<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/jquery.js"></script>
<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/foundation.min.js"></script>
<script>
	$(document).foundation();
	document.documentElement.setAttribute('data-useragent', navigator.userAgent);
</script>
</body>
</html>