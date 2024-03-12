package az.rock.flyjob.js.domain.presentation.ports.input.services.query.concretes;

import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.AnyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.MyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.simple.SimpleAnyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.dto.response.resume.contact.simple.SimpleMyContactResponseModel;
import az.rock.flyjob.js.domain.presentation.ports.input.services.query.abstracts.AbstractContactQueryDomainPresentationService;
import az.rock.flyjob.js.domain.presentation.ports.output.repository.query.AbstractContactQueryRepositoryAdapter;
import az.rock.flyjob.js.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.lib.domain.id.auth.EmailID;
import az.rock.lib.domain.id.js.ResumeID;
import az.rock.lib.valueObject.SimplePageableRequest;
import az.rock.lib.valueObject.SimplePageableResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ContactQueryDomainPresentationService implements AbstractContactQueryDomainPresentationService {
    private final AbstractSecurityContextHolder abstractSecurityContextHolder;
    private  final AbstractContactQueryRepositoryAdapter abstractContactQueryRepositoryAdapter;

    public ContactQueryDomainPresentationService(AbstractSecurityContextHolder abstractSecurityContextHolder, AbstractContactQueryRepositoryAdapter abstractContactQueryRepositoryAdapter) {
        this.abstractSecurityContextHolder = abstractSecurityContextHolder;
        this.abstractContactQueryRepositoryAdapter = abstractContactQueryRepositoryAdapter;
    }

    @Override
    public SimplePageableResponse<AnyContactResponseModel> queryAllAnyContacts(SimplePageableRequest simplePageableRequest) {
        return null;
    }

    @Override
    public SimplePageableResponse<MyContactResponseModel> queryAllMyContacts(SimplePageableRequest simplePageableRequest) {
        return null;
    }

    @Override
    public SimplePageableResponse<SimpleMyContactResponseModel> queryAllMySimpleContacts(SimplePageableRequest simplePageableRequest) {
        return null;
    }

    @Override
    public SimplePageableResponse<SimpleAnyContactResponseModel> queryAllAnySimpleContacts(SimplePageableRequest simplePageableRequest) {
        return null;
    }

    @Override
    public MyContactResponseModel findMyContactById(UUID uuid) {
        return null;
    }

    @Override
    public AnyContactResponseModel findAnyContactById(UUID uuid) {
        return null;
    }
}
