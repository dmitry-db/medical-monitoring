package liga.medical.medicalmonitoring.core.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "medical_history")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MedicalHistory {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(name = "doc_number")
    private String docNubmer;

    @Column(name = "create_dttm")
    private LocalDate createDttm;

    @Column(name = "modify_dttm")
    private LocalDate modifyDttm;

    @Column(name = "doctor")
    private String doctor;

    @Column(name = "diagnosis")
    private String diagnosis;

    @OneToOne
    @JoinColumn(name = "medical_history")
    private MedicalHistory medicalHistory;

}
