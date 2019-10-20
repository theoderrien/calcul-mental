<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Accueil</title>
    <link rel="stylesheet" type="text/css"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css"/>
    <link rel="stylesheet" type="text/css"
          href="<%= request.getContextPath()%>/vendor/foundation-6.5.1/css/foundation.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath()%>/css/style.css"/>
</head>
<html>
<head>
    <title>Calcul Mental</title>
</head>
<body>
<div class="callout large primary">
    <div class="row column text-center">
        <h1>Accueil</h1>
    </div>
</div>
<div class="row column text-center">
    <h1>Meilleurs joueurs</h1>
</div>
<div class="leaderboard">
    <table style="width: 40%;text-align-last: center;margin: auto">
        <thead>
        <tr>
            <th style="width: 20%">Rang</th>
            <th style="width: 40%">Nom</th>
            <th style="width: 40%">Meilleur score</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="leader" items="${ sessionScope.leaderboard }" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${leader.login}</td>
                <td>${leader.bestScore}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <form method="POST" action="home" style="text-align-last: center; margin-top: 30px">
        <button class="button" style="width: 30%">Start</button>
    </form>
</body>
</html>