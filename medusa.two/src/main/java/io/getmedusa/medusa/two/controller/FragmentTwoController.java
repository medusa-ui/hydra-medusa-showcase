package io.getmedusa.medusa.two.controller;

import io.getmedusa.medusa.core.annotation.UIEventPage;
import io.getmedusa.medusa.core.attributes.Attribute;
import io.getmedusa.medusa.core.session.Session;

import java.util.List;

import static io.getmedusa.medusa.core.attributes.Attribute.$;
import static io.getmedusa.medusa.core.attributes.Attribute.$$;

@UIEventPage(path = "/two/fragment", file = "/fragments/two")
public class FragmentTwoController {

    int counter = 0;
    String message = "Hello Two Fragment";

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
                    $("two_counter", counter ),
                    $("sessionCounter", sessionCounter )
                );
    }

    public List<Attribute> twoCounter(){
        return $$( $("two_counter", ++ counter ) );
    }

    public List<Attribute> twoSessionCounter(Session session){
        int sessionCounter = session.getAttribute("sessionCounter");
        sessionCounter++;
        return $$( $("sessionCounter", sessionCounter ) );
    }

}
