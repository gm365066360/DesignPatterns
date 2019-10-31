package com.gm.designpatterns.iterator;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/16 17:56
 * Description: TestIterator
 * Company : 北京四维图新科技股份有限公司
 */
public class TestIterator {

    public static List<String> ceateList() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("n");
        return list;
    }

    /**
     * 谈到迭代器, 大家首先想到的应该是代替循环语句删除数组中数据
     * -我们讨论一下循环遍历与迭代器遍历对于删除数据的影响情况
     **/
    public static void testJavaLoop() {
        /**
         * for 与第一直觉相反的是,不会数组越界,但是如果符合条件的相邻,则只会删掉第一个
         */
        List<String> list = ceateList();
        for (int i = 0; i < list.size(); i++) {
            if ("a".equals(list.get(i))) {
                //IDE报黄提示: Suspicious ‘List.remove()’ in the loop 可疑的方法
                list.remove(i);
            }
        }
        Log.e("gaom ", "使用for 的结果：" + list);
        //E/gaom: 使用for 的结果：[a, b, n]

        /**
         *  为什么会出现这种现象(相邻,则只会删掉第一个)
         *  for 无条件 , 结果是:每隔一个删掉一个
         */
        List<String> list0 = ceateList();
        for (int i = 0; i < list0.size(); i++) {
            list0.remove(i);
        }
        Log.e("gaom ", "使用for无条件 的结果：" + list0);
        //E/gaom: 使用for无条件 的结果：[a, n]

        //size减少 i在增加 所以会出现隔一个删一个现象

        /**
         * foreach  代替for
         */
        List<String> list1 = ceateList();
        try {
            for (String str : list1) {
                if ("a".equals(str)) {
                    //不报黄提示
                    list1.remove(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
//            W/System.err: java.util.ConcurrentModificationException
//            并发修改异常(不是多线程的那个并发)就是在循环时不能修改数据
            /**
             * @see ArrayList.Itr.next() ConcurrentModificationException 并发修改异常
             */
            //ConcurrentModificationException 并发修改异常
            //Itr next() - if (modCount(修改次数) != expectedModCount)

            //Itr - iterator.remove(); 可以删除的原因
            //ArrayList.this.remove(lastRet);
            //                cursor = lastRet;
            //                lastRet = -1;
            //                expectedModCount = modCount;

        }

        /**
         * deleteList记录, 不能在自己的循环里删, 那就在别人的循环里删
         */
        List<String> list01 = ceateList();
        List<String> deleteList = new ArrayList<>();
        for (int i = 0; i < list01.size(); i++) {
            if ("a".equals(list01.get(i))) {
                deleteList.add(list01.get(i));
            }
        }

        for (int i = 0; i < deleteList.size(); i++) {
            list01.remove(deleteList.get(i));
        }
        Log.e("gaom ", "使用for deleteList 的结果：" + list01);
        //E/gaom: 使用for deleteList 的结果：[b, n]

        /**
         * 倒序删除
         */
        List<String> list2 = ceateList();
        for (int i = list2.size() - 1; i >= 0; i--) {
            if ("a".equals(list2.get(i))) {
                list2.remove(i);
            }
        }
        Log.e("gaom ", "使用for倒序 的结果22：" + list2);
        //E/gaom: 使用for倒序 的结果22：[b, n]

        /**
         * Iterator删除
         */
        List<String> list3 = ceateList();
        Iterator<String> iterator = list3.iterator();//List中的迭代器实现 list.iterator();
        while (iterator.hasNext()) {
            if ("a".equals(iterator.next())) {
                iterator.remove();
            }
        }
        Log.e("gaom ", "使用迭代 的结果：" + list3);
        //E/gaom: 使用迭代 的结果：[b, n]

        /**
         * ## !! 注意
         * Iterator 里使用 list.remove()
         */
        List<String> list4 = ceateList();
        try {
            Iterator<String> iterator1 = list4.iterator();
            while (iterator1.hasNext()) {
                String next = iterator1.next();
                if ("a".equals(next)) {
                    list4.remove(next);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
//            W/System.err: java.util.ConcurrentModificationException
        }

    }


    public static void main() {

        /**
         *  用一个例子来回顾一下java中的循环语句
         */
        testJavaLoop();


        /**
         * 餐馆中同时有菜单A和菜单B两个菜单(存储容器不同),餐馆要打印两个菜单
         */
        Restaurant restaurant = new Restaurant();
        restaurant.oldPrintMenu();

        /**
         * 引入迭代器模式
         */
        AMenu aMenu = new AMenu();
        BMenu bMenu = new BMenu();
        Restaurant restaurant1 = new Restaurant(aMenu, bMenu);
        restaurant1.printMenu();

        /**
         * 之后可随意增加采用其他容器的菜单,提高了系统的可扩展性
         */
        CMenu cMenu = new CMenu();
        Restaurant restaurant2 = new Restaurant(cMenu);
        restaurant2.printMenu();

        /**
         * JDK中的迭代器模式接口
         * @see java.util.Iterator
         * @see java.lang.Iterable
         */
        Data data = new Data();
        Iterator<Data.Item> iterator;
        Data.Item next;
        for (iterator = data.iterator(); iterator.hasNext(); Log.e("gaom log=", next.toString())) {
            next = iterator.next();
        }

        /**
         * list.iterator(); ArrayList类也实现了迭代器
         */
        ArrayList<Data.Item> arrayList = new ArrayList<>();
        arrayList.add(new Data.Item("iterator1"));
        arrayList.add(new Data.Item("iterator2"));
        arrayList.add(new Data.Item("iterator3"));
        //List.iterator()
        Iterator<Data.Item> iterator1 = arrayList.iterator();
        while (iterator1.hasNext()) {
            Log.e("gaom arrayList.=", iterator1.next().toString());
        }

        /**
         *  for-each循环是java语法糖，本质是迭代器模式的使用。
         */
        for (Data.Item item : arrayList) {
            Log.e("gaom foreach.=", item.toString());
        }

        //反编译 转换成while循环 是所有都转换么? 查看Restaurant.oldPrintMenu 结论 你用for循环迭代器 就会转成while循环迭代器
    }

    public static class Data implements Iterable<Data.Item> {

        private ArrayList<Item> arrayList;

        public Data() {
            this.arrayList = new ArrayList<>();
            arrayList.add(new Item("gaom1"));
            arrayList.add(new Item("gaom2"));
            arrayList.add(new Item("gaom3"));
        }

        @NonNull
        @Override
        public Iterator<Data.Item> iterator() {
            return new DataIterator();
        }

        public class DataIterator implements Iterator<Item> {
            int index;

            @Override
            public boolean hasNext() {
                return index < arrayList.size();
            }

            @Override
            public Item next() {
                return arrayList.get(index++);
            }
        }

        public static class Item {
            public String name;

            public Item(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "Item{" +
                        "name='" + name + '\'' +
                        '}';
            }
        }
    }
}
