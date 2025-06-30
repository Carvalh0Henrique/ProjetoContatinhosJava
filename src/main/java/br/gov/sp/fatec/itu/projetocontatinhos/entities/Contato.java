package br.gov.sp.fatec.itu.projetocontatinhos.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_CONTATOS")
public class Contato implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private String nickname;
    private String phone;
    private String email;
    private String dateBorn;
    private Integer age;
    private String gender;
    private String city;
    private String area;
    private String category;

    @Column(nullable = false)
    private boolean favorite;
    
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getNickname() {
        return nickname;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
    public String getDateBorn() {
        return dateBorn;
    }
    public Integer getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    public String getCity() {
        return city;
    }
    public String getArea() {
        return area;
    }
    public String getCategory() {
        return category;
    }
    public boolean getFavorite() {
        return favorite;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDateBorn(String dateBorn) {
        this.dateBorn = dateBorn;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contato other = (Contato) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }   
}
