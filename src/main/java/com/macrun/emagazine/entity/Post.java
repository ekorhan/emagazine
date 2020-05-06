package com.macrun.emagazine.entity;

import com.macrun.emagazine.constant.Category;
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
    @ManyToOne(optional = false)
    private User createdBy;
    @Column(name = "category_id")
    @Enumerated(EnumType.ORDINAL)
    private Category category;
    @Column(name = "title")
    private String title;
    @Column(name = "post_content")
    private String content;
    @Column(name = "asset_id")
    private int assetId;
}
