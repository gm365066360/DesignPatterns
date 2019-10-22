package com.gm.designpatterns.iterator;

/**
 * Author gaoming
 * Email: gaoming2@autoai.com
 * Time 2019/10/16 17:32
 * Description: Menu
 * Company : 北京四维图新科技股份有限公司
 */
public   class MenuItem {
   public String name;
   public String des;
   public double price;

   public MenuItem(String name, String des, double price) {
      this.name = name;
      this.des = des;
      this.price = price;
   }

   @Override
   public String toString() {
      return "MenuItem{" +
              "name='" + name + '\'' +
              ", des='" + des + '\'' +
              ", price=" + price +
              '}';
   }
}
