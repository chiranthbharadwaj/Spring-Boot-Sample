package com.springbootdev.examples.entity;

import javax.persistence.*;

public class User {

    private Long id;

    private Long longValue;

    public Long getLongValue() {
		return longValue;
	}

	public void setLongValue(Long longValue) {
		this.longValue = longValue;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
