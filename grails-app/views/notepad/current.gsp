<!DOCTYPE html>
<html xmlns:is="http://www.w3.org/1999/xhtml">
<head>
    <meta name="layout" content="main"/>
    <title>Notebook - Pramukh</title>
</head>


<body>
<h1 style = "text-align:center;"><strong>Welcome to Notebook</strong></h1>

    <div class = "box" style="margin-top: 50px">
        <table id = "TableNotes" style="color: black">
            <tr>
                <th style="color: black">Title</th>
                <th style="color: black">Description</th>
                <th style="color: black"></th>
            </tr>
            <g:each in="${allNotes}" status="i" var="thisNote">
                <tr>
                    <td>${thisNote.caption}</td>
                    <td>${thisNote.description}</td>
                    <td>
                        <g:link action="delete" onclick="return confirm('Confirm delete note?')" id="${thisNote.id}"> Delete </g:link></td>
                    </td>
                </tr>
            </g:each>
        </table>
    </div>

    <div class="footer" style="font-size:13px;">
        <P><h3>Add a new note:</h3></P>

        <g:form controller="Notepad" action="save">
            <label>Title:</label>
            <g:textField name="caption" style="color: black"/><br/>
            <label>Description: </label>
            <g:textField name="description" style="color: black"/><br/>
            <g:actionSubmit value="Save" onclick="return confirm('Confirm add note?')" style="color: black"/>
        </g:form>

    </div>
</body>
</html>

