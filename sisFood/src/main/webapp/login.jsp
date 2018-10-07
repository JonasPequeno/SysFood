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
    <nav>
        <form method="POST" action="front" class="col s12">
        <div class="nav-wrapper #7b1fa2 purple darken-2">
          <a href="#" class="brand-logo" style="margin-left: 2%;">SysFood</a>
          <ul id="nav-mobile" class="right ">

          <div class="row">
            <div class="input-field col s4">
                    <input id="email" type="email" name="email" class="validate">
                    <label for="email" class="white-text">Email</label>
            </div>

            <div class="input-field col s4">
                <input id="senha" type="password" name="senha" class="validate">
                    <label for="senha" class="white-text">Senha</label>
            </div>

            <button class="btn waves-effect waves-light" type="submit" name="action">Entrar</button>
          </div>
          </ul>
        </div>
        <input type="hidden" name="command" value="Login">
        </form> 
    </nav>    
    
      	
  <div class="row">
    <form method="POST" action="front" enctype="multipart/form-data"  class="col s4" style="margin-left: 5%; margin-top: 5%;">
      <div class="row">

      	<div class="input-field col s12">
      		<input id="nome" name="nome" type="text" class="validate">
          	<label for="nome">Nome</label>
      	</div>
        <div class="input-field col s12">
            <input id="email" name="email" type="text" class="validate">
          	<label for="email">Email</label>
      	</div>
          
        <div class="input-field col s6">
                <input type="text" name="sexo" maxlength="1" required > 
                <label for="sexo">Sexo</label>
        </div>
            
        <div class="input-field col s6">                   
                <label for="foto" name="foto"></label>
                <input type="file" name="foto" required > 
        </div>
          
        <div class="input-field col s12">   
                <input type="text" name="descricao" required>
                <label for="nome">Descricao</label>
        </div>     
          
        <div class="input-field col s4">   
                  <input type="text" name="profissao" required>
                    <label for="profissao">Profissao</label>
        </div>            
        
        <div class="input-field col s4">   
                <input type="text" name="rua" required>
                <label for="rua">Rua</label>
        </div>
        
          
        <div class="input-field col s4">   
            <input type="text" name="estado" required>
            <label for="estado">Estado</label>
        </div>
        
        <div class="input-field col s4">   
            <input type="text" name="cidade" required>
            <label for="cidade">Cidade</label>
        </div>
        
        <div class="input-field col s4">   
            <input type="text" name="fone" required>
            <label for="fone">Fone</label>
        </div>
          
        <div class="input-field col s4">   
            <input type="text" name="cep" required>
            <label for="cep">Cep</label>
        </div>
          
        <div class="input-field col s12">   
            <input type="password" name="senha" required>
            <label for="senha">Senha</label>
        </div>
 
      	<button class="btn waves-effect waves-light" type="submit" name="action" style=" width: 200px; margin-left: 35%;">Cadastrar</button>

      </div>
         <input type="hidden" name="command" value="Cadastro">
    </form>    
  </div>
        
  </div>
      
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-rc.2/js/materialize.min.js"></script>
</body>
</html>
