package com.bz.mc.model.hr;


import com.bz.mc.model.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/* ORG_ID BIGINT,
ORG_NAME VARCHAR(200),
SHORT_CODE VARCHAR(10),
ADDRESS VARCHAR(200),
COUNTRY_ID BIGINT,
DIVISION_ID BIGINT,
DISTRICT_ID BIGINT,
POLICE_STATION_ID BIGINT,
POST_CODE INT,
PO_NAME VARCHAR(100),
EMAIL_ID VARCHAR(100),
CONTACT_NO VARCHAR(100),
FAX_NO VARCHAR(100),
WEB VARCHAR(100),
ACTIVE_STATUS INT,
REMARKS VARCHAR(500),
ENTERED_BY BIGINT(20),
ENTRY_TIMESTAMP DATETIME,
UPDATED_BY BIGINT(20),
UPDATE_TIMESTAMP DATETIME,
FLEX_FIELD1 VARCHAR(500),
FLEX_FIELD2 VARCHAR(500)
*/

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="BG_ORG")
public class Organization extends BaseEntity {

	@Column(name="ORG_NAME")
	private String orgName;

	@Column(name="SHORT_CODE")
	private String shortCode;

	@Column(name= "COUNTRY_ID")
	private Long countryId;

	@Column(name="DIVISION_ID")
	private Long divisionId;

	@Column(name="DISTRICT_ID")
	private Long districtId;

	@Column(name="POLICE_STATION_ID")
	private Long policeStationId;

	@Column(name="ADDRESS")
	private String address;

	@Column(name="EMAIL_ID")
	private String emailAddress;

	@Column(name="CONTACT_NO")
	private String contactNo;

	@Column(name="FAX_NO")
	private String faxNo;

	@Column(name="WEB")
	private String web;

	@Column(name="POST_CODE")
	private long postCode;

	@Column(name="PO_NAME")
	private String pOName;

	@Column(name="ACTIVE_STATUS")
	private int activeStatus;

	@Column(name="REMARKS")
	private String remarks;

	@Column(name="ENTERED_BY")
	private long enteredBy;

	@Column(name="ENTRY_TIMESTAMP")
	private LocalDateTime createdAt;

	@Column(name="UPDATED_BY")
	private long updatedBy;

	@Column(name="UPDATE_TIMESTAMP")
	private LocalDateTime modifiedAt;
}
