package propensi.project.Assettrackr.service;

import propensi.project.Assettrackr.model.UserModel;
import propensi.project.Assettrackr.model.dto.CreateRequest;
import propensi.project.Assettrackr.model.dto.ListUserResponse;
import propensi.project.Assettrackr.model.dto.LoginRequest;
import propensi.project.Assettrackr.model.dto.UserResponse;

public interface UserService {
    public String login(LoginRequest request) throws RuntimeException;
    public ListUserResponse getAllUser();
    public UserResponse getDetailUser(String id) throws RuntimeException;
}
