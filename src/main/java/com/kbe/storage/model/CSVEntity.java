package com.kbe.storage.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class CSVEntity {

    @Id
    private UUID id;
    private String url;
    private int upvotes;
    private int downvotes;
    private float upvoteRate;
    private float downvoteRate;
    private String title;
    private String author;
    private String description;
    private String topic;
    private int fileSize;
    private int imageWidth;
    private int imageHeight;
    private int frameCount;
    private String duration;

    public CSVEntity(UUID id, String url, int upvotes, int downvotes, float upvoteRate, float downvoteRate, String title, String author, String description, String topic, int fileSize, int imageWidth, int imageHeight, int frameCount, String duration) {
        this.id = id;
        this.url = url;
        this.upvotes = upvotes;
        this.downvotes = downvotes;
        this.upvoteRate = upvoteRate;
        this.downvoteRate = downvoteRate;
        this.title = title;
        this.author = author;
        this.description = description;
        this.topic = topic;
        this.fileSize = fileSize;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
        this.frameCount = frameCount;
        this.duration = duration;
    }

    public CSVEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }

    public float getUpvoteRate() {
        return upvoteRate;
    }

    public void setUpvoteRate(float upvoteRate) {
        this.upvoteRate = upvoteRate;
    }

    public float getDownvoteRate() {
        return downvoteRate;
    }

    public void setDownvoteRate(float downvoteRate) {
        this.downvoteRate = downvoteRate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getFrameCount() {
        return frameCount;
    }

    public void setFrameCount(int frameCount) {
        this.frameCount = frameCount;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
