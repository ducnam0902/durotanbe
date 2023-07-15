package com.durotan.mapper;

import com.durotan.daodto.ProductItemDto;
import com.durotan.daodto.SizeDto;
import com.durotan.entity.Color;
import com.durotan.entity.Product;
import com.durotan.entity.ProductItem;
import com.durotan.entity.Size;

public class ProductItemMapper {

    public static ProductItemDto mapToProductItemDto(ProductItem productItem){
        ProductItemDto productItemDto = new ProductItemDto();
        productItemDto.setId(productItem.getId());
        productItemDto.setSku(productItem.getSku());
        productItemDto.setQuanityInStock(productItem.getQuanityInStock());
        productItemDto.setPrice(productItem.getPrice());
        productItemDto.setImages1(productItem.getImage1());
        productItemDto.setImages2(productItem.getImage2());
        productItemDto.setSize(productItem.getSize().getId());
        productItemDto.setColor(productItem.getColors().getId());
        productItemDto.setProduct(productItem.getProduct().getId());

        return productItemDto;
    }

    public static ProductItem mapToProductItem(ProductItemDto productItemDto, Size size, Color color, Product product) {
        ProductItem productItem = new ProductItem();
        productItem.setSku(productItemDto.getSku());
        productItem.setQuanityInStock(productItemDto.getQuanityInStock());
        productItem.setPrice(productItemDto.getPrice());
        productItem.setImage1(productItemDto.getImages1());
        productItem.setImage2(productItemDto.getImages2());
        productItem.setSize(size);
        productItem.setColors(color);
        productItem.setProduct(product);
        return productItem;
    }
}
