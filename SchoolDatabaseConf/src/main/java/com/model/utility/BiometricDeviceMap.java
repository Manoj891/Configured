package com.model.utility;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "biometric_device_map", indexes = {
        @Index(name = "index_biometric_device_map_student_id", columnList = "student_id", unique = true),
        @Index(name = "index_biometric_device_map_emp_id", columnList = "emp_id", unique = true),
        @Index(name = "index_biometric_device_map_device_id", columnList = "device_id", unique = true)
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BiometricDeviceMap {
    @Id
    @Column(name = "id", length = 50)
    private String id;
    @Column(name = "user_type", length = 10)
    private String userType;
    @Column(name = "student_id")
    private Long studentId;
    @Column(name = "emp_id")
    private Long empId;
    @Column(name = "device_id", nullable = false)
    private Long deviceId;
}
