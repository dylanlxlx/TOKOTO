package com.dylanlxlx.tokoto;

public class ProductItem {
    private final int productImgId;
    private final String productName;
    private final String productPrice;
    private final int likeId;

    public ProductItem(int productImgId, String productName, String productPrice, int likeId) {
        this.productImgId = productImgId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.likeId = likeId;
    }

    public int getProductImgId() {
        return productImgId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public int getLikeId() {
        return likeId;
    }
}
