package com.macrun.emagazine.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_comment")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserComment extends BaseEntity {
    @JoinColumn(name = "created_by")
    @ManyToOne(optional = false)
    private User createdBy;
    @JoinColumn(name = "post_id")
    @ManyToOne(optional = false)
    private Post post;
    @Column(name = "comment_content")
    private String content;
}
