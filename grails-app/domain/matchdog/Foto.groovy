package matchdog

class Foto {
	String url
	String descricao

    static constraints = {
    	url blank: false
    	descricao maxSize: 1000
    }
}
