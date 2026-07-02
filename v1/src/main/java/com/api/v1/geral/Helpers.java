package com.api.v1.geral;

import org.springframework.data.mongodb.core.query.Query;

public class Helpers {
    
    public static Query getQuery() {
        return new Query();
    }
}
