package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractCoverPictureDomainMapper;
import az.rock.flyjob.auth.model.root.user.CoverPictureRoot;
import az.rock.lib.domain.id.auth.CoverPictureID;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.*;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CoverPictureDomainMapper implements AbstractCoverPictureDomainMapper {
    @Override
    public CoverPictureRoot of(UserID userID, FileMetaData fileMetaData) {
        return CoverPictureRoot.Builder
                .builder()
                .id(CoverPictureID.of())
                .userId(userID)
                .accessModifier(AccessModifier.PUBLIC)
                .processStatus(ProcessStatus.ON_WAITING)
                .rowStatus(RowStatus.ACTIVE)
                .version(Version.ONE)
                .filename(fileMetaData.getObject())
                .isCurrent(Boolean.TRUE)
                .fileFormat(fileMetaData.fileFormat())
                .filepath(fileMetaData.getObject())
                .region(Objects.requireNonNullElse(fileMetaData.getRegion(), "eu-central-1"))
                .filesize(fileMetaData.getFileSize())
                .build();
    }
}
