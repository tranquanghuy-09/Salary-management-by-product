/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

/**
 *
 * @author huylauri
 */
public class DoubleTriple {
    private double first;  //Hệ số lương
    private double second; //Số ngày làm thực tế
    private double third;  //Sô ngày nghỉ phép

    public DoubleTriple() {
    }

    public DoubleTriple(double first, double second, double third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public double getSecond() {
        return second;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    public double getThird() {
        return third;
    }

    public void setThird(double third) {
        this.third = third;
    }

    @Override
    public String toString() {
        return "DoubleTriple{" + "first=" + first + ", second=" + second + ", third=" + third + '}';
    }

    
   
    
}
