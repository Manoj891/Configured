/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dto;

/**
 *
 * @author MS
 */
public class ThirtPartSMSReq {

    private String mobileNo;
    private String text;

    public ThirtPartSMSReq() {
    }

    public ThirtPartSMSReq(String mobileNo, String text) {
        this.mobileNo = mobileNo;
        this.text = text;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
