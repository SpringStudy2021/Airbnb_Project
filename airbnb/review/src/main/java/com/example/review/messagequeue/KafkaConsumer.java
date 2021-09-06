package com.example.review.messagequeue;

import com.example.review.domain.Review;
import com.example.review.repository.ReviewRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class KafkaConsumer {
    ReviewRepository reviewRepository;
    @Autowired
    public KafkaConsumer(ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    @KafkaListener(topics = "RoomDeleted")
    public void confirmDelete(String kafkaMessage) {
        System.out.println("kafka recieved Message = " + kafkaMessage);
        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        try{
            map = mapper.readValue(kafkaMessage, new TypeReference<Map<Object, Object>>() {
            });

        }catch (JsonProcessingException ex ){
            ex.printStackTrace();
        }

        Long roomId = ((Number)map.get("id") ).longValue();
        List<Review> reviewOptional = reviewRepository.findReviewByCommentTo("R"+roomId);
        if (reviewOptional.size()>0) {
            for(int i=0;i<reviewOptional.size();i++){
                reviewRepository.delete(reviewOptional.get(i));
            }
        }
        else{
            log.info("roomId:"+ (Long)map.get("roomId") + "does not exists");
        }
    }
}
