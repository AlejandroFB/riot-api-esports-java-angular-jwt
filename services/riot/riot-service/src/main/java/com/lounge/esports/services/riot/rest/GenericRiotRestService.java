package com.lounge.esports.services.riot.rest;

import com.lounge.esports.services.riot.api.RiotApiRegion;
import com.lounge.esports.services.riot.api.rest.RestBaseResponse;
import com.lounge.esports.services.riot.exception.IllegalRestCallException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * Generic RIOT API rest service.
 *
 * @author afernandez
 *
 * @param <RES> The response of this service
 *
 */
public abstract class GenericRiotRestService<RES extends RestBaseResponse> {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${riot.api.key}")
    private String apiKey;

    @Autowired
    protected RestTemplate restTemplate;

    private final Class<RES> responseClass;

    protected GenericRiotRestService(Class<RES> responseClass) {
        this.responseClass = responseClass;
    }

    /**
     * Starts the process to invoke the request call to a specific RIOT API endpoint.
     *
     * @param region The region to be used in the request call
     * @param parameters The parameters to be substituted in the URI path
     * @return The result entity with the values retrieved from the endpoint
     */
    public RES invoke(RiotApiRegion region, String ... parameters) {
        final URI uri = UriComponentsBuilder.fromHttpUrl("https://" + getTargetRestServiceUrl(region, parameters))
                .queryParam("api_key", apiKey)
                .build()
                .encode()
                .toUri();

        preInvoke();
        ResponseEntity<RES> response = doInvoke(uri);
        postInvoke(response);

        return response.getBody();
    }

    /**
     * Build the RIOT API specific endpoint with the selected region and parameters.
     *
     * @param region The region to be used in the endpoint
     * @param parameters String parameters to use in the endpoint
     * @return The url path of the specific endpoint
     */
    protected abstract String buildEndpointUrl(RiotApiRegion region, String ... parameters);

    /**
     * Hook for doing stuff prior to the actual invoke.
     * Default: this method is empty and will be overwritten if necessary by the children.
     */
    protected void preInvoke() {
    }

    /**
     * Hook for handling the response after the invoke. The default behavior is to check if the response
     * has been successful. Children classes can overwrite or add behavior to this method if needed.

     * @param response The response entity wrapping the response
     */
    protected void postInvoke(ResponseEntity<RES> response) {
        if (response.getStatusCode() != HttpStatus.OK) {
            final String error = String.format("Call failed for request service: %s | response: %s",
                    getClass().getSimpleName(), response);
            throw new IllegalRestCallException(error, response.getBody());
        }
    }

    /**
     * Invokes the rest service with the given final URI fully constructed and the
     * needed headers.
     *
     * @param uri The full URI to invoke the request
     * @return The response entity expected
     */
    protected ResponseEntity<RES> doInvoke(final URI uri) {
        HttpHeaders httpHeaders = getHeaders();

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<RES> responseEntity = restTemplate.exchange(uri, getHttpMethod(), requestEntity, responseClass);

        return responseEntity;
    }

    /**
     * Returns the basic headers used in every request.
     *
     * @return The newly created headers
     */
    protected HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return httpHeaders;
    }

    /**
     * Return the HTTP Method to be used with the specific request service.

     * @return The specific HTTP Method request
     */
    protected HttpMethod getHttpMethod() {
        return HttpMethod.GET;
    }

    /**
     * Returns the full URI path to invoke, combining the RIOT API url and the specific
     * endpoint of the request service.
     *
     * @param region The region to be used in the request call
     * @param parameters String parameters to use in the request call
     * @return The full uri path of the request service
     */
    private String getTargetRestServiceUrl(RiotApiRegion region, String ... parameters) {
        return region.getApiUrl() + buildEndpointUrl(region, parameters);
    }
}
