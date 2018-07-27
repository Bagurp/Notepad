package notepad

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import org.omg.CORBA.Environment
import spock.lang.Shared
import spock.lang.Specification
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement;

@TestFor(NotepadController)
@Mock(Notepad)
class NotepadControllerTest extends Specification {

    //TODO: Unit tests should not be used to test against databases.
    // GORM (the persistence framework used by Grails) is not running
    // during unit tests. The proper place to test such functionality
    // is within an *integration test*. https://docs.grails.org/latest/guide/testing.html#integrationTesting
    //
    // Also, even within an integration test, opening a direct JDBC
    // connection is brittle and not usually necessary - you can simply
    // use GORM to check for whether the record was persisted by calling
    // Notepad.get() (or Notepad.list() to retrieve all of the records) - Zak

    //A better use of unit tests for your controller might be (for example) to check
    // if a redirect is issued when you expect (like your redirect to the 'current' action)

    @Shared
    Connection conn //TODO: As described above, you shouldn't use direct SQL connections
                    // in a unit test (or really any Grails test, usually)


    @Shared
    Statement stmt //TODO: Same as above

    @Shared
    ResultSet rs //TODO: Same as above

    /* Initialization logic here - connection over jdbc to h2 database*/
    def setupSpec() {

        try{
            conn = DriverManager.getConnection("jdbc:h2:./testDb", "sa", "")
            stmt = conn.createStatement()
            println"\nConnection successful"

        }
        catch(NullPointerException e){
            println "NullPointerException caught";
            e.printStackTrace()
        }
        catch (Exception e){
            println "connection to testDb unsuccessful"
            e.printStackTrace()
        }
    }

    /*Run after the last test feature - closing the connection to db*/
    def cleanupSpec() {

        try{
            conn.close()
            println "Connection closed successfully"
        }
        catch (Exception e){
            println "Error closing connection"
            e.printStackTrace()
        }
    }

    void "test for Index method"() {

        when:
        controller.index()

        then:
        response.redirectedUrl == "/notepad/current"
    }

    void "test for Save method"() {

        setup:
        controller.params.caption = "Stephen King"
        controller.params.description = "he is one of the greatest authors of all time"
        controller.params._action_SaveMethod = "SaveMethod"
        controller.params.controller = "notepad"
        controller.params.format = null
        controller.params.action = "saveMethod"

        when:
        controller.saveMethod()
        viewDb() //TODO: As described above, persistence to the database will not work in a unit test

        then:
        response.redirectedUrl == "/notepad/current"
/*
        The getter is causing an error as there is no row in the table with caption "Stephen King"
        and:
        rs.getString("caption").equals('Stephen King')

        and:
        rs.getString("description") == "he is one of the greatest authors of all time"
 */
    }


    //scaffolding - to check the values returned
    void viewDb(){

        rs = stmt.executeQuery("SELECT * from NOTEPAD")
        while (rs.next()) {
            String caption = rs.getString("caption")
            String description = rs.getString("description")
            System.out.println("\n inside ViewDB method -  "+ caption + "\n" + description)
        }
    }
}

