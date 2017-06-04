package com.sun;

import com.sun.api.IOperation;
import com.sun.impl.PlusOperationImpl;
import com.sun.sapi.DivisionOperationImpl;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * Created by lebron374 on 2017/6/4.
 */
public class DemoRun {
    public static void main(String[] args) throws Exception {
        IOperation plus = new PlusOperationImpl();
        IOperation division = new DivisionOperationImpl();

        // 直接方法调用
        System.out.println(plus.operation(12, 2));
        System.out.println(division.operation(12, 2));

        // ServiceLoader实现的javaspi服务
        ServiceLoader<IOperation> operations = ServiceLoader.load(IOperation.class);
        Iterator<IOperation> operationIterator = operations.iterator();
        while (operationIterator.hasNext()) {
            IOperation operation = operationIterator.next();
            System.out.println(operation.operation(12, 2));
        }

        // 自定义serviceLoader实现javaspi服务
        List<IOperation> operationList = SelfServiceLoader.load(IOperation.class);
        for (IOperation operation:operationList) {
            System.out.println(operation.operation(12, 3));
        }
    }
}
