package io.archura.platform.imperativeshell.pre.filter;

import io.archura.platform.api.context.Context;
import io.archura.platform.api.logger.Logger;
import io.archura.platform.api.type.Configurable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.function.ServerRequest;

import java.util.Map;
import java.util.function.UnaryOperator;

@Component
public class SimplePreFilter implements UnaryOperator<ServerRequest>, Configurable {

    private Map<String, Object> configuration;

    @Override
    public ServerRequest apply(ServerRequest request) {
        final Context context = (Context) request.attributes().get(Context.class.getSimpleName());
        final Logger logger = context.getLogger();

        logger.info("request = " + request + " configuration = " + configuration);
        return request;
    }

    @Override
    public void setConfiguration(Map<String, Object> configuration) {
        this.configuration = configuration;
    }

}
