class BootStrap {

     def init = { servletContext ->
def questionsAndAnswers =
[
    [title:'Who is the current Grails Project Lead?', level:'easy', answers:
        [ [title:'Graeme Rocher', correctAnswer:true],
          [title:'Guillaume Laforge', correctAnswer:false],
          [title:'Dierk Koenig', correctAnswer:false] ]
    ],
    [title:'Who is the current Groovy Project Lead?', level:'easy', answers:
        [ [title:'Graeme Rocher', correctAnswer:false],
        [title:'Guillaume Laforge', correctAnswer:true],
        [title:'Dierk Koenig', correctAnswer:false] ]
    ],
    [title:'When was Griffon first released?', level:'easy', answers:
        [ [title:'2007', correctAnswer:false],
          [title:'2008', correctAnswer:true] ]
    ],
    [title:'What are the two important paradigms Grails borrowed from Rails?', level:'easy', answers:
        [ [title:'CoC and DRY', correctAnswer:true],
          [title:'DRY and FLY', correctAnswer:false],
          [title:'MAI and TAI', correctAnswer:false],
          [title:'YEY and NEY', correctAnswer:false] ]
    ],
    [title:'Who created the Mail Plugin?', level:'medium', answers:
        [ [title:'Marc Palmer', correctAnswer:true],
          [title:'Graeme Rocher', correctAnswer:false],
          [title:'Sven Haiges', correctAnswer:false],
          [title:'Glen Smith', correctAnswer:false] ]
    ],
    [title:'From which episode on did Glen Smith join Sven Haiges for the Grails Podcast?', level:'hard', answers:
        [ [title:'30', correctAnswer:false],
          [title:'45', correctAnswer:false],
          [title:'49', correctAnswer:true],
          [title:'53', correctAnswer:false],
          [title:'60', correctAnswer:false] ]
    ],
    [title:'Are Grails Controller Singleton instances?', level:'medium', answers:
        [ [title:'Yes, there is only one instance per app per controller', correctAnswer:false],
          [title:'No, each request creates a new instance of a controller', correctAnswer:true] ]
    ],
    [title:'What does grails generate-all do?', level:'easy', answers:
        [ [title:'It creates Views and Controller for a Domain class', correctAnswer:true],
          [title:'It creates a new Domain Class, a scaffolded View and a Controller', correctAnswer:false] ]
    ],
    [title:'Which servlet engine does grails run-app use?', level:'medium', answers:
        [ [title:'Jetty', correctAnswer:true],
          [title:'Tomcat', correctAnswer:false] ]
    ],
    [title:'What is Griffon?', level:'easy', answers:
        [ [title:'A cool Jacket from Nike', correctAnswer:false],
          [title:'A Grails-like framework for Swing', correctAnswer:true] ]
    ],
    [title:'Which Grails plugin allows you to easily create graphs of domain objects?', level:'medium', answers:
        [ [title:'The Fixtures Plugin', correctAnswer:true],
          [title:'The xTreme Scaffolding Plugin', correctAnswer:false] ]
    ]
]

questionsAndAnswers.each
{
    def q = new Question(title:it.title, level:it.level).save()
    it.answers.each
    {
        def a = new Answer(title:it.title,correctAnswer:it.correctAnswer)
        q.addToAnswers(a)
        a.save()
    }

}
     }
     def destroy = {
     }
} 