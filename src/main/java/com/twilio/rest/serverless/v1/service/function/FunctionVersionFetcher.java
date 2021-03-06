/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.serverless.v1.service.function;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class FunctionVersionFetcher extends Fetcher<FunctionVersion> {
    private final String pathServiceSid;
    private final String pathFunctionSid;
    private final String pathSid;

    /**
     * Construct a new FunctionVersionFetcher.
     *
     * @param pathServiceSid The SID of the Service to fetch the Function Version
     *                       resource from
     * @param pathFunctionSid The SID of the function that is the parent of the
     *                        Function Version resource to fetch
     * @param pathSid The SID that identifies the Function Version resource to fetch
     */
    public FunctionVersionFetcher(final String pathServiceSid,
                                  final String pathFunctionSid,
                                  final String pathSid) {
        this.pathServiceSid = pathServiceSid;
        this.pathFunctionSid = pathFunctionSid;
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     *
     * @param client TwilioRestClient with which to make the request
     * @return Fetched FunctionVersion
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public FunctionVersion fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.SERVERLESS.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Functions/" + this.pathFunctionSid + "/Versions/" + this.pathSid + "",
            client.getRegion()
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("FunctionVersion fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
            throw new ApiException(restException);
        }

        return FunctionVersion.fromJson(response.getStream(), client.getObjectMapper());
    }
}