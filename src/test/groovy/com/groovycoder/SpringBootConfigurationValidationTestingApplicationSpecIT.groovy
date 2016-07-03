package com.groovycoder

import org.springframework.boot.test.SpringApplicationConfiguration
import spock.lang.Specification

/**
 * Simple smoke test for application.
 */
@SpringApplicationConfiguration(SpringBootConfigurationValidationTestingApplication)
class SpringBootConfigurationValidationTestingApplicationSpecIT extends Specification {

    def "should boot application"() {
        expect: "boots without errors"
        true
    }

}
