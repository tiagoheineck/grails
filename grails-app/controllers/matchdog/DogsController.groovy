package matchdog

class DogsController {

    def add() {
    	[cidades: Cidade.getAll() , racas:  Raca.getAll()]
    }

    def create() {
    	def dog = new Dog(dogParams(params))
        dog.raca = Raca.get(params.raca)
        dog.cidade = Cidade.get(params.cidade)
        dog.dono = Dono.get(session['dono_id'])

    	//importar foto
    	if(params.foto) {
    		def file = request.getFile("foto")
    		String fileUpload = fileUploadService.upload(file)
    		def foto = new Foto(url:fileUpload,descricao:"Foto do Perfil")
    		foto.save(flush: true)
    		dog.addToFoto(foto)
    	}

    	//importar demais fotos
    	if(params.files) {
    		params.files.each {
    			file = request.getFile("foto")
    			String fileUpload = fileUploadService.upload(file)
    			foto = new Foto(url:fileUpload,descricao:"Foto do Perfil")
    			foto.save(flush: true)
    			dog.addToFoto(foto)
    		}
    	}
    	if(dog.save(flush: true)){
            flash.message = "O Dog ${dog.nome} foi Editado com sucesso."
            flash.args = ["notice"]
            session['dog_id'] = dog.id
        }
        redirect(controller: "dogs",action: "index")
    }

    def update() {
    	def dog = Dono.get(params.id)
    	//dog.properties = params
    	if(params.foto) {
    		def file = request.getFile("foto")
    		String fileUpload = fileUploadService.upload(file)
    		def foto
    		if(dog.foto) {
    			foto = new Foto()
    		} else {
    			foto = dog.foto
    		}   		
    		foto.url = fileUpload
    		foto.descricao = "Foto do Perfil"
    		foto.save(flush: true)
    		dog.addToFoto(foto)
    	}
    	dog.save(flush:true)
    	flash.message = "${dog.nome} foi Editado com sucesso"
		flash.args = ["notice"]
		redirect(controller: "dogs",action: "index")
    }

    def edit() {
    	[dog: Dog.get(params.id)]
    }

    def destroy() {
    	def dog = Dog.get(params.id)
    	if (dog.dono.id == session['dono_id']) {
    		dog.datahoraExcluido = Calendar.instance.time
    		dog.save(flush: true)
    		session['dog_id'] == null
    		flash.message = "${dog.nome} foi Excluído com sucesso"
			flash.args = ["notice"]
    	}
    	redirect (controller: "dogs", action: "index")
    }

    def index() {
    	[dogs: Dono.get(session['dono_id']).dogs]
    }

    def show() {
    	def dog = Dog.get(params.id)
    	if (dog.dono.id == session['dono_id']){
    		session['dog_id'] = dog.id
    		flash.message = "${dog.nome} foi Selecionado com sucesso"
			flash.args = ["notice"]
			redirect (uri: "/")
    	} else {
    		flash.message = "${dog.nome} não pode ser selecionado"
			flash.args = ["warning"]
    		redirect (controller: "dogs", action: "index")
    	}
    }

    def private dogParams(params) {
    	[
    		nome: params.nome,
            sexo: params.sexo,
    		temPedigree: params.temPedigree,
    		interessaCruzar: params.interessaCruzar,
    		interessaPassear: params.interessaPassear
    	]
    }
}
