package matchdog

class CurrentTagLib {
    static defaultEncodeAs = "raw"

	def ifCurrentDono = {attrs, body ->
		if (session.dono_id ) {
			def currentDono = Dono.get(session.dono_id)
			if(currentDono){
				out << body() 
			}
		}
	}

	def ifCurrentDog = {attrs, body ->
		if (session.dog_id ) {
			def currentDog = Dog.get(session.dog_id)
			if(currentDog){
				out << body() 
			}
		}
	}

	def ifNotCurrentDog = {attrs, body ->
		if (session.dog_id) {
			def currentDog = Dog.get(session.dog_id)
			if(currentDog){
				
			}
			else{
				out << body() 
			}
		}
		else{
			out << body() 
		}

	}

	def ifCurrentDogHasFoto = {attrs, body ->
		if (session.dog_id ) {
			def currentDog = Dog.get(session.dog_id)
			if(currentDog){
				if(currentDog.foto){
					out << body()
				}
			}
		}
	}

	def ifCurrentDogHasNotFoto = {attrs, body ->
		if (session.dog_id) {
			def currentDog = Dog.get(session.dog_id)
			if(currentDog){
				if(currentDog.foto){
					
				}
				else{
					out << body()
				}
			}
			else{
				out << body() 
			}
		}
		else{
			out << body() 
		}

	}

	def ifCurrentDonoHasFoto = {attrs, body ->
		if (session.dono_id ) {
			def currentDono = Dono.get(session.dono_id)
			if(currentDono){
				if(currentDono.foto){
					out << body()
				}
			}
		}
	}

	def ifCurrentDonoHasNotFoto = {attrs, body ->
		if (session.dono_id) {
			def currentDono = Dono.get(session.dono_id)
			if(currentDono){
				if(currentDono.foto){
					
				}
				else{
					out << body()
				}
			}
			else{
				out << body() 
			}
		}
		else{
			out << body() 
		}

	}

	def getCurrentDogCountMatches = { attrs, body ->
	  	def currentDog = Dog.get(session.dog_id)
	  	if(currentDog){
	    	out << body() << currentDog.get_count_matches()
	  	}
	}

    def getCurrentDogCountLatidas = { attrs, body ->
	  	def currentDog = Dog.get(session.dog_id)
	  	if(currentDog){
	    	out << body() << currentDog.get_count_latidas()
	  	}
	}

	def getCurrentDogNome = { attrs, body ->
	  	def currentDog = Dog.get(session.dog_id)
	  	if(currentDog){
	    	out << body() << currentDog.nome
	  	}
	}

	def getCurrentDogFotoUrl = { attrs, body ->
	  	def currentDog = Dog.get(session.dog_id)
	  	if(currentDog){
	  		if(currentDog.foto){
				out << body() << currentDog.foto.url
	  		}
	  	}
	}

	def getCurrentDonoNome = { attrs, body ->
	  	def currentDono = Dono.get(session.dono_id)
	  	if(currentDono){
	    	out << body() << currentDono.nome
	  	}
	}

	def getCurrentDonoFotoUrl = { attrs, body ->
	  	def currentDono = Dono.get(session.dono_id)
	  	if(currentDono){
	  		if(currentDono.foto){
				out << body() << currentDono.foto.url
	  		}
	  	}
	}
}
