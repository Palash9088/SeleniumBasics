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

