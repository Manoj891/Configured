package com.mode;

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
