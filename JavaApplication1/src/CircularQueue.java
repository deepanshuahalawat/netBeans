
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
public class CircularQueue {
    static final int BUFFLEN =4;
    static int buff[] = new int[BUFFLEN];
    static int head=0,tail=0,available=0;
    public static void main(String str[]){
        
        Serial_printInt(123450);
        
    }
    static void Serial_printInt(int val){
        int rem = 0;
        char num[] = char[10];
    }
    
    public static  void add(int val){
       if(available == BUFFLEN)
           return;
       buff[head] = val;
       head++;
       head = head%BUFFLEN;
       available++;
    }
    public static int remove(){
       if(available == 0)
           return -1;
        int val = buff[tail];
        buff[tail] = 0;
        tail++;
        tail = tail%BUFFLEN;
        available--;
        return val;
    }
    public static boolean isFull(){
        if(available == BUFFLEN)
            return true;
        return false;
    }
    
    public static boolean isEmpty(){
        if(available == 0)
            return true;
        return false;
    }
    
    public static void printStatus(){
        for(int i=0;i<BUFFLEN; i++)
            System.out.print(buff[i]+",\t");
        System.out.println("\n");
        System.out.println("Head: "+head+"\t Tail: "+tail);
        System.out.println("Full: \t"+isFull());
        System.out.println("Empty: \t"+isEmpty());
    }
    
}
