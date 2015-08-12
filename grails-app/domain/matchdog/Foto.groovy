package matchdog

class Foto {
	String url
	String descricao

	static hasMany = [dogs: Dog, donos: Dono]
	static mappedBy = [dogs: "fotos", donos: 'fotos']

    static constraints = {
    	url blank: false
    	descricao maxSize: 1000
    }
}
