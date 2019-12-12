package com.bz.mc.model.charge;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QChargeGroup is a Querydsl query type for ChargeGroup
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChargeGroup extends EntityPathBase<ChargeGroup> {

    private static final long serialVersionUID = -217111163L;

    public static final QChargeGroup chargeGroup = new QChargeGroup("chargeGroup");

    public final NumberPath<Integer> activeStatus = createNumber("activeStatus", Integer.class);

    public final NumberPath<Integer> chargeCycle = createNumber("chargeCycle", Integer.class);

    public final NumberPath<Long> chargeGroupId = createNumber("chargeGroupId", Long.class);

    public final StringPath chargeGroupName = createString("chargeGroupName");

    public final NumberPath<Long> enteredBy = createNumber("enteredBy", Long.class);

    public final DateTimePath<java.time.LocalDateTime> entryTimestamp = createDateTime("entryTimestamp", java.time.LocalDateTime.class);

    public final StringPath flexField1 = createString("flexField1");

    public final StringPath flexField2 = createString("flexField2");

    public final StringPath flexField3 = createString("flexField3");

    public final NumberPath<Integer> paymentCycle = createNumber("paymentCycle", Integer.class);

    public final NumberPath<Long> programId = createNumber("programId", Long.class);

    public final NumberPath<Long> programSegmentId = createNumber("programSegmentId", Long.class);

    public final StringPath remarks = createString("remarks");

    public final NumberPath<Long> sessionId = createNumber("sessionId", Long.class);

    public final StringPath shortCode = createString("shortCode");

    public final NumberPath<Long> updatedBy = createNumber("updatedBy", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updateTimestamp = createDateTime("updateTimestamp", java.time.LocalDateTime.class);

    public QChargeGroup(String variable) {
        super(ChargeGroup.class, forVariable(variable));
    }

    public QChargeGroup(Path<? extends ChargeGroup> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChargeGroup(PathMetadata metadata) {
        super(ChargeGroup.class, metadata);
    }

}

