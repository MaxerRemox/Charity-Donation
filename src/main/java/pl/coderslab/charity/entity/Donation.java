package pl.coderslab.charity.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Donation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(1)
    private Integer quantity;

    @NotEmpty
    @ManyToMany
    private List<Category> categories;

    @NotNull
    @ManyToOne
    private Institution institution;

    @NotBlank
    @Size(min = 3)
    private String street;

    @NotBlank
    @Size(min = 3)
    private String city;

    @NotNull
    @Pattern(regexp = "[0-9][0-9]-[0-9][0-9][0-9]", message = "Niepoprawy kod pocztowy")
    private String zipCode;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;

    @NotNull
    private LocalTime pickUpTime;

    private String pickUpComment;
}
