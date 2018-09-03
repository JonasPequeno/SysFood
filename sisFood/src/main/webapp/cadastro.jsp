<%-- 
    Document   : cadastro
    Created on : 01/09/2018, 21:25:31
    Author     : jonas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                
                <div class="input-field offset-s2 col s2">
                    <input type="text" name="sexo" maxlength="1" required > 
                    <label for="sexo">Sexo</label>
                </div>
                
                <div class="input-field  col s4">
                    <input type="file" name="foto" required > 
                    <label for="foto"></label>
                </div>
            </div>
            
            <div class="row">
                <div class="input-field offset-s2 col s8">   
                    <input type="text" name="nome" required>
                    <label for="nome">Nome</label>
                </div>
            </div>
            
            <div class="row">
                <div class="input-field offset-s2 col s8">   
                    <input type="text" name="profissao" required>
                    <label for="profissao">Profissao</label>
                </div>
            </div>
            
            <div class="row">
                <div class="input-field offset-s2 col s8">   
                    <input type="text" name="descricao" required>
                    <label for="descricao">Descricao</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field offset-s2 col s8">   
                    <input type="text" name="fone" required>
                    <label for="fone">Fone</label>
                </div>
            </div>
            
            <div class="row">
                <div class="input-field offset-s2 col s2">   
                    <input type="text" name="estado" required>
                    <label for="estado">Estado</label>
                </div>
                 <div class="input-field col s2">   
                    <input type="text" name="cidade" required>
                    <label for="cidade">Cidade</label>
                </div>
                 <div class="input-field col s2">   
                    <input type="text" name="rua" required>
                    <label for="rua">Rua</label>
                </div>
                <div class="input-field col s2">   
                    <input type="text" name="cep" required>
                    <label for="cep">Cep</label>
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
                <button class="btn col s6 offset-s3" type="submit" value="cadastra">Cadastre-se</button>
                <div class="row"></div>
            </div>
            <input type="hidden" name="command" value="Cadastro">
        </form>
    </div>   
          <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
    </body>
</html>
