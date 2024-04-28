package com.pokemonreview.api.repository;

import com.pokemonreview.api.models.Review;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ReviewRepositoryTest {
  
  @Autowired
  private ReviewRepository reviewRepository;
  
  @Test
  public void ReviewRepository_SaveAll_ReturnSavedReview() {
    //Arrange
    Review review = Review.builder().title("Great game!").content("content").stars(5).build();
    
    //Act
    Review savedReview = reviewRepository.save(review);
    
    //Assert
    Assertions.assertThat(savedReview).isNotNull();
    Assertions.assertThat(savedReview.getId()).isGreaterThan(0);
  }
  
}
