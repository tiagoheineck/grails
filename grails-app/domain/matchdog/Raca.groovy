package matchdog

class Raca {
	String nome

    static constraints = {
    	nome size: 3..50, blank: false
    }
}
