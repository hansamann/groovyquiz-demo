class Question {
    static hasMany = [answers:Answer]

    Date created = new Date()
    String title
    String level = 'easy'

    static constraints = {
        title(blank:false)
        level(inList:['easy', 'medium', 'hard'])
        created()
        answers()
    }

}
