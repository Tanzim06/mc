package com.bz.mc.model.security;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRole is a Querydsl query type for Role
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRole extends EntityPathBase<Role> {

    private static final long serialVersionUID = -1915887536L;

    public static final QRole role1 = new QRole("role1");

    public final com.bz.mc.model.QBaseEntity _super = new com.bz.mc.model.QBaseEntity(this);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath role = createString("role");

    public QRole(String variable) {
        super(Role.class, forVariable(variable));
    }

    public QRole(Path<? extends Role> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRole(PathMetadata metadata) {
        super(Role.class, metadata);
    }

}

