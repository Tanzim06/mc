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

    public final com.bz.mc.model.QBaseEntity _super = new com.bz.mc.model.QBaseEntity(this);

    public final NumberPath<Integer> activeStatus = createNumber("activeStatus", Integer.class);

    public final NumberPath<Integer> chargeCycle = createNumber("chargeCycle", Integer.class);

    public final StringPath chargeGroupName = createString("chargeGroupName");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    public final DatePath<java.time.LocalDate> effectiveFrom = createDate("effectiveFrom", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> effectiveTo = createDate("effectiveTo", java.time.LocalDate.class);

    public final StringPath flexField1 = createString("flexField1");

    public final StringPath flexField2 = createString("flexField2");

    public final StringPath flexField3 = createString("flexField3");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> modifiedBy = createNumber("modifiedBy", Long.class);

    public final NumberPath<Integer> origin = createNumber("origin", Integer.class);

    public final NumberPath<Integer> paymentCycle = createNumber("paymentCycle", Integer.class);

    public final NumberPath<Long> programId = createNumber("programId", Long.class);

    public final NumberPath<Long> programSegmentId = createNumber("programSegmentId", Long.class);

    public final StringPath remarks = createString("remarks");

    public final NumberPath<Long> sessionId = createNumber("sessionId", Long.class);

    public final StringPath shortCode = createString("shortCode");

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

