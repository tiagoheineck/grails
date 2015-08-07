package matchdog

import grails.transaction.Transactional

@Transactional
class FileUploadService {

    def upload(file) {
    	def nomeOriginal = file.originalFilename		
		def f = request.getFile("foto")
 		if(!f.empty){
			f.transferTo(new File(${serveletContext.getRealPath( destinationDirectory )} + "/${nomeOriginal}"))
		}
		return nomeOriginal
	}    
}
