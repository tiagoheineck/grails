package matchdog

class Match {
	static belongsTo = [dog1: Dog, dog2: Dog]
	Date datahoraDog1Viu
	Date datahoraDog2Viu
	Date datahoraDog1Desistiu
	Date datahoraDog2Desistiu

    static constraints = {
    	dog1 blank: false
    	dog2 blank: false
    }
}
