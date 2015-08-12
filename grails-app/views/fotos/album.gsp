<div id="abre_fotos" style="width:850px;overflow:hidden;">
    <g:if test="${album.fotos}">
        <h2>Fotos de ${ album.nome } </h2>
        <div id="album" class="row">
            <g:each in="${album.fotos}" var="foto">
            <div class="col-md-4">
                <div class="thumbnail clearfix">
                    <img src="/${foto.url}">
                    <div class="caption">
                        ${ foto.descricao }
                    </div>
                </div>
            </div>
            </g:each>
        </div>
    </g:if>
    <g:else>
        <h2>:( Amiguinho não tem foto ainda</h2>
    </g:else>
</div>