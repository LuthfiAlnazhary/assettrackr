package propensi.project.Assettrackr.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "developer")
@Getter
@Setter
public class Developer extends UserModel {

    @NotNull
    @Size(max = 50)
    @Column(name = "bidang_keahlian", nullable = false)
    private String bidangKeahlian;

    @ManyToMany(mappedBy = "listDeveloper")
    @PrimaryKeyJoinColumn
    private List<Server> listServer;
}