package com.greatdpf.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 深入理解 java 集合 Collection
 * 特点：有序，可重复，可存放 null
 * 遍历：两种方式（迭代器，增强 for 循环）
 *
 * @author : dpf
 * @version : V1.0
 * @date : 2020/10/26
 */
public class UnderstandCollection {
    /**
     * 程序的入口
     */
    public static void main(String[] args){
        /*
        Collection<E>
        类型：interface 接口
        继承：Iterable<E> 接口
        方法 <---------------------------------------------------->
        增加：boolean add(E e);
        删除：void clear(); boolean remove(Object o);
              boolean retainAll(Collection<?> c);
        修改：
        查看：Iterator<E> iterator();
        判断: boolean contains(Object o); boolean equals(Object o);
              boolean isEmpty();
        其他：int size(); Object[] toArray();
         */
        // 这里利用 java 多态，创建 Collection 实现类的对象给接口
        Collection<Integer> collection = new ArrayList<>();

        // add 方法添加元素，成功返回 true 否则 false
        System.out.println("添加元素：\t" + collection.add(1));

        System.out.println("集合元素：\t" + collection);

        // clear 清空所有元素
        collection.clear();
        System.out.println("clear元素：\t" + collection);

        // 再添加新的元素
        collection.add(7);
        collection.add(7);
        collection.add(6);
        // remove 删除指定元素但是是第一个出现的，若删除失败，返回false，
        collection.remove(7);
        System.out.println("remove元素：" + collection);

        // 再添加新的元素
        collection.add(7);
        collection.add(5);
        collection.add(6);

        System.out.println("集合元素：\t" + collection);

        // retainAll 移除 c 集合中没有的元素
        Collection<Integer> c = new ArrayList<>();
        c.add(7);
        c.add(5);
        System.out.println("移除 c 集合中没有的元素：" + collection.retainAll(c));
        System.out.println("移除后集合元素：\t" + collection);

        // 再添加新的元素
        collection.add(2);
        collection.add(6);
        collection.add(3);

        System.out.println("添加元素后：\t" + collection);

        // contains 判断集合中是否包含某元素
        System.out.println("contains ：" + collection.contains(6));

        // equals 判断两个集合是否相等
        System.out.println("equals ：" + collection.equals(c));

        // isEmpty 判断集合是否为空
        System.out.println("isEmpty : " + collection.isEmpty());

        //size 返回集合中的元素数
        System.out.println("size ：" + collection.size());

        // toArray 将集合转为数组
        System.out.print("数组元素：");
        Object[] o = collection.toArray();
        for (Object obj : o) {
            System.out.print(obj + " ");
        }
        System.out.println();

        // 遍历集合
        // 方式一：迭代器
        System.out.println("遍历集合");
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        // 方式二：增强 for 循环
        for (Integer i : collection) {
            System.out.print(i + " ");
        }




    }
}
