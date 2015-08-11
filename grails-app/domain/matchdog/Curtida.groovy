package matchdog

class Curtida {
	static belongsTo = [dog: Dog, dogAlvo: Dog]
	Boolean curtiu

    static constraints = {
    	curtiu blank: false
    }
}
