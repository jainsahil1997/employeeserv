package com.paypal.bfs.test.employeeserv.util;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Errors {

    private String field;
    private String message;
}
