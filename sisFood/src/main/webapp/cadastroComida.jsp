<%-- 
    Document   : cadastroComida
    Created on : 14/10/2018, 17:37:52
    Author     : Matheus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Cadastro de Comidas</title>
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
      <a href="front?command=Home" class="brand-logo" style="margin-left: 2%;">SysFood</a>
    </div>
  </nav>
   

<div class="row">
    
      <!--Perfil e Menu-->
      <div class="col s4">
        
        <div class="row">
          <div class="col s8">
            <div class="card">
              <div class="card-image">
                <img src="data:image/jpg;base64,${Usuario.fotoPerfil}">
                <span class="card-title">${Usuario.nome}</span>
              </div>

              <div class="card-content #f3e5f5 purple lighten-5 center">
                <a href="#"><i class="material-icons">settings</i></a>
                <br>
                <p>${Usuario.profissao}</p>
                <p>Mora em ${Usuario.cidade}, ${Usuario.estado}</p>                
              </div>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col s8">
            <div class="menu #f3e5f5 purple lighten-5 center">
              
                <a class="waves-effect black-text " href="front?command=Amigo">Amigos</a>
                <a class="waves-effect black-text " href="front?command=Amizades">Novos Amigos</a>
                <a class="waves-effect black-text " href="#">Mesagens</a>
                <a class="waves-effect black-text " href="front?command=MinhasComidas">Minhas Comidas</a>
                <a class="waves-effect black-text " href="front?command=Estabelecimento">Meus Estabelecimentos</a>
                <a class="waves-effect black-text " href="front?command=Sair" >Sair</a>
                
            </div>
          </div> 
        </div>

      <!--fim Perfil e Menu-->
      </div>


      


      <!--Conteúdo meio da paágina-->
      <div class="col s8 pull-s1" style="margin-top: 2px;">
          
          <div class="row">
            <form method="POST" action="front" class="col s12" style="margin-left: 5%; margin-top: 5%;">
              <h3>Cadastrar Comidas</h3>
              <br>
              <div class="row">

                <div class="input-field col s12">
                  <input id="nome" type="text" name="nome" class="validate" required>
                    <label for="nome">Nome</label>
                </div>

                <div class="input-field col s12">
                    <input id="descricao" type="text" name="descricao" class="validate" required>
                    <label for="descricao">Descrição</label>
                </div>
                  
                <div class="input-field col s12">
                  <input id="preco" type="text" name="preco" class="validate" required>
                    <label for="preco">Preço</label>
                </div>
               
                <button class="col s4 btn waves-effect waves-light" type="submit" name="action" style="margin-left: 30%; margin-top: 5%;">Cadastrar</button>

              </div>
              <input type="hidden" name="command" value="CadastroComida">
            </form>
          </div>
            
      </div>


  </div>


       
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>       
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
  

</body>
</html>
