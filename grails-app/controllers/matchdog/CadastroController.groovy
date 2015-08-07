package matchdog

class CadastroController {

	// Como new é palavra reservada alterei para add
	def add() { } 

    def save() {
    	def dono = new Dono(donoParams(params))

    	//importar foto
    	if(params.foto) {
    		def file = request.getFile("foto")
    		String fileUpload = fileUploadService.upload(file)
    		def foto = new Foto(url:fileUpload,descricao:"Foto do Perfil")
    		foto.save(flush: true)
    		dono.addToFoto(foto)
    	}

    	//importar demais fotos
    	if(params.files) {
    		params.files.each {
    			file = request.getFile("foto")
    			String fileUpload = fileUploadService.upload(file)
    			foto = new Foto(url:fileUpload,descricao:"Foto do Perfil")
    			foto.save(flush: true)
    			dono.addToFoto(foto)
    		}
    	}
    	dono.password = MessageDigest.getInstance("MD5").digest(params.password).encodeHex().toString()
    	dono.save(flush: true)
    	redirect(controller: "cadastro", action: "first_dog")
    }

    def first_dog() {
    	[cidades: Cidade.getAll().collect {[it.nome,it.id]} , racas:  Raca.getAll().collect {[it.nome,it.id]}]
    }

    def edit() {
    	[dono: Dono.get(session['dono_id'])]
    }

    def complete() {
    	[dono: Dono.get(session['dono_id'])]
    }

    def update() {
    	def dono = Dono.get(session['dono_id'])
    	//parei aqui
    	//falta pegar os parametros e fazer setters com as novas informações
    	if(params.foto) {
    		def file = request.getFile("foto")
    		String fileUpload = fileUploadService.upload(file)
    		def foto
    		if(dono.foto) {
    			foto = new Foto()
    		} else {
    			foto = dono.foto
    		}   		
    		foto.url = fileUpload
    		foto.descricao = "Foto do Perfil"
    		foto.save(flush: true)
    		dono.addToFoto(foto)
    	}
    	dono.save(flush:true)
    	flash.message = "Seu Perfil foi Editado com sucesso"
		flash.args = ["notice"]
    }
	

    private void donoParams(params){
    	[nome: params.nome, sexo: params.sexo, email: params.email, password: params.password]
    }  


}
