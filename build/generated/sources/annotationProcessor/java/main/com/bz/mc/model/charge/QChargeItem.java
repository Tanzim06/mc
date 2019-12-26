package com.bz.mc.model.charge;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QChargeItem is a Querydsl query type for ChargeItem
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChargeItem extends EntityPathBase<ChargeItem> {

    private static final long serialVersionUID = 547246925L;

    public static final QChargeItem chargeItem = new QChargeItem("chargeItem");

    public final com.bz.mc.model.QBaseEntity _super = new com.bz.mc.model.QBaseEntity(this);

    public final NumberPath<Integer> activeStatus = createNumber("activeStatus", Integer.class);

    public final NumberPath<Integer> chargeCycle = createNumber("chargeCycle", Integer.class);

    public final NumberPath<Long> chargeGroupId = createNumber("chargeGroupId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    public final NumberPath<Long> currencyId = createNumber("currencyId", Long.class);

    public final StringPath flexField1 = createString("flexField1");

    public final StringPath flexField2 = createString("flexField2");

    public final StringPath flexField3 = createString("flexField3");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Long> itemId = createNumber("itemId", Long.class);

    public final NumberPath<Double> itemRate = createNumber("itemRate", Double.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> modifiedBy = createNumber("modifiedBy", Long.class);

    public final NumberPath<Integer> paymentCycle = createNumber("paymentCycle", Integer.class);

    public final NumberPath<Long> programId = createNumber("programId", Long.class);

    public final NumberPath<Long> programSegmentId = createNumber("programSegmentId", Long.class);

    public final StringPath remarks = createString("remarks");

    public final NumberPath<Long> sessionId = createNumber("sessionId", Long.class);

    public final StringPath shortCode = createString("shortCode");

    public QChargeItem(String variable) {
        super(ChargeItem.class, forVariable(variable));
    }

    public QChargeItem(Path<? extends ChargeItem> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChargeItem(PathMetadata metadata) {
        super(ChargeItem.class, metadata);
    }

}

