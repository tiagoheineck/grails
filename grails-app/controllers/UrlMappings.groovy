class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:'home', action:'index')
        "/home"(controller:'home', action:'index')
        "/logout"(controller:'login', action:'destroy')
        "/farejar"(controller:'home',action: 'farejar')                
        "/curtir"(controller:'home',action: 'curtir') 
        "/cadastro"(controller:'cadastro',action: 'add')        
        "/dogs/new"(controller:'dogs',action: 'add')        
        "500"(view:'/error')
        "404"(view:'/notFound')
    }

}
