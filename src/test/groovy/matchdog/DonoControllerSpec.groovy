package matchdog

import grails.test.mixin.*
import spock.lang.*

@TestFor(DonoController)
@Mock(Dono)
class DonoControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.donoList
            model.donoCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.dono!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def dono = new Dono()
            dono.validate()
            controller.save(dono)

        then:"The create view is rendered again with the correct model"
            model.dono!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            dono = new Dono(params)

            controller.save(dono)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/dono/show/1'
            controller.flash.message != null
            Dono.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def dono = new Dono(params)
            controller.show(dono)

        then:"A model is populated containing the domain instance"
            model.dono == dono
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def dono = new Dono(params)
            controller.edit(dono)

        then:"A model is populated containing the domain instance"
            model.dono == dono
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/dono/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def dono = new Dono()
            dono.validate()
            controller.update(dono)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.dono == dono

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            dono = new Dono(params).save(flush: true)
            controller.update(dono)

        then:"A redirect is issued to the show action"
            dono != null
            response.redirectedUrl == "/dono/show/$dono.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/dono/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def dono = new Dono(params).save(flush: true)

        then:"It exists"
            Dono.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(dono)

        then:"The instance is deleted"
            Dono.count() == 0
            response.redirectedUrl == '/dono/index'
            flash.message != null
    }
}
