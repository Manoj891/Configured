package com.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServerUrlReq {
    private String url;
    private String password;
}
