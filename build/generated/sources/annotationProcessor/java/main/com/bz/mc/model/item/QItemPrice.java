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

    public final NumberPath<Integer> activeStatus = createNumber("activeStatus", Integer.class);

    public final NumberPath<Long> currencyId = createNumber("currencyId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> effectiveFrom = createDateTime("effectiveFrom", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> effectiveTo = createDateTime("effectiveTo", java.time.LocalDateTime.class);

    public final NumberPath<Long> enteredBy = createNumber("enteredBy", Long.class);

    public final DateTimePath<java.time.LocalDateTime> entryTimestamp = createDateTime("entryTimestamp", java.time.LocalDateTime.class);

    public final StringPath flexField1 = createString("flexField1");

    public final StringPath flexField2 = createString("flexField2");

    public final StringPath flexField3 = createString("flexField3");

    public final NumberPath<Long> itemId = createNumber("itemId", Long.class);

    public final NumberPath<Long> itemPriceId = createNumber("itemPriceId", Long.class);

    public final NumberPath<Double> itemRate = createNumber("itemRate", Double.class);

    public final StringPath remarks = createString("remarks");

    public final NumberPath<Integer> segmentExist = createNumber("segmentExist", Integer.class);

    public final NumberPath<Long> updatedBy = createNumber("updatedBy", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updateTimestamp = createDateTime("updateTimestamp", java.time.LocalDateTime.class);

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

