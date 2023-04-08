package Mentoring;

import org.testng.annotations.Test;

public class _01 {

    @Test(priority = 1)
    public void test1() {

        System.out.println("registered");
    }

    @Test(dependsOnMethods = "test1")
    public void test2() {


        System.out.println("login ");

    }

    @Test

    public void test3() {


        System.out.println("3");

    }

    @Test(enabled = false)

    public void test4() {
    }

   //Assertions

   @Test
   public void test5(){
     String s1="java bir programlama dilidir";

   }










}
