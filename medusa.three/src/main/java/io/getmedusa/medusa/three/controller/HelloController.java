package io.getmedusa.medusa.three.controller;

import io.getmedusa.medusa.core.annotation.UIEventPage;
import io.getmedusa.medusa.core.attributes.Attribute;

import java.util.List;

@UIEventPage(path = "/three", file = "/pages/hello")
public class HelloController {
    String message = "Hello from Medusa THREE";

    public List<Attribute> setupAttributes(){
        return Attribute.$$("message", message);
    }
}
