package by.ampsoft;

import abstractfactory.RunAbstractFactory;
import enumerato.EnumerateRunner;
import exceptions.BusinessException;
import exceptions.MyRuntimeException;
import singleton.RunSingleton;
import singleton.Singleton;
import somepackage.SomeClass;

public class Main {

    public static void main(String[] args) throws Exception {
//        try {
//            callRuntimeMethod();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            callBusinessMethod();
//        } catch (BusinessException e) {
//            e.printStackTrace();
//        }
//        callWithError();
//        RunSingleton runSingleton = new RunSingleton();
//        runSingleton.call();

//        RunAbstractFactory runAbstractFactory = new RunAbstractFactory();
//        runAbstractFactory.call();

//        EnumerateRunner runEnumerate = new EnumerateRunner();
//        runEnumerate.call();

        for (int i = 0; i < 10; i++ )
        {
            new SomeClass(i);
            new SomeClass();
        }
    }

    public static void callRuntimeMethod(){
        throw new MyRuntimeException();
    }

    public static void callBusinessMethod() throws BusinessException {
        throw new BusinessException();
    }
    public static void callWithError(){
        String s = null;
        s.length();
    }
}
