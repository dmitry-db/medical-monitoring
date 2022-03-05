package liga.medical.medicalmonitoring.core.model.entity;

import liga.medical.medicalmonitoring.core.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "age")
    private Integer age;

    @Column(name = "city")
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "birthday_dt")
    private LocalDate birthdayDt;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "registration")
    private String registration;

    @Column(name = "passport_series")
    private int passportSeries;

    @Column(name = "passport_number")
    private int passportNumber;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "another_document")
    private String anotherDocument;
}
