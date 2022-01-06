package com.penguin_manufacturing.penguin.Controller;

import com.penguin_manufacturing.penguin.Models.AuthenticationRequest;
import com.penguin_manufacturing.penguin.Models.AuthenticationResponse;
import com.penguin_manufacturing.penguin.Models.UserModel;
import com.penguin_manufacturing.penguin.Models.VerifyResponse;
import com.penguin_manufacturing.penguin.Services.MyUserDetailsService;
import com.penguin_manufacturing.penguin.Services.UserService;
import com.penguin_manufacturing.penguin.Utils.JwtUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@CrossOrigin(origins = "*")
public class AuthenticationController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private MyUserDetailsService myUserDetailsService;

  @Autowired
  private JwtUtility jwtUtil;

  @Autowired
  private UserService userService;

  @PostMapping(value = "/verify")
  public VerifyResponse verifyUser(@RequestBody AuthenticationResponse jwt) {
    String jwtString = jwt.getJwt();
    int userid = jwtUtil.extractUserId(jwtString);
    return this.userService.getUserVerification(userid);
  }

  @PostMapping(value = "/authenticate")
  public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
      throws Exception {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
          authenticationRequest.getusername(), authenticationRequest.getpassword()));
    } catch (Exception e) {
      return ResponseEntity.status(403).body(e.getMessage());
    }

    /**
     * ? QUERIES USER DETAILS FROM MYUSERDETAILSSERVICE
     */
    final UserModel userModel = myUserDetailsService.loadUserModelByUsername(authenticationRequest.getusername());

    // #region
    // !INCORRECT PASSWORD HANDING
    if (!userModel.getpassword().equals(authenticationRequest.getpassword())) {
      return ResponseEntity.status(403).body("Either your username or password is incorrect!");
    }
    // #endregion

    /**
     * ? GENERATES THE JWT TOKEN BASED ON THE USERDETAILS
     */
    final String jwt = jwtUtil.generateToken(userModel);

    return ResponseEntity.ok(new AuthenticationResponse(jwt));
  }
}
