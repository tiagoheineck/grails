package matchdog

class FotosController {

    def create() {    	
    	def file = request.getFile("foto")
    	String fileUpload = fileUploadService.upload(file)
    	def foto = new Foto(url:fileUpload,descricao:"Foto do Perfil")
    	foto.save(flush: true)
    	dono.addToFoto(foto)    	
    	
   		def classe = params.classe.get(params.id)
   		classe.addToFoto(foto)
   		classe.save(flush: true)
   		render(contentType: "application/json") {
 		   json: classe
		}

    }

    def destroy() {
    	def foto = Foto.get(params.id).delete(flush: true)
    	render(contentType: "application/json") {
 		   status: 204
		}
    }

    def update() {
    	def foto = Foto.get(params.id)
    	foto.descricao = params.descricao
    	foto.save(flush: true)
    	render(contentType: "application/json") {
 		   status: 204
		}
    }
    
}
