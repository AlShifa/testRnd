package com.ddlab.core;

 class D {
 D(){
 f1();
 }
 void f1(){ System.out.println("D"+this);}
 }
 class C extends D{
 void f1() {System.out.println("C"+this);}
 }
 public class A{
 public static void main(String args[]){
 D obj = new C(); 
 obj.f1();
 }
 }