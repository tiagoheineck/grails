package matchdog

import java.security.MessageDigest

class LoginController {

    def index() { }

    def create() {
    	def dono = Dono.withCriteria(uniqueResult: true) {
    		eq('email', params.email)
    		eq('password',MessageDigest.getInstance("MD5").digest(params.password.getBytes("UTF-8")).encodeHex().toString())
    	}
    	if (dono) {
    		session['dono_id'] = dono.id
    		if (dono.dogs && dono.dogs.size() == 1){
                redirect(controller: "dogs",action: "show", id: dono.dogs.first().id)
    		}
            else{
                redirect(controller: "dogs",action: "index")    
            }
    	} else {
    		flash.message = "Login ou Senha Inválidos"
			flash.args = ["error"]
			redirect(controller: "login",action: "index")
    	}
    }

    def destroy() {
        session.invalidate()
        redirect(controller: "login",action: "index")
    }
    
}
