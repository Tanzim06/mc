package com.bz.mc.model.item;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QItemPrice is a Querydsl query type for ItemPrice
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItemPrice extends EntityPathBase<ItemPrice> {

    private static final long serialVersionUID = -1735834513L;

    public static final QItemPrice itemPrice = new QItemPrice("itemPrice");

    public final com.bz.mc.model.QBaseEntity _super = new com.bz.mc.model.QBaseEntity(this);

    public final NumberPath<Integer> activeStatus = createNumber("activeStatus", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    public final NumberPath<Long> currencyId = createNumber("currencyId", Long.class);

    public final DatePath<java.time.LocalDate> effectiveFrom = createDate("effectiveFrom", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> effectiveTo = createDate("effectiveTo", java.time.LocalDate.class);

    public final StringPath flexField1 = createString("flexField1");

    public final StringPath flexField2 = createString("flexField2");

    public final StringPath flexField3 = createString("flexField3");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Long> itemId = createNumber("itemId", Long.class);

    public final NumberPath<Double> itemRate = createNumber("itemRate", Double.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> modifiedBy = createNumber("modifiedBy", Long.class);

    public final StringPath remarks = createString("remarks");

    public final NumberPath<Integer> segmentExist = createNumber("segmentExist", Integer.class);

    public QItemPrice(String variable) {
        super(ItemPrice.class, forVariable(variable));
    }

    public QItemPrice(Path<? extends ItemPrice> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItemPrice(PathMetadata metadata) {
        super(ItemPrice.class, metadata);
    }

}

