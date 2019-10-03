package com.switchfully.author.author.book.rating;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RatingMapper {

    public List<RatingDto> mapToDto(List<Rating> ratings) {
        return ratings.stream()
                .map(rating -> new RatingDto()
                        .withId(rating.getId())
                        .withRaterName(rating.getRaterName())
                        .withScoreOutOfFive(rating.getScoreOutOfFive()))
                .collect(Collectors.toList());
    }

    public Rating mapToDomain(RatingDto ratingDto) {
        return new Rating(ratingDto.getScoreOutOfFive(), ratingDto.getRaterName());
    }
}
