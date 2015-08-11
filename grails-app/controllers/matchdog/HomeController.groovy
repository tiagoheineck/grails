package matchdog

class HomeController {

    def index(){
    	[alvos : Dog.findAll() ]
    }

    def farejar(){
    	def faro = new Faro(params)
    	faro.dog_id = session['dog_id']
    	faro.save(flush: true)
    	redirect(uri:"/")    	
    }

    def curtir() {
    	def curtida = new Curtida()
    	curtida.dog = Dog.get(session['dono_id'])
    	curtida.dogAlvo = Dog.get(params.id)
    	curtida.curtiu = params.boolean('curtiu')
    	curtida.save(flush:true)

    	def deumatch = false
        
    	if (curtida.curtiu) {
    		def curtidaCorrespondente = Curtida.find('from Curtida where dog_id = :dog_alvo and dog_alvo_id  = :dog and curtiu is true', [dog_alvo: session['dog_id'], dog: curtida.dog.id])
            
 			if (curtidaCorrespondente) {
 				deumatch = true
 				def m = new Match([dog1: curtidaCorrespondente.dogAlvo,dog2: curtida.dog]) 				
 				m.save(flush: true)
 				flash.message = "MATCH!!!"
				flash.args = ["error"]
 			}   		
    	}
        render(contentType: "application/json") {
           [head: "No Content"]
        }
    }

    private void faroParams(){}

}
