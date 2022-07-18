package io.archura.platform;

import io.archura.platform.function.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.Date;
import java.util.Map;
import java.util.function.Consumer;

@Component
public class SimplePreFilter implements Consumer<ServerRequest>, Configurable {

    public SimplePreFilter() {
        log("SimplePreFilter: " + this.hashCode() + ", Constructor");
    }

    @Override
    public void accept(ServerRequest serverRequest) {
        log("SimplePreFilter: " + this.hashCode() + ", serverRequest = " + serverRequest);
    }

    @Override
    public void setConfiguration(Map<String, Object> configuration) {
        log("SimplePreFilter: " + this.hashCode() + ", configuration = " + configuration);
    }

    private void log(final String log) {
        String message = String.format("[%s] [%s-%s] [%s]: %s",
                new Date(),
                Thread.currentThread().getId(),
                Thread.currentThread().getName(),
                this.getClass().getSimpleName(),
                log);
        System.out.println(message);
    }
}
