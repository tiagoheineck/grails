package matchdog

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DonoController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Dono.list(params), model:[donoCount: Dono.count()]
    }

    def show(Dono dono) {
        respond dono
    }

    def create() {
        respond new Dono(params)
    }

    @Transactional
    def save(Dono dono) {
        if (dono == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (dono.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond dono.errors, view:'create'
            return
        }

        dono.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dono.label', default: 'Dono'), dono.id])
                redirect dono
            }
            '*' { respond dono, [status: CREATED] }
        }
    }

    def edit(Dono dono) {
        respond dono
    }

    @Transactional
    def update(Dono dono) {
        if (dono == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (dono.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond dono.errors, view:'edit'
            return
        }

        dono.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'dono.label', default: 'Dono'), dono.id])
                redirect dono
            }
            '*'{ respond dono, [status: OK] }
        }
    }

    @Transactional
    def delete(Dono dono) {

        if (dono == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        dono.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'dono.label', default: 'Dono'), dono.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dono.label', default: 'Dono'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
