package matchdog

class MatchesController {

    def index() {
        
        def matches = [:]

        [matches : Match.find('from Match where dog1_id = :dog_id OR dog2_id = :dog_id AND (DATAHORA_DOG1DESISTIU is null and DATAHORA_DOG2DESISTIU is null)  )', [dog_id: session['dog_id']])]
        
    	/* ARTUR, ESSE TRECHO AQUI QUE NÃO FUNCIONA
        matches.each {
    		switch(session['dog_id']) {
    			case it.dog1.id:
    				m.datahoraDog1Viu = Calendar.instance.time
    				break
    			case it.dog2.id:
    				m.datahoraDog2Viu = Calendar.instance.time
    				break
    		}
    		it.save(flush:true)
    	}
        */

    }

    def naorolamais() { 
    	def m = Match.get(params.id)
    	switch(session['dog_id']) {
    		case m.dog1.id:
    			m.datahora_dog1_desistiu = Calendar.instance.time
    			break
    		case m.dog2.id:
    			m.datahora_dog2_desistiu = Calendar.instance.time
    	}
    	m.save(flush:true)
    	redirect(controller: "matches")
    }

}
