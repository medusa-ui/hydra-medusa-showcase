package io.getmedusa.meta;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Applications.class })
@ExtendWith({TextReportExtension.class})
public abstract class SelenideIntegrationTest {
    protected static final Logger logger = LoggerFactory.getLogger(SelenideIntegrationTest.class);

    @Autowired
    protected Applications applications;

    @BeforeAll /* use application.properties to set selenide.headless=false or selenide.browser */
    static void setup( @Value("${selenide.headless:true}") Boolean headless, @Value("${selenide.browser:chrome}") String browser) {
        switch (browser) {
            case "chrome"   ->  WebDriverManager.chromedriver().setup();
            case "firefox"  -> WebDriverManager.firefoxdriver().setup();
            case "edge"     -> WebDriverManager.edgedriver().setup();
            default         -> WebDriverManager.chromiumdriver().setup();
        }
        Configuration.headless = headless;
        Configuration.screenshots = false;
        Configuration.browser = browser;
        logger.info("Configuration Selenide done");
    }

}
