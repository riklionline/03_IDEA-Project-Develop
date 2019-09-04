package com.factorypattern;

public class Calculator {
    public static void main(String[] args) {
        ICalculator iCalc = CalculatorFactory.getICalculator("减");
        if(iCalc!=null){
            iCalc.start();
        }
    }
}

class CalculatorFactory{
    public static ICalculator getICalculator(String name){
        if("加".equals(name)){
            return new Add();
        }else if("减".equals(name)){
            return new Sub();
        }else if("乘".equals(name)) {
            return new Mul();
        }else if("除".equals(name)) {
            return new Div();
        }else{
            return null;
        }
    }
}

interface ICalculator{
    public void start();
}
class Add implements ICalculator{
    @Override
    public void start() {
        System.out.println("正在使用加法计算器……");
    }
}
class Sub implements ICalculator{
    @Override
    public void start() {
        System.out.println("正在使用减法计算器……");
    }
}
class Mul implements ICalculator{
    @Override
    public void start() {
        System.out.println("正在使用乘法计算器……");
    }
}
class Div implements ICalculator{
    @Override
    public void start() {
        System.out.println("正在使用除法计算器……");
    }
}