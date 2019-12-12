package com.bz.mc.model.batch;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBatchInfo is a Querydsl query type for BatchInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBatchInfo extends EntityPathBase<BatchInfo> {

    private static final long serialVersionUID = -500044800L;

    public static final QBatchInfo batchInfo = new QBatchInfo("batchInfo");

    public final NumberPath<Integer> activeStatus = createNumber("activeStatus", Integer.class);

    public final NumberPath<Long> batchId = createNumber("batchId", Long.class);

    public final StringPath batchName = createString("batchName");

    public final NumberPath<Long> enteredBy = createNumber("enteredBy", Long.class);

    public final DateTimePath<java.time.LocalDateTime> entryTimestamp = createDateTime("entryTimestamp", java.time.LocalDateTime.class);

    public final StringPath flexField1 = createString("flexField1");

    public final StringPath flexField2 = createString("flexField2");

    public final StringPath flexField3 = createString("flexField3");

    public final NumberPath<Long> programId = createNumber("programId", Long.class);

    public final StringPath remarks = createString("remarks");

    public final NumberPath<Long> sessionId = createNumber("sessionId", Long.class);

    public final StringPath shortCode = createString("shortCode");

    public final NumberPath<Long> updatedBy = createNumber("updatedBy", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updateTimestamp = createDateTime("updateTimestamp", java.time.LocalDateTime.class);

    public final StringPath visualId = createString("visualId");

    public QBatchInfo(String variable) {
        super(BatchInfo.class, forVariable(variable));
    }

    public QBatchInfo(Path<? extends BatchInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBatchInfo(PathMetadata metadata) {
        super(BatchInfo.class, metadata);
    }

}

