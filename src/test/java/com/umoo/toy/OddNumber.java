package com.umoo.toy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class OddNumber {
    private static final int MAX_COUNT = 10;
    public static void main(String[] args) {
        List<Integer> numbers = genNumbers();
        printNumbers("原始数据", numbers);
        transform(numbers);
        printNumbers("处理结果", numbers);
    }
    private static void printNumbers(String title, List<Integer> numbers) {
        System.out.println(title);
        for(Integer num : numbers) {
            System.out.print(num + ", ");
        }
        System.out.println();
    }
    private static List<Integer> genNumbers() {
        List<Integer> list = new ArrayList<>();
        Random rnd = new Random();
        for(int i = 0; i < MAX_COUNT; ++i)
            list.add(rnd.nextInt(100));
        return list;
    }
    private static void transform(List<Integer> list) {
    	Iterator<Integer> iterator = list.iterator();
    	while(iterator.hasNext()){
    		if(iterator.next() % 2 == 0){
    			iterator.remove();
    		}
    	}
    }
}
