package notepad

import org.springframework.web.servlet.tags.Param

class NotepadController {

    def index() {
        redirect(action: 'current')
    }

    def current () {
        def allNotes = Notepad.list()
        [allNotes:allNotes]
    }

    def saveMethod() {

        def saveNotes = new Notepad(params)
        //TODO: System.out.* is imported automatically in Groovy - you can just use `println` - Zak
        System.out.println("the value of params in controller = " + params) //scaffold
        saveNotes.save()
        redirect(action: 'current')
    }

    def delete(long id){

        Notepad notepadInstance = Notepad.get(id)

        //TODO: Can be shortened to if(!notepadInstance) - Google "Groovy truth" for details - Zak
        if (notepadInstance == null) {
            //TODO: System.out. is unnecessary
            System.out.println("Docuemnt Object is NULL")
            return
        }

        notepadInstance.delete(flush: true) //flush:true –>flushes the persistence context, persisting the object immediately
        redirect(action: 'current')
    }
}

