package com.example.demo.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author LHB
 * @version V1.0
 * @Description: TODO
 * @date 2020/5/13 10:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseEntity<T> {

    public ResponseEntity(T data){
        this.data = data;
    }
    private int status = 200;

    private String code = "1";

    private String error;

    private Long timestamp = new Date().getTime();

    private String message;

    private String path;

    private T data;
}
