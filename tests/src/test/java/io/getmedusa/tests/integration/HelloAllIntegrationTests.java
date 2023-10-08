package io.getmedusa.tests.integration;

import io.getmedusa.meta.SelenideIntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.By.*;

public class HelloAllIntegrationTests extends SelenideIntegrationTest {

    final String expected = "Hello from Medusa %s";

    @BeforeEach
    void openPage(){
        logger.info("start testing...");
    }

    @Test
    void one(){
        applications.openMedusaOne("one");
        assertEquals(expected.formatted("ONE"), $(id("one.message")).text());
    }

    @Test
    void two(){
        applications.openMedusaTwo("two");
        assertEquals(expected.formatted("TWO"), $(id("two.message")).text());
    }

    @Test
    void three(){
        applications.openMedusaThree("three");
        assertEquals(expected.formatted("THREE"), $(id("three.message")).text());
    }

    @Test
    void hydra(){
        applications.openHydraOne("one");
        assertEquals(expected.formatted("ONE"), $(id("one.message")).text());

        applications.openHydraOne("two");
        assertEquals(expected.formatted("TWO"), $(id("two.message")).text());

        applications.openHydraOne("three");
        assertEquals(expected.formatted("THREE"), $(id("three.message")).text());
    }

}
