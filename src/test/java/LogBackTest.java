import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yingdg on 2017/9/28 0028.
 */
public class LogBackTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogBackTest.class);

    @Test
    public void logbackTest() {
        LOGGER.info("hello"); // 17:34:12.862 [main] INFO  LogBackTest - hello
    }
}
