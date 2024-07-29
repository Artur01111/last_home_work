package com.example.last_home_work;

public class Container1 {
    private String itemText;
    private String itemPrice;
    private String itemView;
    private String star1;
    private String star2;
    private String star3;
    private String star4;
    private String star5;

    public Container1(String itemText,String itemPrice,String itemView,String star1,String star2,String star3,String
            star4,String star5) {
        this.itemText = itemText;
        this.itemPrice = itemPrice;
        this.itemView = itemView;
        this.star1 = star1;
        this.star2 = star2;
        this.star3 = star3;
        this.star4 = star4;
        this.star5 = star5;
    }

    public String getItemText() {
        return itemText;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public String getItemView() {
        return itemView;
    }

    public String getStar1() {
        return star1;
    }

    public String getStar2() {
        return star2;
    }

    public String getStar3() {
        return star3;
    }

    public String getStar4() {
        return star4;
    }

    public String getStar5() {
        return star5;
    }
}

