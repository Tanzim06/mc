package com.bz.mc.model.studentRegistration;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStudentRegistrationInfo is a Querydsl query type for StudentRegistrationInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentRegistrationInfo extends EntityPathBase<StudentRegistrationInfo> {

    private static final long serialVersionUID = -1263310668L;

    public static final QStudentRegistrationInfo studentRegistrationInfo = new QStudentRegistrationInfo("studentRegistrationInfo");

    public final com.bz.mc.model.QBaseEntity _super = new com.bz.mc.model.QBaseEntity(this);

    public final NumberPath<Integer> activeStatus = createNumber("activeStatus", Integer.class);

    public final NumberPath<Float> ageInYr = createNumber("ageInYr", Float.class);

    public final StringPath bloodGroup = createString("bloodGroup");

    public final NumberPath<Long> branchId = createNumber("branchId", Long.class);

    public final DatePath<java.time.LocalDate> calculatedDOB = createDate("calculatedDOB", java.time.LocalDate.class);

    public final DateTimePath<java.time.LocalDateTime> closeDate = createDateTime("closeDate", java.time.LocalDateTime.class);

    public final NumberPath<Integer> closeFlag = createNumber("closeFlag", Integer.class);

    public final StringPath closeReason = createString("closeReason");

    public final StringPath contactNo = createString("contactNo");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    public final DatePath<java.time.LocalDate> doB = createDate("doB", java.time.LocalDate.class);

    public final StringPath fatherName = createString("fatherName");

    public final StringPath flex1 = createString("flex1");

    public final StringPath flex2 = createString("flex2");

    public final StringPath flex3 = createString("flex3");

    public final EnumPath<Gender> gender = createEnum("gender", Gender.class);

    public final StringPath hobby = createString("hobby");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> modifiedBy = createNumber("modifiedBy", Long.class);

    public final StringPath motherName = createString("motherName");

    public final StringPath permanentAdd = createString("permanentAdd");

    public final StringPath permanentAddPostCode = createString("permanentAddPostCode");

    public final ArrayPath<byte[], Byte> picture = createArray("picture", byte[].class);

    public final StringPath picturePath = createString("picturePath");

    public final StringPath presentAdd = createString("presentAdd");

    public final StringPath presentAddPostcode = createString("presentAddPostcode");

    public final NumberPath<Long> programId = createNumber("programId", Long.class);

    public final NumberPath<Long> programSegmentId = createNumber("programSegmentId", Long.class);

    public final DatePath<java.time.LocalDate> registrationDate = createDate("registrationDate", java.time.LocalDate.class);

    public final StringPath remarks = createString("remarks");

    public final NumberPath<Long> sessionId = createNumber("sessionId", Long.class);

    public final NumberPath<Long> statusId = createNumber("statusId", Long.class);

    public final StringPath studentName = createString("studentName");

    public final StringPath visualId = createString("visualId");

    public QStudentRegistrationInfo(String variable) {
        super(StudentRegistrationInfo.class, forVariable(variable));
    }

    public QStudentRegistrationInfo(Path<? extends StudentRegistrationInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudentRegistrationInfo(PathMetadata metadata) {
        super(StudentRegistrationInfo.class, metadata);
    }

}

