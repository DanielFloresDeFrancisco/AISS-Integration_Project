
package AISS.GitLabMiner.models;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Project {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("name")
    private String name;
    @JsonProperty("name_with_namespace")
    private String nameWithNamespace;
    @JsonProperty("path")
    private String path;
    @JsonProperty("path_with_namespace")
    private String pathWithNamespace;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("default_branch")
    private String defaultBranch;
    @JsonProperty("tag_list")
    private List<Object> tagList;
    @JsonProperty("topics")
    private List<Object> topics;
    @JsonProperty("ssh_url_to_repo")
    private String sshUrlToRepo;
    @JsonProperty("http_url_to_repo")
    private String httpUrlToRepo;
    @JsonProperty("web_url")
    private String webUrl;
    @JsonProperty("readme_url")
    private Object readmeUrl;
    @JsonProperty("forks_count")
    private Integer forksCount;
    @JsonProperty("avatar_url")
    private Object avatarUrl;
    @JsonProperty("star_count")
    private Integer starCount;
    @JsonProperty("last_activity_at")
    private String lastActivityAt;
    @JsonProperty("namespace")
    private Namespace namespace;
    @JsonProperty("container_registry_image_prefix")
    private String containerRegistryImagePrefix;
    @JsonProperty("_links")
    private Links links;
    @JsonProperty("packages_enabled")
    private Boolean packagesEnabled;
    @JsonProperty("empty_repo")
    private Boolean emptyRepo;
    @JsonProperty("archived")
    private Boolean archived;
    @JsonProperty("visibility")
    private String visibility;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("resolve_outdated_diff_discussions")
    private Boolean resolveOutdatedDiffDiscussions;
    @JsonProperty("container_expiration_policy")
    private ContainerExpirationPolicy containerExpirationPolicy;
    @JsonProperty("issues_enabled")
    private Boolean issuesEnabled;
    @JsonProperty("merge_requests_enabled")
    private Boolean mergeRequestsEnabled;
    @JsonProperty("wiki_enabled")
    private Boolean wikiEnabled;
    @JsonProperty("jobs_enabled")
    private Boolean jobsEnabled;
    @JsonProperty("snippets_enabled")
    private Boolean snippetsEnabled;
    @JsonProperty("container_registry_enabled")
    private Boolean containerRegistryEnabled;
    @JsonProperty("service_desk_enabled")
    private Boolean serviceDeskEnabled;
    @JsonProperty("can_create_merge_request_in")
    private Boolean canCreateMergeRequestIn;
    @JsonProperty("issues_access_level")
    private String issuesAccessLevel;
    @JsonProperty("repository_access_level")
    private String repositoryAccessLevel;
    @JsonProperty("merge_requests_access_level")
    private String mergeRequestsAccessLevel;
    @JsonProperty("forking_access_level")
    private String forkingAccessLevel;
    @JsonProperty("wiki_access_level")
    private String wikiAccessLevel;
    @JsonProperty("builds_access_level")
    private String buildsAccessLevel;
    @JsonProperty("snippets_access_level")
    private String snippetsAccessLevel;
    @JsonProperty("pages_access_level")
    private String pagesAccessLevel;
    @JsonProperty("analytics_access_level")
    private String analyticsAccessLevel;
    @JsonProperty("container_registry_access_level")
    private String containerRegistryAccessLevel;
    @JsonProperty("security_and_compliance_access_level")
    private String securityAndComplianceAccessLevel;
    @JsonProperty("releases_access_level")
    private String releasesAccessLevel;
    @JsonProperty("environments_access_level")
    private String environmentsAccessLevel;
    @JsonProperty("feature_flags_access_level")
    private String featureFlagsAccessLevel;
    @JsonProperty("infrastructure_access_level")
    private String infrastructureAccessLevel;
    @JsonProperty("monitor_access_level")
    private String monitorAccessLevel;
    @JsonProperty("emails_disabled")
    private Object emailsDisabled;
    @JsonProperty("shared_runners_enabled")
    private Boolean sharedRunnersEnabled;
    @JsonProperty("lfs_enabled")
    private Boolean lfsEnabled;
    @JsonProperty("creator_id")
    private Integer creatorId;
    @JsonProperty("import_status")
    private String importStatus;
    @JsonProperty("open_issues_count")
    private Integer openIssuesCount;
    @JsonProperty("ci_config_path")
    private String ciConfigPath;
    @JsonProperty("public_jobs")
    private Boolean publicJobs;
    @JsonProperty("shared_with_groups")
    private List<Object> sharedWithGroups;
    @JsonProperty("only_allow_merge_if_pipeline_succeeds")
    private Boolean onlyAllowMergeIfPipelineSucceeds;
    @JsonProperty("allow_merge_on_skipped_pipeline")
    private Object allowMergeOnSkippedPipeline;
    @JsonProperty("request_access_enabled")
    private Boolean requestAccessEnabled;
    @JsonProperty("only_allow_merge_if_all_discussions_are_resolved")
    private Boolean onlyAllowMergeIfAllDiscussionsAreResolved;
    @JsonProperty("remove_source_branch_after_merge")
    private Boolean removeSourceBranchAfterMerge;
    @JsonProperty("printing_merge_request_link_enabled")
    private Boolean printingMergeRequestLinkEnabled;
    @JsonProperty("merge_method")
    private String mergeMethod;
    @JsonProperty("squash_option")
    private String squashOption;
    @JsonProperty("enforce_auth_checks_on_uploads")
    private Boolean enforceAuthChecksOnUploads;
    @JsonProperty("suggestion_commit_message")
    private Object suggestionCommitMessage;
    @JsonProperty("merge_commit_template")
    private Object mergeCommitTemplate;
    @JsonProperty("squash_commit_template")
    private Object squashCommitTemplate;
    @JsonProperty("issue_branch_template")
    private Object issueBranchTemplate;
    @JsonProperty("autoclose_referenced_issues")
    private Boolean autocloseReferencedIssues;
    @JsonProperty("external_authorization_classification_label")
    private String externalAuthorizationClassificationLabel;
    @JsonProperty("requirements_enabled")
    private Boolean requirementsEnabled;
    @JsonProperty("requirements_access_level")
    private String requirementsAccessLevel;
    @JsonProperty("security_and_compliance_enabled")
    private Boolean securityAndComplianceEnabled;
    @JsonProperty("compliance_frameworks")
    private List<Object> complianceFrameworks;
    @JsonProperty("permissions")
    private Permissions permissions;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("name_with_namespace")
    public String getNameWithNamespace() {
        return nameWithNamespace;
    }

    @JsonProperty("name_with_namespace")
    public void setNameWithNamespace(String nameWithNamespace) {
        this.nameWithNamespace = nameWithNamespace;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("path_with_namespace")
    public String getPathWithNamespace() {
        return pathWithNamespace;
    }

    @JsonProperty("path_with_namespace")
    public void setPathWithNamespace(String pathWithNamespace) {
        this.pathWithNamespace = pathWithNamespace;
    }

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("default_branch")
    public String getDefaultBranch() {
        return defaultBranch;
    }

    @JsonProperty("default_branch")
    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    @JsonProperty("tag_list")
    public List<Object> getTagList() {
        return tagList;
    }

    @JsonProperty("tag_list")
    public void setTagList(List<Object> tagList) {
        this.tagList = tagList;
    }

    @JsonProperty("topics")
    public List<Object> getTopics() {
        return topics;
    }

    @JsonProperty("topics")
    public void setTopics(List<Object> topics) {
        this.topics = topics;
    }

    @JsonProperty("ssh_url_to_repo")
    public String getSshUrlToRepo() {
        return sshUrlToRepo;
    }

    @JsonProperty("ssh_url_to_repo")
    public void setSshUrlToRepo(String sshUrlToRepo) {
        this.sshUrlToRepo = sshUrlToRepo;
    }

    @JsonProperty("http_url_to_repo")
    public String getHttpUrlToRepo() {
        return httpUrlToRepo;
    }

    @JsonProperty("http_url_to_repo")
    public void setHttpUrlToRepo(String httpUrlToRepo) {
        this.httpUrlToRepo = httpUrlToRepo;
    }

    @JsonProperty("web_url")
    public String getWebUrl() {
        return webUrl;
    }

    @JsonProperty("web_url")
    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    @JsonProperty("readme_url")
    public Object getReadmeUrl() {
        return readmeUrl;
    }

    @JsonProperty("readme_url")
    public void setReadmeUrl(Object readmeUrl) {
        this.readmeUrl = readmeUrl;
    }

    @JsonProperty("forks_count")
    public Integer getForksCount() {
        return forksCount;
    }

    @JsonProperty("forks_count")
    public void setForksCount(Integer forksCount) {
        this.forksCount = forksCount;
    }

    @JsonProperty("avatar_url")
    public Object getAvatarUrl() {
        return avatarUrl;
    }

    @JsonProperty("avatar_url")
    public void setAvatarUrl(Object avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    @JsonProperty("star_count")
    public Integer getStarCount() {
        return starCount;
    }

    @JsonProperty("star_count")
    public void setStarCount(Integer starCount) {
        this.starCount = starCount;
    }

    @JsonProperty("last_activity_at")
    public String getLastActivityAt() {
        return lastActivityAt;
    }

    @JsonProperty("last_activity_at")
    public void setLastActivityAt(String lastActivityAt) {
        this.lastActivityAt = lastActivityAt;
    }

    @JsonProperty("namespace")
    public Namespace getNamespace() {
        return namespace;
    }

    @JsonProperty("namespace")
    public void setNamespace(Namespace namespace) {
        this.namespace = namespace;
    }

    @JsonProperty("container_registry_image_prefix")
    public String getContainerRegistryImagePrefix() {
        return containerRegistryImagePrefix;
    }

    @JsonProperty("container_registry_image_prefix")
    public void setContainerRegistryImagePrefix(String containerRegistryImagePrefix) {
        this.containerRegistryImagePrefix = containerRegistryImagePrefix;
    }

    @JsonProperty("_links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("_links")
    public void setLinks(Links links) {
        this.links = links;
    }

    @JsonProperty("packages_enabled")
    public Boolean getPackagesEnabled() {
        return packagesEnabled;
    }

    @JsonProperty("packages_enabled")
    public void setPackagesEnabled(Boolean packagesEnabled) {
        this.packagesEnabled = packagesEnabled;
    }

    @JsonProperty("empty_repo")
    public Boolean getEmptyRepo() {
        return emptyRepo;
    }

    @JsonProperty("empty_repo")
    public void setEmptyRepo(Boolean emptyRepo) {
        this.emptyRepo = emptyRepo;
    }

    @JsonProperty("archived")
    public Boolean getArchived() {
        return archived;
    }

    @JsonProperty("archived")
    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    @JsonProperty("visibility")
    public String getVisibility() {
        return visibility;
    }

    @JsonProperty("visibility")
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @JsonProperty("owner")
    public Owner getOwner() {
        return owner;
    }

    @JsonProperty("owner")
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @JsonProperty("resolve_outdated_diff_discussions")
    public Boolean getResolveOutdatedDiffDiscussions() {
        return resolveOutdatedDiffDiscussions;
    }

    @JsonProperty("resolve_outdated_diff_discussions")
    public void setResolveOutdatedDiffDiscussions(Boolean resolveOutdatedDiffDiscussions) {
        this.resolveOutdatedDiffDiscussions = resolveOutdatedDiffDiscussions;
    }

    @JsonProperty("container_expiration_policy")
    public ContainerExpirationPolicy getContainerExpirationPolicy() {
        return containerExpirationPolicy;
    }

    @JsonProperty("container_expiration_policy")
    public void setContainerExpirationPolicy(ContainerExpirationPolicy containerExpirationPolicy) {
        this.containerExpirationPolicy = containerExpirationPolicy;
    }

    @JsonProperty("issues_enabled")
    public Boolean getIssuesEnabled() {
        return issuesEnabled;
    }

    @JsonProperty("issues_enabled")
    public void setIssuesEnabled(Boolean issuesEnabled) {
        this.issuesEnabled = issuesEnabled;
    }

    @JsonProperty("merge_requests_enabled")
    public Boolean getMergeRequestsEnabled() {
        return mergeRequestsEnabled;
    }

    @JsonProperty("merge_requests_enabled")
    public void setMergeRequestsEnabled(Boolean mergeRequestsEnabled) {
        this.mergeRequestsEnabled = mergeRequestsEnabled;
    }

    @JsonProperty("wiki_enabled")
    public Boolean getWikiEnabled() {
        return wikiEnabled;
    }

    @JsonProperty("wiki_enabled")
    public void setWikiEnabled(Boolean wikiEnabled) {
        this.wikiEnabled = wikiEnabled;
    }

    @JsonProperty("jobs_enabled")
    public Boolean getJobsEnabled() {
        return jobsEnabled;
    }

    @JsonProperty("jobs_enabled")
    public void setJobsEnabled(Boolean jobsEnabled) {
        this.jobsEnabled = jobsEnabled;
    }

    @JsonProperty("snippets_enabled")
    public Boolean getSnippetsEnabled() {
        return snippetsEnabled;
    }

    @JsonProperty("snippets_enabled")
    public void setSnippetsEnabled(Boolean snippetsEnabled) {
        this.snippetsEnabled = snippetsEnabled;
    }

    @JsonProperty("container_registry_enabled")
    public Boolean getContainerRegistryEnabled() {
        return containerRegistryEnabled;
    }

    @JsonProperty("container_registry_enabled")
    public void setContainerRegistryEnabled(Boolean containerRegistryEnabled) {
        this.containerRegistryEnabled = containerRegistryEnabled;
    }

    @JsonProperty("service_desk_enabled")
    public Boolean getServiceDeskEnabled() {
        return serviceDeskEnabled;
    }

    @JsonProperty("service_desk_enabled")
    public void setServiceDeskEnabled(Boolean serviceDeskEnabled) {
        this.serviceDeskEnabled = serviceDeskEnabled;
    }

    @JsonProperty("can_create_merge_request_in")
    public Boolean getCanCreateMergeRequestIn() {
        return canCreateMergeRequestIn;
    }

    @JsonProperty("can_create_merge_request_in")
    public void setCanCreateMergeRequestIn(Boolean canCreateMergeRequestIn) {
        this.canCreateMergeRequestIn = canCreateMergeRequestIn;
    }

    @JsonProperty("issues_access_level")
    public String getIssuesAccessLevel() {
        return issuesAccessLevel;
    }

    @JsonProperty("issues_access_level")
    public void setIssuesAccessLevel(String issuesAccessLevel) {
        this.issuesAccessLevel = issuesAccessLevel;
    }

    @JsonProperty("repository_access_level")
    public String getRepositoryAccessLevel() {
        return repositoryAccessLevel;
    }

    @JsonProperty("repository_access_level")
    public void setRepositoryAccessLevel(String repositoryAccessLevel) {
        this.repositoryAccessLevel = repositoryAccessLevel;
    }

    @JsonProperty("merge_requests_access_level")
    public String getMergeRequestsAccessLevel() {
        return mergeRequestsAccessLevel;
    }

    @JsonProperty("merge_requests_access_level")
    public void setMergeRequestsAccessLevel(String mergeRequestsAccessLevel) {
        this.mergeRequestsAccessLevel = mergeRequestsAccessLevel;
    }

    @JsonProperty("forking_access_level")
    public String getForkingAccessLevel() {
        return forkingAccessLevel;
    }

    @JsonProperty("forking_access_level")
    public void setForkingAccessLevel(String forkingAccessLevel) {
        this.forkingAccessLevel = forkingAccessLevel;
    }

    @JsonProperty("wiki_access_level")
    public String getWikiAccessLevel() {
        return wikiAccessLevel;
    }

    @JsonProperty("wiki_access_level")
    public void setWikiAccessLevel(String wikiAccessLevel) {
        this.wikiAccessLevel = wikiAccessLevel;
    }

    @JsonProperty("builds_access_level")
    public String getBuildsAccessLevel() {
        return buildsAccessLevel;
    }

    @JsonProperty("builds_access_level")
    public void setBuildsAccessLevel(String buildsAccessLevel) {
        this.buildsAccessLevel = buildsAccessLevel;
    }

    @JsonProperty("snippets_access_level")
    public String getSnippetsAccessLevel() {
        return snippetsAccessLevel;
    }

    @JsonProperty("snippets_access_level")
    public void setSnippetsAccessLevel(String snippetsAccessLevel) {
        this.snippetsAccessLevel = snippetsAccessLevel;
    }

    @JsonProperty("pages_access_level")
    public String getPagesAccessLevel() {
        return pagesAccessLevel;
    }

    @JsonProperty("pages_access_level")
    public void setPagesAccessLevel(String pagesAccessLevel) {
        this.pagesAccessLevel = pagesAccessLevel;
    }

    @JsonProperty("analytics_access_level")
    public String getAnalyticsAccessLevel() {
        return analyticsAccessLevel;
    }

    @JsonProperty("analytics_access_level")
    public void setAnalyticsAccessLevel(String analyticsAccessLevel) {
        this.analyticsAccessLevel = analyticsAccessLevel;
    }

    @JsonProperty("container_registry_access_level")
    public String getContainerRegistryAccessLevel() {
        return containerRegistryAccessLevel;
    }

    @JsonProperty("container_registry_access_level")
    public void setContainerRegistryAccessLevel(String containerRegistryAccessLevel) {
        this.containerRegistryAccessLevel = containerRegistryAccessLevel;
    }

    @JsonProperty("security_and_compliance_access_level")
    public String getSecurityAndComplianceAccessLevel() {
        return securityAndComplianceAccessLevel;
    }

    @JsonProperty("security_and_compliance_access_level")
    public void setSecurityAndComplianceAccessLevel(String securityAndComplianceAccessLevel) {
        this.securityAndComplianceAccessLevel = securityAndComplianceAccessLevel;
    }

    @JsonProperty("releases_access_level")
    public String getReleasesAccessLevel() {
        return releasesAccessLevel;
    }

    @JsonProperty("releases_access_level")
    public void setReleasesAccessLevel(String releasesAccessLevel) {
        this.releasesAccessLevel = releasesAccessLevel;
    }

    @JsonProperty("environments_access_level")
    public String getEnvironmentsAccessLevel() {
        return environmentsAccessLevel;
    }

    @JsonProperty("environments_access_level")
    public void setEnvironmentsAccessLevel(String environmentsAccessLevel) {
        this.environmentsAccessLevel = environmentsAccessLevel;
    }

    @JsonProperty("feature_flags_access_level")
    public String getFeatureFlagsAccessLevel() {
        return featureFlagsAccessLevel;
    }

    @JsonProperty("feature_flags_access_level")
    public void setFeatureFlagsAccessLevel(String featureFlagsAccessLevel) {
        this.featureFlagsAccessLevel = featureFlagsAccessLevel;
    }

    @JsonProperty("infrastructure_access_level")
    public String getInfrastructureAccessLevel() {
        return infrastructureAccessLevel;
    }

    @JsonProperty("infrastructure_access_level")
    public void setInfrastructureAccessLevel(String infrastructureAccessLevel) {
        this.infrastructureAccessLevel = infrastructureAccessLevel;
    }

    @JsonProperty("monitor_access_level")
    public String getMonitorAccessLevel() {
        return monitorAccessLevel;
    }

    @JsonProperty("monitor_access_level")
    public void setMonitorAccessLevel(String monitorAccessLevel) {
        this.monitorAccessLevel = monitorAccessLevel;
    }

    @JsonProperty("emails_disabled")
    public Object getEmailsDisabled() {
        return emailsDisabled;
    }

    @JsonProperty("emails_disabled")
    public void setEmailsDisabled(Object emailsDisabled) {
        this.emailsDisabled = emailsDisabled;
    }

    @JsonProperty("shared_runners_enabled")
    public Boolean getSharedRunnersEnabled() {
        return sharedRunnersEnabled;
    }

    @JsonProperty("shared_runners_enabled")
    public void setSharedRunnersEnabled(Boolean sharedRunnersEnabled) {
        this.sharedRunnersEnabled = sharedRunnersEnabled;
    }

    @JsonProperty("lfs_enabled")
    public Boolean getLfsEnabled() {
        return lfsEnabled;
    }

    @JsonProperty("lfs_enabled")
    public void setLfsEnabled(Boolean lfsEnabled) {
        this.lfsEnabled = lfsEnabled;
    }

    @JsonProperty("creator_id")
    public Integer getCreatorId() {
        return creatorId;
    }

    @JsonProperty("creator_id")
    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    @JsonProperty("import_status")
    public String getImportStatus() {
        return importStatus;
    }

    @JsonProperty("import_status")
    public void setImportStatus(String importStatus) {
        this.importStatus = importStatus;
    }

    @JsonProperty("open_issues_count")
    public Integer getOpenIssuesCount() {
        return openIssuesCount;
    }

    @JsonProperty("open_issues_count")
    public void setOpenIssuesCount(Integer openIssuesCount) {
        this.openIssuesCount = openIssuesCount;
    }

    @JsonProperty("ci_config_path")
    public String getCiConfigPath() {
        return ciConfigPath;
    }

    @JsonProperty("ci_config_path")
    public void setCiConfigPath(String ciConfigPath) {
        this.ciConfigPath = ciConfigPath;
    }

    @JsonProperty("public_jobs")
    public Boolean getPublicJobs() {
        return publicJobs;
    }

    @JsonProperty("public_jobs")
    public void setPublicJobs(Boolean publicJobs) {
        this.publicJobs = publicJobs;
    }

    @JsonProperty("shared_with_groups")
    public List<Object> getSharedWithGroups() {
        return sharedWithGroups;
    }

    @JsonProperty("shared_with_groups")
    public void setSharedWithGroups(List<Object> sharedWithGroups) {
        this.sharedWithGroups = sharedWithGroups;
    }

    @JsonProperty("only_allow_merge_if_pipeline_succeeds")
    public Boolean getOnlyAllowMergeIfPipelineSucceeds() {
        return onlyAllowMergeIfPipelineSucceeds;
    }

    @JsonProperty("only_allow_merge_if_pipeline_succeeds")
    public void setOnlyAllowMergeIfPipelineSucceeds(Boolean onlyAllowMergeIfPipelineSucceeds) {
        this.onlyAllowMergeIfPipelineSucceeds = onlyAllowMergeIfPipelineSucceeds;
    }

    @JsonProperty("allow_merge_on_skipped_pipeline")
    public Object getAllowMergeOnSkippedPipeline() {
        return allowMergeOnSkippedPipeline;
    }

    @JsonProperty("allow_merge_on_skipped_pipeline")
    public void setAllowMergeOnSkippedPipeline(Object allowMergeOnSkippedPipeline) {
        this.allowMergeOnSkippedPipeline = allowMergeOnSkippedPipeline;
    }

    @JsonProperty("request_access_enabled")
    public Boolean getRequestAccessEnabled() {
        return requestAccessEnabled;
    }

    @JsonProperty("request_access_enabled")
    public void setRequestAccessEnabled(Boolean requestAccessEnabled) {
        this.requestAccessEnabled = requestAccessEnabled;
    }

    @JsonProperty("only_allow_merge_if_all_discussions_are_resolved")
    public Boolean getOnlyAllowMergeIfAllDiscussionsAreResolved() {
        return onlyAllowMergeIfAllDiscussionsAreResolved;
    }

    @JsonProperty("only_allow_merge_if_all_discussions_are_resolved")
    public void setOnlyAllowMergeIfAllDiscussionsAreResolved(Boolean onlyAllowMergeIfAllDiscussionsAreResolved) {
        this.onlyAllowMergeIfAllDiscussionsAreResolved = onlyAllowMergeIfAllDiscussionsAreResolved;
    }

    @JsonProperty("remove_source_branch_after_merge")
    public Boolean getRemoveSourceBranchAfterMerge() {
        return removeSourceBranchAfterMerge;
    }

    @JsonProperty("remove_source_branch_after_merge")
    public void setRemoveSourceBranchAfterMerge(Boolean removeSourceBranchAfterMerge) {
        this.removeSourceBranchAfterMerge = removeSourceBranchAfterMerge;
    }

    @JsonProperty("printing_merge_request_link_enabled")
    public Boolean getPrintingMergeRequestLinkEnabled() {
        return printingMergeRequestLinkEnabled;
    }

    @JsonProperty("printing_merge_request_link_enabled")
    public void setPrintingMergeRequestLinkEnabled(Boolean printingMergeRequestLinkEnabled) {
        this.printingMergeRequestLinkEnabled = printingMergeRequestLinkEnabled;
    }

    @JsonProperty("merge_method")
    public String getMergeMethod() {
        return mergeMethod;
    }

    @JsonProperty("merge_method")
    public void setMergeMethod(String mergeMethod) {
        this.mergeMethod = mergeMethod;
    }

    @JsonProperty("squash_option")
    public String getSquashOption() {
        return squashOption;
    }

    @JsonProperty("squash_option")
    public void setSquashOption(String squashOption) {
        this.squashOption = squashOption;
    }

    @JsonProperty("enforce_auth_checks_on_uploads")
    public Boolean getEnforceAuthChecksOnUploads() {
        return enforceAuthChecksOnUploads;
    }

    @JsonProperty("enforce_auth_checks_on_uploads")
    public void setEnforceAuthChecksOnUploads(Boolean enforceAuthChecksOnUploads) {
        this.enforceAuthChecksOnUploads = enforceAuthChecksOnUploads;
    }

    @JsonProperty("suggestion_commit_message")
    public Object getSuggestionCommitMessage() {
        return suggestionCommitMessage;
    }

    @JsonProperty("suggestion_commit_message")
    public void setSuggestionCommitMessage(Object suggestionCommitMessage) {
        this.suggestionCommitMessage = suggestionCommitMessage;
    }

    @JsonProperty("merge_commit_template")
    public Object getMergeCommitTemplate() {
        return mergeCommitTemplate;
    }

    @JsonProperty("merge_commit_template")
    public void setMergeCommitTemplate(Object mergeCommitTemplate) {
        this.mergeCommitTemplate = mergeCommitTemplate;
    }

    @JsonProperty("squash_commit_template")
    public Object getSquashCommitTemplate() {
        return squashCommitTemplate;
    }

    @JsonProperty("squash_commit_template")
    public void setSquashCommitTemplate(Object squashCommitTemplate) {
        this.squashCommitTemplate = squashCommitTemplate;
    }

    @JsonProperty("issue_branch_template")
    public Object getIssueBranchTemplate() {
        return issueBranchTemplate;
    }

    @JsonProperty("issue_branch_template")
    public void setIssueBranchTemplate(Object issueBranchTemplate) {
        this.issueBranchTemplate = issueBranchTemplate;
    }

    @JsonProperty("autoclose_referenced_issues")
    public Boolean getAutocloseReferencedIssues() {
        return autocloseReferencedIssues;
    }

    @JsonProperty("autoclose_referenced_issues")
    public void setAutocloseReferencedIssues(Boolean autocloseReferencedIssues) {
        this.autocloseReferencedIssues = autocloseReferencedIssues;
    }

    @JsonProperty("external_authorization_classification_label")
    public String getExternalAuthorizationClassificationLabel() {
        return externalAuthorizationClassificationLabel;
    }

    @JsonProperty("external_authorization_classification_label")
    public void setExternalAuthorizationClassificationLabel(String externalAuthorizationClassificationLabel) {
        this.externalAuthorizationClassificationLabel = externalAuthorizationClassificationLabel;
    }

    @JsonProperty("requirements_enabled")
    public Boolean getRequirementsEnabled() {
        return requirementsEnabled;
    }

    @JsonProperty("requirements_enabled")
    public void setRequirementsEnabled(Boolean requirementsEnabled) {
        this.requirementsEnabled = requirementsEnabled;
    }

    @JsonProperty("requirements_access_level")
    public String getRequirementsAccessLevel() {
        return requirementsAccessLevel;
    }

    @JsonProperty("requirements_access_level")
    public void setRequirementsAccessLevel(String requirementsAccessLevel) {
        this.requirementsAccessLevel = requirementsAccessLevel;
    }

    @JsonProperty("security_and_compliance_enabled")
    public Boolean getSecurityAndComplianceEnabled() {
        return securityAndComplianceEnabled;
    }

    @JsonProperty("security_and_compliance_enabled")
    public void setSecurityAndComplianceEnabled(Boolean securityAndComplianceEnabled) {
        this.securityAndComplianceEnabled = securityAndComplianceEnabled;
    }

    @JsonProperty("compliance_frameworks")
    public List<Object> getComplianceFrameworks() {
        return complianceFrameworks;
    }

    @JsonProperty("compliance_frameworks")
    public void setComplianceFrameworks(List<Object> complianceFrameworks) {
        this.complianceFrameworks = complianceFrameworks;
    }

    @JsonProperty("permissions")
    public Permissions getPermissions() {
        return permissions;
    }

    @JsonProperty("permissions")
    public void setPermissions(Permissions permissions) {
        this.permissions = permissions;
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
        sb.append(Project.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("nameWithNamespace");
        sb.append('=');
        sb.append(((this.nameWithNamespace == null)?"<null>":this.nameWithNamespace));
        sb.append(',');
        sb.append("path");
        sb.append('=');
        sb.append(((this.path == null)?"<null>":this.path));
        sb.append(',');
        sb.append("pathWithNamespace");
        sb.append('=');
        sb.append(((this.pathWithNamespace == null)?"<null>":this.pathWithNamespace));
        sb.append(',');
        sb.append("createdAt");
        sb.append('=');
        sb.append(((this.createdAt == null)?"<null>":this.createdAt));
        sb.append(',');
        sb.append("defaultBranch");
        sb.append('=');
        sb.append(((this.defaultBranch == null)?"<null>":this.defaultBranch));
        sb.append(',');
        sb.append("tagList");
        sb.append('=');
        sb.append(((this.tagList == null)?"<null>":this.tagList));
        sb.append(',');
        sb.append("topics");
        sb.append('=');
        sb.append(((this.topics == null)?"<null>":this.topics));
        sb.append(',');
        sb.append("sshUrlToRepo");
        sb.append('=');
        sb.append(((this.sshUrlToRepo == null)?"<null>":this.sshUrlToRepo));
        sb.append(',');
        sb.append("httpUrlToRepo");
        sb.append('=');
        sb.append(((this.httpUrlToRepo == null)?"<null>":this.httpUrlToRepo));
        sb.append(',');
        sb.append("webUrl");
        sb.append('=');
        sb.append(((this.webUrl == null)?"<null>":this.webUrl));
        sb.append(',');
        sb.append("readmeUrl");
        sb.append('=');
        sb.append(((this.readmeUrl == null)?"<null>":this.readmeUrl));
        sb.append(',');
        sb.append("forksCount");
        sb.append('=');
        sb.append(((this.forksCount == null)?"<null>":this.forksCount));
        sb.append(',');
        sb.append("avatarUrl");
        sb.append('=');
        sb.append(((this.avatarUrl == null)?"<null>":this.avatarUrl));
        sb.append(',');
        sb.append("starCount");
        sb.append('=');
        sb.append(((this.starCount == null)?"<null>":this.starCount));
        sb.append(',');
        sb.append("lastActivityAt");
        sb.append('=');
        sb.append(((this.lastActivityAt == null)?"<null>":this.lastActivityAt));
        sb.append(',');
        sb.append("namespace");
        sb.append('=');
        sb.append(((this.namespace == null)?"<null>":this.namespace));
        sb.append(',');
        sb.append("containerRegistryImagePrefix");
        sb.append('=');
        sb.append(((this.containerRegistryImagePrefix == null)?"<null>":this.containerRegistryImagePrefix));
        sb.append(',');
        sb.append("links");
        sb.append('=');
        sb.append(((this.links == null)?"<null>":this.links));
        sb.append(',');
        sb.append("packagesEnabled");
        sb.append('=');
        sb.append(((this.packagesEnabled == null)?"<null>":this.packagesEnabled));
        sb.append(',');
        sb.append("emptyRepo");
        sb.append('=');
        sb.append(((this.emptyRepo == null)?"<null>":this.emptyRepo));
        sb.append(',');
        sb.append("archived");
        sb.append('=');
        sb.append(((this.archived == null)?"<null>":this.archived));
        sb.append(',');
        sb.append("visibility");
        sb.append('=');
        sb.append(((this.visibility == null)?"<null>":this.visibility));
        sb.append(',');
        sb.append("owner");
        sb.append('=');
        sb.append(((this.owner == null)?"<null>":this.owner));
        sb.append(',');
        sb.append("resolveOutdatedDiffDiscussions");
        sb.append('=');
        sb.append(((this.resolveOutdatedDiffDiscussions == null)?"<null>":this.resolveOutdatedDiffDiscussions));
        sb.append(',');
        sb.append("containerExpirationPolicy");
        sb.append('=');
        sb.append(((this.containerExpirationPolicy == null)?"<null>":this.containerExpirationPolicy));
        sb.append(',');
        sb.append("issuesEnabled");
        sb.append('=');
        sb.append(((this.issuesEnabled == null)?"<null>":this.issuesEnabled));
        sb.append(',');
        sb.append("mergeRequestsEnabled");
        sb.append('=');
        sb.append(((this.mergeRequestsEnabled == null)?"<null>":this.mergeRequestsEnabled));
        sb.append(',');
        sb.append("wikiEnabled");
        sb.append('=');
        sb.append(((this.wikiEnabled == null)?"<null>":this.wikiEnabled));
        sb.append(',');
        sb.append("jobsEnabled");
        sb.append('=');
        sb.append(((this.jobsEnabled == null)?"<null>":this.jobsEnabled));
        sb.append(',');
        sb.append("snippetsEnabled");
        sb.append('=');
        sb.append(((this.snippetsEnabled == null)?"<null>":this.snippetsEnabled));
        sb.append(',');
        sb.append("containerRegistryEnabled");
        sb.append('=');
        sb.append(((this.containerRegistryEnabled == null)?"<null>":this.containerRegistryEnabled));
        sb.append(',');
        sb.append("serviceDeskEnabled");
        sb.append('=');
        sb.append(((this.serviceDeskEnabled == null)?"<null>":this.serviceDeskEnabled));
        sb.append(',');
        sb.append("canCreateMergeRequestIn");
        sb.append('=');
        sb.append(((this.canCreateMergeRequestIn == null)?"<null>":this.canCreateMergeRequestIn));
        sb.append(',');
        sb.append("issuesAccessLevel");
        sb.append('=');
        sb.append(((this.issuesAccessLevel == null)?"<null>":this.issuesAccessLevel));
        sb.append(',');
        sb.append("repositoryAccessLevel");
        sb.append('=');
        sb.append(((this.repositoryAccessLevel == null)?"<null>":this.repositoryAccessLevel));
        sb.append(',');
        sb.append("mergeRequestsAccessLevel");
        sb.append('=');
        sb.append(((this.mergeRequestsAccessLevel == null)?"<null>":this.mergeRequestsAccessLevel));
        sb.append(',');
        sb.append("forkingAccessLevel");
        sb.append('=');
        sb.append(((this.forkingAccessLevel == null)?"<null>":this.forkingAccessLevel));
        sb.append(',');
        sb.append("wikiAccessLevel");
        sb.append('=');
        sb.append(((this.wikiAccessLevel == null)?"<null>":this.wikiAccessLevel));
        sb.append(',');
        sb.append("buildsAccessLevel");
        sb.append('=');
        sb.append(((this.buildsAccessLevel == null)?"<null>":this.buildsAccessLevel));
        sb.append(',');
        sb.append("snippetsAccessLevel");
        sb.append('=');
        sb.append(((this.snippetsAccessLevel == null)?"<null>":this.snippetsAccessLevel));
        sb.append(',');
        sb.append("pagesAccessLevel");
        sb.append('=');
        sb.append(((this.pagesAccessLevel == null)?"<null>":this.pagesAccessLevel));
        sb.append(',');
        sb.append("analyticsAccessLevel");
        sb.append('=');
        sb.append(((this.analyticsAccessLevel == null)?"<null>":this.analyticsAccessLevel));
        sb.append(',');
        sb.append("containerRegistryAccessLevel");
        sb.append('=');
        sb.append(((this.containerRegistryAccessLevel == null)?"<null>":this.containerRegistryAccessLevel));
        sb.append(',');
        sb.append("securityAndComplianceAccessLevel");
        sb.append('=');
        sb.append(((this.securityAndComplianceAccessLevel == null)?"<null>":this.securityAndComplianceAccessLevel));
        sb.append(',');
        sb.append("releasesAccessLevel");
        sb.append('=');
        sb.append(((this.releasesAccessLevel == null)?"<null>":this.releasesAccessLevel));
        sb.append(',');
        sb.append("environmentsAccessLevel");
        sb.append('=');
        sb.append(((this.environmentsAccessLevel == null)?"<null>":this.environmentsAccessLevel));
        sb.append(',');
        sb.append("featureFlagsAccessLevel");
        sb.append('=');
        sb.append(((this.featureFlagsAccessLevel == null)?"<null>":this.featureFlagsAccessLevel));
        sb.append(',');
        sb.append("infrastructureAccessLevel");
        sb.append('=');
        sb.append(((this.infrastructureAccessLevel == null)?"<null>":this.infrastructureAccessLevel));
        sb.append(',');
        sb.append("monitorAccessLevel");
        sb.append('=');
        sb.append(((this.monitorAccessLevel == null)?"<null>":this.monitorAccessLevel));
        sb.append(',');
        sb.append("emailsDisabled");
        sb.append('=');
        sb.append(((this.emailsDisabled == null)?"<null>":this.emailsDisabled));
        sb.append(',');
        sb.append("sharedRunnersEnabled");
        sb.append('=');
        sb.append(((this.sharedRunnersEnabled == null)?"<null>":this.sharedRunnersEnabled));
        sb.append(',');
        sb.append("lfsEnabled");
        sb.append('=');
        sb.append(((this.lfsEnabled == null)?"<null>":this.lfsEnabled));
        sb.append(',');
        sb.append("creatorId");
        sb.append('=');
        sb.append(((this.creatorId == null)?"<null>":this.creatorId));
        sb.append(',');
        sb.append("importStatus");
        sb.append('=');
        sb.append(((this.importStatus == null)?"<null>":this.importStatus));
        sb.append(',');
        sb.append("openIssuesCount");
        sb.append('=');
        sb.append(((this.openIssuesCount == null)?"<null>":this.openIssuesCount));
        sb.append(',');
        sb.append("ciConfigPath");
        sb.append('=');
        sb.append(((this.ciConfigPath == null)?"<null>":this.ciConfigPath));
        sb.append(',');
        sb.append("publicJobs");
        sb.append('=');
        sb.append(((this.publicJobs == null)?"<null>":this.publicJobs));
        sb.append(',');
        sb.append("sharedWithGroups");
        sb.append('=');
        sb.append(((this.sharedWithGroups == null)?"<null>":this.sharedWithGroups));
        sb.append(',');
        sb.append("onlyAllowMergeIfPipelineSucceeds");
        sb.append('=');
        sb.append(((this.onlyAllowMergeIfPipelineSucceeds == null)?"<null>":this.onlyAllowMergeIfPipelineSucceeds));
        sb.append(',');
        sb.append("allowMergeOnSkippedPipeline");
        sb.append('=');
        sb.append(((this.allowMergeOnSkippedPipeline == null)?"<null>":this.allowMergeOnSkippedPipeline));
        sb.append(',');
        sb.append("requestAccessEnabled");
        sb.append('=');
        sb.append(((this.requestAccessEnabled == null)?"<null>":this.requestAccessEnabled));
        sb.append(',');
        sb.append("onlyAllowMergeIfAllDiscussionsAreResolved");
        sb.append('=');
        sb.append(((this.onlyAllowMergeIfAllDiscussionsAreResolved == null)?"<null>":this.onlyAllowMergeIfAllDiscussionsAreResolved));
        sb.append(',');
        sb.append("removeSourceBranchAfterMerge");
        sb.append('=');
        sb.append(((this.removeSourceBranchAfterMerge == null)?"<null>":this.removeSourceBranchAfterMerge));
        sb.append(',');
        sb.append("printingMergeRequestLinkEnabled");
        sb.append('=');
        sb.append(((this.printingMergeRequestLinkEnabled == null)?"<null>":this.printingMergeRequestLinkEnabled));
        sb.append(',');
        sb.append("mergeMethod");
        sb.append('=');
        sb.append(((this.mergeMethod == null)?"<null>":this.mergeMethod));
        sb.append(',');
        sb.append("squashOption");
        sb.append('=');
        sb.append(((this.squashOption == null)?"<null>":this.squashOption));
        sb.append(',');
        sb.append("enforceAuthChecksOnUploads");
        sb.append('=');
        sb.append(((this.enforceAuthChecksOnUploads == null)?"<null>":this.enforceAuthChecksOnUploads));
        sb.append(',');
        sb.append("suggestionCommitMessage");
        sb.append('=');
        sb.append(((this.suggestionCommitMessage == null)?"<null>":this.suggestionCommitMessage));
        sb.append(',');
        sb.append("mergeCommitTemplate");
        sb.append('=');
        sb.append(((this.mergeCommitTemplate == null)?"<null>":this.mergeCommitTemplate));
        sb.append(',');
        sb.append("squashCommitTemplate");
        sb.append('=');
        sb.append(((this.squashCommitTemplate == null)?"<null>":this.squashCommitTemplate));
        sb.append(',');
        sb.append("issueBranchTemplate");
        sb.append('=');
        sb.append(((this.issueBranchTemplate == null)?"<null>":this.issueBranchTemplate));
        sb.append(',');
        sb.append("autocloseReferencedIssues");
        sb.append('=');
        sb.append(((this.autocloseReferencedIssues == null)?"<null>":this.autocloseReferencedIssues));
        sb.append(',');
        sb.append("externalAuthorizationClassificationLabel");
        sb.append('=');
        sb.append(((this.externalAuthorizationClassificationLabel == null)?"<null>":this.externalAuthorizationClassificationLabel));
        sb.append(',');
        sb.append("requirementsEnabled");
        sb.append('=');
        sb.append(((this.requirementsEnabled == null)?"<null>":this.requirementsEnabled));
        sb.append(',');
        sb.append("requirementsAccessLevel");
        sb.append('=');
        sb.append(((this.requirementsAccessLevel == null)?"<null>":this.requirementsAccessLevel));
        sb.append(',');
        sb.append("securityAndComplianceEnabled");
        sb.append('=');
        sb.append(((this.securityAndComplianceEnabled == null)?"<null>":this.securityAndComplianceEnabled));
        sb.append(',');
        sb.append("complianceFrameworks");
        sb.append('=');
        sb.append(((this.complianceFrameworks == null)?"<null>":this.complianceFrameworks));
        sb.append(',');
        sb.append("permissions");
        sb.append('=');
        sb.append(((this.permissions == null)?"<null>":this.permissions));
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
