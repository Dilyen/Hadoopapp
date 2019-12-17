package io.turntabl.Hadoopapp.model;

public class TweetsTO {

    private String id;
    private String name;
    private String screenName;
    private String location;

    public TweetsTO(String id, String name, String screenName, String location, int reTweetCount, int followersCount) {
        this.id = id;
        this.name = name;
        this.screenName = screenName;
        this.location = location;
        this.reTweetCount = reTweetCount;
        this.followersCount = followersCount;
    }

    private int reTweetCount;
    private int followersCount;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getLocation() {
        return location;
    }

    public int getReTweetCount() {
        return reTweetCount;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setReTweetCount(int reTweetCount) {
        this.reTweetCount = reTweetCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }
}
