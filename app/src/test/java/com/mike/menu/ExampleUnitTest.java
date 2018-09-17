package com.mike.menu;

import com.google.gson.Gson;
import com.mike.menu.mainApp.common.test.AlgorithmCase;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        //assertEquals(4, 2 + 2);
        int [] arr={75,85,9,34,6,3,15};
        AlgorithmCase algorithmCase=new AlgorithmCase();
        //algorithmCase.swap(arr,1,2);
        algorithmCase.selectSort(arr);
        System.out.println(new Gson().toJson(arr));
    }
}