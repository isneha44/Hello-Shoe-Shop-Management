package lk.ijse.helloshoeshopmanagement.service;


import lk.ijse.helloshoeshopmanagement.auth.request.SignInRequest;
import lk.ijse.helloshoeshopmanagement.auth.request.SignUpRequest;
import lk.ijse.helloshoeshopmanagement.auth.response.JwtAuthResponse;

public interface AuthenticationService {

    JwtAuthResponse signIn(SignInRequest signInRequest);
    JwtAuthResponse signUp(SignUpRequest signUpRequest);

}
