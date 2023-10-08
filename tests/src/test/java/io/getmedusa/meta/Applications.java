package io.getmedusa.meta;

import com.codeborne.selenide.Selenide;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Applications {

    @Value("${HYDRA_ONE:localhost}:8080") String HYDRA_ONE;
    @Value("${MEDUSA_ONE:localhost}:8881") String MEDUSA_ONE;
    @Value("${MEDUSA_TWO:localhost}:8882") String MEDUSA_TWO;
    @Value("${MEDUSA_THREE:localhost}:8883") String MEDUSA_THREE;

    private void openPage(String server, String endpoint){
        Selenide.open("http://%s/%s".formatted(server,endpoint));
    }

    /**
     * Open an endpoint via Hydra One
     * @param endpoint, the page to open
     */
    public void openHydraOne(String endpoint) {openPage(HYDRA_ONE, endpoint);}

    /**
     * Open an endpoint on the Medusa One Server
     * @param endpoint, the page to open
     */
    public void openMedusaOne(String endpoint) {openPage(MEDUSA_ONE, endpoint);}

    /**
     * Open an endpoint, the page to open on the Medusa Two Server
     * @param endpoint, the page to open
     */
    public void openMedusaTwo(String endpoint) {openPage(MEDUSA_TWO, endpoint);}

    /**
     * Open an endpoint on the Medusa Three Server
     * @param endpoint, the page to open
     */
    public void openMedusaThree(String endpoint) {openPage(MEDUSA_THREE, endpoint);}
}
