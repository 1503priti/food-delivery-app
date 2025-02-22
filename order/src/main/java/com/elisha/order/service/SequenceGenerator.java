package com.elisha.order.service;

import com.elisha.order.entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import java.util.Objects;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;



@Service
public class SequenceGenerator {

    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    private MongoTemplate mongoTemplate;

   public int generateNextOrderSeqId() {
       Query query = new Query(Criteria.where("id").is("sequence"));
        Update update = new Update().inc("sequence", 1);
        Sequence counter = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true), Sequence.class);
        return !Objects.isNull(counter) ? counter.getSequence() : 1;

    }
/*public int genSeq(){
    Sequence counter = mongoOperations.findAndModify(query(where("id").is("sequence")),
            new Update().inc("seq",1), options().returnNew(true).upsert(true),
            Sequence.class);
    return !Objects.isNull(counter) ? counter.getSequence() : 1;
}*/

}


