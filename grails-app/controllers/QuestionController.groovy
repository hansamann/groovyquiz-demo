class QuestionController {
    
    def index = { redirect(action:list,params:params) }

    // the delete, save and update actions only accept POST requests
    def allowedMethods = [delete:'POST', save:'POST', update:'POST']

    def list = {
        if(!params.max) params.max = 10
        [ questionInstanceList: Question.list( params ) ]
    }

    def show = {
        def questionInstance = Question.get( params.id )

        if(!questionInstance) {
            flash.message = "Question not found with id ${params.id}"
            redirect(action:list)
        }
        else { return [ questionInstance : questionInstance ] }
    }

    def delete = {
        def questionInstance = Question.get( params.id )
        if(questionInstance) {
            questionInstance.delete()
            flash.message = "Question ${params.id} deleted"
            redirect(action:list)
        }
        else {
            flash.message = "Question not found with id ${params.id}"
            redirect(action:list)
        }
    }

    def edit = {
        def questionInstance = Question.get( params.id )

        if(!questionInstance) {
            flash.message = "Question not found with id ${params.id}"
            redirect(action:list)
        }
        else {
            return [ questionInstance : questionInstance ]
        }
    }

    def update = {
        def questionInstance = Question.get( params.id )
        if(questionInstance) {
            questionInstance.properties = params
            if(!questionInstance.hasErrors() && questionInstance.save()) {
                flash.message = "Question ${params.id} updated"
                redirect(action:show,id:questionInstance.id)
            }
            else {
                render(view:'edit',model:[questionInstance:questionInstance])
            }
        }
        else {
            flash.message = "Question not found with id ${params.id}"
            redirect(action:edit,id:params.id)
        }
    }

    def create = {
        def questionInstance = new Question()
        questionInstance.properties = params
        return ['questionInstance':questionInstance]
    }

    def save = {
        def questionInstance = new Question(params)
        if(!questionInstance.hasErrors() && questionInstance.save()) {
            flash.message = "Question ${questionInstance.id} created"
            redirect(action:show,id:questionInstance.id)
        }
        else {
            render(view:'create',model:[questionInstance:questionInstance])
        }
    }
}
