package notepad

import groovy.sql.Sql
import spock.lang.Shared
import spock.lang.Specification
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

@TestFor(Notepad)
class TestBuildConf extends Specification {

    void "test"() {
        //Test case. This test should pass if the build/conf is correct

        expect:
        !grailsApplication.config.isEmpty()
    }
}