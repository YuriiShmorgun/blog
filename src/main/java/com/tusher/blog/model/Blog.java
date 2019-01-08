package com.tusher.blog.model;

import lombok.*;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

@Entity
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Blog {

    @Id @Getter @Setter
    private ObjectId id;
    @NonNull private String tittle;
    @NonNull private String description;
    @NonNull private String oth;
}
