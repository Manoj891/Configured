package com.model.utility;

import java.util.Date;

public interface IclockTransactionRes {
    long getId();

    String getEmpCode();

    Date getPunchTime();

    String getEmpId();
}
