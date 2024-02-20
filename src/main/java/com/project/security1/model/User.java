package com.project.security1.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  
  @Column(nullable = true, unique = true, length = 50)
  private String username;
  
  @Column(nullable = true, length = 100)
  private String password;
  
  @Column(nullable = true, length = 100)
  private String email;
  
  @Enumerated(EnumType.STRING)
  private RoleType role;
  
  @CreationTimestamp
  private Timestamp createData;
}
