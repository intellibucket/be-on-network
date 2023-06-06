//package az.rock.flyjob.auth.dataAccess.entity.report;
//
//import az.rock.lib.domain.BaseEntity;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.List;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "target_report_types", schema = "report")
//@Entity(name = "TargetReportTypeEntity")
//public class TargetReportTypeEntity extends BaseEntity {
//
//    @Column(name = "title", nullable = false)
//    private String title;
//
//    @Column(name = "description", nullable = false)
//    private String description;
//
//    @OneToMany(mappedBy = "type")
//    private List<TargetReportEntity> targetReport;
//
//    @Column(name = "priority_value", nullable = false)
//    Long priorityValue;
//}
