package com.javastart.response;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "screen_name",
        "is_closed",
        "type",
        "activity",
        "age_limits",
        "description",
        "members_count",
        "site",
        "photo_50",
        "photo_100",
        "photo_200"
})
@Generated("jsonschema2pojo")
public class Group {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("screen_name")
    private String screenName;
    @JsonProperty("is_closed")
    private Integer isClosed;
    @JsonProperty("type")
    private String type;
    @JsonProperty("activity")
    private String activity;
    @JsonProperty("age_limits")
    private Integer ageLimits;
    @JsonProperty("description")
    private String description;
    @JsonProperty("members_count")
    private Integer membersCount;
    @JsonProperty("site")
    private String site;
    @JsonProperty("photo_50")
    private String photo50;
    @JsonProperty("photo_100")
    private String photo100;
    @JsonProperty("photo_200")
    private String photo200;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("screen_name")
    public String getScreenName() {
        return screenName;
    }

    @JsonProperty("screen_name")
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    @JsonProperty("is_closed")
    public Integer getIsClosed() {
        return isClosed;
    }

    @JsonProperty("is_closed")
    public void setIsClosed(Integer isClosed) {
        this.isClosed = isClosed;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("activity")
    public String getActivity() {
        return activity;
    }

    @JsonProperty("activity")
    public void setActivity(String activity) {
        this.activity = activity;
    }

    @JsonProperty("age_limits")
    public Integer getAgeLimits() {
        return ageLimits;
    }

    @JsonProperty("age_limits")
    public void setAgeLimits(Integer ageLimits) {
        this.ageLimits = ageLimits;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("members_count")
    public Integer getMembersCount() {
        return membersCount;
    }

    @JsonProperty("members_count")
    public void setMembersCount(Integer membersCount) {
        this.membersCount = membersCount;
    }

    @JsonProperty("site")
    public String getSite() {
        return site;
    }

    @JsonProperty("site")
    public void setSite(String site) {
        this.site = site;
    }

    @JsonProperty("photo_50")
    public String getPhoto50() {
        return photo50;
    }

    @JsonProperty("photo_50")
    public void setPhoto50(String photo50) {
        this.photo50 = photo50;
    }

    @JsonProperty("photo_100")
    public String getPhoto100() {
        return photo100;
    }

    @JsonProperty("photo_100")
    public void setPhoto100(String photo100) {
        this.photo100 = photo100;
    }

    @JsonProperty("photo_200")
    public String getPhoto200() {
        return photo200;
    }

    @JsonProperty("photo_200")
    public void setPhoto200(String photo200) {
        this.photo200 = photo200;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}