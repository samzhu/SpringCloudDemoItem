package com.sam.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Persistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by samchu on 2016/12/6.
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class) //加這行 CreatedBy 才會生效
public class Item implements Persistable<Long> {
    @Id
    @GeneratedValue
    private Long itemid;

    @NotNull @NotEmpty
    private String name;

    @NotNull
    private Integer price;

    @CreatedBy
    private String createdBy;
    @CreatedDate
    private Date createdDate;

    @LastModifiedBy
    private String lastModifiedBy;
    @LastModifiedDate
    private Date lastModifiedDate;

    @Override
    public Long getId() {
        return itemid;
    }

    @JsonIgnore
    @Override
    public boolean isNew() {
        return createdDate == null;
    }
}
