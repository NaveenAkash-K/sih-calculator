package com.project.sihcalci.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;
import com.project.sihcalci.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    private AuthService authService;

    public String firstQuery(){
        return authService.firstQuery();
    }

}
