<%-- 
    Document   : Configuracao
    Created on : 07/10/2018, 13:52:49
    Author     : Matheus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Configuração</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">


  <style type="text/css">

    .menu a {
      background-color: none; /* Grey background color */
      display: block; /* Make the links appear below each other */
      padding: 12px; /* Add some padding */
      text-decoration: none; /* Remove underline from links */
    }

    .menu a:hover {
      background-color: #bdbdbd; /* Dark grey background on mouse-over */
    }


  </style>

</head>
<body>


  <!--Barra de navegaão-->
  <nav>
    <div class="nav-wrapper #7b1fa2 purple darken-2">
      <a href="#" class="brand-logo" style="margin-left: 2%;">SysFood</a>
    </div>
  </nav>
   

 <div class="row">
  
      <!--Conteúdo meio da paágina-->
      <div class="col s8" style="margin-top: 2px;">
        
        <div class="row">
          <form method="POST" action="front" enctype="multipart/form-data" class="col s8" style= "margin-left: 45%; margin-top: 5%;">
            <h3>Configurações de Usuário</h3>
            <br>
            <div class="row">

                <div class="input-field col s12">
                    <input id="nome" value="${Usuario.nome}" name="nome" type="text" class="validate">
                    <label for="nome">Nome</label>
                </div>
          

                <div class="input-field col s6">
                        <input type="text" value="${Usuario.sexo}" name="sexo" maxlength="1" required > 
                        <label for="sexo">Sexo</label>
                </div>



                <div class="col s6 file-field input-field">
                        <div class="btn">
                          <span>Foto</span>
                          <input type="file" name="foto" required>
                        </div>
                        <div class="file-path-wrapper">
                          <input class="file-path validate" type="text">
                        </div>
                </div>

                <div class="input-field col s12">   
                        <input value="${Usuario.descricao}" type="text" name="descricao" required>
                        <label for="nome">Descricao</label>
                </div>     

                <div class="input-field col s4">   
                          <input value="${Usuario.profissao}" type="text" name="profissao" required>
                            <label for="profissao">Profissao</label>
                </div>            

                <div class="input-field col s4">   
                        <input value="${Usuario.rua}" type="text" name="rua" required>
                        <label for="rua">Rua</label>
                </div>


                <div class="input-field col s4">   
                    <input type="text" name="estado" value="${Usuario.estado}" required>
                    <label for="estado">Estado</label>
                </div>

                <div class="input-field col s4">   
                    <input type="text" name="cidade" value="${Usuario.cidade}" required>
                    <label for="cidade">Cidade</label>
                </div>

                <div class="input-field col s4">   
                    <input type="text" name="fone" value="${Usuario.fone}" required>
                    <label for="fone">Fone</label>
                </div>

                <div class="input-field col s4">   
                    <input type="text" name="cep" value="${Usuario.cep}" required>
                    <label for="cep">Cep</label>
                </div>

                <div class="input-field col s12">   
                    <input type="password" name="senha" required>
                    <label for="senha">Senha</label>
                </div>
                
                <div class="input-field col s12">   
                    <input type="password" name="confirmarSenha">
                    <label for="confirmarSenha">Confirmar Senha</label>
                </div>
 

              <button class="btn waves-effect waves-light col s4" type="submit" name="atualizar" style="margin-left: 5%;">Atualizar</button>
              <button class="btn waves-effect waves-light col s4" type="submit" name="excluir" style="margin-left: 20%;">Excluir Conta</button>

            </div>
            <input type="hidden" name="command" value="EditaUsuario">
          </form>
      </div>
            
    </div>


  </div>


       
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>       
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
  
</body>
</html>
