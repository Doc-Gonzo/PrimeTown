package at.mathias_schaller.PrimeTown.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "houses")
public class House extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size
    @Column(unique = true)
    private String owner;

    


    // Getters and Setters (Omitted for brevity)


}