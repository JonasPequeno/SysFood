<%-- 
    Document   : home
    Created on : 31/08/2018, 22:45:07
    Author     : jonas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Home</title>
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
        
        <ul class="collection">
            <li class="collection-item avatar">
              <img src="data:image/jpg;base64,${param.fotoPerfil}" alt="" class="circle">
              <span class="title">${param.nome}</span>
              <p>${param.emailDes}<br>
                 ${param.descricao}
              </p>
              <div class="row">
              </div>
                 
            </li>        
         </ul>   
                 
        <div class="row">
                <form method="POST" action="front" class="col s12 ">
                  <div class="row">
                    <div class="input-field col s10 ">
                        <input id="msg" type="text" name="msg" class="validate">
                    </div>
                      <button type="submit" class="col s2 right" style="margin-top: 10px;"  name="action">Enviar</button>
                  </div>
                    <input name="emailDes" value="${param.emailDes}" type="hidden"/>
                  <input type="hidden" name="command" value="EnviaMensagem">
                </form>
            </div>    
        </div>                  

  <!--Fim da row2-->
  </div>


       
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>       
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>

</body>
</html>

