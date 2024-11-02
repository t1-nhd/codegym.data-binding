package com.codegym.formbindingemailconfiguration.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class EmailConfiguration {
    private String language;
    private int pageSize;
    private boolean spamFilterEnabled;
    private String signature;
    private String subSignature;
}
