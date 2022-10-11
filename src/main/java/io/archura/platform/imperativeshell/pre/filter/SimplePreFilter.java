package io.archura.platform.imperativeshell.pre.filter;

import io.archura.platform.api.context.Context;
import io.archura.platform.api.http.HttpServerRequest;
import io.archura.platform.api.logger.Logger;
import io.archura.platform.api.type.Configurable;

import java.util.Map;
import java.util.function.UnaryOperator;

public class SimplePreFilter implements UnaryOperator<HttpServerRequest>, Configurable {

    private Map<String, Object> configuration;

    @Override
    public HttpServerRequest apply(HttpServerRequest request) {
        final Context context = (Context) request.getAttributes().get(Context.class.getSimpleName());
        final Logger logger = context.getLogger();

        logger.info("request = " + request + " configuration = " + configuration);
        return request;
    }

    @Override
    public void setConfiguration(Map<String, Object> configuration) {
        this.configuration = configuration;
    }

}
