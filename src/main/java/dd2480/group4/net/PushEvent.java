package dd2480.group4.net;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Json classes to get information from request from GitHub
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PushEvent {

    @JsonProperty("repository")
    public Repository repository;
    @JsonProperty("after")
    public String hashId;
    @JsonProperty("pusher")
    public Pusher pusher;

    /**
     * @param json the json file to read
     * @return a class representation of the json request.
     * @throws IOException Fails to read the JSON.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static PushEvent fromJson(String json) throws IOException {
        var mapper = new ObjectMapper();
        return mapper.readValue(json, PushEvent.class);
    }

    /**
     * The class represents the repository
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Repository {
        @JsonProperty("name")
        public String name;
        @JsonProperty("owner")
        public Owner owner;
        @JsonProperty("git_url")
        public String url;
    }

    /**
     * The class represents the pusher of the commit.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Pusher {
        @JsonProperty("email")
        public String email;
        @JsonProperty("name")
        public String name;

    }

    /**
     * The class represents the owner of the repository.
     */
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Owner {
        @JsonProperty("name")
        public String name;
    }
}
