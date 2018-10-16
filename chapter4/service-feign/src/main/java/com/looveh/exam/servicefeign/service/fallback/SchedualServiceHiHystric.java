package com.looveh.exam.servicefeign.service.fallback;

import com.looveh.exam.servicefeign.service.SchedualServiceHi;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry," + name;
    }
}
