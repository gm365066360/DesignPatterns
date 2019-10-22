package com.gm.designpatterns.iterator;

import android.util.Log;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/16 17:49
 * Description: Restaurant
 * Company : 北京四维图新科技股份有限公司
 */
public class Restaurant {

    /**我们不希望在打印时还要了解菜单的内部容器是什么才能打印*/
    public void oldPrintMenu() {
        AMenu aMenu = new AMenu();
        BMenu bMenu = new BMenu();
        for (int i = 0; i < aMenu.getMenuItems().size(); i++) {
            print(aMenu.menuItems.get(i));
        }
        for (int i = 0; i < bMenu.getMenuItems().length; i++) {
            //数组容量
            if (bMenu.menuItems[i]!=null) {
                print(bMenu.menuItems[i]);
            }
        }
    }

    private void print(MenuItem next) {
        Log.e("gaom ", next.toString());
//        E/gaom: MenuItem{name='A1', des='A1 is right', price=1.0}
//        E/gaom: MenuItem{name='A2', des='A2 is right', price=2.0}
//        E/gaom: MenuItem{name='A3', des='A3 is right', price=3.0}
//        E/gaom: MenuItem{name='B1', des='B1 is right', price=1.0}
//        E/gaom: MenuItem{name='B2', des='B2 is right', price=2.0}
//        E/gaom: MenuItem{name='B3', des='B3 is right', price=3.0}
    }



    //Iterator


    Iteratable[] iteratable;

    public Restaurant(Iteratable... iteratable) {
        this.iteratable = iteratable;
    }

    public void printMenu() {
        for (int i = 0; i < iteratable.length; i++) {
            Iterator iterator;
            MenuItem next;
            for (iterator = iteratable[i].createIterator(); iterator.hasNext(); print(next)) {
                next = (MenuItem) iterator.next();
            }
        }
    }
}
