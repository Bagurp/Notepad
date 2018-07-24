package notepad

class NotepadController {

    def index() {
        redirect(action: 'current')
    }

    def current () {
        def allNotes = Notepad.list()
        [allNotes:allNotes]
    }

    def save() {
        def saveNotes = new Notepad(params)
        saveNotes.save()
        redirect(action: 'current')
    }

    def delete(long id){

        Notepad notepadInstance = Notepad.get(id)

        if (notepadInstance == null) {
            System.out.println("Docuemnt Object is NULL")
            return
        }

        notepadInstance.delete(flush: true) //flush:true –>flushes the persistence context, persisting the object immediately
        redirect(action: 'current')
    }
}

