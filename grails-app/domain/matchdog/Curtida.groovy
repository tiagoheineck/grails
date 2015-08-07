package matchdog

class Curtida {
	static belongsTo = [dog: Dog, dogAlvo: Dog, match: Match]
	Boolean curtiu

    static constraints = {
    	curtiu blank: false
    }
}
