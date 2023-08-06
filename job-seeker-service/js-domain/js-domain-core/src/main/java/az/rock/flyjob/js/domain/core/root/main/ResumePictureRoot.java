package az.rock.flyjob.js.domain.core.root.main;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.domain.id.js.ResumePictureID;

public class ResumePictureRoot extends AggregateRoot<ResumePictureID> {
    private ResumeID resume;

    private Boolean isCurrent;

    private String region;

    private String filepath;

    private String filename;

    private String fileFormat;
}
