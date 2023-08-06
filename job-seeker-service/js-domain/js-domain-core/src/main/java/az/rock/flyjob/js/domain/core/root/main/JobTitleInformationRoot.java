package az.rock.flyjob.js.domain.core.root.main;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.js.InformationID;
import az.rock.lib.domain.id.js.JobTitleInformationID;

public class JobTitleInformationRoot extends AggregateRoot<JobTitleInformationID> {

    private InformationID information;

    private String jobTitle;
}
