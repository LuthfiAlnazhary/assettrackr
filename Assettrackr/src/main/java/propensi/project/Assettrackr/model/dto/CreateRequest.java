package propensi.project.Assettrackr.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateRequest {
    private String username;
    private String email;
    private String password;
    private String role;
    private String divisi;

}
