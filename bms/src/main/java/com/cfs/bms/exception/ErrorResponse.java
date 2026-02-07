package com.cfs.bms.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private Date timestamp;
    private String error;
    private String message;
    private String path;

    public ErrorResponse(Date date, int value, String notFound, String message, String description) {
    }
}
