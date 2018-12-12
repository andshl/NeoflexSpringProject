package ru.neoflex.mvc.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Entity
public class Role implements GrantedAuthority {

    @Id
    @SequenceGenerator(name = "role_id_sequence_gen", sequenceName = "role_id_sequence", initialValue = 10)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_sequence_gen")
    private Long id;
    private String name;

    @Column(unique = true)
    private String authority;


    @Override
    public String getAuthority() {
        return authority;
    }
}
