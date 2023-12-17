package com.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PushData {
    private long id;
    private String empCode;
    private String punchTime;
    private String empId;
}
