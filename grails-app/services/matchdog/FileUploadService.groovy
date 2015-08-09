package matchdog

import grails.transaction.Transactional

@Transactional
class FileUploadService {

	def servletContext

    def upload(file) {
    	def nomeOriginal = file.originalFilename
 		if(!file.empty){
			file.transferTo(new File(servletContext.getRealPath( "/" ) , nomeOriginal))
		}
		return nomeOriginal
	}    
}
