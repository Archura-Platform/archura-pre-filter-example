package io.archura.platform;

import io.archura.platform.function.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.Map;
import java.util.function.Consumer;

@Component
public class SimplePreFilter implements Consumer<ServerRequest>, Configurable {

    public SimplePreFilter() {
        System.out.println("SimplePreFilter: " + this.hashCode() + ", Constructor");
    }

    @Override
    public void accept(ServerRequest serverRequest) {
        System.out.println("SimplePreFilter: " + this.hashCode() + ", serverRequest = " + serverRequest);
    }

    @Override
    public void setConfiguration(Map<String, Object> configuration) {
        System.out.println("SimplePreFilter: " + this.hashCode() + ", configuration = " + configuration);
    }
}
