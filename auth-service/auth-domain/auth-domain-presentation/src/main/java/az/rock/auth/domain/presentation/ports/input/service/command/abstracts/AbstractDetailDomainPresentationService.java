package az.rock.auth.domain.presentation.ports.input.service.command.abstracts;

import az.rock.auth.domain.presentation.dto.response.DetailPrivateModelResponse;
import az.rock.lib.annotation.InputPort;

@InputPort
public interface AbstractDetailDomainPresentationService {
    DetailPrivateModelResponse queryDetail();
}
