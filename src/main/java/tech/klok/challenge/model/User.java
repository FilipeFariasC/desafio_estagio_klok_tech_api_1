package tech.klok.challenge.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import tech.klok.challenge.model.categories.MaritalStatus;
import tech.klok.challenge.model.categories.Sex;
import tech.klok.challenge.validation.constraints.ValidAge;

@Entity
@Table(name="t_user")
public class User implements Serializable, UserDetails{
	
	private static final long serialVersionUID = 2187982020549437111L;
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@NotBlank
	@NotNull
	@Column(name="username")
	private String username;
	
	@NotEmpty
	@NotBlank
	@NotNull
	@Column(name="password")
	private String password;
	
	@NotEmpty
	@NotBlank
	@NotNull
	@CPF
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="birth_date", columnDefinition = "DATE")
	@ValidAge
	private LocalDate birthDate;

	@Enumerated(EnumType.STRING)
	@Column(name="gender")
	private Sex sex;
	
	@Enumerated(EnumType.STRING)
	@Column(name="marital_status")
	private MaritalStatus maritalStatus;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id_fk")
	private Set<Adhesion> adhesions = new HashSet<>();
	
	@ElementCollection
	private Collection<SimpleGrantedAuthority> authorities;
	
	public void setAuthorities(Collection<SimpleGrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Set<Adhesion> getAdhesions() {
		return adhesions;
	}

	public void setAdhesions(Set<Adhesion> adhesions) {
		this.adhesions = adhesions;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	
	
}
