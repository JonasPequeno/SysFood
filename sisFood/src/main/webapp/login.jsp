<%-- 
    Document   : login
    Created on : 23/08/2018, 00:11:11
    Author     : jonas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>login</title>
</head>
<body>
    <div class="row">        
        <h1 class="center">SysFood</h1>
    </div>
    <div class="row">
        <form method="POST" action="front" class="col s12">
            <div class="row">
                <div class="input-field offset-s2 col s8">
                    <input type="email" name="email" required > 
                    <label for="email">Email</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field offset-s2 col s8">   
                    <input type="password" name="senha" required>
                    <label for="senha">Senha</label>
                </div>
            </div>
            <div class="row"></div>
            <div class="row">
                <a class="btn col s6 offset-s3" type="submit" value="entrar">Acessar</a>
                <div class="row"></div>
                <a class="col s4 offset-s2" herf="">Criar conta de acesso!</a>
            </div>
            <input type="hidden" name="Login" value="Login">
        </form>
    </div>    
    
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
</body>
</html>
