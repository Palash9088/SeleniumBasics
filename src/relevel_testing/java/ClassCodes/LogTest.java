package ClassCodes;//import java.util.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LogTest {
    private static final Log log = LogFactory.getLog(LogTest.class);

    public static void main(String[] args) {
        log.debug("Debug Message");
        log.info("Information Message");
        log.warn("Warning Message");
        log.error("Error Message");
        log.fatal("Fatal Message");


    }
}
/*
* https://relevel.com/courses/software-testing-course-0001/schedule/class-details/74566da2-613a-4a92-baaf-e30ea3ae9f98/assignment/6afc03a2-144c-4738-b1b5-404c90bc0ff4

Home/Software Testing Course/Introduction to Maven and Apache Logging Libraries/Assignment - 1

Assignment - 1
Submission Date - 15th Sep, 2022, 10 AM
Requirements: 1. Create a pom.xml file for installing Maven dependencies of JUnit and Spring Boot Framework.

2. Write a program to display the below log messages.

log.trace(""Trace Message!"");
log.debug(""Debug Message!"");
log.info(""Info Message!"");
log.warn(""Warn Message!"");
log.error(""Error Message!"");
log.fatal(""Fatal Message!"");

Now make the program to display the log messages of all levels above the INFO level. i.e. Only WARN, ERROR and FATAL should be logged.

[Hint: Use setLevel() method of Logger, by importing from org.apache.log4j.*]*/

