package com.example.classtest2.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Enter First Name")
    @Column(nullable = false)
    private String firstName;

    private String lastName;

    private String name;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = true)
    private String password;

    @Email
    @NotEmpty(message = "Enter An Email")
    @Column(nullable = false, unique = true)
    private String email;

    @Column(unique = true)
    private String mobile;

    private String gender;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date regiDate;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastModifiedDate = new Date();

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date birthDate;

    private boolean status;

    //////Token Activation ==============
    @Column(nullable = false)
    private String conformationToken;

    //////File Upload==============
    @Column(nullable = true)
    private String fileName;
    private String filePath;
    private String fileExtension;
    private Long fileSize;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> role;

    public User() {
    }

//    public User(User user) {
//        this.name = user.name;
//        this.username = user.username;
//        this.password = user.password;
//        this.email = user.email;
//        this.status = user.status;
//        this.role = user.role;
//    }
//
//    public User(String name, String username, String password, String email, boolean status, Set<Role> role) {
//        this.name = name;
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.status = status;
//        this.role = role;
//    }
    public User(User user) {
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.name = user.name;
        this.username = user.username;
        this.password = user.password;
        this.email = user.email;
        this.mobile = user.mobile;
        this.gender = user.gender;
        this.regiDate = user.regiDate;
        this.lastModifiedDate = user.lastModifiedDate;
        this.birthDate = user.birthDate;
        this.status = user.status;
        this.conformationToken = user.conformationToken;
        this.fileName = user.fileName;
        this.filePath = user.filePath;
        this.fileExtension = user.fileExtension;
        this.fileSize = user.fileSize;
        this.role = user.role;
    }

    public User(@NotEmpty(message = "Enter First Name") String firstName, String lastName, String name, String username, String password, @Email @NotEmpty(message = "Enter An Email") String email, String mobile, String gender, Date regiDate, Date lastModifiedDate, Date birthDate, boolean status, String conformationToken, String fileName, String filePath, String fileExtension, Long fileSize, Set<Role> role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.regiDate = regiDate;
        this.lastModifiedDate = lastModifiedDate;
        this.birthDate = birthDate;
        this.status = status;
        this.conformationToken = conformationToken;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileExtension = fileExtension;
        this.fileSize = fileSize;
        this.role = role;
    }

    public User(@NotEmpty(message = "Enter First Name") String firstName, String lastName, String username, @Email @NotEmpty(message = "Enter An Email") String email, Date birthDate, boolean status, String conformationToken, Set<Role> role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.birthDate = birthDate;
        this.status = status;
        this.conformationToken = conformationToken;
        this.role = role;
    }

    public User(@NotEmpty(message = "Enter First Name") String firstName, String lastName, String username, String password, @Email @NotEmpty(message = "Enter An Email") String email, Date birthDate, boolean status, String conformationToken, Set<Role> role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.status = status;
        this.conformationToken = conformationToken;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getRegiDate() {
        return regiDate;
    }

    public void setRegiDate(Date regiDate) {
        this.regiDate = regiDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getConformationToken() {
        return conformationToken;
    }

    public void setConformationToken(String conformationToken) {
        this.conformationToken = conformationToken;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return status == user.status &&
                Objects.equals(id, user.id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(name, user.name) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(mobile, user.mobile) &&
                Objects.equals(gender, user.gender) &&
                Objects.equals(regiDate, user.regiDate) &&
                Objects.equals(lastModifiedDate, user.lastModifiedDate) &&
                Objects.equals(birthDate, user.birthDate) &&
                Objects.equals(conformationToken, user.conformationToken) &&
                Objects.equals(fileName, user.fileName) &&
                Objects.equals(filePath, user.filePath) &&
                Objects.equals(fileExtension, user.fileExtension) &&
                Objects.equals(fileSize, user.fileSize) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, name, username, password, email, mobile, gender, regiDate, lastModifiedDate, birthDate, status, conformationToken, fileName, filePath, fileExtension, fileSize, role);
    }
}
