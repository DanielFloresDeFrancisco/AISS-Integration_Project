
package AISS.GitLabMiner.models;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "project_access",
    "group_access"
})
public class Permissions {

    @JsonProperty("project_access")
    private Object projectAccess;
    @JsonProperty("group_access")
    private Object groupAccess;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("project_access")
    public Object getProjectAccess() {
        return projectAccess;
    }

    @JsonProperty("project_access")
    public void setProjectAccess(Object projectAccess) {
        this.projectAccess = projectAccess;
    }

    @JsonProperty("group_access")
    public Object getGroupAccess() {
        return groupAccess;
    }

    @JsonProperty("group_access")
    public void setGroupAccess(Object groupAccess) {
        this.groupAccess = groupAccess;
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
        sb.append(Permissions.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("projectAccess");
        sb.append('=');
        sb.append(((this.projectAccess == null)?"<null>":this.projectAccess));
        sb.append(',');
        sb.append("groupAccess");
        sb.append('=');
        sb.append(((this.groupAccess == null)?"<null>":this.groupAccess));
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
