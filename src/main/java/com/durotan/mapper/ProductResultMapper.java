package com.durotan.mapper;


import com.durotan.daodto.ColorGroupDto;
import com.durotan.daodto.ProductResultDto;
import com.durotan.daodto.SizeGroupDto;
import com.durotan.entity.Color;
import com.durotan.entity.ProductItem;
import com.durotan.utils.mapping.mappingUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ProductResultMapper {

    public static ProductResultDto mapToProductResultDto(ProductItem product, List<ColorGroupDto> colorGroup ){
        ProductResultDto productResult = new ProductResultDto();
        productResult.setName(product.getProduct().getName());
        productResult.setPrice(product.getProduct().getPrice());
        productResult.setCategory(product.getProduct().getCategory().getCategoryName());
        productResult.setColorGroup(colorGroup);

        return productResult;
    }
    public static List<ProductResultDto> mapToProductResultListDto(List<ProductItem>products){
        List<ProductResultDto> productResultList = new ArrayList<>();
        products.forEach(product -> {
            ProductResultDto existsProduct = productResultList.stream()
                    .filter(resultProduct -> product.getProduct().getName().equals(resultProduct.getName()))
                    .findAny()
                    .orElse(null);

            if (existsProduct == null) {
                SizeGroupDto quanityProduct = mappingUtils.mapToSizeGroupDto(product);
                ColorGroupDto productColorGroup = mappingUtils.mapToColorGroupDto(product, List.of(quanityProduct));
                productResultList.add(mapToProductResultDto(product, List.of(productColorGroup)));
            } else {
                List<ColorGroupDto> colorGroupDtoList = existsProduct.getColorGroup();
                ColorGroupDto existColorProduct = colorGroupDtoList.stream()
                        .filter(resultProduct -> resultProduct.getColorName().equals(product.getColors().getColorName()))
                        .findAny()
                        .orElse(null);

                SizeGroupDto quanityProduct = mappingUtils.mapToSizeGroupDto(product);
                List<ColorGroupDto> colorGroupList = new ArrayList<>();
                if (existColorProduct != null) {
                    List<SizeGroupDto> quanityProductList = new ArrayList<>();
                    quanityProductList.addAll(existColorProduct.getSizeGroup());
                    quanityProductList.add(quanityProduct);

                    ColorGroupDto colorGroupUpdated = existColorProduct;
                    colorGroupUpdated.setSizeGroup(quanityProductList);

                    colorGroupList.addAll(existsProduct.getColorGroup());
                    colorGroupList.remove(existColorProduct);
                    colorGroupList.add(colorGroupUpdated);

                    existsProduct.setColorGroup(colorGroupList);

                } else {
                    ColorGroupDto productColorGroup = mappingUtils.mapToColorGroupDto(product, List.of(quanityProduct));
                    colorGroupList.addAll(existsProduct.getColorGroup());
                    colorGroupList.add(productColorGroup);

                    existsProduct.setColorGroup(colorGroupList);
                }


            }
        });
        return productResultList;
    };
}
