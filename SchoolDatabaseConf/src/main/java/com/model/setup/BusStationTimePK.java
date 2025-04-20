/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.setup;

import lombok.EqualsAndHashCode;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@EqualsAndHashCode
public class BusStationTimePK implements Serializable {

    @Column(name = "BUS")
    private Long bus;
    @Column(name = "STATION")
    private Long station;
    @Column(name = "GO_RETURN")
    private String goReturn;

    public BusStationTimePK() {
    }

    public BusStationTimePK(Long bus, Long station, String goReturn) {
        this.bus = bus;
        this.station = station;
        this.goReturn = goReturn;
    }

    public Long getBus() {
        return bus;
    }

    public void setBus(Long bus) {
        this.bus = bus;
    }

    public Long getStation() {
        return station;
    }

    public void setStation(Long station) {
        this.station = station;
    }

    public String getGoReturn() {
        return goReturn;
    }

    public void setGoReturn(String goReturn) {
        this.goReturn = goReturn;
    }

}
