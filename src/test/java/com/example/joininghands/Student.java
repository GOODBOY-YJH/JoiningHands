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
        new Thread(main::test).start();
        new Thread(main::test).start();
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