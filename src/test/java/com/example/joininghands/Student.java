package com.example.joininghands;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Student {

    // 日志行号记录
    private AtomicInteger count = new AtomicInteger();

    public static void main(String[] args) {
        Student main = new Student();
        // 开启两个线程去执行test方法
        // new Thread(main::test).start();
        // new Thread(main::test).start();
        tableSizeFor(17);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n;
    }

    private synchronized void test() {
        try {
            log("进入了同步方法，并开始睡觉，1s");
            // sleep不会释放锁，因此其他线程不能进入这个方法
            Thread.sleep(1000);
            log("睡好了，但没事做，有事叫我，等待2s");
            //阻塞在此，并且释放锁，其它线程可以进入这个方法
            //当其它线程调用此对象的notify或者notifyAll时才有机会停止阻塞
            //就算没有人notify，如果超时了也会停止阻塞
            wait(2000);
            log("我要走了，但我要再睡一觉，10s");
            //这里睡的时间很长，因为没有释放锁，其它线程就算wait超时了也无法继续执行
            Thread.sleep(10000);
            log("走了");
            // notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 打印日志
    private void log(String s) {
        System.out.println(count.incrementAndGet() + " "
                + new Date().toString().split(" ")[3]
                + "\t" + Thread.currentThread().getName() + " " + s);
    }
}

class Node{
    public int count;
    public char ch;
    public Node[] nextNode=new Node[26];
    public Node(){

    }
    public Node(char ch){
        this.ch = ch;
    }
}

class Trie {

    Node head;

    public Trie() {
        head = new Node();
    }

    public void insert(String word) {
        Node temp = head;
        for(int i = 0; i < word.length(); ++i){
            if(temp.nextNode[word.charAt(i) - 'a'] == null){
                temp.nextNode[word.charAt(i) - 'a'] = new Node(word.charAt(i));
            }
            temp = temp.nextNode[word.charAt(i) - 'a'];
        }
    }

    public boolean search(String word) {
        Node temp = head;
        for(int i = 0; i < word.length(); ++i){
            if(temp.nextNode[word.charAt(i) - 'a'] == null){
                return false;
            }
            temp = temp.nextNode[word.charAt(i) - 'a'];
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        Node temp = head;
        for(int i = 0; i < prefix.length(); ++i){
            if(temp.nextNode[prefix.charAt(i) - 'a'] == null){
                return false;
            }
            temp = temp.nextNode[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}


class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] temp = new int[n + 1];
        int max = 0;
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                temp[j] = matrix[i][j] == '1' ? temp[j] + 1 : 0;
            }
            // 哨兵
            temp[matrix[0].length] = -1;
            max = Math.max(max, maxArea(temp, n));
        }
        return max;
    }

    public int maxArea(int[] temp, int n){
        int[] stack = new int[n + 2];
        int st = 0;
        // LinkedList<Integer> list = new LinkedList<>();
        // // 哨兵 前后各一个
        // list.addLast(-1);
        stack[st] = -1;
        int max = 0;
        for(int i = 0; i < temp.length; ++i){
            if(st < 1){
                stack[++st] = i;
            }
            else if(st >= 1 && temp[i] > temp[stack[st]]){
                stack[++st] = i;
            }else {
                while(st >= 1 && temp[i] <= temp[stack[st]]){
                    int l = stack[st--];;
                    int r = stack[st];
                    int side =  (i - r - 1) < temp[l] ? (i - r - 1) : temp[l];
                    max = Math.max(max, side * side);
                }
                stack[++st] = i;
            }
            // if(list.size() <= 1){
            //     list.addLast(i);
            // }
            // else if(list.size() > 1 && temp[i] > temp[list.peekLast()]){
            //     list.addLast(i);
            // }else {
            //     while(list.size() > 1 && temp[i] <= temp[list.peekLast()]){
            //         int l = list.pollLast();
            //         int r = list.peekLast();
            //         int side =  (i - r - 1) < temp[l] ? (i - r - 1) : temp[l];
            //         max = Math.max(max, side * side);
            //     }
            //     list.addLast(i);
            // }
        }
        return max;
    }
}