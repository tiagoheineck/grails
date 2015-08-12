package matchdog

class Dog {
	String nome
	String sexo
	String descricaoPerfil
	Boolean temPedigree
	Boolean interessaCruzar
	Boolean interessaPassear
	Date datahoraExcluido

	Dono dono
	Raca raca
	Cidade cidade
	Foto foto


	static belongsTo = [Dono, Raca, Cidade, Foto]

	static hasMany = [fotos: Foto]

    static constraints = {
    	nome size: 3..50, nullable: false, blank: false
    	sexo maxSize: 1, nullable: false, blank: false
    	descricaoPerfil maxSize: 1000, nullable: true
		datahoraExcluido nullable: true
		foto nullable: true
    }

    def get_count_matches(){
    	0
    }
    def get_count_latidas(){
    	0
    }

}
