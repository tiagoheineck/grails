package matchdog

class HomeController {

    def index(){
    	//to perdidão aqui   	
    }

    def farejar(){
    	def faro = new Faro(params)
    	faro.dog_id = session['dog_id']
    	faro.save(flush: true)
    	redirect(uri:"/")    	
    }

    def curtir() {
    	def curtida = new Curtida()
    	curtida.dog_id = session['dog_id']
    	curtida.dog_alvo_id = params.dog_id
    	curtida.curtiu = params.curtiu
    	curtida.save(flush:true)

    	def deumatch = false
    	if (curtida.curtida) {
    		def curtidaCorrespondente = Curtida.where(dog: curtida.dog_alvo_id).where(dogAlvo: curtida.dog).where(curtiu: true).first()
 			if (curtidaCorrespondente) {
 				deumatch = true
 				def m = new Match([dog1: curtidaCorrespondente.dogAlvo,dog2: curtida.dog]) 				
 				m.save(flush: true)
 				flash.message = "MATCH!!!"
				flash.args = ["error"]
 			}   		
    	}
    }

    private void faroParams(){}

}
