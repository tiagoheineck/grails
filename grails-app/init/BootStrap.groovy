class BootStrap {

    def init = { servletContext ->

    	switch(grails.util.Environment.current) {
    		 case grails.util.Environment.DEVELOPMENT:                
                seedTestData()
                break;
    	}


    }
    
    def destroy = {
    }

	private void seedTestData() {
    	def cidade = new matchdog.Cidade(nome: 'Recife',estado: 'PE')
    	assert cidade.save(failOnError:true, flush:true, insert: true)
    	def cidade2 = new matchdog.Cidade(nome: 'Blumenau',estado: 'SC')
    	assert cidade2.save(failOnError:true, flush:true, insert: true)
    	def raca = new matchdog.Raca(nome: 'Poodle')
    	assert raca.save(failOnError:true, flush:true, insert: true)
    	def raca2 = new matchdog.Raca(nome: 'Border Collie')
    	assert raca2.save(failOnError:true, flush:true, insert: true)
        def dono = new matchdog.Dono(nome: 'Joao da Couve', sexo: 'M', email: 'a@a.com', password: java.security.MessageDigest.getInstance("MD5").digest('123'.getBytes("UTF-8")).encodeHex().toString())
        assert dono.save(failOnError:true, flush:true, insert: true) 
        def dog = new matchdog.Dog(nome: 'Bolica', sexo: 'M', descricaoPerfil: 'Cão chupando manga',
            temPedigree: true, interessaCruzar: true, interessaPassear: true, dono: dono, raca: raca, cidade: cidade)      
        assert dog.save(failOnError:true, flush:true, insert: true) 
    }

}
