/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fajar.wsclient.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Republic Of Gamers
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Message implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 288170501686629409L;
	private String messageTo;
	private String messageFrom;
	private String message;
	private Date date;

}

