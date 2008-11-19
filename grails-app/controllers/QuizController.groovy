class QuizController {

    def index = { redirect(action:'level', params:params)}

    def level = {
        if (!session.answered)
            session.answered = []

        def questions = Question.findAllByLevel(params.id ?: 'easy')
        [questions:questions.findAll {!session.answered.contains(it.id)}]
    }

    def answer = {
        def answer = Answer.get(params.answerId)

        if (answer.correctAnswer)
        {
            flash.message = "Well done!"
            session.answered << answer.question.id
        }
        else
        {
            flash.message = 'Nope, try again!'
        }

        redirect(action:'level', params:params)

    }
}
