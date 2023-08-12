package com.model.utility;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sms_configuration")
public class SmsConfiguration {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "request_ip")
    private String requestIp;
    @Column(name = "context")
    private String context;
    @Column(name = "token")
    private String token;
    @Column(name = "rate")
    private float rate;
    @Column(name = "created_by", length = 30)
    private String createdBy;
    @Column(name = "created_date", length = 30)
    private String createdDate;
}
