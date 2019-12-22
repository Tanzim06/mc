package com.bz.mc.model.item;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QItemInfo is a Querydsl query type for ItemInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QItemInfo extends EntityPathBase<ItemInfo> {

    private static final long serialVersionUID = -1164585784L;

    public static final QItemInfo itemInfo = new QItemInfo("itemInfo");

    public final com.bz.mc.model.QBaseEntity _super = new com.bz.mc.model.QBaseEntity(this);

    public final NumberPath<Integer> activeStatus = createNumber("activeStatus", Integer.class);

    public final NumberPath<Integer> billFlag = createNumber("billFlag", Integer.class);

    public final NumberPath<Long> enteredBy = createNumber("enteredBy", Long.class);

    public final DateTimePath<java.time.LocalDateTime> entryTimestamp = createDateTime("entryTimestamp", java.time.LocalDateTime.class);

    public final StringPath flexField1 = createString("flexField1");

    public final StringPath flexField2 = createString("flexField2");

    public final StringPath flexField3 = createString("flexField3");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final NumberPath<Integer> inventoryFlag = createNumber("inventoryFlag", Integer.class);

    public final StringPath itemName = createString("itemName");

    public final StringPath remarks = createString("remarks");

    public final NumberPath<Long> updatedBy = createNumber("updatedBy", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updateTimestamp = createDateTime("updateTimestamp", java.time.LocalDateTime.class);

    public QItemInfo(String variable) {
        super(ItemInfo.class, forVariable(variable));
    }

    public QItemInfo(Path<? extends ItemInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QItemInfo(PathMetadata metadata) {
        super(ItemInfo.class, metadata);
    }

}

