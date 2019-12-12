package com.bz.mc.model.hr;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrganization is a Querydsl query type for Organization
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrganization extends EntityPathBase<Organization> {

    private static final long serialVersionUID = 2087304835L;

    public static final QOrganization organization = new QOrganization("organization");

    public final com.bz.mc.model.QBaseEntity _super = new com.bz.mc.model.QBaseEntity(this);

    public final NumberPath<Integer> activeStatus = createNumber("activeStatus", Integer.class);

    public final StringPath address = createString("address");

    public final StringPath contactNo = createString("contactNo");

    public final NumberPath<Long> countryId = createNumber("countryId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> districtId = createNumber("districtId", Long.class);

    public final NumberPath<Long> divisionId = createNumber("divisionId", Long.class);

    public final StringPath emailAddress = createString("emailAddress");

    public final NumberPath<Long> enteredBy = createNumber("enteredBy", Long.class);

    public final StringPath faxNo = createString("faxNo");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final DateTimePath<java.time.LocalDateTime> modifiedAt = createDateTime("modifiedAt", java.time.LocalDateTime.class);

    public final StringPath orgName = createString("orgName");

    public final NumberPath<Long> policeStationId = createNumber("policeStationId", Long.class);

    public final StringPath pOName = createString("pOName");

    public final NumberPath<Long> postCode = createNumber("postCode", Long.class);

    public final StringPath remarks = createString("remarks");

    public final StringPath shortCode = createString("shortCode");

    public final NumberPath<Long> updatedBy = createNumber("updatedBy", Long.class);

    public final StringPath web = createString("web");

    public QOrganization(String variable) {
        super(Organization.class, forVariable(variable));
    }

    public QOrganization(Path<? extends Organization> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrganization(PathMetadata metadata) {
        super(Organization.class, metadata);
    }

}

