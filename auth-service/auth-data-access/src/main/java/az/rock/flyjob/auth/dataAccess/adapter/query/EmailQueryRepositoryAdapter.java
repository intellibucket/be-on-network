package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractEmailQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.EmailDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.EmailQueryJPARepository;
import az.rock.flyjob.auth.root.user.EmailRoot;
import az.rock.lib.domain.id.EmailID;
import az.rock.lib.domain.id.UserID;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmailQueryRepositoryAdapter implements AbstractEmailQueryRepositoryAdapter {

    private final EmailQueryJPARepository emailQueryJPARepository;

    private final EmailDataAccessMapper emailDataAccessMapper;

    public EmailQueryRepositoryAdapter(EmailQueryJPARepository emailQueryJPARepository,
                                       EmailDataAccessMapper emailDataAccessMapper) {
        this.emailQueryJPARepository = emailQueryJPARepository;
        this.emailDataAccessMapper = emailDataAccessMapper;
    }

    @Override
    public Optional<EmailRoot> findMyEmailByID(UserID userID, EmailID emailID) {
        var optionalEntity = Optional.ofNullable(this.emailQueryJPARepository
                .findByUserIDAndEmailID(userID.getAbsoluteID(), emailID.getAbsoluteID()));
        if (optionalEntity.isPresent()) return this.emailDataAccessMapper.toRoot(optionalEntity.get());
        else return Optional.empty();
    }

    @Override
    public Optional<EmailRoot> findAnyByByID(EmailID emailID) {
        var optionalEntity = Optional.ofNullable(this.emailQueryJPARepository.findByID(emailID.getAbsoluteID()));
        if (optionalEntity.isPresent()) return this.emailDataAccessMapper.toRoot(optionalEntity.get());
        else return Optional.empty();
    }

    @Override
    public List<Optional<EmailRoot>> findAllMyEmails(UserID userID) {
        var entities = this.emailQueryJPARepository.findAllByUserID(userID.getAbsoluteID());
        return entities.stream().map(this.emailDataAccessMapper::toRoot).toList();
    }

    @Override
    public List<EmailID> findAllMyEmailsID(UserID userID) {
        var entities = this.emailQueryJPARepository.findAllIDByUserID(userID.getAbsoluteID());
        return entities.stream().map(EmailID::of).toList();
    }
}
