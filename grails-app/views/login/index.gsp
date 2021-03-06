<!doctype html>
<html>
    <head>
        <meta name="layout" content="initial"/>
        <title>Welcome to Grails</title>
</head>
    <body>
<div class="col-md-5">
  <h4>Match Dog!</h4>
<p>
Serviço que permite o encontro entre "pet lovers" e seus cachorros.
</p>
<p>
Os usuários realizam um cadastro e no formato "Tinder", os usuários vão "curtindo" os animais (e donos) que o sistema fornece aleatoreamente com base nos interesses cadastrados.
</p>
<p>
Caso dois usuários se "curtam", ocorreu o Match! e o sistema exibe os contatos do par para que eles combinem o encontro dos bichinhos ;)
</p>
<hr>
<p>
A aplicação Match Dog é um projeto da disciplina [MPI906-2015] de Engenharia de Software do Mestrado Profissional - UFPE
</p>
<p>
Equipe:
</p>
<ul>
  <li>Artur C. Alves /~aca5</li>
  <li>Plínio A. Garcia /~pag2</li>
  <li>Tiago Heineck /~th</li>
</ul>
  
</div>
          <div class="col-md-2"></div>
          <div class="col-md-5">
<form name="login" class="form-horizontal" action="/login/create">

<fieldset>
<legend>Entrar</legend>
<div class="form-group">
  <div class="col-md-10">
      <input id="input_email" required="required" name="email" type="email" placeholder="e-mail" class="form-control input-md">
  </div>
</div>

<div class="form-group">
  <div class="col-md-6">
    <input id="input_password" required="required" name="password" type="password" placeholder="senha" class="form-control input-md">
  </div>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success form-control">Login</button>
  </div>
</div>
<hr>
<div class="form-group">
  <div class="col-md-6">
    Você ainda não têm cadastro?
  </div>
  <div class="col-md-4">
    <a href="/cadastro" id="singlebutton" name="cadastro" class="btn btn-warning form-control">Cadastre-se</a>
  </div>
</div>
</fieldset>

<fieldset>
<legend>Ou, mais fácil</legend>
<div class="form-group">
  <div class="col-md-10">
    <center>
    <a href="/auth/facebook" id="singlebutton" disabled="disabled" name="singlebutton" class="btn btn-primary btn-lg">
      <i class="fa fa-facebook-official fa-fw"></i> Entrar com Facebook</a>
      </center>
  </div>
</div>

</fieldset>
</form>
          </div>

   </body>
</html>
