package com.macrun.emagazine.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "post")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Post extends BaseEntity {
    @JoinColumn(name = "created_by")
    @ManyToOne
    private User createdBy;
    @Column(name = "category_id")
    private Integer category;
    @Column(name = "title")
    private String title;
    @Column(name = "post_content")
    private String content;
    @Column(name = "asset_id")
    private Integer assetId;

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAssetId() {
        return assetId;
    }

    public void setAssetId(Integer assetId) {
        this.assetId = assetId;
    }
}
