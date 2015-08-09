<!doctype html>
<html>
    <head>
        <meta name="layout" content="initial"/>
        <title>Welcome to Grails</title>
</head>
    <body>

<form name="cadastro" action="/cadastro/update" method="post" multipart="true" class="form-horizontal">

<div class="row">

<div class="col-md-5">

<span class="title-session glyphicon glyphicon-camera"></span><span class="title-session">Foto do Perfil</span>
<hr>

<output  id='fotoperfilinicial' style="display:block">
    <div class="thumbnail">
          <g:if test="${ dono.foto != null}">
            <img src="/images/${dono.foto.url}">  
          </g:if>
          <g:else>
            <asset:image src="dono_default_image.png"/>
          </g:else>
     </div>
</output>
<output  id='fotoperfilnova' style="display:none">
</output>

<span class="file-input btn btn-default btn-block btn-file">
                Procurar Foto&hellip; 
                <input type="file" data-initial-image="fotoperfilinicial" data-output-image="fotoperfilnova" name="foto" id="foto" class="form-control" accept="image/x-png, image/gif, image/jpeg">
</span>

</div>
          <div class="col-md-2"></div>
          <div class="col-md-5">

<span class="title-session glyphicon glyphicon-edit"></span><span class="title-session">Seus dados</span>
<hr>
<div class="form-group">
  <div class="col-sm-2">
    <label for="nome">Nome: </label>
  </div>
  <div class="col-sm-10">
      <input type="text" id="nome" name="nome" placeholder="Seu nome" class="form-control" value="${dono.nome}">
  </div>
</div>
<div class="form-group">
  <div class="col-sm-2">
    <label for="email">E-mail: </label>
  </div>
  <div class="col-sm-10">
      <input type="email" id="email" name="email" placeholder="E-mail" class="form-control" value="${dono.email}">
  </div>
</div>
<div class="form-group">
  <div class="col-sm-2">
    <label for="sexo">Sexo: </label>
  </div>
  <div class="col-sm-10">
    <select id="sexo" name="sexo" class="form-control">
        <option value="M" <g:if test="${{dono.sexo} == 'M'}"> selected="selected" </g:if> >Masculino</option>
        <option value="F" <g:if test="${{dono.sexo} == 'F'}"> selected="selected" </g:if> >Feminino</option>
    </select>
  </div>
</div>

<div class="form-group">
    <input type="submit" class="btn btn-success btn-block form-control" value="Salvar">
</div>


</div>


</div>

</form>

<div class='row'>
    
<div class="col=md-12">
    <br>
    <br>

    <span class="title-session glyphicon glyphicon-picture"></span><span class="title-session">Álbum de fotos</span>
    <hr>
    <br>
    <br>
    <div class='row'>
        <div class='col-md-12' id='novaFoto'>
            
            <div class="thumbnail clearfix">
            
            <form name="fotos" action="/fotos" method="post" multipart="true" class="dropzone form" id="media-dropzone">

              <div class="fallback">
                <input type="file" name="media" multiple="true" />
              </div>
            </form>
            
            </div>
            
        </div>
    </div>
        
    <div id='album' class="row"></div>

</div>
</div> 



<div class="modal fade" id="deleteFotoModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header panel-heading">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title">Você tem certeza disso ?</h4>
        </div>
        <div class="modal-body">
          Você tem certeza que <b>deseja remover essa foto?</b>
        </div>
        <div class="modal-footer">
            <form id="form_excluir_foto" class="button_to" method="post" action="">
              <input type="hidden" name="_method" value="delete">
              <button type="button" class="btn btn-default" data-dismiss="modal">Não! Não quero remover.</button>
              <input class="btn btn-primary" type="submit" value="Sim! Quero remover!">
              <input type="hidden" name="authenticity_token" value="<%= form_authenticity_token %>">
              </form>
          
        </div>
      </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script>
    $('#deleteFotoModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget) // Button that triggered the modal
        var id = button.data('id')
        
        var modal = $(this)
        modal.find('#form_excluir_foto').attr("action", "/fotos/"+String(id))
        
        modal.find('#form_excluir_foto').submit(function(){
            $.post(
                $(this).attr('action'), 
                $(this).serialize(), 
                function(json) {
                    modal.find('.close').click();
                    button.parents('.fotoBox').remove();
                     $('.same-height').responsiveEqualHeightGrid();
                }, 'json');
            return false;
        })
      
    });
    
    function adicionarFotoNoAlbum(foto) {
            $.tmpl("templates/foto", foto).appendTo("#album");
    }
    
  $(function() {
        
        document.getElementById('foto').addEventListener('change', handleFileSelect, false);
        
        
        <g:each in="${dono.fotos}">
            adicionarFotoNoAlbum(
                {
                    url: '/images/${it.url}',  
                    descricao: '${it.descricao}', 
                    id: '${it.title}'
                }
            );
        </g:each>
        
        $('.same-height').responsiveEqualHeightGrid();
    
        var mediaDropzone = new Dropzone("#media-dropzone", {
            dictDefaultMessage:"<center>"
              +"<br>"
              +"<br>"
              +"<icon class='fa fa-image fa-4x fa-fw'></icon>"
              +"<br>"
              +"Arraste novas fotos para cá"
              +"<br>"
              +"<br>"
              +"</center>"});
                
        mediaDropzone.on('sending', function(data, xhr, formData){
            formData.append('classe', 'dono');
            formData.append('id', ${dono.id});
        });
        
        mediaDropzone.on("success", function(file, responseText) {
            var foto =  {
                url: '/images/'+responseText.url,  
                descricao: responseText.descricao, 
                id: responseText.id
            };
            adicionarFotoNoAlbum(foto);
            var _this = this;
                setTimeout(function(){
                  _this.removeAllFiles();
                },1000);
        
            $('.same-height').responsiveEqualHeightGrid();	
      
        });
      
    });
  
</script>



