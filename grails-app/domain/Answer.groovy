class Answer {
    static belongsTo = [question:Question]

    String title
    Boolean correctAnswer

    static constraints = {
        title(blank:false)
        correctAnswer()
        question(nullable:false)
    }

}
