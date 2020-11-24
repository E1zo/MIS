package com.yi.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Drug {

    private Integer drugid;


    private String name;


    private String pinyin;


    private String unit;

    private String specification;

    private Integer price;


    private Integer quantity;


    public Integer getDrugid() {
        return drugid;
    }


    public void setDrugid(Integer drugid) {
        this.drugid = drugid;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    public String getPinyin() {
        return pinyin;
    }


    public void setPinyin(String pinyin) {
        this.pinyin = pinyin == null ? null : pinyin.trim();
    }


    public String getUnit() {
        return unit;
    }


    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }


    public String getSpecification() {
        return specification;
    }


    public void setSpecification(String specification) {
        this.specification = specification == null ? null : specification.trim();
    }


    public Integer getPrice() {
        return price;
    }


    public void setPrice(Integer price) {
        this.price = price;
    }


    public Integer getQuantity() {
        return quantity;
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "drugid=" + drugid +
                ", name='" + name + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", unit='" + unit + '\'' +
                ", specification='" + specification + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}