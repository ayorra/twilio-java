/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.trunking.v1.trunk;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class IpAccessControlListFetcher extends Fetcher<IpAccessControlList> {
    private final String pathTrunkSid;
    private final String pathSid;

    /**
     * Construct a new IpAccessControlListFetcher.
     * 
     * @param pathTrunkSid The trunk_sid
     * @param pathSid The sid
     */
    public IpAccessControlListFetcher(final String pathTrunkSid, 
                                      final String pathSid) {
        this.pathTrunkSid = pathTrunkSid;
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Fetched IpAccessControlList
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public IpAccessControlList fetch(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.GET,
            Domains.TRUNKING.toString(),
            "/v1/Trunks/" + this.pathTrunkSid + "/IpAccessControlLists/" + this.pathSid + "",
            client.getRegion()
        );

        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("IpAccessControlList fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }

            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }

        return IpAccessControlList.fromJson(response.getStream(), client.getObjectMapper());
    }
}