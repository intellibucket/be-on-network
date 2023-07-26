package az.rock.auth.domain.presentation.handler.concretes;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractCoverPictureDomainMapper;
import az.rock.auth.domain.presentation.ports.output.dfs.AbstractFileStorageAdapter;
import az.rock.flyjob.auth.service.abstracts.AbstractCoverPictureDomainService;
import org.springframework.stereotype.Service;

@Service
public class CoverPictureCreateCommandHandler {
    //TODO: Implement this class
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractFileStorageAdapter fileStorageService;
    private final AbstractCoverPictureDomainMapper coverPictureDomainMapper;
    private final AbstractCoverPictureDomainService coverPictureDomainService;

    public CoverPictureCreateCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                            AbstractFileStorageAdapter fileStorageService,
                                            AbstractCoverPictureDomainMapper coverPictureDomainMapper,
                                            AbstractCoverPictureDomainService coverPictureDomainService) {
        this.securityContextHolder = securityContextHolder;
        this.fileStorageService = fileStorageService;
        this.coverPictureDomainMapper = coverPictureDomainMapper;
        this.coverPictureDomainService = coverPictureDomainService;
    }
}
