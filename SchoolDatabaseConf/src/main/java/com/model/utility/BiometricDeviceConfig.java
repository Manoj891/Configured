package com.model.utility;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "biometric_device_config")
public class BiometricDeviceConfig {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "serial_number", length = 15)
    private String serialNumber;
    @Column(name = "device_name", length = 20)
    private String deviceName;
    @Column(name = "branch_id")
    private Integer branchId;
    @Column(name = "password",length = 50)
    private String password;
}
