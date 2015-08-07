package matchdog

class AlbumController {
// Lembrar de desligar o layout neste controller
// @plinio http://stackoverflow.com/questions/4829671/render-a-page-in-grails-without-html-and-body-tag

    def dog() { 
    	[dog: Dog.get(params.id), fotos: dog.fotos]
    }

    def dono(){
    	[dono: Dono.get(params.id),fotos: dono.fotos]
    }
}
