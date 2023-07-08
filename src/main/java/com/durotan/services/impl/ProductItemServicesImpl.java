package com.durotan.services.impl;

import com.durotan.daodto.ProductDto;
import com.durotan.entity.ProductItem;
import com.durotan.repository.ProductItemRepository;
import com.durotan.services.ProductItemServices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductItemServicesImpl implements ProductItemServices {
    private ProductItemRepository productItemRepository;

    public ProductItemServicesImpl( ProductItemRepository productItemRepository){
        this.productItemRepository = productItemRepository;
    }

    @Override
    public List<ProductDto> getAllProductItem() {
        List<ProductItem> productItems = productItemRepository.findAll();
        List<ProductDto> productRes = new ArrayList<>();
        productItems.forEach(items -> {
            ProductDto product = new ProductDto();
            product.setId(items.getId());
            product.setSku(items.getSku());
            product.setQuanityInStock(items.getQuanityInStock());
            product.setPrice(items.getPrice());
            product.setImages(items.getImages());
            product.setSize(items.getSize().getSizeName());
            product.setProductName(items.getProduct().getName());
            product.setColor(items.getColors().getColorName());
            product.setDescription(items.getProduct().getDescription());
            productRes.add(product);

        });
        return productRes;
    }
}
