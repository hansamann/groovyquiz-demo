

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Groovy Quiz</title>
    </head>
    <body>
        
        <div class="body">
            <h1>Groovy Quiz at JUG!</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>


            <g:each in="${questions}" var="question">
              <div class="question">
                <div class="questionTitle">
                  ${question?.title}
                </div>
                <g:each in="${question?.answers}" var="answer">
                  <g:link action="answer" id="${params.id}" params="[answerId:answer.id]">${answer?.title}</g:link><br/>
                </g:each>
              </div> 

            </g:each>
                
           
        </div>
    </body>
</html>
