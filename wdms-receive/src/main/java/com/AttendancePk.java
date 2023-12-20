package com;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class AttendancePk implements Serializable {

    private long id;
    private int branch;

    @Override
    public String toString() {
        return "{\"id\":\"" + id + "\",\"branch\":\"" + branch + "\"}";
    }
}
