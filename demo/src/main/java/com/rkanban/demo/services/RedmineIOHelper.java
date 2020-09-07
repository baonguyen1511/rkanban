package com.rkanban.demo.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.rkanban.demo.config.RedmineConfig;
import com.rkanban.demo.models.Issue;
import com.rkanban.demo.models.Project;
import com.rkanban.demo.utils.ContextManager;
import com.taskadapter.redmineapi.Params;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import com.taskadapter.redmineapi.internal.Transport;

public class RedmineIOHelper {

    // to make sure we all use the same config
    private static RedmineConfig getRedmineConfig() {
        return new RedmineConfig();
    }

    private RedmineManager mgr = RedmineManagerFactory.createWithUserAuth(
            getRedmineConfig().getURI(), getRedmineConfig().getLogin(),
            getRedmineConfig().getPassword());
    private Transport transport = mgr.getTransport();
    private ContextManager contextManager = new ContextManager();

    /**
     * Crawl a collection of project from systems
     * 
     * @return list of Project objects
     */
    public List<Project> getProjects() {
        try {
            List<Project> projects = new ArrayList<Project>();
            for (com.taskadapter.redmineapi.bean.Project project : mgr
                    .getProjectManager()
                    .getProjects()) {
                // Create a object to store data then push it into
                // the list
                Project obj = new Project();
                obj.setId(project.getId());
                obj.setIdentifier(project.getIdentifier());
                obj.setName(project.getName());
                obj.setStatus(project.getStatus());
                obj.setCreated_on(
                        new Timestamp(project.getCreatedOn().getTime()));
                obj.setUpdated_on(
                        new Timestamp(project.getUpdatedOn().getTime()));
                obj.setParent_id(project.getParentId());
                projects.add(obj);
            }
            return projects;
        } catch (RedmineException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Crawl a collection of filtered issue by parameter
     * 
     * @param
     * @return list of Issue objects
     */
    public List<Issue> getIssues(String projectKey, String tracker_id,
            String status_id) {
        try {
            List<Issue> issues = new ArrayList<Issue>();
            if (!contextManager.isNullOrEmpty(projectKey)) {
                for (com.taskadapter.redmineapi.bean.Issue issue : transport
                        .getObjectsList(
                                com.taskadapter.redmineapi.bean.Issue.class,
                                (new Params().add("tracker_id", tracker_id)
                                        .add("project_id", projectKey)
                                        .add("status_id", status_id))
                                                .getList())) {
                    // Create a temporary object to store data then push it into
                    // the list
                    Issue obj = new Issue();
                    obj.setId(issue.getId());
                    obj.setSubject(issue.getSubject());
                    obj.setAsignee(issue.getAssigneeName());
                    obj.setStatus(issue.getStatusId());
                    obj.setCreated_on(
                            new Timestamp(issue.getCreatedOn().getTime()));
                    obj.setUpdated_on(
                            new Timestamp(issue.getUpdatedOn().getTime()));
                    obj.setProject_id(issue.getProjectId());
                    issues.add(obj);
                }
                return issues;
            }
        } catch (RedmineException e) {
            e.printStackTrace();
        }
        return null;
    }
}
