package com.bz.mc.model.program;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProgram is a Querydsl query type for Program
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProgram extends EntityPathBase<Program> {

    private static final long serialVersionUID = -1660977210L;

    public static final QProgram program = new QProgram("program");

    public final com.bz.mc.model.QBaseEntity _super = new com.bz.mc.model.QBaseEntity(this);

    public final NumberPath<Integer> activeStatus = createNumber("activeStatus", Integer.class);

    public final NumberPath<Long> branchId = createNumber("branchId", Long.class);

    public final NumberPath<Integer> createAutoSegment = createNumber("createAutoSegment", Integer.class);

    public final NumberPath<Long> deptId = createNumber("deptId", Long.class);

    public final NumberPath<Long> enteredBy = createNumber("enteredBy", Long.class);

    public final DateTimePath<java.time.LocalDateTime> entryTimeStamp = createDateTime("entryTimeStamp", java.time.LocalDateTime.class);

    public final StringPath flexField1 = createString("flexField1");

    public final StringPath flexField2 = createString("flexField2");

    public final StringPath flexField3 = createString("flexField3");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Long> progarmTypeId = createNumber("progarmTypeId", Long.class);

    public final StringPath programDesc = createString("programDesc");

    public final NumberPath<Long> programId = createNumber("programId", Long.class);

    public final StringPath programName = createString("programName");

    public final StringPath remarks = createString("remarks");

    public final NumberPath<Integer> segmentNo = createNumber("segmentNo", Integer.class);

    public final StringPath shortCode = createString("shortCode");

    public final NumberPath<Long> updateBy = createNumber("updateBy", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updateTimeStamp = createDateTime("updateTimeStamp", java.time.LocalDateTime.class);

    public final StringPath userProgarmNo = createString("userProgarmNo");

    public QProgram(String variable) {
        super(Program.class, forVariable(variable));
    }

    public QProgram(Path<? extends Program> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProgram(PathMetadata metadata) {
        super(Program.class, metadata);
    }

}

