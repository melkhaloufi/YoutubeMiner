package aiss.YoutubeMiner.model.OneVideo;

import aiss.YoutubeMiner.model.caption.Caption;
import aiss.YoutubeMiner.model.comment.Comment;
import aiss.YoutubeMiner.model.videoSnippet.VideoSnippet;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OneVideo {
    @JsonProperty("id")
    private String id;
    @JsonProperty("snippet")
    private OneVideoSnippet snippet;

    // These attributes have been manually added
    @JsonProperty("comments")
    private List<Comment> comments;

    @JsonProperty("captions")
    private List<Caption> captions;

    public OneVideo() {
        this.comments = new ArrayList<>();
        this.captions = new ArrayList<>();
    }

    @JsonProperty("comments")
    public List<Comment> getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @JsonProperty("captions")
    public List<Caption> getCaptions() { return captions; }

    @JsonProperty("captions")
    public void setCaptions(List<Caption> captions) {
        this.captions = captions;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("snippet")
    public OneVideoSnippet getSnippet() {
        return snippet;
    }

    @JsonProperty("snippet")
    public void setSnippet(OneVideoSnippet snippet) {
        this.snippet = snippet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VideoSnippet.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("snippet");
        sb.append('=');
        sb.append(((this.snippet == null)?"<null>":this.snippet));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}
