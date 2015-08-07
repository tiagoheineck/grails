package matchdog

class Dono {
	String nome
	String sexo
	String email
	String password

	// desnecessario pois nao teremos login via Face
	//String provider
	//String uid
	//String token
	//Date expires_at

	static belongsTo = Foto

	static hasMany = [fotos: Foto]

    static constraints = {
    	nome size: 3..50, blank: false
    	sexo maxSize: 1, blank: false
    	email blank:false
    }
}
