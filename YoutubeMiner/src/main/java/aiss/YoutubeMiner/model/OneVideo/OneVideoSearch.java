package aiss.YoutubeMiner.model.OneVideo;

import aiss.YoutubeMiner.model.videoSnippet.VideoSnippetSearch;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class OneVideoSearch {
    @JsonProperty("items")
    private List<OneVideoSnippet> items;

    @JsonProperty("items")
    public List<OneVideoSnippet> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<OneVideoSnippet> items) {
        this.items = items;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VideoSnippetSearch.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("items");
        sb.append('=');
        sb.append(((this.items == null)?"<null>":this.items));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}
