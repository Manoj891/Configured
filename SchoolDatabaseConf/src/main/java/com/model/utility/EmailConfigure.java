package com.model.utility;

import javax.persistence.*;

@Entity
@Table(name = "email_configure")
public class EmailConfigure {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "send_email", length = 150)
    private String sendEmail;
    @Column(name = "email_password", length = 150)
    private String emailPassword;
    @Column(name = "smtp_host", length = 15)
    private String smtpHost;
    @Column(name = "smtp_port", length = 10)
    private String smtpPort;
    @Column(name = "starttls", columnDefinition = "varchar(5) default 'true'")
    private String starttls;
}
