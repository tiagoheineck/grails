package matchdog

import grails.transaction.Transactional

@Transactional
class FileUploadService {

	def servletContext

    def upload(file) {
 		if(file.originalFilename){
 			def nomeOriginal = file.originalFilename
			file.transferTo(new File(servletContext.getRealPath( "/" ) , nomeOriginal))
			return nomeOriginal
		}
		return ''
	}    
}
