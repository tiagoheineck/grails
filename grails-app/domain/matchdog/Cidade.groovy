package matchdog

class Cidade {

	String nome
	String estado

    static constraints = {
    	nome size: 3..50, blank: false
    	estado maxSize: 2, blank: false
    }
}
