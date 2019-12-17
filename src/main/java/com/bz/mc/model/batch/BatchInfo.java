package com.bz.mc.model.batch;


import com.bz.mc.model.BaseEntity;
import lombok.*;


import javax.persistence.*;
import java.time.LocalDateTime;


@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="BATCH_INFO")
public class BatchInfo  extends BaseEntity {


   // @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @GenericGenerator(name = "custom_sequence", strategy =
//            "com.bz.mc.IdGenerator")
//    @GeneratedValue(generator = "custom_sequence")
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="ID")
//    private Long id;

    @Column(name="BATCH_NAME")
    private String batchName;

    @Column(name="VISUAL_ID")
    private String visualId;

    @Column(name="SHORT_CODE")
    private String shortCode;

    @Column(name="PROGRAM_ID")
    private Long programId;


    @Column(name="SESSION_ID")
    private Long sessionId;

    @Column(name="ACTIVE_STATUS")
    private int activeStatus;


    @Column(name="REMARKS")
    private String remarks;

    @Column(name="ENTERED_BY")
    private Long enteredBy;

    @Column(name="ENTRY_TIMESTAMP")
    private LocalDateTime entryTimestamp;


    @Column(name="UPDATED_BY")
    private Long updatedBy;

    @Column(name="UPDATE_TIMESTAMP")
    private LocalDateTime updateTimestamp;

    @Column(name="FLEX_FIELD1")
    private String flexField1;

    @Column(name="FLEX_FIELD2")
    private String flexField2;

    @Column(name="FLEX_FIELD3")
    private String flexField3;

    @Transient
    private boolean active;

    @Transient
    private String sActive;

    @Builder
    public BatchInfo( String shortCode, Long programId, Long sessionId, int activeStatus, String remarks, Long enteredBy, LocalDateTime entryTimestamp, Long updatedBy, LocalDateTime updateTimestamp, String flexField1, String flexField2, String flexField3, boolean active, String sActive) {

        this.shortCode = shortCode;
        this.programId = programId;
        this.sessionId = sessionId;
        this.activeStatus = activeStatus;
        this.remarks = remarks;
        this.enteredBy = enteredBy;
        this.entryTimestamp = entryTimestamp;
        this.updatedBy = updatedBy;
        this.updateTimestamp = updateTimestamp;
        this.flexField1 = flexField1;
        this.flexField2 = flexField2;
        this.flexField3 = flexField3;
        this.active = active;
        this.sActive = sActive;
    }


}
