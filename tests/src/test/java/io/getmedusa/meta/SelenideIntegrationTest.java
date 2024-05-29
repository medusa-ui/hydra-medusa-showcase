package io.getmedusa.meta;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.junit5.TextReportExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(Applications.class)
@ExtendWith({TextReportExtension.class})
public abstract class SelenideIntegrationTest {
    protected static final Logger logger = LoggerFactory.getLogger(SelenideIntegrationTest.class);

    @Autowired
    protected Applications applications;

    @BeforeAll
    static void setup(@Value("${selenide.headless:true}") Boolean headless,
                      @Value("${selenide.screenshots:false}") Boolean screenshots,
                      @Value("${selenide.browser:chrome}") String browser) {
        Configuration.headless=headless;
        Configuration.screenshots=screenshots;
        Configuration.browser=browser;
        logger.info("Configuration Selenide done");
    }

}
