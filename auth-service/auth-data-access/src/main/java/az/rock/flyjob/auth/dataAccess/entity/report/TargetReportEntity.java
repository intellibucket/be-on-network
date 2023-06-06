//package az.rock.flyjob.auth.dataAccess.entity.report;
//
//import az.rock.lib.domain.BaseEntity;
//import az.rock.lib.valueObject.UserType;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.List;
//import java.util.UUID;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "target_reports", schema = "report")
//@Entity(name = "TargetReportEntity")
//public class TargetReportEntity extends BaseEntity {
//
//    @Column(name = "title", nullable = false)
//    private String title;
//
//    @Column(name = "description", nullable = false)
//    private String description;
//
//    @Column(name = "screenshot_url", nullable = false)
//    private String screenshotUrl;
//
//    @Enumerated(EnumType.STRING)
//    private UserType reporterType;
//
//    @Column(name = "reporter_id", nullable = false)
//    private UUID reporterId;
//
//    @Column(name = "target_id", nullable = false)
//    private UUID targetId;
//    @ManyToOne
//    private TargetReportTypeEntity type;
//}
