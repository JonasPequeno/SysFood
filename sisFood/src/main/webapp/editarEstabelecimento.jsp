<%-- 
    Document   : cadastroEstabelecimento
    Created on : 12/10/2018, 15:36:58
    Author     : jonas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Editar de Estabelecimentos</title>
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
          <h3>Editar Estabelecimentos</h3>
        
          <div class="row">
            <form class="col s12" method="POST" action="front" enctype="multipart/form-data" style="margin-left: 5%; margin-top: 5%;">
              <div class="row">

                <div class="input-field col s6">
                    <input id="nome" type="text" name="nome" value="${param.nome}" class="validate" required>
                    <label for="nome">Nome</label>
                </div>

                <div class="input-field col s6">
                    <input id="endereco" type="text" name="cidade" value="${param.cidade}" class="validate" required>
                    <label for="endereco">Cidade</label>
                </div>
                  
                <div class="input-field col s6">
                  <input id="endereco" type="text" name="estado" value="${param.estado}" class="validate" required>
                    <label for="endereco">Estado</label>
                </div>
                  
                <div class="input-field col s6">
                    <input id="endereco" type="text" name="cep" value="${param.cep}" class="validate" required>
                    <label for="endereco">CEP</label>
                </div>
                  
                <div class="input-field col s6">
                  <input id="endereco" type="text" name="rua" value="${param.rua}" class="validate" required>
                    <label for="endereco">Rua</label>
                </div>
                  
                <div class="input-field col s6">
                  <input id="endereco" type="text" name="numero" value="${param.numero}" class="validate" required>
                    <label for="endereco">Numero</label>
                </div>

                <div class="input-field col s6">
                  <input id="descricao" type="text" name="descricao" value="${param.descricao}" class="validate" required>
                    <label for="descricao">Descrição</label>
                </div>



                <div class="input-field col s6">
                  <input id="telefone" type="text" name="telefone" value="${param.fone}" class="validate" required>
                    <label for="telefone">Telefone</label>
                </div>

                  
                <div class="col s6 file-field input-field">
                  <div class="btn">
                    <span>Imagem</span>
                    <input type="file" name="foto" required > 
                  </div>
                  <div class="file-path-wrapper">
                    <input class="file-path validate" type="text">
                  </div>
                </div>

               
                <div class="input-field col s6">
                  <input id="endereco" type="text" name="tipo" value="${param.tipo}" class="validate" required>
                    <label for="endereco">Tipo</label>
                </div>
                
                  <input name="id" value="${param.id}" type="hidden"/>

                <button class="col s4 btn waves-effect waves-light" type="submit" 
                name="action" style="margin-left: 30%; margin-top: 5%;">Editar</button>
                
                <input type="hidden" name="command" value="EditaEstabelecimento">

              </div>
            </form>
          </div>
            
      </div>


  </div>


       
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>       
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
  

</body>
</html>