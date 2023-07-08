package com.durotan.services.impl;

import com.durotan.entity.ProductItem;
import com.durotan.repository.ProductItemRepository;
import com.durotan.services.ProductItemServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductItemServicesImpl implements ProductItemServices {
    private ProductItemRepository productItemRepository;

    public ProductItemServicesImpl( ProductItemRepository productItemRepository){
        this.productItemRepository = productItemRepository;
    }

    @Override
    public List<ProductItem> getAllProductItem() {
        List<ProductItem> productItems = productItemRepository.findAll();
        return productItems;
    }
}
