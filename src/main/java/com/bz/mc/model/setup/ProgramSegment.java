package com.bz.mc.model.setup;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import com.bz.mc.model.Auditable;
import com.bz.mc.model.BaseEntity;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder")
@Entity
@Table(name="PROGRAM_SEGMENT")
@ToString

public class ProgramSegment extends BaseEntity implements Auditable {

	@Column(name="VISUAL_ID")
	private String visualId;
	
	@Column(name="SEGMENT_NAME")
	private String segmentName;
	
	@Column(name="PARENT_PROGRAM_SEGMENT_ID")
	private Long parentProgramSegmentId;
	
	@Column(name="PROGRAM_ID")
	private Long programId;
	
	@Column(name="SL_NO")
	private int slNo;
	
	@Column(name="ACTIVE_STATUS")
	private int activeStatus;
	
	@Column(name="REMARKS")
	private String remarks;
	
	@Column(name="ENTERED_BY")
	private Long createdBy;
	
	@Column(name="ENTRY_TIMESTAMP")
	private LocalDateTime createdAt;
	
	@Column(name="UPDATED_BY")
	private LocalDateTime modifiedBy;
	
	@Column(name="UPDATE_TIMESTAMP")
	private LocalDateTime modifiedAt;
	
	@Column(name="FLEX_FIELD1")
	private String flexField1;

	@Column(name="FLEX_FIELD2")
	private String flexField2;

	@Column(name="FLEX_FIELD3")
	private String flexField3;
	
	@Transient
	private boolean active;

}

