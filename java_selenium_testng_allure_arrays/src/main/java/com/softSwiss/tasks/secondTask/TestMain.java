package com.softSwiss.tasks.secondTask;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestMain {

    @Test
    public void testUploadFilesAndGetArrayOfUniqueElements(){
        Main main = new Main();
        Assert.assertEquals(main.uploadFilesAndGetArrayOfUniqueElements(), new int[] {1,2,3,5,6,7});
    }
}
