package io.archura.platform;

import io.archura.platform.context.Context;
import io.archura.platform.function.Configurable;
import io.archura.platform.logging.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.Map;
import java.util.function.Consumer;

@Component
public class SimplePreFilter implements Consumer<ServerRequest>, Configurable {

    private Map<String, Object> configuration;

    @Override
    public void accept(ServerRequest request) {
        final Context context = (Context) request.attributes().get(Context.class.getSimpleName());
        final Logger logger = context.getLogger();

        logger.info("request = " + request + " configuration = " + configuration);
    }

    @Override
    public void setConfiguration(Map<String, Object> configuration) {
        this.configuration = configuration;
    }

}
