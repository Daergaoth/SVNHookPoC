package com.daergaoth.svnhook.dto;

public class SVNPostCommitDTO {
    private String author;
    private String changed;
    private String log;
    private String rev;

    public SVNPostCommitDTO() {
    }

    public SVNPostCommitDTO(String author, String changed, String log, String rev) {
        this.author = author;
        this.changed = changed;
        this.log = log;
        this.rev = rev;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getChanged() {
        return changed;
    }

    public void setChanged(String changed) {
        this.changed = changed;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getRev() {
        return rev;
    }

    public void setRev(String rev) {
        this.rev = rev;
    }
}
