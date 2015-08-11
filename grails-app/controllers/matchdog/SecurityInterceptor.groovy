package matchdog


class SecurityInterceptor {

	SecurityInterceptor() {
    	matchAll()
    	.excludes(controller:"login").excludes(controller:"cadastro",action:"create|add")
  	}

    boolean before() {
    	if (!session['dono_id']) {
    		redirect(controller:"login")
    	} else {    
    		true	
    	}
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }

}
