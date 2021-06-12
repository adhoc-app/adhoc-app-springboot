package fi.adhocapp.adhocappspringboot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "t_user")
@Data
public class User implements Serializable {

	private static final long serialVersionUID = -6945811386079001252L;

	@Id
	@Column(insertable = true, updatable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Column(name = "email", nullable = false, insertable = true, updatable = false)
	private String email;
	
	@Column(name = "password_hash", nullable = false)
	private String passwordHash;

}
