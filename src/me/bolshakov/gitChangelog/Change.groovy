package me.bolshakov.gitChangelog

public class Change {
    final String author;
    final String message;
    final int relativeCommitId;

    public Change(String author, String message, int relativeCommitId) {
        this.author = author;
        this.message = message;
        this.relativeCommitId = relativeCommitId;
    }
}
