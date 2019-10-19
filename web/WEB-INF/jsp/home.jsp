<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Home</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
    <link rel="stylesheet" type="text/css"
          href="<%= request.getContextPath()%>/vendor/foundation-6.5.1/css/foundation.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css"/>
</head>
<body>
<div class="callout large primary">
    <div class="row column text-center">
        <h1>Calcul Mental</h1>
    </div>
</div>
    <div class="row column text-center">
        <h1>/-/</h1>
    </div>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Best Score</th>
        <th>Time</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${ sessionScope.user }" varStatus="status">
        <tr>
            <td>${user.login}</td>
            <td>${user.score}</td>
            <td>${user.time}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<form method="POST" action="home">
    <button class="button expanded">Start</button>
</form>

<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/jquery.js"></script>
<script src="<%= request.getContextPath()%>/vendor/foundation-6.5.1/js/vendor/foundation.min.js"></script>
<script>
    $(document).foundation();
    document.documentElement.setAttribute('data-useragent', navigator.userAgent);
    $(document).ready(function () {
        $("a.delete-link").on("click", function () {
            $("#form-id").attr("value", $(this).attr("data-id-to-del"));
            $("form#delete-form").submit();
        });
    });
</script>
</body>
</html>
