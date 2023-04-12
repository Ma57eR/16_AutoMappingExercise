package softuni.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String trailerId;

    private String thumbnailURL;

    private float size;

    private BigDecimal price;

    private String description;

    private LocalDate releaseDate;



}
