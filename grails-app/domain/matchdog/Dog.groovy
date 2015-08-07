package matchdog

class Dog {
	String nome
	String sexo
	String descricaoPerfil
	Boolean temPedrigree
	Boolean interessaCruzar
	Boolean interessaPassear
	Date datahoraExcluido

	static belongsTo = [Dono, Raca, Cidade, Foto]

	static hasMany = [fotos: Foto]

    static constraints = {
    	nome size: 3..50, blank: false
    	sexo maxSize: 1, blank: false
    	descricaoPerfil maxSize: 1000
    }
}
