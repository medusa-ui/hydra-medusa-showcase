package io.getmedusa.medusa.three.controller;

import io.getmedusa.medusa.core.annotation.UIEventPage;
import io.getmedusa.medusa.core.attributes.Attribute;
import io.getmedusa.medusa.core.session.Session;

import java.util.List;

import static io.getmedusa.medusa.core.attributes.Attribute.$;
import static io.getmedusa.medusa.core.attributes.Attribute.$$;

@UIEventPage(path = "/three/fragment", file = "/fragments/three")
public class FragmentThreeController {

    int counter = 0;
    String message = "Hello Three Fragment";

    public List<Attribute> setupAttributes(Session session){
        int sessionCounter = 0;
        if(null == session) {
            session = new Session();
        }
        if(null != session.getAttribute("sessionCounter")) {
            sessionCounter = session.getAttribute("sessionCounter");
        }
        session.getLastParameters().add($("sessionCounter", sessionCounter));
        return $$(
                    $("message", message),
                    $("three_counter", counter ),
                    $("sessionCounter", sessionCounter )
                );
    }

    public List<Attribute> threeCounter(){
        return $$( $("three_counter", ++ counter ) );
    }

    public List<Attribute> threeSessionCounter(Session session){
        int sessionCounter = session.getAttribute("sessionCounter");
        sessionCounter++;
        return $$( $("sessionCounter", sessionCounter ) );
    }

}
