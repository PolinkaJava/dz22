<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <style>
        body {
            background-color: #FFC0CB;
            color: white;
            font-family: Arial, sans-serif;
        }

        .container {
            max-width: 400px;
            margin: auto;
        }

        img {
            width: 100px;
            display: block;
            margin: auto;
        }

        input[type=text], input[type=password] {
            width: calc(100% - 20px);
            padding: 10px;
            margin-bottom: 20px;
        }

        button {
            padding: 10px 20px;
            background-color:#d8363a;
            border:none;
            color:white;
            cursor:pointer
        }

        button:hover {background-color:#ee7724}

        .create-new {
            text-align:center;
            display:block;
            margin-top:10px;
            color:white
        }
    </style>
</head>
<body>

<div class="container">
    <img src="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.tslkmf3bU9SR6TvvLtvIJwHaJQ%26pid%3DApi&f=1&ipt=3666d40290f70de2819cced79defe6abbe57907afcd75426b822c5af634ab4d0&ipo=images" alt="logo">

<form action="login" method="post">
        Please login to your account<br><br>

        Username<br>
        <input type="text" name="username" placeholder=""><br>

        Password<br>
        <input type="password" name="password" placeholder=""><br><br>

        <button type="submit">LOG IN</button><br><br>

        Don't have an account? <button type="button" class="create-new">CREATE NEW</button>
    </form>

</div>

<script>
    document.querySelector('.create-new').addEventListener('click', function() {
        window.location.href = "C:\Users\user\Desktop\Maven\project2\src\main\resources\webapps\register.jsp";
    }
    );
</script>

</body>
</html>
