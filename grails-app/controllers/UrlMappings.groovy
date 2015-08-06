class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "/farejar"(controller:'home',action: 'farejar')                
        "/curtir"(controller:'home',action: 'curtir') 
        "/cadastro/new"(controller:'cadastro',action: 'add')        
        "/dogs/new"(controller:'dogs',action: 'add')        
        "500"(view:'/error')
        "404"(view:'/notFound')
    }

}
