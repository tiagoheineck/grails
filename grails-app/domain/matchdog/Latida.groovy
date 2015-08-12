package matchdog

class Latida {
	static belongsTo = [deDog: Dog, paraDog: Dog, match: Match]
	String mensagem
	Date enviadaEm
	Date lidaEm
    static constraints = {
    	deDog nullable: false
    	paraDog nullable: false
    	mensagem nullable: false, blank: false, maxSize: 1000
    	enviadaEm nullable: false, blank: false
        lidaEm nullable: true
    }

    static mapping = {
        sort enviadaEm: "asc"
    }
}
