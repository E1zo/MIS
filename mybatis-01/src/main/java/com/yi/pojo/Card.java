package com.yi.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    private Integer cardid;


    private String cardtype;


    private Float discount;


    public Integer getCardid() {
        return cardid;
    }


    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype == null ? null : cardtype.trim();
    }

    public Float getDiscount() {
        return discount;
    }


    public void setDiscount(Float discount) {
        this.discount = discount;
    }
}