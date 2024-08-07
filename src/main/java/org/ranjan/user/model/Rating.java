package org.ranjan.user.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Rating")
public class Rating {

    @Id
    @Column(name = "RatingId", length = 100)
    @GeneratedValue
    private Long ratingId;
    @Column(name="UserId", length = 500)
    private Long userId;
    @Column(name="HotelId", length = 100)
    private Long hotelId;
    @Column(name ="Rating", length = 50)
    private Integer rating;
    @Column(name="Feedback", length = 1000)
    private String feedback;



}
