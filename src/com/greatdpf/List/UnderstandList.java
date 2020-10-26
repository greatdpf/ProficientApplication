package com.greatdpf.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 深入理解 Java 集合 List
 * 新增加的方法均和索引有关！
 *
 * @author : dpf
 * @version : V1.0
 * @date : 2020/10/26
 */
public class UnderstandList {
    /**
     * 程序的入口
     */
    public static void main(String[] args){
        /*
        List<E>
        类型：interface 接口
        继承：Collection<E> 接口
         <----------------------特有方法都和索引有关------------------------>
        增加：void add(int index, E element);
        删除：E remove(int index);
        修改：E set(int index, E element)
        查找：E get(int index); int indexOf(Object o);
              int lastIndexOf(Object o); ListIterator<E> listIterator();
        判断:
        其他：List<E> subList(int fromIndex, int toIndex)
         */
        List<Integer> list = new ArrayList<>();

        // add 添加元素，继承父类 Collection 方法
        System.out.println("add : " + list.add(1));
        System.out.println(list);

        // List 特有的方法 add(int index, E element) 在指定索引中添加元素
        System.out.println("在指定索引添加元素" );
        list.add(0, 2);

        System.out.println(list);

        // remove 移除指定索引中的元素,并返回移除的元素
        System.out.println("remove : " + list.remove(0));
        System.out.println(list);

        // set 修改指定索引中的元素，并返回修改的元素
        System.out.println("set : " + list.set(0, 3));
        System.out.println(list);

        // 添加元素
        list.add(2);
        list.add(3);
        list.add(6);
        list.add(3);
        list.add(4);

        // get 获取指定索引的元素，并返回此元素
        System.out.println("get : " + list.get(0));
        System.out.println(list);

        // indexOf 返回指定元素的第一次出现的索引
        System.out.println("indexOf ：" + list.indexOf(3));
        // lastIndexOf 返回指定元素的最后一次出现的索引
        System.out.println("lastIndexOf ：" + list.lastIndexOf(3));

        // 将 list 切割为一个新的 List，[0,3)
        List<Integer> l = list.subList(1, 3);
        System.out.println("subList : " + l);

        // 遍历集合
        System.out.println("集合遍历");
        // 方式一：迭代器
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 方式二：增强 for 循环
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 方式三：普通 for 循环
        for (int i = 0;i < list.size();i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

    }
}
