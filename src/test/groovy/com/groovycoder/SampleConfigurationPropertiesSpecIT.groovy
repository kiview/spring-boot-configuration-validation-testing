/*
 * Spring-Boot-Configuration-Validation-Testing
 * Copyright (C) 2016 Kevin Wittek
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.groovycoder

import org.springframework.boot.test.EnvironmentTestUtils
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import spock.lang.Specification

/**
 * Integration tests for {@link SampleConfigurationProperties} validation.
 * Heavily inspired by <a href="https://github.com/spring-projects/spring-boot/blob/master/spring-boot-samples/spring-boot-sample-property-validation/src/test/java/sample/propertyvalidation/SamplePropertyValidationApplicationTests.java">spring-boot-sample-property-validation</a>
 */
class SampleConfigurationPropertiesSpecIT extends Specification {

    def "does crash if validation of external properties fails"() {

        given: "the context"
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()
        context.register(SpringBootConfigurationValidationTestingApplication)

        when: "setting invalid config"
        EnvironmentTestUtils.addEnvironment(context, "sample.size:-1")
        context.refresh()

        then: "application crashes"
        thrown Exception
    }

}
