package com.capgemini.chess.bo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractTimestampBO implements Serializable {
	private static final long serialVersionUID = 7505303940768159770L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "int")
	private Long id;

	@Version
	@Column(name = "version", columnDefinition = "int default '0'")
	private int version;

	@Column(name = "createdAt", columnDefinition = "timestamp default current_timestamp")
	private Timestamp createdAt;

	@Column(name = "updatedAt", columnDefinition = "timestamp default current_timestamp")
	private Timestamp updatedAt;

	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	@PrePersist
	void onCreate() {
		this.setCreatedAt(new Timestamp((new Date()).getTime()));
	}

	@PreUpdate
	void onUpdate() {
		this.setUpdatedAt(new Timestamp((new Date()).getTime()));
	}

}
