
package AISS.GitLabMiner.models;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


public class ContainerExpirationPolicy {

    @JsonProperty("cadence")
    private String cadence;
    @JsonProperty("enabled")
    private Boolean enabled;
    @JsonProperty("keep_n")
    private Integer keepN;
    @JsonProperty("older_than")
    private String olderThan;
    @JsonProperty("name_regex")
    private String nameRegex;
    @JsonProperty("name_regex_keep")
    private Object nameRegexKeep;
    @JsonProperty("next_run_at")
    private String nextRunAt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("cadence")
    public String getCadence() {
        return cadence;
    }

    @JsonProperty("cadence")
    public void setCadence(String cadence) {
        this.cadence = cadence;
    }

    @JsonProperty("enabled")
    public Boolean getEnabled() {
        return enabled;
    }

    @JsonProperty("enabled")
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @JsonProperty("keep_n")
    public Integer getKeepN() {
        return keepN;
    }

    @JsonProperty("keep_n")
    public void setKeepN(Integer keepN) {
        this.keepN = keepN;
    }

    @JsonProperty("older_than")
    public String getOlderThan() {
        return olderThan;
    }

    @JsonProperty("older_than")
    public void setOlderThan(String olderThan) {
        this.olderThan = olderThan;
    }

    @JsonProperty("name_regex")
    public String getNameRegex() {
        return nameRegex;
    }

    @JsonProperty("name_regex")
    public void setNameRegex(String nameRegex) {
        this.nameRegex = nameRegex;
    }

    @JsonProperty("name_regex_keep")
    public Object getNameRegexKeep() {
        return nameRegexKeep;
    }

    @JsonProperty("name_regex_keep")
    public void setNameRegexKeep(Object nameRegexKeep) {
        this.nameRegexKeep = nameRegexKeep;
    }

    @JsonProperty("next_run_at")
    public String getNextRunAt() {
        return nextRunAt;
    }

    @JsonProperty("next_run_at")
    public void setNextRunAt(String nextRunAt) {
        this.nextRunAt = nextRunAt;
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
        sb.append(ContainerExpirationPolicy.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cadence");
        sb.append('=');
        sb.append(((this.cadence == null)?"<null>":this.cadence));
        sb.append(',');
        sb.append("enabled");
        sb.append('=');
        sb.append(((this.enabled == null)?"<null>":this.enabled));
        sb.append(',');
        sb.append("keepN");
        sb.append('=');
        sb.append(((this.keepN == null)?"<null>":this.keepN));
        sb.append(',');
        sb.append("olderThan");
        sb.append('=');
        sb.append(((this.olderThan == null)?"<null>":this.olderThan));
        sb.append(',');
        sb.append("nameRegex");
        sb.append('=');
        sb.append(((this.nameRegex == null)?"<null>":this.nameRegex));
        sb.append(',');
        sb.append("nameRegexKeep");
        sb.append('=');
        sb.append(((this.nameRegexKeep == null)?"<null>":this.nameRegexKeep));
        sb.append(',');
        sb.append("nextRunAt");
        sb.append('=');
        sb.append(((this.nextRunAt == null)?"<null>":this.nextRunAt));
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
