package com.example.starteck.myapplication;

/**
 * Created by Starteck on 9/29/2017.
 */

public class Product {
    private String name;
    private String Description;
    private String image;
    private String price;
    private String ProductURL;
    private String ProductId;

    public String getProductURL() {
        return ProductURL;
    }

    public void setProductURL(String productURL) {
        ProductURL = productURL;
    }

    public String getProductId() {
        return ProductId;
    }

    public void setProductId(String productId) {
        ProductId = productId;
    }



    public Product(String name, String description, String image, String price ,String ProductURL , String ProductId) {
        this.name = name;
        Description = description;
        this.image = image;
        this.price = price;
        this.ProductURL= ProductURL;
        this.ProductId = ProductId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
