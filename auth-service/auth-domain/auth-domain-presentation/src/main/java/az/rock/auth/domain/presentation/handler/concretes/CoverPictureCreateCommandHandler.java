package az.rock.auth.domain.presentation.handler.concretes;

import az.rock.auth.domain.presentation.handler.abstracts.AbstractCoverPictureCreateCommandHandler;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractCoverPictureDomainMapper;
import az.rock.auth.domain.presentation.ports.output.dfs.AbstractFileStorageAdapter;
import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.event.impl.concretes.auth.create.CoverPictureCreatedEvent;
import az.rock.lib.valueObject.MultipartFileWrapper;
import org.springframework.stereotype.Component;

@Component
public class CoverPictureCreateCommandHandler implements AbstractCoverPictureCreateCommandHandler {

    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractFileStorageAdapter fileStorageService;
    private final AbstractCoverPictureDomainMapper coverPictureDomainMapper;

    public CoverPictureCreateCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                            AbstractFileStorageAdapter fileStorageService,
                                            AbstractCoverPictureDomainMapper coverPictureDomainMapper) {
        this.securityContextHolder = securityContextHolder;
        this.fileStorageService = fileStorageService;
        this.coverPictureDomainMapper = coverPictureDomainMapper;
    }

    @Override
    public CoverPictureCreatedEvent handle(MultipartFileWrapper coverPicture) {
        var currentUserId = this.securityContextHolder.availableUser();
        var savedFile = this.fileStorageService.uploadFile(coverPicture);
        var root = this.coverPictureDomainMapper.of(currentUserId, savedFile);
        //if (!root.isEmpty()) return CoverPictureCreatedEvent.of(root);
        //else throw new AuthDomainPresentationException("F0000000001");
        return null;
    }
}
