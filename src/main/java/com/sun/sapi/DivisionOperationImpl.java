package com.sun.sapi;

import com.sun.api.IOperation;

/**
 * Created by lebron374 on 2017/6/4.
 */
public class DivisionOperationImpl implements IOperation {
    public int operation(int numberA, int numberB) {
        return numberA / numberB;
    }
}
