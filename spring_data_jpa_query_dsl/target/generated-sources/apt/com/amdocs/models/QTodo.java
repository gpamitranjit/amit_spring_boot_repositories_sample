package com.amdocs.models;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QTodo is a Querydsl query type for Todo
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QTodo extends EntityPathBase<Todo> {

    private static final long serialVersionUID = 648847344L;

    public static final QTodo todo = new QTodo("todo");

    public final StringPath description = createString("description");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public QTodo(String variable) {
        super(Todo.class, forVariable(variable));
    }

    public QTodo(Path<? extends Todo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTodo(PathMetadata<?> metadata) {
        super(Todo.class, metadata);
    }

}

