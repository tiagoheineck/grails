class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:'home', action:'index')
        "/home"(controller:'home', action:'index')
        "/farejar"(controller:'home',action: 'farejar')
        "/curtir"(controller:'home',action: 'curtir')
        "/cadastro"(controller:'cadastro',action: 'add')
        "/logout"(controller:'login', action:'destroy')
        "/dogs/new"(controller:'dogs',action: 'add')
        "/matches"(controller: 'matches', action:'index')        
        "/album/$classe/$id"(controller: 'fotos', action:'album')
        "500"(view:'/error')
        "404"(view:'/notFound')
    }

}
