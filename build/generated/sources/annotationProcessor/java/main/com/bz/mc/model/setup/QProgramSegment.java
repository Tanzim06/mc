package com.bz.mc.model.setup;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QProgramSegment is a Querydsl query type for ProgramSegment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProgramSegment extends EntityPathBase<ProgramSegment> {

    private static final long serialVersionUID = 1276722292L;

    public static final QProgramSegment programSegment = new QProgramSegment("programSegment");

    public final com.bz.mc.model.QBaseEntity _super = new com.bz.mc.model.QBaseEntity(this);

    public final NumberPath<Integer> activeStatus = createNumber("activeStatus", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    public final StringPath flexField1 = createString("flexField1");

    public final StringPath flexField2 = createString("flexField2");

    public final StringPath flexField3 = createString("flexField3");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> modifiedBy = createDateTime("modifiedBy", java.time.LocalDateTime.class);

    public final NumberPath<Long> parentProgramSegmentId = createNumber("parentProgramSegmentId", Long.class);

    public final NumberPath<Long> programId = createNumber("programId", Long.class);

    public final StringPath remarks = createString("remarks");

    public final StringPath segmentName = createString("segmentName");

    public final NumberPath<Integer> slNo = createNumber("slNo", Integer.class);

    public final StringPath visualId = createString("visualId");

    public QProgramSegment(String variable) {
        super(ProgramSegment.class, forVariable(variable));
    }

    public QProgramSegment(Path<? extends ProgramSegment> path) {
        super(path.getType(), path.getMetadata());
    }

    public QProgramSegment(PathMetadata metadata) {
        super(ProgramSegment.class, metadata);
    }

}

