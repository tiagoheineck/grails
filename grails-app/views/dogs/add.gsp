<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Welcome to Grails</title>
</head>
    <body>

<form name="cadastro" action="/dogs/create" method="post" enctype="multipart/form-data" class="form-horizontal">

<div class="col-md-5">


<span class="title-session glyphicon glyphicon-camera"></span><span class="title-session">Foto do Perfil</span>
<hr>

<output  id='fotoperfilinicial' style="display:block">
    <div class="thumbnail">
        <asset:image src="dog_default_image.png"/>
     </div>
</output>
<output  id='fotoperfilnova' style="display:none">
</output>

<span class="file-input btn btn-default btn-block btn-file">
                Procurar Foto&hellip; 
                <input type="file" data-initial-image="fotoperfilinicial" data-output-image="fotoperfilnova" name="foto" id="foto" class="form-control" accept="image/x-png, image/gif, image/jpeg">
</span>


<script>
  document.getElementById('foto').addEventListener('change', handleFileSelect, false);
  
</script>
</div>
<div class="col-md-2"></div>
<div class="col-md-5">


<span class="title-session glyphiconsPro glyphicon-dog">
     <span class="dog-icon-g"><asset:image src="dog-icon.png"/></span>
</span><span class="title-session">Seu dog</span>
<hr>
<div class="form-group">
  <div class="col-md-6">
     <input id="nome"  type="text" required="required" name="nome" class="form-control" placeholder="Nome">
  </div>
  <div class="col-md-6">
        <g:select name="raca"
          from="${racas}"
          class="form-control"
          optionKey="id" 
          optionValue="nome"
           />
  </div>
</div>
<div class="form-group">
    <div class="col-md-5">
    <select id="sexo" name="sexo" required="required" class="form-control">
        <option value="M">Macho</option>
        <option value="F">Fêmea</option>
    </select>
    </div>
    
    <div class="col-md-3">
        <label for="pedigree">
            <span style="display: inline;margin-right:5px;" class="glyphicon glyphicon-certificate"></span>Pedigree?</label>
    </div>
    <div class="col-md-4">
        <select id="pedigree" name="temPedigree" class="form-control">
            <option value="1">Sim</option>
            <option value="0">Não</option>
        </select>
    </div>
</div>
<div class="form-group">
<div class="col-md-2">
        <label for="cidade_id">Cidade:</label>
    </div>
    <div class="col-md-10">
        <g:select name="cidade"
          from="${cidades}"
          class="form-control"
          optionKey="id" 
          optionValue="nome"
           />
    </div>
</div>
<div class="form-group">
    
    
    <div class="col-md-3">
        <label for="passear">Quer Passear?</label>
    </div>
    <div class="col-md-3">
        <select id="passear" name="interessaPassear" class="form-control">
            <option value="1">Sim</option>
            <option value="0">Não</option>
        </select>
    </div>
    <div class="col-md-3">
        <label for="cruzar">Quer Cruzar?</label>
    </div>
    <div class="col-md-3">
        <select id="cruzar" name="interessaCruzar" class="form-control">
            <option value="1">Sim</option>
            <option value="0">Não</option>
        </select>
    </div>
</div>


<div class="form-group">
    <div class="col-md-12">
        <input type="submit" name="Salvar" class="btn btn-success btn-block" value="Salvar">
    </div>
</div>

</form>
</div>
