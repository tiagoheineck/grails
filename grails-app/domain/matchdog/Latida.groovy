package matchdog

class Latida {
	static belongsTo = [deDog: Dog, paraDog: Dog, match: Match]
	String mensagem
	Date enviadaEm
	Date lidaEm
    static constraints = {
    	deDog blank: false
    	paraDog blank: false
    	mensagem blank: false, maxSize: 1000
    	enviadaEm blank: false
    }

    static mapping = {
        sort enviadaEm: "asc"
    }
}
