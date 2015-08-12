package matchdog

class Dono {
	String nome
	String sexo
	String email
	String password

	Foto foto

	// desnecessario pois nao teremos login via Face
	//String provider
	//String uid
	//String token
	//Date expires_at

	static belongsTo = Foto

	static hasMany = [fotos: Foto, dogs: Dog]

    static constraints = {
    	nome size: 3..50, nullable: false, blank: false
    	sexo maxSize: 1, nullable: false, blank: false
    	email nullable: false, blank:false
    	foto nullable: true
    }

    static mapping = {
        foto column: "foto_perfil_id"
    }
}
