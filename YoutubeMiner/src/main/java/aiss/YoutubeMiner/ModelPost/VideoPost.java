package aiss.YoutubeMiner.ModelPost;

import aiss.YoutubeMiner.model.caption.Caption;
import aiss.YoutubeMiner.model.comment.Comment;
import aiss.YoutubeMiner.model.videoSnippet.VideoSnippetId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoPost {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("releaseTime")
    private String releaseTime;

    @JsonProperty("comments")
    private List<CommentPost> comments;

    @JsonProperty("captions")
    private List<CaptionPost> captions;

    public VideoPost(String id, String name, String description, String releaseTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseTime = releaseTime;
        this.comments = new ArrayList<>();
        this.captions = new ArrayList<>();
    }

    public VideoPost(String id, String name, String description, String releaseTime, List<CommentPost> comments, List<CaptionPost> captions) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.releaseTime = releaseTime;
        this.comments = new ArrayList<>(comments);
        this.captions = new ArrayList<>(captions);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public List<CommentPost> getComments() {
        return comments;
    }

    public void setComments(List<CommentPost> comments) {
        this.comments = comments;
    }

    public List<CaptionPost> getCaptions() {
        return captions;
    }

    public void setCaptions(List<CaptionPost> captions) {
        this.captions = captions;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                ", comments=" + comments +
                ", captions=" + captions +
                '}';
    }
}
