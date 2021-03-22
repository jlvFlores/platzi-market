package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.PurchaseItem;
import com.platzi.market.persistence.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
        @Mapping(source = "id.idProducto", target = "productId"),
        @Mapping(source = "cantidad", target = "quantity"),
        @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto comprasProducto);

    @InheritInverseConfiguration
    @Mappings({
        @Mapping(source = "compra", target = "true"),
        @Mapping(source = "producto", target = "true"),
        @Mapping(source = "id.idCompra", target = "true")
    })
    ComprasProducto toComprasProducto(PurchaseItem item);
}
