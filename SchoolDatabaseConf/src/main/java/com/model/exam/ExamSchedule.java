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
    @Column(name = "id")
    private long id;
    @Column(name = "exam_id",nullable = false)
    private long examId;
    @Column(name = "program_id",nullable = false)
    private long programId;
    @Column(name = "class_id",nullable = false)
    private long classId;
    @Column(name = "exam_date",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date examDate;
    @Column(name = "start_time",nullable = false)
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @Column(name = "end_time",nullable = false)
    @Temporal(TemporalType.TIME)
    private Date endTime;


}
