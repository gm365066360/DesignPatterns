package com.gm.designpatterns.iterator;

import java.util.ArrayList;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/16 17:37
 * Description: AMenu
 * Company : 北京四维图新科技股份有限公司
 */
public class BMenu implements Iteratable {

    MenuItem[] menuItems;

    final int maxNum = 10;

    public BMenu() {
        this.menuItems = new MenuItem[maxNum];
        this.menuItems[0] = new MenuItem("B1", "B1 is right", 1d);
        this.menuItems[1] = new MenuItem("B2", "B2 is right", 2d);
        this.menuItems[2] = new MenuItem("B3", "B3 is right", 3d);
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    //Iterator


    @Override
    public Iterator createIterator() {
        return new BMenuIterator();
    }

    public class BMenuIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            //!=null
            return index < menuItems.length && menuItems[index] != null;
        }

        @Override
        public Object next() {
            //++
            return  menuItems[index++];
        }
    }
}
