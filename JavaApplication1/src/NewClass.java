
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class NewClass {
    public static void main(String arg[]){
        
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5,10,15,45,12,65,12,1,23,44,22,11,33,21,5,1,6,5,1,3,4,8,7,5,69,5,4,1,2,3,6,7,1,23,87);
        
        String result = numbers.stream().distinct().filter(n -> n<15 ).sorted().map(n->n*n).map(num -> new String(num+"")).collect(Collectors.joining(","));
        System.out.println(result);
        
        
        System.out.println("--------------");
//get list of unique squares
        List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        
        squaresList.forEach( (n) -> System.out.println(n));
 
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int arr[] = {1,2,1,5,6,4,2,5,9,3,5,1,2,6,4,1,2,3,6,5,4,2,6,7,8,9};
        List<Integer> list = Arrays.asList(1,2,1,5,6,4,2,5,9,3,5,1,2,6,4,1,2,3,6,5,4,2,6,7,8,9);
        for(int i=0;i<arr.length;i++){
            int freq=0;
            if(hm.containsKey(arr[i])){
                freq = hm.get(arr[i]);
                hm.put(arr[i], freq+1);
            }else{
                hm.put(arr[i],1);
            }
        }
        hm.forEach((new MyPrint<Integer,Integer>())::showMap);
    }
}
class MyPrint<T,U>{
    public  void showMap(T a, U b){
        System.out.println("Key: "+a+"\tValue: "+b);
    }
    
}