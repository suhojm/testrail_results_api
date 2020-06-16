package rest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TestResult {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String title;

    private String testrailId;

    private String status;

    private String jiraInfo;

    private String automationDefect;

    private String comment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTestrailId() {
        return testrailId;
    }

    public void setTestrailId(String testrailId) {
        this.testrailId = testrailId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getJiraInfo() {
        return jiraInfo;
    }

    public void setJiraInfo(String jiraInfo) {
        this.jiraInfo = jiraInfo;
    }

    public String getAutomationDefect() {
        return automationDefect;
    }

    public void setAutomationDefect(String automationDefect) {
        this.automationDefect = automationDefect;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
