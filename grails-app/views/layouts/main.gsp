<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><g:layoutTitle default="MatchDog - Grails"/></title>
    <meta name="description" content="">
    <meta name="author" content="">
        <asset:javascript src="application.js"/>
        
        <!-- Bootstrap -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

        <!-- Owl Carousel -->
        <link rel="https://cdnjs.cloudflare.com/ajax/libs/owl-carousel/1.3.3/owl.carousel.min.css">
        <link rel="https://cdnjs.cloudflare.com/ajax/libs/owl-carousel/1.3.3/owl.theme.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/owl-carousel/1.3.3/owl.carousel.min.js"></script>


        <!-- FancyBox 2 -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
        <link rel="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css">
        <!--
        <link rel="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/helpers/jquery.fancybox-buttons.css"  />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/helpers/jquery.fancybox-buttons.js"></script>
        -->

        <asset:stylesheet src="application.css"/>



    <g:layoutHead/>
  </head>
  <body>
    <header class="navbar">
      <nav class="navbar-inner">
        <div class="container container-logo-application">
          <div class="row-fluid">
            <div class="col-sm-8"></div>
            <div class="col-sm-4">
              <div class="contadores">
                <div id="conta_match">
                  &nbsp;
                  <g:if test="${current_dog != null && !current_dog.isEmpty()}">
                    <a href="/matches/" title="Matches"> 
                        <span class="glyphicon glyphicon-fire"></span> 
                        ${contador_matches} Matches
                    </a>
                  </g:if>
                </div>
                <div id="conta_chat">
                  &nbsp;
                <g:if test="${current_dog != null && !current_dog.isEmpty()}">
                    <a href="/matches/" title="Bate-papo"> 
                        <span class="glyphicon glyphicon-comment"></span>
                        ${contador_latidas} Latidas
                    </a>
                </g:if>
                </div>
                <div class="profile logout">
                  <a href="/logout">
                    <span class="glyphicon glyphicon-off"></span> Sair
                  </a>
                </div>
              </div>
            </div>
          </div>
          <div class="row-fluid">
            <div class="col-sm-2 col-padding-reduce">
              <span> <asset:image src="icon_matchDog100.png"/> </span>
            </div>
            <div class="col-sm-8 busca">
            <!-- aqui era variável de instância  @current_dog -->
              <g:if test="${current_dog != null && !current_dog.isEmpty()}">
                <g:form name="" class="form-horizontal" action="farejar">
                  <div class="form-group">
                    <div class="col-sm-1 col-padding-reduce">
                      <span>Procuro </span>
                      <select id="sexo" name="faro[sexo_dono]" class="form-control">
                          <option value="M"
                            <g:if test="${current_faro.sexo_dono == 'M'}">  'selected="selected"'</g:if>
                          >Homem</option>
                          <option value="F"
                           <g:if test="${current_faro.sexo_dono == 'F'}">  'selected="selected"'</g:if>
                           >Mulher</option>
                      </select>
                    </div>

                    <div class="col-sm-3 col-padding-reduce">
                      <span> dono(a) de </span>
                        <g:select id="faro_raca_id" class="form-control" name='faro[raca_id]' value="${current_faro?.raca_id}"
                            noSelection="${['null':'Selecione']}"
                            from='${get_racas}'
                            optionKey="id" optionValue="nome"></g:select>

                    </div>
                    <div class="col-sm-1 col-padding-reduce">
                      <span>que seja</span>
                      <select id="sexoDog" name="faro[sexo_dog]" class="form-control">
                          <option value="M" <g:if test="${current_faro.sexo_dog == 'M'}">  'selected="selected"'</g:if>
                            >Macho</option>
                          <option value="F" <g:if test="${current_faro.sexo_dog == 'F'}">  'selected="selected"'</g:if>
                          >Fêmea</option>
                      </select>
                    </div>
                    
                    <div class="col-sm-3 col-padding-reduce">
                      <span>para </span>
                      <br>
                      <span>
                            <input type="checkbox" name="faro[interessa_cruzar]" id="faro_interessa_cruzar" 
                                value="1" <g:if test="${current_faro.interessa_cruzar == '1'}">  'checked="checked"'</g:if>
                                >
                      </span>
                      <span>cruzar </span>
                      <br>
                      <input type="checkbox" name="faro[interessa_passear]" id="faro_interessa_passear" 
                                value="1" <g:if test="${current_faro.interessa_passear == '1'}">  'checked="checked"'</g:if>>

                       <span>passear </span>
                    </div>
                    <div class="col-sm-3 col-padding-reduce">
                       <span>na cidade</span>

                        <g:select id="faro_cidade_id" class="form-control" name='faro[cidade_id]' value="${current_faro?.cidade_id}"
                        noSelection="${['null':'Selecione']}"
                        from='${get_cidades}'
                        optionKey="id" optionValue="nome"></g:select>


                    </div>
                    <div class="col-sm-2 col-padding-reduce">
                        <button type="submit" id="farejar_bt" name="farejar" class="btn btn-danger btn-block" value="">
                        <span class="glyphicon glyphicon-fire"></span> Farejar
                        </button>
                    </div>
                  </div>
                  </g:form>
              </g:if>
            </div>
            <div class="col-md-2 nav profile-avatares">
              <g:if test="${current_user != null && !current_user.isEmpty()}">
              <div id="profile-dono" class="profile">
                <a href="/cadastro/edit" title="<%= current_user.nome %>">
                  <g:if test="${current_user.foto != null}">
                    <img src="/images/${current_user.foto.url}"> 
                  </g:if>
                  <g:else>  
                    <asset:image src="dono_default_image.png"/>
                  </g:else>    
                  <span class="glyphicon glyphicon-user"></span>Perfil
                </a>
              </div>
              </g:if>
              
              <g:if test="${current_dog != null && !current_dog.isEmpty()}">
              <div id="profile-dog"  class="profile">
                
                <a href="/dogs" title="<%= current_dog.nome %>">
                  <g:if test="${current_dog.foto != null}">
                    <img src="/images/${current_dog.foto.url}"> 
                  </g:if>
                  <g:else>  
                    <asset:image src="dog_default_image.png"/>
                  </g:else>    
                  <span class="dog-icon-p"><asset:image src="dog-icon.png"/></span>Dogs
                </a>
              </div>
              </g:if>
              <g:else>  
              <div id="profile-dog"  class="profile">
                <a href="/dogs" title="Escolha um Dog!">
                <span class="dog-icon-p"><asset:image src="dog-icon.png"/></span>Escolha um Dog!
                </a>
              </div>
              </g:else> 
            </div>

        </div>
      </nav>
    </header>
    
    <div id="main" role="main">
      <div class="container">
        <div class="content">
           
            <g:layoutBody/>
            
          </div>
      </div>
      <!-- end of .container -->
    </div> 
    <!-- end of #main -->
    
  </body>
</html>

<script>
$(document).ready(function() {
      $('a.fancybox').fancybox({ parent: "body"});
});
</script>