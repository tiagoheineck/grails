package matchdog

class Faro {
	String sexoDono
	String sexoDog
	Boolean interessaPassear 
	Boolean interessaCruzar 

	static belongsTo = [Dono, Raca, Cidade]

    static constraints = {
    	sexoDono maxSize: 1
    	sexoDog maxSize: 1
    }
}
