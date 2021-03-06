/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.trunking.v1.trunk;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OriginationUrl extends Resource {
    private static final long serialVersionUID = 147762448771620L;

    /**
     * Create a OriginationUrlFetcher to execute fetch.
     *
     * @param pathTrunkSid The SID of the Trunk from which to fetch the
     *                     OriginationUrl
     * @param pathSid The unique string that identifies the resource
     * @return OriginationUrlFetcher capable of executing the fetch
     */
    public static OriginationUrlFetcher fetcher(final String pathTrunkSid,
                                                final String pathSid) {
        return new OriginationUrlFetcher(pathTrunkSid, pathSid);
    }

    /**
     * Create a OriginationUrlDeleter to execute delete.
     *
     * @param pathTrunkSid The SID of the Trunk from which to delete the
     *                     OriginationUrl
     * @param pathSid The unique string that identifies the resource
     * @return OriginationUrlDeleter capable of executing the delete
     */
    public static OriginationUrlDeleter deleter(final String pathTrunkSid,
                                                final String pathSid) {
        return new OriginationUrlDeleter(pathTrunkSid, pathSid);
    }

    /**
     * Create a OriginationUrlCreator to execute create.
     *
     * @param pathTrunkSid The SID of the Trunk to associate the resource with
     * @param weight The value that determines the relative load the URI should
     *               receive compared to others with the same priority
     * @param priority The relative importance of the URI
     * @param enabled Whether the URL is enabled
     * @param friendlyName A string to describe the resource
     * @param sipUrl The SIP address you want Twilio to route your Origination
     *               calls to
     * @return OriginationUrlCreator capable of executing the create
     */
    public static OriginationUrlCreator creator(final String pathTrunkSid,
                                                final Integer weight,
                                                final Integer priority,
                                                final Boolean enabled,
                                                final String friendlyName,
                                                final URI sipUrl) {
        return new OriginationUrlCreator(pathTrunkSid, weight, priority, enabled, friendlyName, sipUrl);
    }

    /**
     * Create a OriginationUrlReader to execute read.
     *
     * @param pathTrunkSid The SID of the Trunk from which to read the
     *                     OriginationUrl
     * @return OriginationUrlReader capable of executing the read
     */
    public static OriginationUrlReader reader(final String pathTrunkSid) {
        return new OriginationUrlReader(pathTrunkSid);
    }

    /**
     * Create a OriginationUrlUpdater to execute update.
     *
     * @param pathTrunkSid The SID of the Trunk from which to update the
     *                     OriginationUrl
     * @param pathSid The unique string that identifies the resource
     * @return OriginationUrlUpdater capable of executing the update
     */
    public static OriginationUrlUpdater updater(final String pathTrunkSid,
                                                final String pathSid) {
        return new OriginationUrlUpdater(pathTrunkSid, pathSid);
    }

    /**
     * Converts a JSON String into a OriginationUrl object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return OriginationUrl object represented by the provided JSON
     */
    public static OriginationUrl fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, OriginationUrl.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a OriginationUrl object using the provided
     * ObjectMapper.
     *
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return OriginationUrl object represented by the provided JSON
     */
    public static OriginationUrl fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, OriginationUrl.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String sid;
    private final String trunkSid;
    private final Integer weight;
    private final Boolean enabled;
    private final URI sipUrl;
    private final String friendlyName;
    private final Integer priority;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final URI url;

    @JsonCreator
    private OriginationUrl(@JsonProperty("account_sid")
                           final String accountSid,
                           @JsonProperty("sid")
                           final String sid,
                           @JsonProperty("trunk_sid")
                           final String trunkSid,
                           @JsonProperty("weight")
                           final Integer weight,
                           @JsonProperty("enabled")
                           final Boolean enabled,
                           @JsonProperty("sip_url")
                           final URI sipUrl,
                           @JsonProperty("friendly_name")
                           final String friendlyName,
                           @JsonProperty("priority")
                           final Integer priority,
                           @JsonProperty("date_created")
                           final String dateCreated,
                           @JsonProperty("date_updated")
                           final String dateUpdated,
                           @JsonProperty("url")
                           final URI url) {
        this.accountSid = accountSid;
        this.sid = sid;
        this.trunkSid = trunkSid;
        this.weight = weight;
        this.enabled = enabled;
        this.sipUrl = sipUrl;
        this.friendlyName = friendlyName;
        this.priority = priority;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.url = url;
    }

    /**
     * Returns The SID of the Account that created the resource.
     *
     * @return The SID of the Account that created the resource
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The unique string that identifies the resource.
     *
     * @return The unique string that identifies the resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The SID of the Trunk that owns the Origination URL.
     *
     * @return The SID of the Trunk that owns the Origination URL
     */
    public final String getTrunkSid() {
        return this.trunkSid;
    }

    /**
     * Returns The value that determines the relative load the URI should receive
     * compared to others with the same priority.
     *
     * @return The value that determines the relative load the URI should receive
     *         compared to others with the same priority
     */
    public final Integer getWeight() {
        return this.weight;
    }

    /**
     * Returns Whether the URL is enabled.
     *
     * @return Whether the URL is enabled
     */
    public final Boolean getEnabled() {
        return this.enabled;
    }

    /**
     * Returns The SIP address you want Twilio to route your Origination calls to.
     *
     * @return The SIP address you want Twilio to route your Origination calls to
     */
    public final URI getSipUrl() {
        return this.sipUrl;
    }

    /**
     * Returns The string that you assigned to describe the resource.
     *
     * @return The string that you assigned to describe the resource
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The relative importance of the URI.
     *
     * @return The relative importance of the URI
     */
    public final Integer getPriority() {
        return this.priority;
    }

    /**
     * Returns The RFC 2822 date and time in GMT when the resource was created.
     *
     * @return The RFC 2822 date and time in GMT when the resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The RFC 2822 date and time in GMT when the resource was last updated.
     *
     * @return The RFC 2822 date and time in GMT when the resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The absolute URL of the resource.
     *
     * @return The absolute URL of the resource
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OriginationUrl other = (OriginationUrl) o;

        return Objects.equals(accountSid, other.accountSid) &&
               Objects.equals(sid, other.sid) &&
               Objects.equals(trunkSid, other.trunkSid) &&
               Objects.equals(weight, other.weight) &&
               Objects.equals(enabled, other.enabled) &&
               Objects.equals(sipUrl, other.sipUrl) &&
               Objects.equals(friendlyName, other.friendlyName) &&
               Objects.equals(priority, other.priority) &&
               Objects.equals(dateCreated, other.dateCreated) &&
               Objects.equals(dateUpdated, other.dateUpdated) &&
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            sid,
                            trunkSid,
                            weight,
                            enabled,
                            sipUrl,
                            friendlyName,
                            priority,
                            dateCreated,
                            dateUpdated,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("sid", sid)
                          .add("trunkSid", trunkSid)
                          .add("weight", weight)
                          .add("enabled", enabled)
                          .add("sipUrl", sipUrl)
                          .add("friendlyName", friendlyName)
                          .add("priority", priority)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("url", url)
                          .toString();
    }
}