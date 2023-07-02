package az.rock.flyjob.auth.root.user;

import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.id.ProfilePictureID;
import az.rock.lib.valueObject.AccessModifier;
import az.rock.lib.valueObject.PictureType;

public class ProfilePictureRoot extends AggregateRoot<ProfilePictureID> {

    private AccessModifier accessModifier;

    private PictureType type;

    private Boolean isCurrent;

    private String filepath;

    private String filename;

    private String fileFormat;

    private Long filesize;

    private String filepathThumbnail;

    private String filepathMedium;

    private String filepathLarge;

    private String filepathExtraLarge;

    private String filepathWebp;

}
