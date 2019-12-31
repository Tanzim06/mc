package com.bz.mc.model.shedule;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBillDate is a Querydsl query type for BillDate
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBillDate extends EntityPathBase<BillDate> {

    private static final long serialVersionUID = -769095651L;

    public static final QBillDate billDate1 = new QBillDate("billDate1");

    public final com.bz.mc.model.QBaseEntity _super = new com.bz.mc.model.QBaseEntity(this);

    public final NumberPath<Integer> activeStatus = createNumber("activeStatus", Integer.class);

    public final DatePath<java.time.LocalDate> billDate = createDate("billDate", java.time.LocalDate.class);

    public final NumberPath<Long> chargeGroupId = createNumber("chargeGroupId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    public final StringPath flexField1 = createString("flexField1");

    public final StringPath flexField2 = createString("flexField2");

    public final StringPath flexField3 = createString("flexField3");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> modifiedBy = createNumber("modifiedBy", Long.class);

    public final StringPath remarks = createString("remarks");

    public final NumberPath<Integer> slNo = createNumber("slNo", Integer.class);

    public final NumberPath<Integer> year = createNumber("year", Integer.class);

    public QBillDate(String variable) {
        super(BillDate.class, forVariable(variable));
    }

    public QBillDate(Path<? extends BillDate> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBillDate(PathMetadata metadata) {
        super(BillDate.class, metadata);
    }

}

