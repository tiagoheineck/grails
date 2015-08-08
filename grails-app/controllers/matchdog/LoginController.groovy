package matchdog

class LoginController {

    def index() { }

    def create() {    	
    	def dono = Dono.withCriteria {
    		eq email, params.email
    		eq password = MessageDigest.getInstance("MD5").digest(params.password).encodeHex().toString()
    	}
    	if (dono) {
    		session['dono_id'] = dono.id
    		if (dono.dogs) {
    			session['dog_id'] = dono.dogs.first().id 
    		}
    		redirect (uri: "/")
    	} else {
    		flash.message = "Login ou Senha Inválidos"
			flash.args = ["error"]
			redirect(controller: "login",action: "index")
    	}
    }
}
