package com.softSwiss.tasks.firstTask;

import org.testng.annotations.Factory;

public class Runner {

    @Factory
    public Object[] startCases(){
        return new Object[] { new Tests()};
    }
}
