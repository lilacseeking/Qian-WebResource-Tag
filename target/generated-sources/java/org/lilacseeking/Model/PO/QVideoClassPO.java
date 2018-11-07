package org.lilacseeking.Model.PO;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QVideoClassPO is a Querydsl query type for VideoClassPO
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVideoClassPO extends EntityPathBase<VideoClassPO> {

    private static final long serialVersionUID = 1030407355L;

    public static final QVideoClassPO videoClassPO = new QVideoClassPO("videoClassPO");

    public final QBaseEntityPO _super = new QBaseEntityPO(this);

    //inherited
    public final NumberPath<Integer> achieve = _super.achieve;

    //inherited
    public final NumberPath<Long> creater = _super.creater;

    //inherited
    public final NumberPath<Long> deleter = _super.deleter;

    public final StringPath description = createString("description");

    public final NumberPath<Double> discount = createNumber("discount", Double.class);

    //inherited
    public final DateTimePath<java.util.Date> gmtCreate = _super.gmtCreate;

    //inherited
    public final DateTimePath<java.util.Date> gmtDelete = _super.gmtDelete;

    //inherited
    public final DateTimePath<java.util.Date> gmtModify = _super.gmtModify;

    //inherited
    public final StringPath guid = _super.guid;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final BooleanPath isFree = createBoolean("isFree");

    //inherited
    public final NumberPath<Long> modifier = _super.modifier;

    public final StringPath name = createString("name");

    public final StringPath tags = createString("tags");

    public final NumberPath<Long> teacher = createNumber("teacher", Long.class);

    //inherited
    public final NumberPath<Integer> version = _super.version;

    public QVideoClassPO(String variable) {
        super(VideoClassPO.class, forVariable(variable));
    }

    public QVideoClassPO(Path<? extends VideoClassPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVideoClassPO(PathMetadata metadata) {
        super(VideoClassPO.class, metadata);
    }

}

