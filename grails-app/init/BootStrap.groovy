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
    }

}
