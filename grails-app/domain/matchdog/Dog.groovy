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

    static mapping = {
        foto column: "foto_perfil_id"
    }

    def get_count_matches(){
    	def matches = Match.find("from Match where ((dog1_id = :dog  OR dog2_id = :dog) and (datahora_dog1desistiu IS NULL AND datahora_dog2desistiu IS NULL))", [dog: this.id])
    	matches ? matches.count() : 0
    }
    def get_count_latidas(){
    	def latidas = Latida.find("from Latida where (para_dog_id = :dog AND lida_em IS NULL)", [dog: this.id])
    	latidas ? latidas.count() : 0
    }

}
