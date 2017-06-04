package test.com.sun.sapi; 

import com.sun.sapi.PlusOperationImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* PlusOperationImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 4, 2017</pre> 
* @version 1.0 
*/ 
public class PlusOperationImplTest { 

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
    *
    * Method: operation(int numberA, int numberB)
    *
    */
    @Test
    public void testOperation() throws Exception {
        PlusOperationImpl operation = new PlusOperationImpl();
        int result = operation.operation(12, 4);

        Assert.assertEquals(result, 16);
    }

} 
