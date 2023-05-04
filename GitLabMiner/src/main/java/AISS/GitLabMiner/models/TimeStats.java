
package AISS.GitLabMiner.models;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class TimeStats {

    @JsonProperty("time_estimate")
    private Integer timeEstimate;
    @JsonProperty("total_time_spent")
    private Integer totalTimeSpent;
    @JsonProperty("human_time_estimate")
    private Object humanTimeEstimate;
    @JsonProperty("human_total_time_spent")
    private Object humanTotalTimeSpent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("time_estimate")
    public Integer getTimeEstimate() {
        return timeEstimate;
    }

    @JsonProperty("time_estimate")
    public void setTimeEstimate(Integer timeEstimate) {
        this.timeEstimate = timeEstimate;
    }

    @JsonProperty("total_time_spent")
    public Integer getTotalTimeSpent() {
        return totalTimeSpent;
    }

    @JsonProperty("total_time_spent")
    public void setTotalTimeSpent(Integer totalTimeSpent) {
        this.totalTimeSpent = totalTimeSpent;
    }

    @JsonProperty("human_time_estimate")
    public Object getHumanTimeEstimate() {
        return humanTimeEstimate;
    }

    @JsonProperty("human_time_estimate")
    public void setHumanTimeEstimate(Object humanTimeEstimate) {
        this.humanTimeEstimate = humanTimeEstimate;
    }

    @JsonProperty("human_total_time_spent")
    public Object getHumanTotalTimeSpent() {
        return humanTotalTimeSpent;
    }

    @JsonProperty("human_total_time_spent")
    public void setHumanTotalTimeSpent(Object humanTotalTimeSpent) {
        this.humanTotalTimeSpent = humanTotalTimeSpent;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TimeStats.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("timeEstimate");
        sb.append('=');
        sb.append(((this.timeEstimate == null)?"<null>":this.timeEstimate));
        sb.append(',');
        sb.append("totalTimeSpent");
        sb.append('=');
        sb.append(((this.totalTimeSpent == null)?"<null>":this.totalTimeSpent));
        sb.append(',');
        sb.append("humanTimeEstimate");
        sb.append('=');
        sb.append(((this.humanTimeEstimate == null)?"<null>":this.humanTimeEstimate));
        sb.append(',');
        sb.append("humanTotalTimeSpent");
        sb.append('=');
        sb.append(((this.humanTotalTimeSpent == null)?"<null>":this.humanTotalTimeSpent));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
