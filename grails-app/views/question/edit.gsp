

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Edit Question</title>
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Question List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Question</g:link></span>
        </div>
        <div class="body">
            <h1>Edit Question</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${questionInstance}">
            <div class="errors">
                <g:renderErrors bean="${questionInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form method="post" >
                <input type="hidden" name="id" value="${questionInstance?.id}" />
                <div class="dialog">
                    <table>
                        <tbody>
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="title">Title:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:questionInstance,field:'title','errors')}">
                                    <input type="text" id="title" name="title" value="${fieldValue(bean:questionInstance,field:'title')}"/>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="level">Level:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:questionInstance,field:'level','errors')}">
                                    <g:select id="level" name="level" from="${questionInstance.constraints.level.inList}" value="${questionInstance.level}" ></g:select>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="created">Created:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:questionInstance,field:'created','errors')}">
                                    <g:datePicker name="created" value="${questionInstance?.created}" ></g:datePicker>
                                </td>
                            </tr> 
                        
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="answers">Answers:</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:questionInstance,field:'answers','errors')}">
                                    
<ul>
<g:each var="a" in="${questionInstance?.answers?}">
    <li><g:link controller="answer" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></li>
</g:each>
</ul>
<g:link controller="answer" params="['question.id':questionInstance?.id]" action="create">Add Answer</g:link>

                                </td>
                            </tr> 
                        
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><g:actionSubmit class="save" value="Update" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
