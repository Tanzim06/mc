package com.bz.mc.model.setup;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSessionInfo is a Querydsl query type for SessionInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSessionInfo extends EntityPathBase<SessionInfo> {

    private static final long serialVersionUID = 1752941087L;

    public static final QSessionInfo sessionInfo = new QSessionInfo("sessionInfo");

    public final com.bz.mc.model.QBaseEntity _super = new com.bz.mc.model.QBaseEntity(this);

    public final NumberPath<Integer> activeStatus = createNumber("activeStatus", Integer.class);

    public final NumberPath<Long> branchId = createNumber("branchId", Long.class);

    public final DatePath<java.time.LocalDate> endDate = createDate("endDate", java.time.LocalDate.class);

    public final NumberPath<Long> enteredBy = createNumber("enteredBy", Long.class);

    public final DateTimePath<java.time.LocalDateTime> entryTimestamp = createDateTime("entryTimestamp", java.time.LocalDateTime.class);

    public final StringPath flex1 = createString("flex1");

    public final StringPath flex2 = createString("flex2");

    public final StringPath flex3 = createString("flex3");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath remarks = createString("remarks");

    public final NumberPath<Long> sessionId = createNumber("sessionId", Long.class);

    public final StringPath sessionName = createString("sessionName");

    public final StringPath shortCode = createString("shortCode");

    public final DatePath<java.time.LocalDate> startDate = createDate("startDate", java.time.LocalDate.class);

    public final NumberPath<Long> updatedBy = createNumber("updatedBy", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updateTimestap = createDateTime("updateTimestap", java.time.LocalDateTime.class);

    public final StringPath visualId = createString("visualId");

    public QSessionInfo(String variable) {
        super(SessionInfo.class, forVariable(variable));
    }

    public QSessionInfo(Path<? extends SessionInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSessionInfo(PathMetadata metadata) {
        super(SessionInfo.class, metadata);
    }

}

