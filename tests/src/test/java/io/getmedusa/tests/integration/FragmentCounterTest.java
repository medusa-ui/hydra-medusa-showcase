package io.getmedusa.tests.integration;

import com.codeborne.selenide.WebDriverRunner;
import io.getmedusa.meta.SelenideIntegrationTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class FragmentCounterTest extends SelenideIntegrationTest {

    @Test
    void increaseOneCounterViaHydra() {
        applications.openHydraOne("one/counters");
        allTemplatesShouldBeRendered();
        increaseCounter("#txt_one_counter", "#btn_one_counter");
    }

    @Test
    void increaseTwoCounterViaHydra() {
        applications.openHydraOne("two/counters");
        allTemplatesShouldBeRendered();
        increaseCounter("#txt_two_counter", "#btn_two_counter");
    }

    @Test
    void increaseThreeCounterViaHydra() {
        applications.openHydraOne("three/counters");
        allTemplatesShouldBeRendered();
        increaseCounter("#txt_three_counter", "#btn_three_counter");
    }

    @Test
    @Disabled("Shouldn't this work?")
    void increaseAllCountersViaHydraOneFromASinglePage() {
        applications.openHydraOne("one/counters");
        allTemplatesShouldBeRendered();
        increaseCounter("#txt_one_counter", "#btn_one_counter");
        increaseCounter("#txt_two_counter", "#btn_two_counter");
        increaseCounter("#txt_three_counter", "#btn_three_counter");
    }

    private void increaseCounter(String txtId, String btnId ){
        // current value
        int current = Integer.parseInt($(txtId).text());

        // increment
        $(btnId).shouldBe(visible).click();
        $(txtId).shouldHave(text("" + ++current  ));

        // increment again
        $((btnId)).shouldBe(visible).click();
        $(txtId).shouldHave(text("" + ++current  ));
    }

    private  void allTemplatesShouldBeRendered() {

        System.out.println(WebDriverRunner.getWebDriver().getPageSource());

        $("#txt_one_counter").shouldBe(visible);
        $("#btn_one_counter").shouldBe(visible);

        $("#txt_two_counter").shouldBe(visible);
        $("#btn_two_counter").shouldBe(visible);

        $("#txt_three_counter").shouldBe(visible);
        $("#btn_three_counter").shouldBe(visible);
    }

}
