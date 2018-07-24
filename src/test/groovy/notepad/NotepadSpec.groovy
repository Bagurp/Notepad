package notepad

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class NotepadSpec extends Specification implements DomainUnitTest<Notepad> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
