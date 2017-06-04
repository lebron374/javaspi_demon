package com.sun.sapi;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lebron374 on 2017/6/4.
 */
public class DivisionOperationImplTest {

    @Test
    public void testOperation() throws Exception {
        DivisionOperationImpl operation = new DivisionOperationImpl();
        int result = operation.operation(12, 3);
        Assert.assertEquals(result, 4);
    }
}