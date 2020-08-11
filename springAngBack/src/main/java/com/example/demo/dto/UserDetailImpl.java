package com.example.demo.dto;


import com.example.demo.models.Student;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;


public class UserDetailImpl implements UserDetails {
    Student student;
    public UserDetailImpl(Student student) {
        this.student=student;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities=new HashSet<GrantedAuthority>(1);
        grantedAuthorities.add(new SimpleGrantedAuthority("ROlE_USER"));
        return grantedAuthorities;
    }


    @Override
    public String getPassword() {
        return String.valueOf(student.getPassword());
    }


    @Override
    public String getUsername() {
        return student.getFirstName();
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
        return true;
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    @Override
    public boolean isEnabled() {
        return true;
    }
}
