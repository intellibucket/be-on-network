package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.dto.request.PictureQueryRequest;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractProfilePictureCommandDomainPresentation;
import az.rock.auth.domain.presentation.ports.output.dfs.AbstractFileStorageAdapter;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractProfilePictureMessagePublisher;
import az.rock.flyjob.auth.event.user.ProfilePictureCreatedEvent;
import az.rock.flyjob.auth.root.user.ProfilePictureRoot;
import az.rock.lib.domain.id.ProfilePictureID;
import az.rock.lib.util.GDateTime;
import az.rock.lib.valueObject.*;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ProfilePictureCommandDomainPresentation implements AbstractProfilePictureCommandDomainPresentation {

    private final AbstractFileStorageAdapter fileStorageService;
    private final AbstractProfilePictureMessagePublisher profilePictureMessagePublisher;

    public ProfilePictureCommandDomainPresentation(AbstractFileStorageAdapter fileStorageService,
                                                   AbstractProfilePictureMessagePublisher profilePictureMessagePublisher) {
        this.fileStorageService = fileStorageService;
        this.profilePictureMessagePublisher = profilePictureMessagePublisher;
    }

    @Override
    public UUID uploadProfilePicture(MultipartFileWrapper file) {
        var result = this.fileStorageService.uploadFile(file);
        var pictureRoot = ProfilePictureRoot.Builder
                .builder()
                .id(ProfilePictureID.of(UUID.randomUUID()))
                .accessModifier(AccessModifier.PUBLIC)
                .rowStatus(RowStatus.ACTIVE)
                .processStatus(ProcessStatus.PROCESSING)
                .createdDate(GDateTime.toZonedDateTime(GDateTime.of()))
                .version(Version.ONE)
                .modificationDate(GDateTime.toZonedDateTime(GDateTime.of()))
                .fileFormat("jpg")
                .build();
        var event = ProfilePictureCreatedEvent.of(pictureRoot);
        this.profilePictureMessagePublisher.publish(SagaRoot.of(event));
        return UUID.randomUUID();
    }

    @Override
    public byte[] get(PictureQueryRequest request) {
        var response = this.fileStorageService.get(request.path());
        return new byte[0];
    }


}
