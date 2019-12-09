//package com.bz.mc.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//import java.time.LocalDateTime;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "PROJECT")
//public class Project extends BaseEntity implements Auditable {
//
//    @Column(name = "PROJECT_NAME")
//    private String projectName;
//
//    @Column(name = "INTEREST_RATE")
//    private Double interestRate;
//
//    @Column(name = "NO_OF_INSTALLMENT")
//    private Long noOfInstallment;
//
//    @Column(name = "LOAN_DURATION")
//    private Long loanDuration;
//
//    @Column(name = "REMARKS")
//    private String remarks;
//
//    @Column(name = "ACTIVE_STATUS")
//    private int activeStatus;
//
//    @Column(name = "ENTERED_BY")
//    private Long createdBy;
//
//    @Column(name = "UPDATED_BY")
//    private Long modifiedBy;
//
//    @Column(name = "ENTRY_TIMESTAMP")
//    private LocalDateTime createdAt;
//
//    @Column(name = "UPDATE_TIMESTAMP")
//    private LocalDateTime modifiedAt;
//}
