package com.bz.mc.model.studentRegistration;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QStudentEducationPastInfo is a Querydsl query type for StudentEducationPastInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStudentEducationPastInfo extends EntityPathBase<StudentEducationPastInfo> {

    private static final long serialVersionUID = 1757303195L;

    public static final QStudentEducationPastInfo studentEducationPastInfo = new QStudentEducationPastInfo("studentEducationPastInfo");

    public final com.bz.mc.model.QBaseEntity _super = new com.bz.mc.model.QBaseEntity(this);

    public final NumberPath<Integer> activeStatus = createNumber("activeStatus", Integer.class);

    public final StringPath boardName = createString("boardName");

    public final NumberPath<Long> enteredBy = createNumber("enteredBy", Long.class);

    public final DateTimePath<java.time.LocalDateTime> entryTimestamp = createDateTime("entryTimestamp", java.time.LocalDateTime.class);

    public final StringPath examName = createString("examName");

    public final StringPath flex1 = createString("flex1");

    public final StringPath flex2 = createString("flex2");

    public final StringPath flex3 = createString("flex3");

    public final NumberPath<Float> gpa = createNumber("gpa", Float.class);

    public final StringPath groupName = createString("groupName");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Float> marksBiology = createNumber("marksBiology", Float.class);

    public final StringPath regNo = createString("regNo");

    public final StringPath remarks = createString("remarks");

    public final StringPath rollNo = createString("rollNo");

    public final NumberPath<Long> studentEduPastId = createNumber("studentEduPastId", Long.class);

    public final NumberPath<Long> studentRegistrationId = createNumber("studentRegistrationId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updatedBy = createDateTime("updatedBy", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updateTimestap = createDateTime("updateTimestap", java.time.LocalDateTime.class);

    public final NumberPath<Integer> yearPassed = createNumber("yearPassed", Integer.class);

    public QStudentEducationPastInfo(String variable) {
        super(StudentEducationPastInfo.class, forVariable(variable));
    }

    public QStudentEducationPastInfo(Path<? extends StudentEducationPastInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudentEducationPastInfo(PathMetadata metadata) {
        super(StudentEducationPastInfo.class, metadata);
    }

}

