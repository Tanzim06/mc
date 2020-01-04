package com.bz.mc.model.admission;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdmissionBooking is a Querydsl query type for AdmissionBooking
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAdmissionBooking extends EntityPathBase<AdmissionBooking> {

    private static final long serialVersionUID = -1567700695L;

    public static final QAdmissionBooking admissionBooking = new QAdmissionBooking("admissionBooking");

    public final com.bz.mc.model.QBaseEntity _super = new com.bz.mc.model.QBaseEntity(this);

    public final NumberPath<Integer> activeStatus = createNumber("activeStatus", Integer.class);

    public final NumberPath<Double> advAmount = createNumber("advAmount", Double.class);

    public final NumberPath<Double> amountToBePaid = createNumber("amountToBePaid", Double.class);

    public final DatePath<java.time.LocalDate> bookingDate = createDate("bookingDate", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> confirmDate = createDate("confirmDate", java.time.LocalDate.class);

    public final NumberPath<Integer> confirmFlag = createNumber("confirmFlag", Integer.class);

    public final StringPath contactNo = createString("contactNo");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    public final NumberPath<Long> currencyId = createNumber("currencyId", Long.class);

    public final DatePath<java.time.LocalDate> dateToBePaid = createDate("dateToBePaid", java.time.LocalDate.class);

    public final DatePath<java.time.LocalDate> DOB = createDate("DOB", java.time.LocalDate.class);

    public final StringPath fatherName = createString("fatherName");

    public final StringPath flexField1 = createString("flexField1");

    public final StringPath flexField2 = createString("flexField2");

    public final StringPath flexField3 = createString("flexField3");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> modifiedBy = createNumber("modifiedBy", Long.class);

    public final StringPath motherName = createString("motherName");

    public final StringPath NID = createString("NID");

    public final StringPath permanentAdd = createString("permanentAdd");

    public final StringPath presentAdd = createString("presentAdd");

    public final StringPath remarks = createString("remarks");

    public final NumberPath<Long> sessionId = createNumber("sessionId", Long.class);

    public final StringPath spouseName = createString("spouseName");

    public final StringPath studentName = createString("studentName");

    public QAdmissionBooking(String variable) {
        super(AdmissionBooking.class, forVariable(variable));
    }

    public QAdmissionBooking(Path<? extends AdmissionBooking> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdmissionBooking(PathMetadata metadata) {
        super(AdmissionBooking.class, metadata);
    }

}

