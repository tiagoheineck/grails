package matchdog

class MatchesController {

    def index() {
    	def matches = Match.withCriteria{
    		eq dog1_id, session['dog_id']
    		or {
    			eq dog2_id, session['dog_id']
    		}
    		not {
    			datahora_dog1_desistiu = null
    			datahora_dog2_desistiu = null
    		}    	
    		order created_at, DESC	
    	}
    	matches.each {
    		switch(session['dog_id']) {
    			case it.dog1.id:
    				m.datahora_dog1_viu = Calendar.instance.time
    				break
    			case it.dog2.id:
    				m.datahora_dog2_viu = Calendar.instance.time
    				break
    		}
    		it.save(flush:true)
    	}
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
