<!doctype html>
<html>
    <head>
        <meta name="layout" content="main"/>
        <title>Welcome to Grails</title>
</head>
    <body>
<div class="row">
    <span class="title-session glyphiconsPro glyphicon-dog">
       <span class="dog-icon-g"><asset:image src="dog-icon.png"/></span>
        </span><span class="title-session">Meus Dogs</span>
    <a class="btn btn-info" href="/dogs/new"><span class="glyphicon glyphicon-plus"></span>Novo Dog</a>
  </div>
<hr>
<div class="row">
    <div>
    <g:each in="${dogs}">
    
  <div class="col-sm-6 col-md-4 same-height">
    <div class="thumbnail">
      <a href="/dogs/${it.id}">
          <g:if test="${ it.foto != null}">
            <img src="/${it.foto.url}">  
          </g:if>
          <g:else>
            <asset:image src="dog_default_image.png"/>
          </g:else>
      </a>
      <div class="caption">
        <h3>${it.nome}</h3>
        <div>
                  <span class="glyphicon glyphicon-fire"></span> ${it.get_count_matches()} Matches
                  &nbsp;
                  <span class="glyphicon glyphicon-comment"></span> ${it.get_count_latidas()} Latidas
        </div>
        <ul class="list-group">
          <li class="list-group-item list-group-item-success">
              ${ it.raca.nome}
              <g:if test="${ it.sexo == 'F'}">
               | Fêmea
              </g:if>
              <g:else>
               | Macho
              </g:else>
              <g:if test="${ it.temPedigree }">
                com Pedigree
              </g:if>
          </li>
          <li class="list-group-item">${ it.cidade.nome } - ${ it.cidade.estado }</li>
          <li class="list-group-item list-group-item-warning">
              Interessa 
                  <g:if test="${ it.interessaPassear}">
                      Passear
                  </g:if>
                  <g:if test="${ it.interessaPassear && it.interessaCruzar}">
                      e
                  </g:if>
                  <g:if test="${ it.interessaCruzar}">
                      Cruzar
                  </g:if>
        </ul>
        <p>
            <a href="/dogs/${ it.id}" class="btn btn-primary" role="button">Encontrar um par</a>
            <a href="/dogs/${ it.id}/edit" class="btn btn-warning" role="button">Editar</a>
            <button data-toggle="modal" data-target="#deleteDogModal" data-id="${ it.id}" data-nome="${ it.nome}" class="btn btn-danger" role="button">Excluir</button>
        </p>
      </div>
    </div>
  </div>
  
   </g:each>
  </div>
</div>

<div class="modal fade" id="deleteDogModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header panel-heading">
          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
          <h4 class="modal-title">Você tem certeza disso ?</h4>
        </div>
        <div class="modal-body">
          Você tem certeza que <b>deseja remover <span id="nome"></span>?</b>
        </div>
        <div class="modal-footer">
            <form id="form_excluir_dog" class="button_to" method="post" action="">
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
    $('#deleteDogModal').on('show.bs.modal', function (event) {
      var button = $(event.relatedTarget) // Button that triggered the modal
      var dog_id = button.data('id')
      var dog_nome = button.data('nome')
      
      var modal = $(this)
      modal.find('#nome').text(dog_nome)
      modal.find('#form_excluir_dog').attr("action", "/dogs/"+String(dog_id))
    })
    
    $( document ).ready(function() {
      	$('.same-height').responsiveEqualHeightGrid();	
    });

  </script>

   </body>
</html>

   </body>
</html>
