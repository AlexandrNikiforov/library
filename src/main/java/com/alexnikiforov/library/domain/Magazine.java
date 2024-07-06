package com.alexnikiforov.library.domain;

public class Magazine extends LibraryItem {

    private String issue;
    public Magazine(String title, String issue) {
        super(title);
        this.issue = issue;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }
}
