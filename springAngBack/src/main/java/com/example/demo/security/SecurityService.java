package com.example.demo.security;

import com.example.demo.dto.UserDetailImpl;
import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class SecurityService implements UserDetailsService {
    private StudentRepository studentRepository;

    public SecurityService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Student student=studentRepository.findByFirstName(userName).orElseThrow(()->new UsernameNotFoundException("user not found"));
        return new UserDetailImpl(student);
    }
}
