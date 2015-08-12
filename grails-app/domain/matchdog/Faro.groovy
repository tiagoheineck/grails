package matchdog

class Faro {
	Date datahora
	String sexoDono
	String sexoDog
	Boolean interessaPassear 
	Boolean interessaCruzar

	Raca raca
	Cidade cidade
	Dog dog

	static belongsTo = [Dog, Raca, Cidade]

    static constraints = {
    	sexoDono maxSize: 1
    	sexoDog maxSize: 1
    	datahora nullable: false
    }
}
