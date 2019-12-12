package com.bz.mc.model.security;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -1915794523L;

    public static final QUser user = new QUser("user");

    public final com.bz.mc.model.QBaseEntity _super = new com.bz.mc.model.QBaseEntity(this);

    public final NumberPath<Integer> activeStatus = createNumber("activeStatus", Integer.class);

    public final StringPath contactAddress = createString("contactAddress");

    public final StringPath contactNo = createString("contactNo");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> createdBy = createNumber("createdBy", Long.class);

    public final StringPath emailAddress = createString("emailAddress");

    public final StringPath fullName = createString("fullName");

    public final NumberPath<Integer> gender = createNumber("gender", Integer.class);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final StringPath nid = createString("nid");

    public final StringPath password = createString("password");

    public final StringPath remarks = createString("remarks");

    public final SetPath<Role, QRole> roles = this.<Role, QRole>createSet("roles", Role.class, QRole.class, PathInits.DIRECT2);

    public final NumberPath<Long> updatedBy = createNumber("updatedBy", Long.class);

    public final StringPath username = createString("username");

    public final NumberPath<Long> userRefId = createNumber("userRefId", Long.class);

    public final EnumPath<com.bz.mc.model.common.UserStatus> userStatus = createEnum("userStatus", com.bz.mc.model.common.UserStatus.class);

    public final EnumPath<com.bz.mc.model.common.UserType> userType = createEnum("userType", com.bz.mc.model.common.UserType.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

