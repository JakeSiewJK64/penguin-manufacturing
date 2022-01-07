package com.penguin_manufacturing.penguin.Utils;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

import com.penguin_manufacturing.penguin.Models.UserModel;

import org.json.JSONObject;
import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtility {
  private String secretKey = "45F94C61FAC55EAFE98CA5F89151E";

  public int extractUserId(String token) {
    return (int) extractAllClaims(token).get("userid");
  }

  public String extractUsername(String token) {
    return extractAllClaims(token).get("username").toString();
  }

  public Date extractExpiration(String token) {
    DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
    try {
      return format.parse(extractAllClaims(token).get("expiration_date").toString());
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
  }

  public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  public Claims extractAllClaims(String token) {
    return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
  }

  public Boolean isTokenExpired(String token) {
    return extractExpiration(token).before(new Date());
  }

  public String generateToken(UserModel userModel) {
    return createToken(userModel);
  }

  public String createToken(UserModel user) {
    JSONObject json = new JSONObject();
    json.put("username", user.getusername());
    json.put("userid", user.getuserid());
    json.put("issued_at", new Date(System.currentTimeMillis()));
    json.put("expiration_date", new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10));

    return Jwts.builder().setPayload(json.toString()).signWith(SignatureAlgorithm.HS256, secretKey).compact();
  }

  public Boolean validateToken(String token, UserDetails userDetails) {
    final String username = extractUsername(token);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
  }
}
