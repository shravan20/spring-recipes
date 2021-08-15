package com.example.employee.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories
@EnableJpaAuditing
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Audit {

    @JsonFormat(
            shape = JsonFormat.Shape.STRING
    )
    @CreatedDate
    private Timestamp createdAt;

    @CreatedBy
    private String createdBy;

    @JsonFormat(
            shape = JsonFormat.Shape.STRING
    )
    @LastModifiedDate
    private Timestamp updatedAt;

    @LastModifiedBy
    private String updatedBy;
}
