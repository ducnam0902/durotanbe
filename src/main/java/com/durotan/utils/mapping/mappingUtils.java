package com.durotan.utils.mapping;

import com.durotan.daodto.ColorGroupDto;
import com.durotan.daodto.SizeGroupDto;
import com.durotan.entity.ProductItem;

import java.util.List;

public class mappingUtils {
    public static SizeGroupDto mapToSizeGroupDto(ProductItem product){
        SizeGroupDto quanityProduct = new SizeGroupDto();
        quanityProduct.setSizeName(product.getSize().getSizeName());
        quanityProduct.setQuanity(product.getQuanityInStock());
        return quanityProduct;
    }

    public static ColorGroupDto mapToColorGroupDto(ProductItem product, List<SizeGroupDto> quanityProduct){
        ColorGroupDto productColor = new ColorGroupDto();
        productColor.setColorName(product.getColors().getColorName());
        productColor.setImages(List.of(product.getImage1(), product.getImage2()));
        productColor.setSizeGroup(quanityProduct);
        return productColor;
    }
}
