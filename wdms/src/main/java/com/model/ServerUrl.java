package com.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "server_url")
public class ServerUrl {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "url")
    private String url;

}
