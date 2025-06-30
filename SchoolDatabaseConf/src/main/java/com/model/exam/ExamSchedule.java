package com.model.exam;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "exam_schedule")
public class ExamSchedule {
    @Id
    private long id;
    private long examId;
    private long programId;
    private long classId;
    @Column(name = "exam_date")
    @Temporal(TemporalType.DATE)
    private Date examDate;
    @Column(name = "start_time")
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "end_time")
    @Temporal(TemporalType.TIME)
    private Date endTime;

}
