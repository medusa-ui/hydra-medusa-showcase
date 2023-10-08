package io.getmedusa.medusa.two.controller;

import io.getmedusa.medusa.core.annotation.UIEventPage;
import io.getmedusa.medusa.core.attributes.Attribute;

import java.util.List;

@UIEventPage(path = "/two", file = "/pages/hello")
public class HelloController {
    String message = "Hello from Medusa TWO";

    public List<Attribute> setupAttributes(){
        return Attribute.$$("message", message);
    }
}
