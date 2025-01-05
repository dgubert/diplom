package models;

import lombok.Data;

@Data
public class AddItemToBasketRequestModel {
    int regionId;
    String cartId;
    ItemJsonRequestModel[] items;
}
