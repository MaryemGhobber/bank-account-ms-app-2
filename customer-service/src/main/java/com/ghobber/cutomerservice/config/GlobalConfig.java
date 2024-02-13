package com.ghobber.cutomerservice.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;


//solution2
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@ConfigurationProperties(prefix = "global.params")
public class GlobalConfig {
    int p1;
    int p2;
}
