package com.typstudy.java1;

/**
 * @author typ
 * @date 2019/5/21 17:28
 * @Description: com.typstudy.java1
 */
public class Goods implements Comparable{
    private String name;
    private Double price;

    public Goods() {
    }

    public Goods(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
       if(o instanceof Goods){
           Goods goods=(Goods)o;
           if(this.price>goods.price){
               return 1;
           }else if (this.price<goods.price){
               return -1;
           }else{
              // return 0;
               return -this.name.compareTo(goods.name);
           }
       }
       throw new RuntimeException("输入的数据类型不一致！");
    }

}
