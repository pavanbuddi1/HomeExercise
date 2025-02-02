package com.fetch.homeexercise.model;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class Receipt {
    private String retailer;
    private String purchaseDate;
    private String purchaseTime;
    private List<Item> items;
    private String total;

}
