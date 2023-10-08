package io.getmedusa.medusa.one.controller;

import io.getmedusa.medusa.core.annotation.UIEventPage;
import io.getmedusa.medusa.core.attributes.Attribute;

import java.util.List;

@UIEventPage(path = "/one", file = "/pages/hello")
public class HelloController {
    String message = "Hello from Medusa ONE";

    public List<Attribute> setupAttributes(){
        return Attribute.$$("message", message);
    }
}
