package com.macrun.emagazine.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    @Column(name = "id", unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "created_at")
    @Temporal(TemporalType.TIME)
    private Date createdAt;
    @Column(name = "updated_at")
    @Temporal(TemporalType.TIME)
    private Date updatedAt;
    @Column(name = "status")
    private boolean status;
}
